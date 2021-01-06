package com.maryanto.dimas.bootcamp.hibernate.generator;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.generator.dao.ClassRoomWithSequenceGeneratorDao;
import com.maryanto.dimas.bootcamp.hibernate.generator.dao.ClassRoomWithUuidGeneratorDao;
import com.maryanto.dimas.bootcamp.hibernate.generator.entity.ClassRoomWithSequenceGenerator;
import com.maryanto.dimas.bootcamp.hibernate.generator.entity.ClassRoomWithUuidGenerator;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.time.LocalDateTime;

@Slf4j
public class TestClassRoomWithUuidGenerator extends TestCase {

    private Session session;
    private ClassRoomWithUuidGeneratorDao dao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.dao = new ClassRoomWithUuidGeneratorDao(session);
    }

    @Test
    public void testInsertValid() {
        ClassRoomWithUuidGenerator check = ClassRoomWithUuidGenerator.builder()
                .name("SI-02")
                .year(2011)
                .createdBy("admin")
                .createdDateTime(LocalDateTime.now()).build();

        this.session.beginTransaction();
        check = this.dao.save(check);
        log.info("inserted value: {}", check);
        this.session.getTransaction().commit();
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
