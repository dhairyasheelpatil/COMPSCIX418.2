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

    public void createUser(String userName, String passWord) {
        user = new User(userName, passWord);
        userList.push(user);
    }

    public void deleteUser(String userName) {
        userList(userName) = null
    }

    public User[] getAccountList() {
      return userList;
    }
}

public class User {
  private String userName;
  private String passWord;

  public User(String userName, String passWord) {
    this.userName = userName;
    this.passWord = passWord;
  }

  public String readUser()
  {
    return userName;
  }

  public void updateUserPassword(String userName, String passWord) {
    this.userName = userName;
    this.passWord = passWord;
  }
}

// Client side:
//
//         MySingletonShape mySingletonShape = MySingleton.getInstance();
//         mySingletonShape.draw();
