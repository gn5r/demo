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
public class 子Listener implements EntityListener<子> {

    @Override
    public void preInsert(子 entity, PreInsertContext<子> context) {
    }

    @Override
    public void preUpdate(子 entity, PreUpdateContext<子> context) {
    }

    @Override
    public void preDelete(子 entity, PreDeleteContext<子> context) {
    }

    @Override
    public void postInsert(子 entity, PostInsertContext<子> context) {
    }

    @Override
    public void postUpdate(子 entity, PostUpdateContext<子> context) {
    }

    @Override
    public void postDelete(子 entity, PostDeleteContext<子> context) {
    }
}