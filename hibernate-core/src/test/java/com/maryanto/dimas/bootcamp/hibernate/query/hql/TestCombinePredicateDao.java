package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.entity.ParentChildEmployeeEntity;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.CombinePredicateDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class TestCombinePredicateDao extends TestCase {

    private Session session;
    private CombinePredicateDao combineDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.combineDao = new CombinePredicateDao(session);
    }

    @Test
    public void testAndOperator() {
        List<ParentChildEmployeeEntity> data = this.combineDao.findBySalaryHigherThanAndJobName(
                new BigDecimal(3_100_000), "Software Engineer");
        List<String> collect = data.stream().map(ParentChildEmployeeEntity::getName)
                .collect(Collectors.toList());
        log.info("data: {}", collect);
        assertEquals("jumlah data", 3, data.size());
    }

    @Test
    public void testOrOperator() {
        List<ParentChildEmployeeEntity> data = this.combineDao.findBySalaryHigherThanOrJobName(
                new BigDecimal(3_100_000), "Software Engineer");
        List<String> collect = data.stream().map(ParentChildEmployeeEntity::getName)
                .collect(Collectors.toList());
        log.info("data: {}", collect);
        assertEquals("jumlah data", 8, data.size());
    }

    @Test
    public void testOrAndOperator() {
        List<ParentChildEmployeeEntity> data = this.combineDao.findBySalaryHigherThanAndJobNameOrManagerIsNotNull(
                new BigDecimal(3_100_000), "Software Engineer");
        List<String> collect = data.stream().map(ParentChildEmployeeEntity::getName)
                .collect(Collectors.toList());
        log.info("data: {}", collect);
        assertEquals("jumlah data", 4, data.size());
    }

    @Test
    public void testOrAndWithPriorityOperator() {
        List<ParentChildEmployeeEntity> data = this.combineDao.findBySalaryHigherThanOrJobNameAndManagerIsNotNullPriority(
                new BigDecimal(3_100_000), "Software Engineer");
        List<String> collect = data.stream().map(ParentChildEmployeeEntity::getName)
                .collect(Collectors.toList());
        log.info("data: {}", collect);
        assertEquals("jumlah data", 7, data.size());
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
