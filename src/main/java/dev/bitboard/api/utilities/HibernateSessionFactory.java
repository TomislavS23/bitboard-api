package dev.bitboard.api.utilities;

import dev.bitboard.api.model.Role;
import dev.bitboard.api.model.User;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

public final class HibernateSessionFactory {
    private static final String CONNECTION_STRING = EnvironmentUtilities.get("CONNECTION_STRING");
    private static final String USERNAME = EnvironmentUtilities.get("PSQL_USERNAME");
    private static final String PASSWORD = EnvironmentUtilities.get("PSQL_PASSWORD");

    @Getter
    private static final SessionFactory sessionFactory;

    private HibernateSessionFactory() {
    }

    static {
        sessionFactory
                = new Configuration()
                .addAnnotatedClass(Role.class)
                .addAnnotatedClass(User.class)
                .setProperty(AvailableSettings.JAKARTA_JDBC_URL, CONNECTION_STRING)
                .setProperty(AvailableSettings.JAKARTA_JDBC_USER, USERNAME)
                .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, PASSWORD)
                .setProperty(AvailableSettings.SHOW_SQL, true)
                .setProperty(AvailableSettings.FORMAT_SQL, true)
                .setProperty(AvailableSettings.HIGHLIGHT_SQL, true)
                .buildSessionFactory();
    }

}
