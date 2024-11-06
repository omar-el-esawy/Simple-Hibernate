package org.example.util;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    @Getter
    final private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

}

//spring-boot-starter-data-jpa
//|
//|-- spring-boot-starter-jpa
//|   |-- spring-boot-starter
//|   |   |-- spring-boot
//|   |   |-- spring-boot-autoconfigure
//|   |   |-- spring-boot-starter-logging
//|   |
//|   |-- hibernate-core
//|   |   |-- antlr
//|   |   |-- dom4j
//|   |   |-- hibernate-jpa-2.1-api
//|   |   |-- javassist
//|   |   |-- jboss-logging
//|   |   |-- jboss-transaction-api_1.2_spec
//|   |
//|   |-- jakarta.persistence-api
//|   |-- spring-data-jpa
//|       |-- spring-data-commons
//|       |-- spring-orm
//|       |-- spring-aspects
//|
//|-- jakarta.persistence-api