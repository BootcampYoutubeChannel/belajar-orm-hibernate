package com.maryanto.dimas.bootcamp.latihan.config;

import com.maryanto.dimas.bootcamp.latihan.entity.Employees;
import com.maryanto.dimas.bootcamp.latihan.entity.Jobs;
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
            metadataSources.addAnnotatedClass(Jobs.class)
                    .addAnnotatedClass(Employees.class);
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
