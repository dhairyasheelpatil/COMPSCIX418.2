public class ClientController {

     public int validateOrder(Order order) {
      // check if order is valid
      // validate order quantity and price
       OrderState orderState = getOrderState(order.item);
       if (orderState == VALID) {
         // check item state in store 
         if (order.item.getState() == AVAILABLE) {
           return 0;
         } else {
          // item not available 
           return 1;
         }
       } else {
        // invalid order
         return 2;
       }
     }
   }