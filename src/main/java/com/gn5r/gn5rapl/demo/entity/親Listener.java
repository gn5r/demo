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
public class 親Listener implements EntityListener<親> {

    @Override
    public void preInsert(親 entity, PreInsertContext<親> context) {
    }

    @Override
    public void preUpdate(親 entity, PreUpdateContext<親> context) {
    }

    @Override
    public void preDelete(親 entity, PreDeleteContext<親> context) {
    }

    @Override
    public void postInsert(親 entity, PostInsertContext<親> context) {
    }

    @Override
    public void postUpdate(親 entity, PostUpdateContext<親> context) {
    }

    @Override
    public void postDelete(親 entity, PostDeleteContext<親> context) {
    }
}