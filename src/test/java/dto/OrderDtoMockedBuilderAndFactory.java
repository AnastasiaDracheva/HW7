package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import utilus.RandomDataGenerator;
import utilus.RandomNum;

import java.awt.image.PixelGrabber;

@Builder
@Getter
@Setter
public class OrderDtoMockedBuilderAndFactory {
     private String status;
     private int courierId;
     private String customerName;
     private String customerPhone;
     private String comment;
     private long id;
     private String api_key;

     public static  OrderDtoMockedBuilderAndFactory createRandomOrder(){
          return OrderDtoMockedBuilderAndFactory.builder()
                  .status("OPEN")
                  .courierId(RandomNum.generateId())
                  .customerName(RandomDataGenerator.generateName())
                  .customerPhone(RandomDataGenerator.generateRandomPhone())
                  .comment(RandomDataGenerator.generateComment())
                  .id(RandomNum.generateId())
                  .build();

     }

}
