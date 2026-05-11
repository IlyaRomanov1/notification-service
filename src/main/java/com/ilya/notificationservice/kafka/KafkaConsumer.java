package com.ilya.notificationservice.kafka;

import com.ilya.notificationservice.dtos.OrderViewDto;
import com.ilya.notificationservice.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final OrderService orderService;

    @KafkaListener(topics = "send-order", groupId = "my_consumer")
    public void listen(OrderViewDto orderDto){
        orderService.save(orderDto);
    }
}
