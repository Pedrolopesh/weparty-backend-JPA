package com.weparty.api.Service;

import com.weparty.api.Model.EventModel;
import com.weparty.api.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<EventModel> index() {
        return (List<EventModel>) eventRepository.findAll();
    }

    public Object store(EventModel eventModel) {
        try {
            return eventRepository.save(eventModel);
        } catch (Exception e) {
            return e;
        }
    }
}
