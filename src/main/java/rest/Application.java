package rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import authority.SecurityConfiguration;
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration(exclude={MultipartAutoConfiguration.class})
@EnableScheduling
@EnableWebSecurity
@Import(SecurityConfiguration.class)
public class Application  extends SpringBootServletInitializer {
	//对上传文件的大小做限制
	@Bean(name = "multipartResolver")
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		resolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
		resolver.setMaxInMemorySize(40960);
		resolver.setMaxUploadSize(200*1024*1024);//上传文件大小 50M 50*1024*1024
		return resolver;
	}
	
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
