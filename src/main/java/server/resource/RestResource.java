package server.resource;

import model.Event;
import server.service.EventService;
import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class RestResource {

    @Autowired
    private EventService eventService;

    @GetMapping(value = "/event/{id}")
    public Mono<Event> eventById (@PathVariable("id") Long id) {
        return Mono.just(new Event(id, new Date()));
    }

    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Event> events () {

        Flux<Event> eventFlux = Flux
                .fromStream(Stream.generate(eventService::createEvent));
        Flux<Long> durationFlux = Flux.interval(Duration.ofSeconds(1));
        final Flux<Event> map = Flux.zip(eventFlux, durationFlux).map(Tuple2::getT1);
        return map;
    }
}
