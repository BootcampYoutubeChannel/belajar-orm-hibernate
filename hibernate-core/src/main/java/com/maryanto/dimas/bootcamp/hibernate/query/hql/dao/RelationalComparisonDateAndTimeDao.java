package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.MahasiswaOneToOneEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class RelationalComparisonDateAndTimeDao {

    private Session session;

    public RelationalComparisonDateAndTimeDao(Session session) {
        this.session = session;
    }

    public List<MahasiswaOneToOneEntity> findEqualByTanggalLahir(LocalDate tanggalLahir) {
        //language=HQL
        String hql = "from MahasiswaOneToOneEntity where tanggalLahir = :tanggalLahir";
        Query<MahasiswaOneToOneEntity> query = this.session.createQuery(hql, MahasiswaOneToOneEntity.class)
                .setParameter("tanggalLahir", tanggalLahir);
        return query.getResultList();
    }

    public List<MahasiswaOneToOneEntity> findNotSameByTanggalLahir(LocalDate tanggalLahir) {
        //language=HQL
        String hql = "from MahasiswaOneToOneEntity where tanggalLahir != :tanggalLahir";
        Query<MahasiswaOneToOneEntity> query = this.session.createQuery(hql, MahasiswaOneToOneEntity.class)
                .setParameter("tanggalLahir", tanggalLahir);
        return query.getResultList();
    }

    public List<MahasiswaOneToOneEntity> findNotEqualByTanggalLahir(LocalDate tanggalLahir) {
        //language=HQL
        String hql = "from MahasiswaOneToOneEntity where tanggalLahir <> :tanggalLahir";
        Query<MahasiswaOneToOneEntity> query = this.session.createQuery(hql, MahasiswaOneToOneEntity.class)
                .setParameter("tanggalLahir", tanggalLahir);
        return query.getResultList();
    }

    public List<MahasiswaOneToOneEntity> findHigherByTanggalLahir(LocalDate tanggalLahir) {
        //language=HQL
        String hql = "from MahasiswaOneToOneEntity where tanggalLahir > :tanggalLahir";
        Query<MahasiswaOneToOneEntity> query = this.session.createQuery(hql, MahasiswaOneToOneEntity.class)
                .setParameter("tanggalLahir", tanggalLahir);
        return query.getResultList();
    }

    public List<MahasiswaOneToOneEntity> findHigherThanByTanggalLahir(LocalDate tanggalLahir) {
        //language=HQL
        String hql = "from MahasiswaOneToOneEntity where tanggalLahir >= :tanggalLahir";
        Query<MahasiswaOneToOneEntity> query = this.session.createQuery(hql, MahasiswaOneToOneEntity.class)
                .setParameter("tanggalLahir", tanggalLahir);
        return query.getResultList();
    }

    public List<MahasiswaOneToOneEntity> findLowerByTanggalLahir(LocalDate tanggalLahir) {
        //language=HQL
        String hql = "from MahasiswaOneToOneEntity where tanggalLahir < :tanggalLahir";
        Query<MahasiswaOneToOneEntity> query = this.session.createQuery(hql, MahasiswaOneToOneEntity.class)
                .setParameter("tanggalLahir", tanggalLahir);
        return query.getResultList();
    }

    public List<MahasiswaOneToOneEntity> findLowerThanByTanggalLahir(LocalDate tanggalLahir) {
        //language=HQL
        String hql = "from MahasiswaOneToOneEntity where tanggalLahir <= :tanggalLahir";
        Query<MahasiswaOneToOneEntity> query = this.session.createQuery(hql, MahasiswaOneToOneEntity.class)
                .setParameter("tanggalLahir", tanggalLahir);
        return query.getResultList();
    }
}
