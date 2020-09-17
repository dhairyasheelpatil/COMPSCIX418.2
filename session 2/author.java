import java.util.ArrayList;

class Person {
    public String name;
    public String gender;
    public String email;

    // I thought about utilizing method overloading and defining different constructors based on whether or not
    //   the client passed in that name/gender or not. That seemed to be pretty messy, so I ended up utilizing the 
    //   mapName and mapGender class to handle null values in instantiating the class
  	public Person (String name, String email, String gender)	{
      this.name = this.mapName(name);
      this.gender = this.mapGender(gender);
      this.email = email;
    };
  
    public String mapName(String name) {
      if(name == null) {
        return "anonymous";
      } else {
        return name;
      }
    }

    private String mapGender(String gender) {
        if(gender == null) {
          return "undefined";
        }
        
        gender = gender.toLowerCase();
        switch (gender) {
            case "m":
                return "male";
            case "f":
                return "female";
            case "nb":
                return "non-binary";
            default:
                return "undefined";
        }
    }
  
    public String getName() {
        return this.name;
    }

    public String getGender() {
        return this.gender;
    }
    
    public String getEmail() {
        return this.email;
    }

	public String toString()	{
        return "Name is:" + this.getName() + ". Gender is " + this.getGender() + ". Email is " + this.getEmail();
	};

}

// I decided to have author extend Person class as I imagine we will utilize the person class for 
//  different classes like Customer or Agent. 
class Author extends Person {
    public ArrayList<Book> books;

    public Author(String name, String gender, String email) {
      super(name, gender, email);
      this.books = new ArrayList<Book>();
    }

    public Book writeBook(String title, double price, int publicationYear) {
        Book newBook = new Book(title, this, price, publicationYear);

        this.books.add(newBook);

        return newBook;
    }

    public Book getBooks() {
        return this.books;
    }
}

class Book {
    public String title;
    public Author author;
    public double price;
    public int publicationYear;

    public Book (String title, Author author, double price, int publicationYear) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publicationYear = publicationYear;
    };

    public String getTitle() {
        return this.title;
    }
    public Author getAuthor() {
        return this.author;
    }
    public double getPrice() {
        return this.price;
    }
    public int getPublicationYear() {
        return this.publicationYear;
    }
    public String toString() {
        return "Title is: " + getTitle() + ". Author is " + author.toString() + ". Price is " + this.getPrice() + ". Publication year is " + this.getPublicationYear();
    }
}


class Main {
  public static void main(String[] args) {
    
        Author authorTest = new Author(null, "test@mail.com", null);
        System.out.println("name is: " + authorTest.getName());  
        System.out.println("eamil is: " + authorTest.getEmail()); 
        System.out.println("gender is: " + authorTest.getGender()); 

        Book testBook = authorTest.writeBook("Design Patterns", 29.99, 1999);
        System.out.print(testBook.toString());
  }
}