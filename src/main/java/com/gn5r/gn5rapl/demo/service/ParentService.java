package com.gn5r.gn5rapl.demo.service;

import com.gn5r.gn5rapl.demo.dto.親Dto;
import com.gn5r.gn5rapl.demo.repository.親Dao;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ParentService {

    @Autowired
    private 親Dao paretDao;

    @Autowired
    private ModelMapper modelMapper;

    public final 親Dto getParent(Integer parentId) {
        return paretDao.selectByParentId(parentId);
    }
}