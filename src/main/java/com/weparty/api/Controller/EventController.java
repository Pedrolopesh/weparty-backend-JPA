package com.weparty.api.Controller;

import com.weparty.api.Model.EventModel;
import com.weparty.api.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Event")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventModel addEvent(@RequestBody EventModel eventModel) {
        return (EventModel) eventService.store(eventModel);
    }

    @GetMapping
    public List<EventModel> listAll() {
        return eventService.index();
    }
}
