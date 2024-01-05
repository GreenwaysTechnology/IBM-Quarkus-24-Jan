package com.ibm.eventsourcing;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockAddedEvent implements StockEvent {
    private  Stock stockDetails;
}
