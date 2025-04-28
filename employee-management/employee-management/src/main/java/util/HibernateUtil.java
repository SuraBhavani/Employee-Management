package util;

import model.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration config = new Configuration();

            // Database connection settings
            config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/ems_db");
            config.setProperty("hibernate.connection.username", "root");
            config.setProperty("hibernate.connection.password", "Mohith@123");

            // Hibernate settings
            config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
            config.setProperty("hibernate.hbm2ddl.auto", "update");
            config.setProperty("hibernate.show_sql", "true");

            // Register entity class
            config.addAnnotatedClass(Employee.class);

            // Build session factory
            StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder().applySettings(config.getProperties());

            sessionFactory = config.buildSessionFactory(builder.build());

        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
