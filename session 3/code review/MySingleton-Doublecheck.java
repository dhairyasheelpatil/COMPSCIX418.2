public class MySingleton {
    private static volatile MySingleton instance;
    public static MySingleton getInstance() {
        MySingleton localInstance = instance;
        if (localInstance == null) {
            synchronized (MySingleton.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new MySingleton();
                }
            }
        }
        return localInstance;
    }
}