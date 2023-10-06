package food.delivery.domain;

import food.delivery.RiderApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Delivery_table")
@Data
//<<< DDD / Aggregate Root
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;

    private String orderId;

    private String address;

    @PostPersist
    public void onPostPersist() {}

    @PreUpdate
    public void onPreUpdate() {}

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    //<<< Clean Arch / Port Method
    public void pick(PickCommand pickCommand) {
        //implement business logic here:

        Picked picked = new Picked(this);
        picked.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void delivery(DeliveryCommand deliveryCommand) {
        //implement business logic here:

        Delivered delivered = new Delivered(this);
        delivered.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void orderinfoCopy(OrderPlaced orderPlaced) {
        //implement business logic here:

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateStatus(CookFinished cookFinished) {
        //implement business logic here:

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookFinished.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
