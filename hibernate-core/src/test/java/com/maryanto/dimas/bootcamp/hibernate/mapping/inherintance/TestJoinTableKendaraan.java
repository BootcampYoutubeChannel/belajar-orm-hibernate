package com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.jointable.dao.JoinTableKendaraanDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.jointable.entity.JoinTableKendaraanEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.jointable.entity.JoinTableMobilEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.jointable.entity.JoinTableMotorEntity;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Optional;

@Slf4j
@Ignore
public class TestJoinTableKendaraan extends TestCase {

    private Session session;
    private JoinTableKendaraanDao kendaraanDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.kendaraanDao = new JoinTableKendaraanDao(session);
    }

    @Test
    public void testSaveMotor() {
        Transaction trx = this.session.beginTransaction();
        JoinTableKendaraanEntity s1000rr = JoinTableMotorEntity.builder()
                .nama("BMW S1000RR")
                .cc(1000)
                .jumlahCylinder(4)
                .jumlahRoda(2)
                .namaPabrikan("PT. BMW Motorrad")
                .jenisRantai("Rantai")
                .build();
        s1000rr = this.kendaraanDao.save(s1000rr);
        trx.commit();

        Optional<JoinTableMotorEntity> motorOptional = this.kendaraanDao.findByMotorId(s1000rr.getId());
        assertTrue("motor is present", motorOptional.isPresent());
        JoinTableMotorEntity testFindById = motorOptional.get();
        assertEquals("nama motor", testFindById.getNama(), s1000rr.getNama());
        log.info("mobil: {}", testFindById);
    }

    @Test
    public void testSaveMobil() {
        Transaction trx = this.session.beginTransaction();
        JoinTableKendaraanEntity hondaBrio = JoinTableMobilEntity.builder()
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

        Optional<JoinTableMobilEntity> mobilOptional = this.kendaraanDao.findByMobilId(hondaBrio.getId());
        assertTrue("mobil is present", mobilOptional.isPresent());
        JoinTableMobilEntity testFindById = mobilOptional.get();
        assertEquals("nama mobil", testFindById.getNama(), hondaBrio.getNama());
        log.info("mobil: {}", testFindById);
    }

    @Test
    public void testFindById() {
        this.session.beginTransaction();
        Optional<JoinTableKendaraanEntity> mobilOptional =
                this.kendaraanDao.findById("b6b49ca0-2357-430d-ba13-3c31c23366de");
        assertTrue("general is present", mobilOptional.isPresent());
        log.info("mobil: {}", mobilOptional.get());
    }

    @Test
    public void testFindByMobilId() {
        this.session.beginTransaction();
        Optional<JoinTableMobilEntity> mobilOptional =
                this.kendaraanDao.findByMobilId("7d6ac358-719f-4381-b52b-9b14e7114b1a");
        assertTrue("mobil is present", mobilOptional.isPresent());
        log.info("mobil: {}", mobilOptional.get());
    }

    @Test
    public void testFindByMotorId() {
        this.session.beginTransaction();
        Optional<JoinTableMotorEntity> mobilOptional =
                this.kendaraanDao.findByMotorId("b6b49ca0-2357-430d-ba13-3c31c23366de");
        assertTrue("motor is present", mobilOptional.isPresent());
        log.info("motor: {}", mobilOptional.get());
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
