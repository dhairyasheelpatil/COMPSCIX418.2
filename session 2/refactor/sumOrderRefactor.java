
public CustomerOrder{

public double getPriceForOrders(){

        List<Order> listOrder=readOrders();
        int sum=0;
        double price=0;
        for(int i=0;i<listOrder.size();i++){
        Order order=listOrder[i];
        sum+=order.getItemsCount();
        price+=calculatePrice(order);
        logOrder(order);
        }
        System.out.println("amount:"+price);

        return price;
        }

        double getPriceForOrder(Order order){
        return order.getValue()*10;
        }
        void logOrder(Order order) {
            System.out.println("name:" + order.getCustomer());
            System.out.println("number:" + order.getId());
        }
        }
