package dto;

import lombok.Getter;
import lombok.Setter;


public class OrderDtoMocked {

     @Getter
     @Setter

     private String status;
     private int courierId;
     private String customerName;
     private String customerPhone;
     private String comment;
     private long id;
     private String api_key;
    

     public OrderDtoMocked(String status, int courierId, String customerName, String customerPhone, String comment, int id) {
          this.status = status;
          this.courierId = courierId;
          this.customerName = customerName;
          this.customerPhone = customerPhone;
          this.comment = comment;
          this.id = id;
     }

     public OrderDtoMocked() {

     }

     public String getStatus() {
          return status;
     }

     public int getCourierId() {
          return courierId;
     }

     public String getCustomerName() {
          return customerName;
     }

     public String getCustomerPhone() {
          return customerPhone;
     }

     public String getComment() {
          return comment;
     }

     public long getId() {
          return id;
     }

     public String getApi_key() {
          return api_key;
     }

     public void setStatus(String status) {
          this.status = status;
     }

     public void setCourierId(int courierId) {
          this.courierId = courierId;
     }

     public void setCustomerName(String customerName) {
          this.customerName = customerName;
     }

     public void setCustomerPhone(String customerPhone) {
          this.customerPhone = customerPhone;
     }

     public void setComment(String comment) {
          this.comment = comment;
     }

     public void setId(long id) {
          this.id = id;
     }

     public void setApi_key(String api_key) {
          this.api_key = api_key;
     }
}
