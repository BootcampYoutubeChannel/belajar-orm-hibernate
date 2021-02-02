package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.entity.ParentChildEmployeeEntity;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.OrderingDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class TestOrderingDao extends TestCase {

    private Session session;
    private OrderingDao orderDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.orderDao = new OrderingDao(session);
    }
    
    @Test
    public void testOrderBySalaryAsc(){
        List<ParentChildEmployeeEntity> data = this.orderDao.findAllSortBySalaryAsc();
        List<BigDecimal> collect = data.stream().map(ParentChildEmployeeEntity::getSalary)
                .collect(Collectors.toList());
        log.info("data: {}", collect);
    }

    @Test
    public void testOrderBySalaryDesc(){
        List<ParentChildEmployeeEntity> data = this.orderDao.findAllSortBySalaryDesc();
        List<BigDecimal> collect = data.stream().map(ParentChildEmployeeEntity::getSalary)
                .collect(Collectors.toList());
        log.info("data: {}", collect);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
