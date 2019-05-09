package server.service;

import model.Event;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    public Event createEvent () {
        return new Event(System.currentTimeMillis(), new Date());
    }
}
