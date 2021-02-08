package com.maryanto.dimas.bootcamp.config;

import com.github.fluent.hibernate.cfg.scanner.EntityScanner;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

@Slf4j
public class HibernateConfiguration {
    private static final SessionFactory ourSessionFactory;

    static {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            MetadataSources metadataSources = new MetadataSources(registry);
            List<Class<?>> classes = EntityScanner
                    .scanPackages("com.maryanto.dimas.bootcamp.entity").result();
            for (Class<?> annotatedClass : classes) {
                metadataSources.addAnnotatedClass(annotatedClass);
            }
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
