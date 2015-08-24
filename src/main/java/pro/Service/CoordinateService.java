package pro.Service;

import pro.Model.Coordinate;

import java.util.List;

/**
 * Created by user on 22.08.2015.
 */
public interface CoordinateService {
    void saveCoordinate(Coordinate coordinate);
    List<Coordinate> loadCoordinates();
}
