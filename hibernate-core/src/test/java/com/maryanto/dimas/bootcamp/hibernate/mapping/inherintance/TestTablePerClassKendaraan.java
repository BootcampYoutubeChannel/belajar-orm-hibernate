package com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.tableperclass.dao.TablePerClassKendaraanDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.tableperclass.entity.TablePerClassKendaraanEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.tableperclass.entity.TablePerClassMobilEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.tableperclass.entity.TablePerClassMotorEntity;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Optional;

@Slf4j
@Ignore
public class TestTablePerClassKendaraan extends TestCase {

    private Session session;
    private TablePerClassKendaraanDao kendaraanDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.kendaraanDao = new TablePerClassKendaraanDao(session);
    }

    @Test
    public void testSaveMotor() {
        Transaction trx = this.session.beginTransaction();
        TablePerClassKendaraanEntity s1000rr = TablePerClassMotorEntity.builder()
                .nama("BMW S1000RR")
                .cc(1000)
                .jumlahCylinder(4)
                .jumlahRoda(2)
                .namaPabrikan("PT. BMW Motorrad")
                .jenisRantai("Rantai")
                .build();
        s1000rr = this.kendaraanDao.save(s1000rr);
        trx.commit();

        Optional<TablePerClassMotorEntity> motorOptional = this.kendaraanDao.findByMotorId(s1000rr.getId());
        assertTrue("motor is present", motorOptional.isPresent());
        TablePerClassMotorEntity testFindById = motorOptional.get();
        assertEquals("nama motor", testFindById.getNama(), s1000rr.getNama());
        log.info("mobil: {}", testFindById);
    }

    @Test
    public void testSaveMobil() {
        Transaction trx = this.session.beginTransaction();
        TablePerClassKendaraanEntity hondaBrio = TablePerClassMobilEntity.builder()
                .nama("Honda BRIO")
                .allWheelDrive(false)
                .cc(1000)
                .jumlahCylinder(4)
                .jumlahKursi(4)
                .jumlahRoda(4)
                .namaPabrikan("PT. Honda Motor Company")
                .build();
        hondaBrio = this.kendaraanDao.save(hondaBrio);
        trx.commit();

        Optional<TablePerClassMobilEntity> mobilOptional = this.kendaraanDao.findByMobilId(hondaBrio.getId());
        assertTrue("mobil is present", mobilOptional.isPresent());
        TablePerClassMobilEntity testFindById = mobilOptional.get();
        assertEquals("nama mobil", testFindById.getNama(), hondaBrio.getNama());
        log.info("mobil: {}", testFindById);
    }

    @Test
    public void testFindById() {
        this.session.beginTransaction();
        Optional<TablePerClassKendaraanEntity> generalOptional =
                this.kendaraanDao.findById("24ee59de-ef6c-4c21-8cfd-d91489917c7a");
        assertTrue("general is present", generalOptional.isPresent());
        log.info("mobil: {}", generalOptional.get());
    }

    @Test
    public void testFindByMobilId() {
        this.session.beginTransaction();
        Optional<TablePerClassMobilEntity> mobilOptional =
                this.kendaraanDao.findByMobilId("24ee59de-ef6c-4c21-8cfd-d91489917c7a");
        assertTrue("mobil is present", mobilOptional.isPresent());
        log.info("mobil: {}", mobilOptional.get());
    }

    @Test
    public void testFindByMotorId() {
        this.session.beginTransaction();
        Optional<TablePerClassMotorEntity> motorOptional =
                this.kendaraanDao.findByMotorId("24ee59de-ef6c-4c21-8cfd-d91489917c7a");
        assertTrue("motor is present", motorOptional.isPresent());
        log.info("motor: {}", motorOptional.get());
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
