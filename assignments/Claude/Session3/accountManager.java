// [SM] Great usage of the sibngleton pattern
// should the AccountManagerSigleton also update the user account?
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
      // where is the user variable declared, is it a private variable. In case of delete, you can also clear the user variable
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
  // should allow this operation to happen using the AccountManagerSigleton class 
  public void updateUserPassword(String userName, String passWord) {
    this.userName = userName;
    this.passWord = passWord;
  }
}

// Client side:
//
//         MySingletonShape mySingletonShape = MySingleton.getInstance();
//         mySingletonShape.draw();
