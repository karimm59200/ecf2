package org.example.services;

import org.example.entities.Adherents;
import org.example.entities.CentreSportif;
import org.example.interfaces.Repository;

import java.util.List;

public class CentreSportifService extends BaseService implements Repository<CentreSportif> {

    public CentreSportifService(){
        super();
    }
    @Override
    public boolean create(CentreSportif o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(CentreSportif o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(CentreSportif o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public CentreSportif findById(int id) {
        session = sessionFactory.openSession();
        CentreSportif centreSportif = session.get(CentreSportif.class, id);
        session.close();
        return centreSportif;
    }

    @Override
    public List<CentreSportif> findAll() {
        return null;
    }
    public void begin(){
        session = sessionFactory.openSession();
    }

    public void end(){

        //  session.close();
        sessionFactory.close();
    }
}
