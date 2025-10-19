package com.toki.section1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* connection 상속 관리 */
public class NUserDAO extends UserDAO{

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mariadb://localhost/study","toki0327", "toki0327"
        );
        
        return con;
    }
}
