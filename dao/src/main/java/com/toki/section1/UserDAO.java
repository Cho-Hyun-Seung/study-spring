package com.toki.section1;

import java.sql.*;

public abstract class UserDAO {
    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
                "insert into users(id, name, password) values (?, ?, ?)"
        );

        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException{
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users where id = ?"
        );
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        con.close();

        return user;
    }

    /* 1. 커넥션 분리 */
    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;

    /* 2. sql 생성 분리 */


    /* 3. 커넥션 끊기 분리*/

}

