public class MySingleton {
    private static MySingleton instance;

    public static synchronized MySingleton getInstance() {
        if (instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }
}