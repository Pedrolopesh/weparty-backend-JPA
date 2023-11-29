package com.weparty.api.Controller;

import com.weparty.api.Model.EventModel;
import com.weparty.api.Model.UserResponseModel;
import com.weparty.api.Model.UserSystemModel;
import com.weparty.api.Repository.UserSystemRepository;
import com.weparty.api.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/event")
public class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    private UserSystemRepository userSystemRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventModel addEvent(@RequestBody EventModel eventModel) {
//        Optional<UserSystemModel> user = userSystemRepository.findById(Math.toIntExact(eventModel.getEventUserId()));
//
//        if (user.isPresent()) {
//            eventModel.setUser(user.get()); // Relacionamento entre evento e o usuário que criou o evento
//            return (EventModel) eventService.store(eventModel);
//        }
//
//        return null;
        Optional<UserSystemModel> userOptional = userSystemRepository.findById(Math.toIntExact(eventModel.getEventUserId()));

        if (userOptional.isPresent()) {
            UserSystemModel user = userOptional.get();
            eventModel.setUser(user); // Establish relationship between the event and the user
            EventModel createdEvent = (EventModel) eventService.store(eventModel);

            // Create a response without the password
            UserResponseModel userResponse = new UserResponseModel(user.getUserId(), user.getName(), user.getEmail(), user.getImage());
            createdEvent.setUserResponse(userResponse);

            return createdEvent;
        }

        return null;
    }

    @GetMapping("/all")
    public List<EventModel> listAll() {
        return eventService.index();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEvent(@PathVariable Long id, @RequestBody EventModel updatedEvent) {
        Object result = eventService.update(id, updatedEvent);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEvent(@PathVariable Long id) {
        Object result = eventService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEventById(@PathVariable Long id) {
        Object result = eventService.findById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
