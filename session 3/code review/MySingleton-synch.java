public class MySingleton {
    private static MySingleton instance = null;
    private MySingleton() {

    }
    // performance issues with the synchronized keyword
    public static synchronized MySingleton getInstance() {
        if (instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }

    public void draw() {
        // draw a shape
    }
}

Client side:

        MySingletonShape mySingletonShape = MySingleton.getInstance();
        mySingletonShape.draw();

