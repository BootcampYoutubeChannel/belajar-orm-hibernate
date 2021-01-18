package com.maryanto.dimas.bootcamp.hibernate.config;

import com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.embedded.entity.ClassRoomEmbedded;
import com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.idclass.entity.ClassRoomIdClass;
import com.maryanto.dimas.bootcamp.hibernate.constraint.entity.ClassRoomWithUniquesConstraint;
import com.maryanto.dimas.bootcamp.hibernate.constraint.entity.EmployeeWithCheckConstraint;
import com.maryanto.dimas.bootcamp.hibernate.generator.entity.ClassRoomWithSequenceGenerator;
import com.maryanto.dimas.bootcamp.hibernate.generator.entity.ClassRoomWithUuidGenerator;
import com.maryanto.dimas.bootcamp.hibernate.mapping.embedded.entity.MahasiswaEmbedded;
import com.maryanto.dimas.bootcamp.hibernate.mapping.embedded.entity.MahasiswaEmbeddedOverrideAttributes;
import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity.EmployeeEnumOrdinal;
import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity.EmployeeEnumString;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.jointable.entity.JoinTableKendaraanEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.jointable.entity.JoinTableMobilEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.jointable.entity.JoinTableMotorEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.mappedsuperclass.entity.MappedSuperclassKendaraanEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.mappedsuperclass.entity.MappedSuperclassMobilEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.mappedsuperclass.entity.MappedSuperclassMotorEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.singletable.entity.SingleTableKendaraanEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.singletable.entity.SingleTableMobilEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.inherintance.singletable.entity.SingleTableMotorEntity;
import com.maryanto.dimas.bootcamp.hibernate.mapping.jointable.entity.*;
import com.maryanto.dimas.bootcamp.hibernate.simple.entity.master.Mahasiswa;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

@Slf4j
public class HibernateConfiguration {

    private static final SessionFactory ourSessionFactory;

    static {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            MetadataSources metadataSources = new MetadataSources(registry);
            metadataSources.addAnnotatedClass(Mahasiswa.class)
                    .addAnnotatedClass(ClassRoomWithUniquesConstraint.class)
                    .addAnnotatedClass(EmployeeWithCheckConstraint.class)
                    .addAnnotatedClass(ClassRoomWithSequenceGenerator.class)
                    .addAnnotatedClass(ClassRoomWithUuidGenerator.class)
                    .addAnnotatedClass(ClassRoomEmbedded.class)
                    .addAnnotatedClass(ClassRoomIdClass.class)
                    .addAnnotatedClass(EmployeeEnumOrdinal.class)
                    .addAnnotatedClass(EmployeeEnumString.class)
                    .addAnnotatedClass(MahasiswaEmbedded.class)
                    .addAnnotatedClass(MahasiswaEmbeddedOverrideAttributes.class)
                    .addAnnotatedClass(AlamatOneToOneEntity.class)
                    .addAnnotatedClass(MahasiswaOneToOneEntity.class)
                    .addAnnotatedClass(MahasiswaOneToManyEntity.class)
                    .addAnnotatedClass(AlamatOneToManyEntity.class)
                    .addAnnotatedClass(MahasiswaManyToOneEntity.class)
                    .addAnnotatedClass(KelasManyToOneEntity.class)
                    .addAnnotatedClass(MahasiswaManyToManyEntity.class)
                    .addAnnotatedClass(MatakuliahManyToManyEntity.class)
                    .addAnnotatedClass(MappedSuperclassKendaraanEntity.class)
                    .addAnnotatedClass(MappedSuperclassMobilEntity.class)
                    .addAnnotatedClass(MappedSuperclassMotorEntity.class)
                    .addAnnotatedClass(SingleTableKendaraanEntity.class)
                    .addAnnotatedClass(SingleTableMobilEntity.class)
                    .addAnnotatedClass(SingleTableMotorEntity.class)
                    .addAnnotatedClass(JoinTableKendaraanEntity.class)
                    .addAnnotatedClass(JoinTableMotorEntity.class)
                    .addAnnotatedClass(JoinTableMobilEntity.class);
            ourSessionFactory = metadataSources.buildMetadata().buildSessionFactory();

        } catch (Throwable ex) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }
}
