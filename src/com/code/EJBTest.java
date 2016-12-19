package com.code;

import javax.ejb.EJBException;
import javax.ejb.EntityContext;
import javax.ejb.RemoveException;
import java.rmi.RemoteException;

/**
 * Created by Andrew on 2016/1/16.
 */
public class EJBTest implements javax.ejb.EntityBean {
    @Override
    public void setEntityContext(EntityContext entityContext) throws EJBException, RemoteException {

    }

    @Override
    public void unsetEntityContext() throws EJBException, RemoteException {

    }

    @Override
    public void ejbRemove() throws RemoveException, EJBException, RemoteException {

    }

    @Override
    public void ejbActivate() throws EJBException, RemoteException {

    }

    @Override
    public void ejbPassivate() throws EJBException, RemoteException {

    }

    @Override
    public void ejbLoad() throws EJBException, RemoteException {

    }

    @Override
    public void ejbStore() throws EJBException, RemoteException {

    }
}
