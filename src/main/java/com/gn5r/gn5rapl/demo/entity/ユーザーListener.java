package com.gn5r.gn5rapl.demo.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * 
 * @author gn5r
 */
public class ユーザーListener implements EntityListener<ユーザー> {

    @Override
    public void preInsert(ユーザー entity, PreInsertContext<ユーザー> context) {
    }

    @Override
    public void preUpdate(ユーザー entity, PreUpdateContext<ユーザー> context) {
    }

    @Override
    public void preDelete(ユーザー entity, PreDeleteContext<ユーザー> context) {
    }

    @Override
    public void postInsert(ユーザー entity, PostInsertContext<ユーザー> context) {
    }

    @Override
    public void postUpdate(ユーザー entity, PostUpdateContext<ユーザー> context) {
    }

    @Override
    public void postDelete(ユーザー entity, PostDeleteContext<ユーザー> context) {
    }
}