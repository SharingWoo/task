import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by SharingWoo on 2017/2/24.
 */
@SpringBootApplication(scanBasePackages = {"indi.wsn.mytask"})
public class StartApp {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(StartApp.class, args);
    }

   /* @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }*/
}
