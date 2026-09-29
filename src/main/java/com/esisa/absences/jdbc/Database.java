package com.esisa.absences.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Database {
    private DataSource dataSource;
    private Connection db;

    public Database(DataSource dataSource) {
        this.dataSource = dataSource;
        this.db = dataSource.getConnection();
    }

    public String[][] executeSelect(String query) {
        if (db == null) {
            System.err.println("Database connection is null. Please verify MySQL service and credentials.");
            return new String[0][0];
        }
        try {
            Statement sql = db.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = sql.executeQuery(query);
            rs.last();
            int rows = rs.getRow();
            rs.beforeFirst();
            ResultSetMetaData rsm = rs.getMetaData();
            int cols = rsm.getColumnCount();
            String data[][] = new String[rows][cols];
            int row = 0;
            while (rs.next()) {
                for (int col = 0; col < cols; col++) data[row][col] = rs.getString(col + 1);
                row++;
            }
            rs.close();
            return data;
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
            return new String[0][0];
        }
    }

    public String[][] selectAll(String tableName) { return executeSelect("SELECT * FROM " + tableName); }
    public String[][] selectByKeyword(String tableName, String key, Object value) {
        return executeSelect("SELECT * FROM " + tableName + " WHERE " + key + " LIKE '%" + value + "%'");
    }
    public String[][] selectById(String tableName, String id, Object value) {
        return executeSelect("SELECT * FROM " + tableName + " WHERE " + id + " = '" + value + "'");
    }
    public String[][] selectWhere(String tableName, String condition) {
        return executeSelect("SELECT * FROM " + tableName + " WHERE " + condition);
    }
    public int insert(String tableName, Object... row) {
        StringBuffer query = new StringBuffer("INSERT INTO " + tableName + " VALUES('");
        query.append(row[0]).append("'");
        for (int i = 1; i < row.length; i++) query.append(",'" + row[i] + "'");
        query.append(")");
        System.out.println(">> SQL QUERY :" + query);
        if (db == null) {
            System.err.println("Database connection is null. Please verify MySQL service and credentials.");
            return 0;
        }
        try {
            Statement sql = db.createStatement();
            return sql.executeUpdate(query.toString());
        } catch (Exception e) {
            System.out.println("Erreur d'insertion : " + e.getMessage());
            return 0;
        }
    }
}
