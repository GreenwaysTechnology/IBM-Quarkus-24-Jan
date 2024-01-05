package com.ibm.eventsourcing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class EventService {


    @Inject
    @Channel("stock")
    Emitter<EventRecord> template;

    public void addEvent(StockAddedEvent event) throws JsonProcessingException {

        //Prepare Event Record(Object),populate all event data
        EventRecord eventRecord = new EventRecord();
        eventRecord.setEventData(new ObjectMapper().writeValueAsString(event.getStockDetails()));
        eventRecord.setEventType(StockStatus.STOCK_ADDED.name());
        eventRecord.setEventId(UUID.randomUUID().getMostSignificantBits());
        eventRecord.setEntityId(event.getStockDetails().getName());
        eventRecord.setEventTime(LocalDateTime.now());
        //publish event into kafka
        var future = template.send(eventRecord);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println(result);
            } else {
                System.out.println(ex.getMessage());
            }
        });
    }

    public void addEvent(StockRemovedEvent event) throws JsonProcessingException {
        EventRecord eventRecord = new EventRecord();
        eventRecord.setEventData(new ObjectMapper().writeValueAsString(event.getStockDetails()));
        eventRecord.setEventType(StockStatus.STOCK_REMOVED.name());
        eventRecord.setEventId(UUID.randomUUID().getMostSignificantBits());
        eventRecord.setEntityId(event.getStockDetails().getName());
        eventRecord.setEventTime(LocalDateTime.now());
        var future = template.send(eventRecord);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println(result);
            } else {
                System.out.println(ex.getMessage());
            }
        });
    }


}
