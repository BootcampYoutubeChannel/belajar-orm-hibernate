package com.maryanto.dimas.bootcamp.hibernate.config;

import com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.embedded.entity.ClassRoomEmbedded;
import com.maryanto.dimas.bootcamp.hibernate.compose.primarykey.idclass.entity.ClassRoomIdClass;
import com.maryanto.dimas.bootcamp.hibernate.constraint.entity.ClassRoomWithUniquesConstraint;
import com.maryanto.dimas.bootcamp.hibernate.constraint.entity.EmployeeWithCheckConstraint;
import com.maryanto.dimas.bootcamp.hibernate.generator.entity.ClassRoomWithSequenceGenerator;
import com.maryanto.dimas.bootcamp.hibernate.generator.entity.ClassRoomWithUuidGenerator;
import com.maryanto.dimas.bootcamp.hibernate.mapping.embedded.entity.MahasiswaEmbedded;
import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity.EmployeeEnumOrdinal;
import com.maryanto.dimas.bootcamp.hibernate.mapping.enumeration.entity.EmployeeEnumString;
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
                    .addAnnotatedClass(MahasiswaEmbedded.class);
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
