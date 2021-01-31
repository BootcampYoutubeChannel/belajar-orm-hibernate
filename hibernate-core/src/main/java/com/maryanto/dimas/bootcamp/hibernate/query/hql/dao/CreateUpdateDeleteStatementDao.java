package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.repository.CrudRepository;
import com.maryanto.dimas.bootcamp.hibernate.simple.entity.master.Mahasiswa;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Slf4j
public class CreateUpdateDeleteStatementDao implements CrudRepository<Mahasiswa, Long> {
    private Session session;

    public CreateUpdateDeleteStatementDao(Session session) {
        this.session = session;
    }

    @Override
    public Mahasiswa save(Mahasiswa value) throws HibernateException {
        Long returnKey = (Long) this.session.save(value);
        value.setKode(returnKey);
        return value;
    }

    @Override
    public Mahasiswa update(Mahasiswa value) throws HibernateException {
        //language=HQL
        String hql = "update Mahasiswa \n" +
                "set nama = :nama, thnMasuk = :tahunMasuk, active = :status, biodata = :bio \n" +
                "where kode = :id";
        int rowUpdated = this.session.createQuery(hql)
                .setParameter("id", value.getKode())
                .setParameter("status", value.getActive())
                .setParameter("nama", value.getNama())
                .setParameter("tahunMasuk", value.getThnMasuk())
                .setParameter("bio", value.getBiodata())
                .executeUpdate();
        log.info("updated rows in mahasiswa: {}", rowUpdated);
        return value;
    }

    @Override
    public boolean removeById(Long value) throws HibernateException {
        String hql = "delete from Mahasiswa \n" +
                "where id = :id";
        int rowUpdated = this.session.createQuery(hql)
                .setParameter("id", value)
                .executeUpdate();
        return rowUpdated >= 1;
    }

    @Override
    public Optional<Mahasiswa> findById(Long value) {
        try {
            //language=HQL
            String hql = "from Mahasiswa where id = :id";
            Mahasiswa data = this.session.createQuery(hql, Mahasiswa.class)
                    .setParameter("id", value)
                    .getSingleResult();
            return data != null ? Optional.of(data) : Optional.empty();
        } catch (NoResultException nre) {
            return Optional.empty();
        }
    }

    @Override
    public List<Mahasiswa> findAll() {
        //language=HQL
        String hql = "from Mahasiswa";
        return this.session.createQuery(hql, Mahasiswa.class)
                .getResultList();
    }
}
