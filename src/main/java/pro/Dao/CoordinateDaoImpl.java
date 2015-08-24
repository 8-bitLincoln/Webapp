package pro.Dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pro.Model.Coordinate;

import java.util.List;

/**
 * Created by user on 24.08.2015.
 */
@Component
public class CoordinateDaoImpl implements CoordinateDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Transactional
    public void save(Coordinate Coord) {
        sessionFactory.getCurrentSession()
                .save(Coord);
    }

    @Transactional
    public List<Coordinate> loadAll() {
        @SuppressWarnings("unchecked")
        List<Coordinate> list = (List<Coordinate>) sessionFactory.getCurrentSession()
                .createCriteria(Coordinate.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return list;
//        getHibernateTemplate().loadAll(Coordinate.class);
    }
}
