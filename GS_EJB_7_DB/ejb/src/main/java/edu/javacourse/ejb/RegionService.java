package edu.javacourse.ejb;

import edu.javacourse.ejb.dao.RegionDao;
import edu.javacourse.ejb.model.Region;

import javax.ejb.*;
import java.io.Serializable;
import java.util.List;


/**
 *
 MANDATORY - если есть, будет использовать ее, если нет - бросит
 javax.ejb.EJBTransactionRequiredException
 NEVER - если нет, то и не будет. Если есть - бросит javax.ejb.EJBException
 NOT_SUPPORTED - текущая транзакция "подвешивается" и не передается в другие вызовы
 REQUIRED - использует текущую, если есть или автоматически начнет новую
 REQUIRES_NEW - если нет, создаст новую и будет передаваться дальше, если есть -
 "подвесит" старую и создаст новую
 SUPPORTS - если есть транзакция, будет использовать, если нет - ее и не будет
 *
 */

/**
 * Created by Georgy Gobozov on 06.02.2015.
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER) // default value
public class RegionService{

    @EJB(beanName = "RegionDaoImpl")
    RegionDao regionDao;


    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Region getRegion(Integer id) {
        return regionDao.getRegion(id);
    }

    @TransactionAttribute(TransactionAttributeType.NEVER)
    public List<Region> getAllRegions() {
        return regionDao.getAllRegions();
    }


    @TransactionAttribute(TransactionAttributeType.REQUIRED) // default value
    public Serializable createRegion(Region region) {
        return regionDao.createRegion(region);
    }


//    @TransactionAttribute(TransactionAttributeType.MANDATORY) // throws exception - transaction required
//    public void removeRegion(Region region) {
//        regionDao.removeRegion(region);
//    }


    @TransactionAttribute(TransactionAttributeType.REQUIRED) // throws exception - transaction required
    public void removeRegion(Region region) {
        remove(region);
    }

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void remove(Region region) {
        regionDao.removeRegion(region);
    }

}
