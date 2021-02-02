package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.entity.ParentChildEmployeeEntity;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.LimitOffsetDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class TestLimitOffsetDao extends TestCase {

    private Session session;
    private LimitOffsetDao offsetLimitDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.offsetLimitDao = new LimitOffsetDao(session);
    }

    @Test
    public void testOffsetData() {
        List<ParentChildEmployeeEntity> data = this.offsetLimitDao.offset(3);
        List<String> collect = data.stream().map(ParentChildEmployeeEntity::getName).collect(Collectors.toList());
        log.info("data: {size: {}, element: {}}", collect.size(), collect);
    }

    @Test
    public void testLimitData() {
        List<ParentChildEmployeeEntity> data = this.offsetLimitDao.limit(4);
        List<String> collect = data.stream().map(ParentChildEmployeeEntity::getName).collect(Collectors.toList());
        log.info("data: {size: {}, element: {}}", collect.size(), collect);
    }

    @Test
    public void testPaginate() {
        List<ParentChildEmployeeEntity> data = this.offsetLimitDao.offsetAndLimit(4, 5);
        List<String> collect = data.stream().map(ParentChildEmployeeEntity::getName).collect(Collectors.toList());
        log.info("data: {size: {}, element: {}}", collect.size(), collect);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
