class ShoppingCart {
  public static ShoppingCart* Instance();
  private ShoppingCart();
  private static ShoppingCart* _instance;
};

ShoppingCart* Shoppingcart::_instance = NULL;

ShoppingCart* ShoppingCart::getInstance() {
  if (_instance = NULL) {
    _instance = new ShoppingCart();
  }
  return _instance;
}

class Item(object) {
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
    this.category = 'Decor'
    this.quanity = 1
  }
}

class Electronics(Item) extends Item {
  public Electronics {
    this.category = 'Electronics'
    this.quanity = 1
  }
}

public class ShoppingCart {
  private static final ShoppingCart instance = new ShoppingCart();
  private List<Item> myCart = new ArrayList<Item>();
  private ShoppingCart() {}

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
          item = myCart.get(counter)
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
