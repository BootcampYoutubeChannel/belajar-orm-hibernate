package com.maryanto.dimas.bootcamp.hibernate.composite.primarykey;

import com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.embedded.dao.ClassRoomEmbeddedDao;
import com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.embedded.entity.ClassRoomEmbeddable;
import com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.embedded.entity.ClassRoomEmbedded;
import com.maryanto.dimas.bootcamp.hibernate.config.HibernateConfiguration;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
@Slf4j
public class TestClassRoomEmbedded extends TestCase {

    private Session session;
    private ClassRoomEmbeddedDao dao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.dao = new ClassRoomEmbeddedDao(session);
    }

    @Test
    public void testSaveMahasiswa() {
        ClassRoomEmbedded classRoom = ClassRoomEmbedded.builder()
                .id(ClassRoomEmbeddable.builder()
                        .classId("si-iiI")
                        .year(2011)
                        .build()
                ).name("SI - III")
                .description("System Informasi - III")
                .programStudy("IF")
                .build();

        this.session.beginTransaction();
//        save data and then return auto generated id
        classRoom = this.dao.save(classRoom);

//        commit
        this.session.getTransaction().commit();

        log.info("classroom saved: {}", classRoom);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
