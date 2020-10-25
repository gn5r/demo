package com.gn5r.gn5rapl.demo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.gn5r.gn5rapl.demo.dto.TopicPathDto;
import com.gn5r.gn5rapl.demo.dto.子Dto;
import com.gn5r.gn5rapl.demo.entity.子;
import com.gn5r.gn5rapl.demo.repository.子Dao;
import com.gn5r.spring.boot.common.exception.RestRuntimeException;
import com.gn5r.spring.boot.common.logger.CmnLogger;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
@Transactional
public class ChildService {

    @Autowired
    private 子Dao childDao;

    @Autowired
    private ModelMapper modelMapper;

    public List<TopicPathDto> getTopicPathByParentId(final Integer parentId) {
        List<TopicPathDto> list = this.getAllChildList(parentId);
        List<TopicPathDto> removeList = new ArrayList<>();

        for (TopicPathDto e : list) {
            if (!CollectionUtils.isEmpty(e.getChildList())) {
                List<TopicPathDto> tmpList = list.stream()
                        .filter(child -> Objects.equals(e.getChildId(), child.getUpperChildId()))
                        .collect(Collectors.toList());
                removeList.addAll(tmpList);
            }
        }

        removeList.sort(Comparator.comparing(TopicPathDto::getChildId));

        removeList.stream().forEach(e -> list.remove(e));

        // 第3世代以降の子は非表示
        list.stream().forEach(child -> child.getChildList().stream().forEach(e -> e.getChildList().clear()));

        return list;
    }

    public List<TopicPathDto> getTopicPathByChildId(final Integer childId) {
        final 子 child = childDao.selectById(childId);
        List<TopicPathDto> list = new ArrayList<>();

        if (!Objects.isNull(child)) {

            list = this.getAllChildList(child.getParentId());

            final Integer upperChildId = child.getUpperChildId();

            if (Objects.isNull(upperChildId)) {
                list = list.stream().filter(e -> Objects.isNull(e.getUpperChildId())).collect(Collectors.toList());
            } else {
                list = list.stream().filter(e -> Objects.equals(e.getChildId(), upperChildId))
                        .collect(Collectors.toList());
            }

            final List<TopicPathDto> childList = list.stream()
                    .filter(item -> !CollectionUtils.isEmpty(item.getChildList().stream()
                            .filter(e -> !e.getChildList().isEmpty()).collect(Collectors.toList())))
                    .collect(Collectors.toList());

            if (!CollectionUtils.isEmpty(childList)) {
                list.stream().forEach(item -> item.getChildList().stream().forEach(e -> e.getChildList().clear()));                
            }

            list.sort(Comparator.comparing(TopicPathDto::getChildId));
        } else {
            throw new RestRuntimeException(HttpStatus.NOT_FOUND, "子ID【" + String.valueOf(childId) + "】のデータが見つかりませんでした");
        }

        return list;
    }

    public List<TopicPathDto> getAllChildListByChildId(final Integer childId) {
        final 子 child = childDao.selectById(childId);
        List<TopicPathDto> list = new ArrayList<>();

        if(!Objects.isNull(child)) {
            list = this.getAllChildList(child.getParentId());
        }

        return list;
    }

    public List<TopicPathDto> getAllChildList(final Integer parentId) {
        List<TopicPathDto> list = new ArrayList<>();
        final List<子Dto> allChildList = childDao.selectByParentId(parentId);

        if (!CollectionUtils.isEmpty(allChildList)) {
            for (子Dto e : allChildList) {
                final TopicPathDto dto = modelMapper.map(e, TopicPathDto.class);
                list.add(dto);
            }

            for (TopicPathDto dto : list) {
                final Integer childId = dto.getChildId();
                final List<TopicPathDto> childList = list.stream()
                        .filter(child -> Objects.equals(childId, child.getUpperChildId())).collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(childList)) {
                    dto.setChildList(childList);
                } else {
                    dto.setChildList(new ArrayList<>());
                }
            }

            list.sort(Comparator.comparing(TopicPathDto::getChildId));

            list.stream()
                    .forEach(child -> child.getChildList().stream().forEach(e -> e.setName("　".concat(e.getName()))));
        }

        return list;
    }
}