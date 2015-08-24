package Dao;

import Model.Coordinate;

import java.util.List;

/**
 * Created by user on 22.08.2015.
 */
public interface ICoordinateDAO {
    void save(Coordinate coordinate);
    List<Coordinate> loadAll();
}
