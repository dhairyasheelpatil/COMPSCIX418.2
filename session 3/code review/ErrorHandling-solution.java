public class ShoppingClientController {

     public void validateOrder(Order order) {
      try {
        tryToValidateOrder(order);
      } catch(InvalidOrderException e) {
         System.out.println("Invalid Order");
      }
    }

    private void tryToValidateOrder(Order order) throws InvalidOrderException {
      OrderState orderState = getOrderState(order.item);
      reportOrderState(orderState);
    }

     private OrderState getOrderState(Item item) {
      ItemState itemState = item.getState();
      if (itemState != AVAILABLE) {
        throw new InvalidOrderException(“Invalid item for: ” + item.getId().toString());
      }
      return itemState;
    }
}