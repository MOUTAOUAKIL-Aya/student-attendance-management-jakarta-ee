package com.esisa.absences.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
    private String driver;
    private String url;
    private String username;
    private String password;

    public DataSource() {}
    public DataSource(String driver, String url, String username, String password) {
        this.driver = driver; this.url = url; this.username = username; this.password = password;
    }
    public String getDriver() { return driver; }
    public void setDriver(String driver) { this.driver = driver; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Connection getConnection() {
        try {
            Class.forName(driver);
            Connection db = DriverManager.getConnection(url, username, password);
            System.out.println("Connexion bien établie...");
            return db;
        } catch (Exception e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
            return null;
        }
    }
}
