package pro.Dao;

import pro.Model.Coordinate;

import java.util.List;

/**
 * Created by user on 22.08.2015.
 */
public interface CoordinateDao {
    void save(Coordinate coordinate);
    List<Coordinate> loadAll();
}
