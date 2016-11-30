package rest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
public class Application  extends SpringBootServletInitializer {
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
//    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
//        RestTemplate restTemplate = new RestTemplate();
//        Test test=restTemplate.getForObject("http://localhost:8080/greeting1", Test.class);
//        System.out.println(test.getId()+";"+test.getContent());
//    }
}
