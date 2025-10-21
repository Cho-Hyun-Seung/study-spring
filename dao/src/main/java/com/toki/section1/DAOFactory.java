package com.toki.section1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// 애플리케이션 컨텍스트 또는 빅 팩토리가 사용할 설정 정보라는 표시
@Configuration
public class DAOFactory {

    // 오브젝트 생성을 담당하는 IoC용 메소드라는 표시
    @Bean
    public UserDAO userDAO(){
        return new UserDAO(connectionMaker());
    }

    // connectionMaker 분리를 통해, 다른 DAO 생성 시, connection을 모두 하나하나 바꿀 필요가 없어짐!
//    public UserDAO userDAO(){
//        return new UserDAO(connectionMaker());
//    }

    @Bean
    public ConnectionMaker connectionMaker(){
        return new DConnectionMaker();
    }
}
