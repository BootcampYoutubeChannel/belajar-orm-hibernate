package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.query.dto.AggregationModel;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.AggregateFunctionDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.math.BigDecimal;

@Slf4j
public class TestAggregateFunctionn extends TestCase {

    private Session session;
    private AggregateFunctionDao aggregateDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.aggregateDao = new AggregateFunctionDao(session);
    }

    @Test
    public void testFunctionAggregate() {
        AggregationModel data = this.aggregateDao.getDataAggregation();
        log.info("data: {}", data);
        assertNotNull("data not null", data);
    }

    @Test
    public void testFunctionAggregateSingle() {
        BigDecimal data = this.aggregateDao.getTotalSalary();
        log.info("data: {}", data);
        assertNotNull("data not null", data);
    }

    @Test
    public void testFunctionAggregateObjects() {
        Object[] data = this.aggregateDao.getDataAggregationObject();
        assertNotNull("data not null", data);
        log.info("{ count: {}, avg: {}, min: {}, max: {}, sum: {}}",
                data[0], data[1], data[2], data[3], data[4]);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
