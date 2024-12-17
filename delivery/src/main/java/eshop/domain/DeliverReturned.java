package eshop.domain;

import eshop.domain.*;
import eshop.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliverReturned extends AbstractEvent {

    private Long id;
    private Long orderid;
    private String userid;
    private Long productid;
    private String productname;
    private Integer qty;
    private String status;

    public DeliverReturned(Delivery aggregate) {
        super(aggregate);
    }

    public DeliverReturned() {
        super();
    }
}
//>>> DDD / Domain Event