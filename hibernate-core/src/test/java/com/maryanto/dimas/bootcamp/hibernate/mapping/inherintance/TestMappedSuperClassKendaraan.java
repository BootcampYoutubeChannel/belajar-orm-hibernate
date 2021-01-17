package com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.mappedsuperclass.dao.MappedSuperclassMobilDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.mappedsuperclass.dao.MappedSuperclassMotorDao;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.mappedsuperclass.entity.MappedSuperclassMobilEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.mappedsuperclass.entity.MappedSuperclassMotorEntity;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Optional;

@Slf4j
public class TestMappedSuperClassKendaraan extends TestCase {

    private Session session;
    private MappedSuperclassMobilDao mobilDao;
    private MappedSuperclassMotorDao motorDao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.mobilDao = new MappedSuperclassMobilDao(session);
        this.motorDao = new MappedSuperclassMotorDao(session);
    }

    @Test
    public void testSaveMobil() {
        MappedSuperclassMobilEntity hondaBrio = MappedSuperclassMobilEntity.builder()
                .nama("Honda BRIO")
                .allWheelDrive(false)
                .cc(1000)
                .jumlahCylinder(4)
                .jumlahKursi(4)
                .jumlahRoda(4)
                .namaPabrikan("PT. Honda Motor Company")
                .build();

        Transaction trx = this.session.beginTransaction();
        hondaBrio = this.mobilDao.save(hondaBrio);
        trx.commit();

        Optional<MappedSuperclassMobilEntity> optional = this.mobilDao.findById(hondaBrio.getId());
        assertTrue("mobil is present", optional.isPresent());
        hondaBrio = optional.get();
        log.info("mobil: {}", hondaBrio);
    }

    @Test
    public void testSaveMotor() {
        MappedSuperclassMotorEntity cbr150 = MappedSuperclassMotorEntity.builder()
                .nama("Honda CBR 150")
                .jenisRantai("Rantai")
                .cc(150)
                .jumlahCylinder(2)
                .jumlahRoda(2)
                .namaPabrikan("PT. Atra Honda Motor")
                .build();

        Transaction trx = this.session.beginTransaction();
        cbr150 = this.motorDao.save(cbr150);
        trx.commit();

        Optional<MappedSuperclassMotorEntity> optional = this.motorDao.findById(cbr150.getId());
        assertTrue("motor is present", optional.isPresent());
        cbr150 = optional.get();
        log.info("motor: {}", cbr150);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
