package com.gn5r.gn5rapl.demo.repository;

import com.gn5r.gn5rapl.config.AppConfig;
import com.gn5r.gn5rapl.demo.dto.親Dto;
import com.gn5r.gn5rapl.demo.entity.親;
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
public interface 親Dao {

    /**
     * @param 親id
     * @return the 親 entity
     */
    @Select
    public 親 selectById(Integer 親id);

    /**
     * 親IDから外部結合した結果を取得する
     * 
     * @param parentId 親ID
     * @return {@link 親Dto}
     */
    @Select
    public 親Dto selectByParentId(Integer parentId);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    public int insert(親 entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    public int update(親 entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    public int delete(親 entity);
}