package client;

import java.util.Collections;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ReactiveClientApplication implements CommandLineRunner {

    public static void main (String[] args) {
        new SpringApplicationBuilder(ReactiveClientApplication.class)
                .properties(Collections.singletonMap("server.port", "8081"))
                .run(args);

    }

    @Override
    public void run (final String... args) throws Exception {
//        WebClient
//                .create("http://localhost:8080")
//                .get()
//                .uri("/events")
//                .accept(MediaType.TEXT_EVENT_STREAM)
//                .exchange()
//                .flatMap(cr -> cr.bodyToFlux(Event.class))
//                .subscribe(System.out::println);
    }
}
