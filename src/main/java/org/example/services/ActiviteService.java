package org.example.services;

import org.example.entities.Activite;
import org.example.entities.Adherents;
import org.example.interfaces.Repository;

import java.util.List;

public class ActiviteService extends BaseService implements Repository<Activite> {

    public ActiviteService(){
        super();
    }
    @Override
    public boolean create(Activite o) {
        session= sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Activite o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Activite o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Activite findById(int id) {
        session = sessionFactory.openSession();
        Activite activite = session.get(Activite.class, id);
        session.close();
        return activite;
    }


    @Override
    public List<Activite> findAll() {
        List<Activite> activiteList = null;
        session = sessionFactory.openSession();
        activiteList = session.createQuery("from Activite").list();
        session.close();
        return activiteList;
    }
    public void begin(){
        session = sessionFactory.openSession();
    }

    public void end(){

        //  session.close();
        sessionFactory.close();
    }
}
