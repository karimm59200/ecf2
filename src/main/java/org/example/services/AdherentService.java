package org.example.services;

import org.example.entities.Activite;
import org.example.entities.Adherents;
import org.example.interfaces.Repository;

import java.util.List;

public class AdherentService extends BaseService implements Repository<Adherents> {

    public AdherentService(){
        super();
    }
    @Override
    public boolean create(Adherents o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Adherents o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Adherents o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Adherents findById(int id) {
        session = sessionFactory.openSession();
        Adherents adherents = session.get(Adherents.class, id);
        session.close();
        return adherents;
    }

    @Override
    public List<Adherents> findAll() {
        List<Adherents> adherentsList = null;
        session = sessionFactory.openSession();
        adherentsList = session.createQuery("from Adherents").list();
        session.close();
        return adherentsList;
    }



    public void begin(){
        session = sessionFactory.openSession();
    }

    public void end(){

        //  session.close();
        sessionFactory.close();
    }


}
