package com.toki.section1;

public class DAOFactory {

    public UserDAO userDAO(){
        return new UserDAO(connectionMaker());
    }

    // connectionMaker 분리를 통해, 다른 DAO 생성 시, connection을 모두 하나하나 바꿀 필요가 없어짐!
//    public UserDAO userDAO(){
//        return new UserDAO(connectionMaker());
//    }

    public ConnectionMaker connectionMaker(){
        return new DConnectionMaker();
    }
}
