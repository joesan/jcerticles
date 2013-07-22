/*
 * Project: Java User Group, Chennai
 * Copyright(c) 2010 jugc.in
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.core.persistence.jpa;

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
public interface IGenericBaseDAO < T > {

    /**
     *
     * @param entity
     */
    void save(T entity);

    /**
     *
     * @param entity
     */
    void delete(T entity);

    /**
     *
     * @param entity
     */
    //void update(T entity);

    /**
     *
     * @param id
     * @return
     */
    T findById(T object, T key);

}