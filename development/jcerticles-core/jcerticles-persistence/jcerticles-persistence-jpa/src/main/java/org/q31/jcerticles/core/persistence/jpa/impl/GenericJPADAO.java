/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.core.persistence.jpa.impl;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;

import org.q31.jcerticles.core.persistence.jpa.IGenericBaseDAO;

/**
 * The base Generic DAO interface
 *
 * TODO... Write Javadoc...
 *
 * @author    Jothi Shankar Kumar. S
 * @since     1.6
 *
 * @param <T> the entity type
 * @param <ID> the primary key type
 *
 */
public class GenericJPADAO < T, ID > implements IGenericBaseDAO < T > {

    //protected Class<T> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    @SuppressWarnings("unchecked")
	public GenericJPADAO() {    	
//    	if(!(((ParameterizedType) getClass()
//                .getGenericSuperclass()).getActualTypeArguments()[0] instanceof TypeVariableImpl)) {        	
//        	this.entityClass = (Class<T>) ((ParameterizedType) getClass()
//                    .getGenericSuperclass()).getActualTypeArguments()[0];    		    		
//    	}
    	if (entityManager != null) {
    		entityManager.setFlushMode(FlushModeType.COMMIT);    		
    	}
    }

   /**
    * {@inheritDoc}
    */
    public void save(T entity) {
        entityManager.persist(entity);
    }

   /**
    * {@inheritDoc}
    */
    public void delete(T entity) {
        entityManager.remove(entity);
    }

   /**
    * {@inheritDoc}
    */
    public T findById(T object, T key) {
    	T entity = (T) entityManager.find(object.getClass(), key);
    	return entity;
    }
}