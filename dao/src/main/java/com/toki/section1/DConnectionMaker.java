package com.toki.section1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker{
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mariadb://localhost/study","toki0327", "toki0327"
        );

        return con;
    }
}
