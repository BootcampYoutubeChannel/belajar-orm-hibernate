package com.maryanto.dimas.bootcamp.hibernate.composite.primarykey;

import com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.embedded.dao.ClassRoomEmbeddedDao;
import com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.embedded.entity.ClassRoomEmbeddable;
import com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.embedded.entity.ClassRoomEmbedded;
import com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.idclass.dao.ClassRoomIdClassDao;
import com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.idclass.entity.ClassRoomIdClass;
import com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.idclass.entity.KeyClassRoomIdClass;
import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Optional;

@Ignore
@Slf4j
public class TestClassRoomIdClass extends TestCase {

    private Session session;
    private ClassRoomIdClassDao dao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.dao = new ClassRoomIdClassDao(session);
    }

    @Test
    public void testSaveMahasiswa() {
        ClassRoomIdClass classRoom = ClassRoomIdClass.builder()
                .classId("si-01")
                .year(2011)
                .name("SI - III")
                .description("System Informasi - III")
                .programStudy("IF")
                .build();

        this.session.beginTransaction();
//        save data and then return auto generated id
        classRoom = this.dao.save(classRoom);

//        commit
        this.session.getTransaction().commit();

        Optional<ClassRoomIdClass> classRoomOptional = this.dao.findById(KeyClassRoomIdClass.builder()
                .classId("si-01")
                .year(2011).build());

        assertTrue("classRoom find by id is present ", classRoomOptional.isPresent());
        log.info("classroom saved: {}", classRoomOptional.get());
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
