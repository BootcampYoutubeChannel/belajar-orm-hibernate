package com.maryanto.dimas.bootcamp.latihan;

import com.maryanto.dimas.bootcamp.latihan.config.HibernateConfiguration;
import com.maryanto.dimas.bootcamp.latihan.dao.JobsDao;
import com.maryanto.dimas.bootcamp.latihan.entity.Jobs;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Optional;

@Slf4j
public class TestJobs extends TestCase {

    private Session session;
    private JobsDao dao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.dao = new JobsDao(session);
    }

    @Test
    public void testSaveJob() {
        this.session.beginTransaction();
        Jobs job = Jobs.builder()
                .nama("Programmer")
                .keterangan("create a project").build();
        job = this.dao.save(job);
        this.session.getTransaction().commit();
        assertNotNull("job id was return", job.getId());
    }

    @Test
    public void testUpdateJob() {
        this.session.beginTransaction();
        Jobs job = Jobs.builder()
                .id(1L)
                .nama("Programmer")
                .keterangan("create a project (Updated)").build();
        job = this.dao.update(job);
        this.session.getTransaction().commit();
    }

    @Test
    public void testFindById() {
        this.session.beginTransaction();
        Optional<Jobs> jobOptional = this.dao.findById(1L);
        assertTrue("job id present", jobOptional.isPresent());
        log.info("job => {}", jobOptional.get());
    }

    @Test
    public void testDeleteById() {
        this.session.beginTransaction();
        Optional<Jobs> jobOptional = this.dao.findById(1L);
        assertTrue("job id present", jobOptional.isPresent());
        log.info("job => {}", jobOptional.get());
        this.dao.removeBy(jobOptional.get());
        this.session.getTransaction().commit();
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
