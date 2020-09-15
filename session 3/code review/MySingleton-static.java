public class MySingleton {

private MySingleton instance;
// eager instattioation
static {
     instance = new MySingleton();
 }

 public MySingleton getInstance() {
        return instance;
    }
}