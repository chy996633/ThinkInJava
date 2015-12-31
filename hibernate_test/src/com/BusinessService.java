package com;

import oracle.jdbc.OracleDriver;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


/**
 * Created by Andrew on 2015/12/29.
 */
public class BusinessService {
    public static SessionFactory sessionFactory;

    static {
        try {
            Configuration config = new Configuration().configure();
            sessionFactory = config.buildSessionFactory();

        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }


    public void test(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Customer customer = new Customer("michael","12",new HashSet<>());
        session.save(customer);
        session.getTransaction().commit();
        session.close();
    }

    public void load(){
        Session session = sessionFactory.openSession();
        session.get(Customer.class,"1");

    }

    public void findAll(){
        Session session = sessionFactory.openSession();
        Query query =  session.createQuery("from Customer as a order by a.name asc ");
        List list =  query.list();
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void main(String[] args) {
        new BusinessService().findAll();

    }

}
