package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.CaseWhenConditionDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

@Slf4j
public class TestCaseWhenConditionDao extends TestCase {

    private Session session;
    private CaseWhenConditionDao caseWhenDao;


    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.caseWhenDao = new CaseWhenConditionDao(session);
    }
    @Test
    public void testSimpleExpresion() {
        String employeeWithManager = this.caseWhenDao.simpleCaseWhenExpresion("365eb4fc-d0b8-4d9b-98e9-8c51c9e10d4b");
        assertNotNull("not null", employeeWithManager);
        log.info("data: {}", employeeWithManager);

        String employeeWithoutManager = this.caseWhenDao.simpleCaseWhenExpresion("557a5a21-5b1f-4b9e-b79d-450b8efe075a");
        assertNotNull("not null", employeeWithoutManager);
        log.info("data: {}", employeeWithoutManager);
    }

    @Test
    public void testMultipleCondition() {
        String employeeWithManager = this.caseWhenDao.multipleConditionCaseWhenExpresion("365eb4fc-d0b8-4d9b-98e9-8c51c9e10d4b");
        assertNotNull("not null", employeeWithManager);
        log.info("data: {}", employeeWithManager);

        String employeeWithoutManager = this.caseWhenDao.multipleConditionCaseWhenExpresion("557a5a21-5b1f-4b9e-b79d-450b8efe075a");
        assertNotNull("not null", employeeWithoutManager);
        log.info("data: {}", employeeWithoutManager);
    }

    @Test
    public void testNestedCondition() {
        String employeeWithManager = this.caseWhenDao.nestedCaseWhenExpresion("365eb4fc-d0b8-4d9b-98e9-8c51c9e10d4b");
        assertNotNull("not null", employeeWithManager);
        log.info("data: {}", employeeWithManager);

        String employeeWithoutManager = this.caseWhenDao.nestedCaseWhenExpresion("557a5a21-5b1f-4b9e-b79d-450b8efe075a");
        assertNotNull("not null", employeeWithoutManager);
        log.info("data: {}", employeeWithoutManager);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
