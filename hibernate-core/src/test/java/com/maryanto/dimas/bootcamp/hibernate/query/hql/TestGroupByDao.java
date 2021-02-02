package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.query.dto.GroupByModel;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.GroupByDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
public class TestGroupByDao extends TestCase {

    private Session session;
    private GroupByDao groupByDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.groupByDao = new GroupByDao(session);
    }

    /**
     * [
     *  GroupByModel(jobName=Chief Technology Officer, salary=10000000.00),
     *  GroupByModel(jobName=Software Engineer, salary=13000000.00),
     *  GroupByModel(jobName=Bisnis Analyst, salary=6900000.00),
     *  GroupByModel(jobName=Principal Software Engineer, salary=3500000.00)]
     */
    @Test
    public void testGroupBy() {
        List<GroupByModel> data = this.groupByDao.findGroupByJob();
        log.info("data: {}", data);
    }

    /**
     * [
     * GroupByModel(jobName=Chief Technology Officer, salary=10000000.00),
     * GroupByModel(jobName=Software Engineer, salary=13000000.00),
     * GroupByModel(jobName=Bisnis Analyst, salary=6900000.00)]
     */
    @Test
    public void testGroupByWithHaving() {
        List<GroupByModel> data = this.groupByDao.findGroupByJobWithHaving(new BigDecimal(5_000_000));
        log.info("data: {}", data);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
