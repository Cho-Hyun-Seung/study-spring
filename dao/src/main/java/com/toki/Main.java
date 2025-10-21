package com.toki;

import com.toki.section1.DAOFactory;
import com.toki.section1.DConnectionMaker;
import com.toki.section1.User;
import com.toki.section1.UserDAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDAO dao = new DAOFactory().userDAO();

        User user = new User();
        user.setId("99");
        user.setName("현승");
        user.setPassword("test");

        dao.add(user);

        System.out.println(user.getId() + ": 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());

        System.out.println(user2.getPassword());
        System.out.println(user2.getId() + ": 조회 성공");

    }
}