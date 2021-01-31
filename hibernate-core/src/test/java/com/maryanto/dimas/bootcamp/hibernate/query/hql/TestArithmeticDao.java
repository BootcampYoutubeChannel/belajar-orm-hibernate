package com.maryanto.dimas.bootcamp.hibernate.query.hql;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.parentchild.entity.ParentChildEmployeeEntity;
import com.maryanto.dimas.bootcamp.hibernate.query.dto.ArithmeticModel;
import com.maryanto.dimas.bootcamp.hibernate.query.hql.dao.ArithmaticDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
public class TestArithmeticDao extends TestCase {

    private Session session;
    private ArithmaticDao arithmaticDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.arithmaticDao = new ArithmaticDao(session);
    }

    @Test
    public void testArithmeticModel() {
        List<ArithmeticModel> data = this.arithmaticDao.selectWithArithmeticModel("365eb4fc-d0b8-4d9b-98e9-8c51c9e10d4b");
        log.info("data: {}", data);
    }

    @Test
    public void testArithmeticAggregation() {
        BigDecimal saldo = this.arithmaticDao.hitungTotalSalarySemuaEmployeeDalamSetahun();
        log.info("data: {}", saldo);
    }

    @Test
    public void testArithmeticWhereClause() {
        List<ParentChildEmployeeEntity> data = this.arithmaticDao.cariKaryawanYangSalaryDalamSetahunDiatas(new BigDecimal(37_000_000));
        log.info("data: {}", data);
        assertEquals("jumlah data ", 2, data.size());
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
