package edu.javacourse.ejb.dao;

import edu.javacourse.ejb.model.Region;

import javax.ejb.Local;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Georgy Gobozov on 06.02.2015.
 */
@Local
public interface RegionDao {

    public Region getRegion(Integer id);

    public List<Region> getAllRegions();

    public Serializable createRegion(Region region);

    public void removeRegion(Region region);

}
