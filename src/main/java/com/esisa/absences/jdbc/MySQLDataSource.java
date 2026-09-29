package com.esisa.absences.jdbc;

public class MySQLDataSource extends DataSource {
    public static final String MYSQL_BRIDGE = "jdbc:mysql:";

    private static String detectDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return "com.mysql.cj.jdbc.Driver";
        } catch (ClassNotFoundException e) {
            return "com.mysql.jdbc.Driver";
        }
    }

    private static String formatUrl(String host, String source) {
        return MYSQL_BRIDGE + "//" + host + "/" + source + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    }

    public MySQLDataSource(String host, String source, String username, String password) {
        super(detectDriver(), formatUrl(host, source), username, password);
    }
    public MySQLDataSource(String source, String username, String password) {
        this("localhost", source, username, password);
    }
    public MySQLDataSource(String source, String username) {
        this("localhost", source, username, "");
    }
    public MySQLDataSource(String source) {
        this("localhost", source, "root", "");
    }
}
