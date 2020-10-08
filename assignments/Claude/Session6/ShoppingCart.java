public class AccountManagerSigleton {
    private static AccountManagerSigleton instance = null;
    private static User[] userList;
    private MySingleton() {

    }
    // performance issues with the synchronized keyword
    public static synchronized AccountManagerSigleton getInstance() {
        if (instance == null) {
            instance = new AccountManagerSigleton();
        }
        return instance;
    }

    public void createUser(String userName) {
        user = new User(userName);
        userList.push(user);
    }

    public void deleteUser(String userName) {
        for(User i : userList) {
            if (i.getUserName() == userName) {
                i = null;
            }
        }
    }

    public User[] getAccountList() {
      return userList;
    }
}

public class User {
    private String userName;
    private ShoppingCart shoppingCart;
  
    public User(String userName) {
      this.userName = userName;
      this.shoppingCart = new ShoppingCart();
    }
  
    public String getUserName() {
        return this.userName;
    }
    public ShoppingCart getShoppingChart()
    {
      return this.shoppingCart;
    }

}


public class Item(object) {
  private String category;
  private String name;
  private float price;
  private int itemID;
  private int quanity;

  def Item(type){
    if type == "Clothing": return Clothing()
    if type == "Decor": return Decor()
    if type == "Electronics": return Electronics()
    assert 0, "Bad item creation: " + type
  }

  public static int getItemID {
    return this.ItemID
  }

  public static void update {
    this.quanity++
  }

  public static String getItemName {
    return this.name
  }

  public static float getItemPrice {
    return this.price
  }
}

class Clothing(Item) extends Item {
  public Clothing {
    this.category = 'Clothing'
    this.quanity = 1
  }
}

class Decor(Item) extends Item {
  public Decor {
    this.category = "Decor"
    this.quanity = 1
  }
}

class Electronics(Item) extends Item {
  public Electronics {
    this.category = 'Electronics'
    this.quanity = 1
  }
}

class ShoppingCart {
  private List<Item> myCart = new ArrayList<Item>();

  public static void addItem(Item){
    for (int counter = 0; counter < myCart.size(); counter++) {
          item = myCart.get(counter)
          if item.getItemID == Item.getItemID {
            item.update();
          }
          else {
            myCart.add(Item);
          }
    }
  }

  public static void listCart() {
    for (int counter = 0; counter < myCart.size(); counter++) {
          item = myCart.get(counter);
          System.out.println(item.getItemName() + ": " + item.getItemPrice());
    }
  }

  public static void deleteItem(itemID) {
    myCart.remove(itemID);
  }

  public static ShoppingCart getInstance() {
    return instance;
  }
}
