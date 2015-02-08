package edu.javacourse.ejb;

import edu.javacourse.ejb.dao.RegionDao;
import edu.javacourse.ejb.model.Region;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class RegionDaoImpl implements RegionDao {

    @PersistenceContext(unitName = "testPU")
    private EntityManager em;


    @Override
    public Region getRegion(Integer id) {
        return em.find(Region.class, id);
    }

    @Override
    public List<Region> getAllRegions() {
        List<Region> allRegions = em.createNamedQuery("Region.GetAll").getResultList();
        return allRegions;
    }

    @Override
    public Serializable createRegion(Region region) {
        em.persist(region);
        return region.getRegionId();
    }

    @Override
    public void removeRegion(Region region) {
        region = em.merge(region);
        em.remove(region);
    }


}
