package pro.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pro.Dao.CoordinateDao;
import pro.Model.Coordinate;

import java.util.List;

@Component
public class CoordinateServiceImpl implements CoordinateService {

    @Autowired
    private CoordinateDao dao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveCoordinate(Coordinate coordinate) {
        dao.save(coordinate);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<Coordinate> loadCoordinates() {
        return dao.loadAll();
    }
}