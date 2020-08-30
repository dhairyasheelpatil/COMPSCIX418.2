public class MySingleton {

private MySingleton instance;

static {
     instance = new MySingleton();
 }

 public MySingleton getInstance() {
        return instance;
    }
}