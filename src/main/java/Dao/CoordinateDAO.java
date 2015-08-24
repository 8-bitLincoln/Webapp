package Dao;

import Model.Coordinate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by user on 22.08.2015.
 */
public class CoordinateDAO extends HibernateDaoSupport implements ICoordinateDAO {

    public void save(Coordinate coordinate) {
        getHibernateTemplate().save(coordinate);
    }

    @SuppressWarnings("unchecked")
    public List<Coordinate> loadAll(){
        return getHibernateTemplate().loadAll(Coordinate.class);
    }

}
