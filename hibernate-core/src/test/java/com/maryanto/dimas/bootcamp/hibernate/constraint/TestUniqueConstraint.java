package com.maryanto.dimas.bootcamp.hibernate.constraint;

import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.hibernate.constraint.dao.ClassRoomWithUniquesConstraintDao;
import com.maryanto.dimas.bootcamp.hibernate.constraint.entity.ClassRoomWithUniquesConstraint;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
public class TestUniqueConstraint extends TestCase {

    private Session session;
    private ClassRoomWithUniquesConstraintDao dao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.dao = new ClassRoomWithUniquesConstraintDao(session);
    }

    @Test
    public void testInsertValid() {
        ClassRoomWithUniquesConstraint uniqueConstraint = ClassRoomWithUniquesConstraint.builder()
                .id(UUID.randomUUID().toString())
                .name("si-2")
                .year(2011)
                .createdBy("admin")
                .createdDateTime(LocalDateTime.now()).build();
        this.session.beginTransaction();
        this.dao.save(uniqueConstraint);
        this.session.getTransaction().commit();
    }

    @Test
    public void testInsertInValid() {
        this.session.beginTransaction();

        ClassRoomWithUniquesConstraint uniqueConstraint = ClassRoomWithUniquesConstraint.builder()
                .id(UUID.randomUUID().toString())
                .name("si-1")
                .year(2011)
                .createdBy("admin")
                .createdDateTime(LocalDateTime.now()).build();

        this.dao.save(uniqueConstraint);
        this.session.getTransaction().commit();

        uniqueConstraint = ClassRoomWithUniquesConstraint.builder()
                .id(UUID.randomUUID().toString())
                .name("si-1")
                .year(2011)
                .createdBy("admin")
                .createdDateTime(LocalDateTime.now()).build();
        this.session.beginTransaction();
        this.dao.save(uniqueConstraint);
        this.session.getTransaction().commit();
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
