package terra

import java.util.Arrays
import org.springframework.context.ApplicationContext
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.boot.SpringApplication

@SpringBootApplication
class Application {

    @Bean
    fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner =
            CommandLineRunner { args: Array<String?>? ->
                println("Let's inspect the beans provided by Spring Boot:")
                val beanNames = ctx.beanDefinitionNames
                Arrays.sort(beanNames)
                for (beanName in beanNames) {
                    println(beanName)
                }
            }

}

fun main(args: Array<String>) {
    println("Hello Liquibase")
    SpringApplication.run(Application::class.java, *args)
}