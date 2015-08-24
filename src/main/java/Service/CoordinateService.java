package Service;

import Dao.ICoordinateDAO;
import Model.Coordinate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 22.08.2015.
 */
public class CoordinateService implements ICoordinateService {
    private ICoordinateDAO dao;

    public void setDao (ICoordinateDAO dao){
        this.dao = dao;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveCoordinate(Coordinate coordinate) {
        dao.save(coordinate);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<Coordinate> loadCoordinates() {
        return dao.loadAll();
    }
}
