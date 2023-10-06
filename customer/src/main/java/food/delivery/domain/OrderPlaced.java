package food.delivery.domain;

import food.delivery.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String foodId;
    private String options;
    private String address;
    private String customerId;
    private String storeId;
}
