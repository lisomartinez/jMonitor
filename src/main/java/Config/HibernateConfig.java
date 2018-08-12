package Config;

import Entities.Profile;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateConfig {

    private Properties properties;
    private Configuration configuration;
    private SessionFactory sessionFactory;


    public void HibernateConfig() {
        this.properties = new Properties();
        this.configuration = new Configuration()
                .setProperties(properties)
                .addAnnotatedClass(Profile.class);

    }

    public SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            sessionFactory = configuration.buildSessionFactory();
        }

        return sessionFactory;
    }


}
