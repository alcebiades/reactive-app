package server.resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestResourceTest {

    private WebTestClient webTestClient;

    @Before
    public void before () {
        this.webTestClient = WebTestClient.bindToServer()
                .baseUrl("http://localhost:8080").build();
    }

    @Test
    public void eventById () {
        this.webTestClient.get()
                .uri("/event/100")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }
}