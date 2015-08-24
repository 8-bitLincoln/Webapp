package Service;

import Model.Coordinate;

import java.util.List;

/**
 * Created by user on 22.08.2015.
 */
public interface ICoordinateService {
    void saveCoordinate(Coordinate coordinate);
    List<Coordinate> loadCoordinates();
}
