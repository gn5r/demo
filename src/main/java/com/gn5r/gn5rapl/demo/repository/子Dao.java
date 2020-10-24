package com.gn5r.gn5rapl.demo.repository;

import java.util.List;

import com.gn5r.gn5rapl.config.AppConfig;
import com.gn5r.gn5rapl.demo.dto.子Dto;
import com.gn5r.gn5rapl.demo.entity.子;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import org.seasar.doma.boot.ConfigAutowireable;

/**
 * @author gn5r
 */
@ConfigAutowireable
@Dao(config = AppConfig.class)
public interface 子Dao {

    /**
     * @param 子id
     * @return the 子 entity
     */
    @Select
    public 子 selectById(Integer 子id);

    /**
     * 親IDに紐づく子の一覧を取得する
     * 
     * @param parentId 親ID
     * @return {@lin 子Dto}リスト
     */
    @Select
    public List<子Dto> selectByParentId(Integer parentId);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    public int insert(子 entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    public int update(子 entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    public int delete(子 entity);
}