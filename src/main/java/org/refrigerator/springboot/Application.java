/**
 * @class 프로젝트 메인 클래스. 여기부터 읽기 때문에 프로젝트 최상단에 위치해야 함.
 */
package org.refrigerator.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //내장 WAS(Web Application Server) 실행
        SpringApplication.run(Application.class, args);
    }
}
