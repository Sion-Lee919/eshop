package eshop.domain;

import eshop.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class DeliveryCompleted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String userId;
    private Long productId;
    private String productName;
    private Integer qty;
    private String status;
}
