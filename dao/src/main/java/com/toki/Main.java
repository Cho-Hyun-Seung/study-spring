package com.toki;

import com.toki.section1.User;
import com.toki.section1.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        /* 어플리케이션 컨텍스트 정보 가져오기 */
        ApplicationContext context = new AnnotationConfigApplicationContext();

        /* getBean은 기본적으로 Object 타입을 return 하기 때문에 매번 리턴되는 오브젝트를 타입 캐스팅 해주어야 함
        * 하지만 generic 방식을 사용해 타입을지정해주면 캐스팅 코드 사용할 필요 없음 */
        UserDAO dao = context.getBean("userDAO", UserDAO.class);

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