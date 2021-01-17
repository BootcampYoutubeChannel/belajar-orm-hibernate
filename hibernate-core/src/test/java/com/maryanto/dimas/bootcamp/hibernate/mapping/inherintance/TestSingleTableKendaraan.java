package com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.singletable.dao.SingleTableKendaraanDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.singletable.entity.SingleTableKendaraanEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.singletable.entity.SingleTableMobilEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.singletable.entity.SingleTableMotorEntity;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Optional;

@Ignore
@Slf4j
public class TestSingleTableKendaraan extends TestCase {

    private Session session;
    private SingleTableKendaraanDao kendaraanDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.kendaraanDao = new SingleTableKendaraanDao(session);
    }

    @Test
    public void testSaveMobil() {
        Transaction trx = this.session.beginTransaction();
        log.info("connected!");

        SingleTableKendaraanEntity hondaBrio = SingleTableMobilEntity.builder()
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
        Optional<SingleTableMobilEntity> mobilOptional = this.kendaraanDao.findByMobilId(hondaBrio.getId());
        assertTrue("mobil is present", mobilOptional.isPresent());
        SingleTableMobilEntity testFindById = mobilOptional.get();
        assertEquals("nama mobil", testFindById.getNama(), hondaBrio.getNama());
        log.info("mobil: {}", testFindById);
    }

    @Test
    public void testSaveMotor() {
        Transaction trx = this.session.beginTransaction();
        log.info("connected!");

        SingleTableKendaraanEntity s1000rr = SingleTableMotorEntity.builder()
                .nama("BMW S1000RR")
                .cc(1000)
                .jumlahCylinder(4)
                .jumlahRoda(2)
                .namaPabrikan("PT. BMW Motorrad")
                .jenisRantai("Rantai")
                .build();
        s1000rr = this.kendaraanDao.save(s1000rr);
        trx.commit();
        Optional<SingleTableMotorEntity> motorOptional = this.kendaraanDao.findByMotorId(s1000rr.getId());
        assertTrue("motor is present", motorOptional.isPresent());
        SingleTableMotorEntity testFindById = motorOptional.get();
        assertEquals("nama motor", testFindById.getNama(), s1000rr.getNama());
        log.info("mobil: {}", testFindById);
    }

    @Test
    public void testFindById() {
        Transaction trx = this.session.beginTransaction();
        log.info("connected!");
        Optional<SingleTableKendaraanEntity> motorOptional = this.kendaraanDao.findById("66f43f8e-2fb9-417e-a8a5-92886f708d54");
        assertTrue("motor is present", motorOptional.isPresent());
        SingleTableKendaraanEntity testFindById = motorOptional.get();
        log.info("kedaraan: {}", testFindById);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
