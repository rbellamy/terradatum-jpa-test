package com.terradatum.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by rbellamy on 12/21/15.
 */
@Stateless
@LocalBean
public class AgentContactInfoBean {
    @PersistenceContext(unitName = "testUnit")
    private EntityManager entityManager;

    public String sayHello() {
        return "Hello World!";
    }
}
