package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.entity.ParentChildEmployeeEntity;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.LikePredicateDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class TestLikePredicateDao extends TestCase {

    private Session session;
    private LikePredicateDao likeDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.likeDao = new LikePredicateDao(session);
    }

    @Test
    public void testWithoutExpresion() {
        String predicate = "Dimas Maryanto";
        List<ParentChildEmployeeEntity> data = this.likeDao.likeOperator(predicate);
        assertEquals("size data", 1, data.size());
        ParentChildEmployeeEntity empl = data.stream().findFirst().orElse(null);
        assertNotNull("not null", empl);
        assertEquals("nama ", predicate, empl.getName());
        log.info("data: {}", data);
    }

    @Test
    public void testStringExpressionContainChar() {
        String predicate = "%a%";
        List<ParentChildEmployeeEntity> list = this.likeDao.likeOperator(predicate);
        assertEquals("size data", 3, list.size());
        List<String> names = list.stream()
                .map(data -> data.getName())
                .collect(Collectors.toList());
        log.info("data: {}", names);
    }

    @Test
    public void testStringExpressionSecondCharIs() {
        String predicate = "_i%";
        List<ParentChildEmployeeEntity> list = this.likeDao.likeOperator(predicate);
        assertEquals("size data", 1, list.size());
        List<String> names = list.stream()
                .map(data -> data.getName())
                .collect(Collectors.toList());
        log.info("data: {}", names);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
