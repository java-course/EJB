package edu.javacourse.ejb;

import edu.javacourse.ejb.dao.RegionDao;
import edu.javacourse.ejb.model.Region;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Georgy Gobozov on 06.02.2015.
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class RegionServiceManual {

    @EJB
    RegionDao regionDao;

    @Resource
    UserTransaction transaction;


    public Serializable createRegion(Region region) {
        Integer id = null;
        try {

            transaction.begin();
            id = (Integer) regionDao.createRegion(region);
            if (id % 2 == 0)
                throw new Exception(); // just throw exception if id even
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                transaction.rollback();
            } catch (SystemException e1) {
                e1.printStackTrace();
            }
        }
        return id;
    }

}
