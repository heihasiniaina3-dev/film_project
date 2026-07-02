package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    // Remplace "nom_de_ta_base" par "gestion_films"
    private static final String URL = "jdbc:postgresql://localhost:5432/gestion_films";
    private static final String USER = "postgres";
    private static final String PASSWORD = "ralay betrena";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}