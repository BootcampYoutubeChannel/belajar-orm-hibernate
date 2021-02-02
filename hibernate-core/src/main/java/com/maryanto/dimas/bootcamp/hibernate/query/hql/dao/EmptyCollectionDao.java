package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import com.maryanto.dimas.bootcamp.hibernate.mapping.collection.entity.CollectionAsEmbeddedMahasiswa;
import com.maryanto.dimas.bootcamp.hibernate.mapping.collection.entity.CollectionAsValueMahasiswaEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.MahasiswaOneToManyEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmptyCollectionDao {

    private Session session;

    public EmptyCollectionDao(Session session) {
        this.session = session;
    }

    public List<CollectionAsValueMahasiswaEntity> emptyCollectionAsValue() {
        //language=HQL
        String hql = "select mhs\n" +
                "from CollectionAsValueMahasiswaEntity mhs\n" +
                "where mhs.contacts is empty";
        Query<CollectionAsValueMahasiswaEntity> query = this.session
                .createQuery(hql, CollectionAsValueMahasiswaEntity.class);
        return query.getResultList();
    }

    public List<CollectionAsValueMahasiswaEntity> notEmptyCollectionAsValue() {
        //language=HQL
        String hql = "select mhs\n" +
                "from CollectionAsValueMahasiswaEntity mhs\n" +
                "where mhs.contacts is not empty";
        Query<CollectionAsValueMahasiswaEntity> query = this.session
                .createQuery(hql, CollectionAsValueMahasiswaEntity.class);
        return query.getResultList();
    }

    public List<CollectionAsEmbeddedMahasiswa> emptyCollectionAsType() {
        //language=HQL
        String hql = "select mhs\n" +
                "from CollectionAsEmbeddedMahasiswa mhs\n" +
                "where mhs.addresses is empty";
        Query<CollectionAsEmbeddedMahasiswa> query = this.session
                .createQuery(hql, CollectionAsEmbeddedMahasiswa.class);
        return query.getResultList();
    }

    public List<CollectionAsEmbeddedMahasiswa> notEmptyCollectionAsType() {
        //language=HQL
        String hql = "select mhs\n" +
                "from CollectionAsEmbeddedMahasiswa mhs\n" +
                "where mhs.addresses is not empty";
        Query<CollectionAsEmbeddedMahasiswa> query = this.session
                .createQuery(hql, CollectionAsEmbeddedMahasiswa.class);
        return query.getResultList();
    }

    public List<MahasiswaOneToManyEntity> emptyCollectionAsEntity() {
        //language=HQL
        String hql = "select mhs\n" +
                "from MahasiswaOneToManyEntity mhs\n" +
                "where mhs.listAlamat is empty";
        Query<MahasiswaOneToManyEntity> query = this.session
                .createQuery(hql, MahasiswaOneToManyEntity.class);
        return query.getResultList();
    }

    public List<MahasiswaOneToManyEntity> notEmptyCollectionAsEntity() {
        //language=HQL
        String hql = "select mhs\n" +
                "from MahasiswaOneToManyEntity mhs\n" +
                "where mhs.listAlamat is not empty";
        Query<MahasiswaOneToManyEntity> query = this.session
                .createQuery(hql, MahasiswaOneToManyEntity.class);
        return query.getResultList();
    }
}
