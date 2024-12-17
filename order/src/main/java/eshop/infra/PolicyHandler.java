package eshop.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import eshop.config.kafka.KafkaProcessor;
import eshop.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCompleted'"
    )
    public void wheneverDeliveryCompleted_UpdateStatus(
        @Payload DeliveryCompleted deliveryCompleted
    ) {
        DeliveryCompleted event = deliveryCompleted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + deliveryCompleted + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliverReturned'"
    )
    public void wheneverDeliverReturned_UpdateStatus(
        @Payload DeliverReturned deliverReturned
    ) {
        DeliverReturned event = deliverReturned;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + deliverReturned + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SoldOut'"
    )
    public void wheneverSoldOut_RejectOrder(@Payload SoldOut soldOut) {
        SoldOut event = soldOut;
        System.out.println(
            "\n\n##### listener RejectOrder : " + soldOut + "\n\n"
        );

        // Sample Logic //
        Order.rejectOrder(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
