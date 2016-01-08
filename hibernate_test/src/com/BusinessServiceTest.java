package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Andrew on 2016/1/8.
 */
public class BusinessServiceTest {

    public static final long cId = 9L;
    public static SessionFactory sessionFactory;
    public static Session session;
    private BusinessService service;

    @Before
    public void setUp() throws Exception {
        service = new BusinessService();
    }


    @Test
    public void testSaveCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setName("James A");
        service.saveCustomer(customer);
        assertNotNull(service.getCustomerById(customer.getId()));
        //clean the mess
        service.deleteCustomer(customer);
    }




    @Test
    public void testDeleteCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setName("James A");
        service.saveCustomer(customer);

        service.deleteCustomer(customer);
        assertNull(service.getCustomerById(customer.getId()));
    }


    @After
    public void tearDown() throws Exception {

    }
}