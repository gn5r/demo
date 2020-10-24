package com.gn5r.gn5rapl.demo.repository;

import com.gn5r.gn5rapl.config.AppConfig;
import com.gn5r.gn5rapl.demo.entity.ユーザー;
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
public interface ユーザーDao {

    /**
     * @param ユーザーid
     * @return the ユーザー entity
     */
    @Select
    public ユーザー selectById(String ユーザーid);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    public int insert(ユーザー entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    public int update(ユーザー entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    public int delete(ユーザー entity);
}