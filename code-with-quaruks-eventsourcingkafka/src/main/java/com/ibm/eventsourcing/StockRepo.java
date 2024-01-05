package com.ibm.eventsourcing;

import java.util.List;

import io.smallrye.mutiny.Uni;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StockRepo implements PanacheRepository<Stock> {
    public Uni<List<Stock>> findByName(String name) {
        //SELECT *FROM stock WHERE name=name
        return list("name", name);
    }
}