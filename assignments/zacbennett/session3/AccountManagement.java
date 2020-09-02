class AccountManagement {


}

class User {
    String email;
    String password;
    Int age;
    String id;

    static {
        id = UUID();
    }

    public String getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }
    public String setEmail(email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }
    public String setPassword(password) {
        this.password = password;
    }

    public Int getAge() {
        return this.age;
    }
    public Int setAge(age) {
        this.age = age;
    }
}

class UserBuilder {
    String email;
    String password;
    Int age;
 
    public String setEmail(email) {
        this.email = email;
        return this;
    }

    public String setPassword(password) {
        this.password = password;
        return this;
    }

    public Int setAge(age) {
        this.age = age;
        return this;
    }

    public User build() {
        User user = new User();

        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setAge(this.age);

        return user;
    }
}

class UserManagement {
    Db db;
    UserManagement (Db db) {
        this.db = new Db();
    }

    public User createUser(String email, String password, Int age) {
        UserBuilder userBuilder = new UserBuilder();
        User newUser = userBuilder.setEmail(email).setPassword(password).setAge(age).build();

        this.db.createUser(newUser)

        return newUser
    }

    public User getUser(String id) {
        return this.db.getUser(id);
    }

    public User updateUser(String id, String key, String value) {
        User oldUser = this.getUser(id);
        User newUser = oldUser;
        switch (key) {
            case "email":
                newUser.setEmail(value);
                break;
            case "password":
                newUser.setPassword(value);
                break;
            case "age":
                newUser.setAge(value.toInt());
                break;
            default:
                System.out.print("Invalid key to update")
                break;
        }

        this.db.updateUser(oldUser, newUser);
    }

    public void deleteUser(String id) {
        User userToDelete = this.getUser(id);
        this.db.deleteUser(userToDelete)
    }
}

// Singleton
class Db {
    private Db instance;
    
    static {
        instance = new Db();
    }

    public Db getInstance() {
            return instance;
    }

    // These functions would handle the necessary SQL
    insertUser(String id) {

    }

    getUser(String id) {

    }

    updateUser(String id) {

    }

    deleteUser(String id) {

    }
}


size, number of spaces, is it disabled, compact, normal, state available vs occupied
levles spots