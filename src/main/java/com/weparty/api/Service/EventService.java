package com.weparty.api.Service;

import com.weparty.api.Model.EventModel;
import com.weparty.api.Model.UserResponseModel;
import com.weparty.api.Model.UserSystemModel;
import com.weparty.api.Repository.EventRepository;
import com.weparty.api.Repository.UserSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserSystemRepository userSystemRepository;

//    public List<EventModel> index() {
//        return (List<EventModel>) eventRepository.findAll();
//    }

    public List<EventModel> index() {
        List<EventModel> events = (List<EventModel>) eventRepository.findAll();

        // Agora, para cada evento, carregue o usuário associado
        events.forEach(event -> {
            UserSystemModel user = userSystemRepository.findById(Math.toIntExact(event.getEventUserId())).orElse(null);

            UserResponseModel userResponse = new UserResponseModel(user.getUserId(), user.getName(), user.getEmail(), user.getImage());

            event.setUserResponse(userResponse);
        });

        return events;
    }

    public Object store(EventModel eventModel) {
        try {
            return eventRepository.save(eventModel);
        } catch (Exception e) {
            return e;
        }
    }

    public Object update(Long id, EventModel updatedEvent) {
        Optional<EventModel> eventOptional = eventRepository.findById(Math.toIntExact(id));
        if (eventOptional.isPresent()) {
            EventModel existingEvent = eventOptional.get();
            existingEvent.setName(updatedEvent.getName());
            existingEvent.setDescription(updatedEvent.getDescription());
            existingEvent.setStartDate(updatedEvent.getStartDate());
            existingEvent.setEndDate(updatedEvent.getEndDate());
            existingEvent.setCountry(updatedEvent.getCountry());
            existingEvent.setZipCode(updatedEvent.getZipCode());
            existingEvent.setCity(updatedEvent.getCity());
            existingEvent.setState(updatedEvent.getState());
            existingEvent.setDistrict(updatedEvent.getDistrict());
            existingEvent.setStreet(updatedEvent.getStreet());
            existingEvent.setNumber(updatedEvent.getNumber());


            return eventRepository.save(existingEvent);
        } else {
            return "Perfil not found with id: " + id;
        }
    }

    public Object delete(Long id) {
        Optional<EventModel> eventOptional = eventRepository.findById(Math.toIntExact(id));
        if (eventOptional.isPresent()) {
            eventRepository.deleteById(Math.toIntExact(id));
            return "event_deleted_true";
        } else {
            return "event_deleted_false";
        }
    }

    public Object findById(Long id) {
        try {
            Optional<EventModel> eventOptional = eventRepository.findById(Math.toIntExact(id));
            return eventOptional;
        } catch (Exception e) {
            return  "not_found";
        }
    }
}
