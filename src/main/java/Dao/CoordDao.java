package Dao;

import Model.Coordinate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import java.util.List;

/**
 * Created by user on 24.08.2015.
 */
public class CoordDao implements ICoordinateDAO{
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void save(Coordinate Coord) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(Coord);
        session.getTransaction().commit();
    }

    public List loadAll() {
        Session session = sessionFactory.openSession();
        List<Coordinate> list = session.createQuery("From Coordinate").list();
        return list;
    }
}
