public class MySingleton {

    public static class SingletonHolder {
        public static final MySingleton HOLDER_INSTANCE = new MySingleton();
    }

    public static MySingleton getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
}