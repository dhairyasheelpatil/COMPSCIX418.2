# Session Two

In this session you will review session one, discuss reusability and refactoring.

## Exercise One

### Problem Description

The code under the refactor folder, this code was written long time ago and you are asked to analyze the code, figure out the parts that need refactoring from your point of view.
Things to consider:
- Point out why we need to refactor the code, we will discuss the reasoning and direction in class.
- Improve the code in steps, which class would you start with and what improvement would you add.
- Disucss the impact on the client side, if any.

## Exercise Two

### Problem Description

Design a system that registers Authors and their published books and articles. 

Author should have:
- name, email, gender
- Author can also be anonymous with no name or gender
- write the Author class and a test class, example:

Author authorTest = new Author("test", "test@mail.com", 'm')
System.out.println("name is: " + authorTest.getName());  
System.out.println("eamil is: " + authorTest.getEmail()); 
System.out.println("gender is: " + authorTest.getGender()); 
- toString should return the author name, email and gender

- A book can have one author, design the book class.
- toString should return the book name, author information, price and publication year

- Extra: one book can have many authors

## Exercise Three

### Problem Description
Design a Parking lot with different types of vehicles: cars, buses, trucks and motorcycles.
Things to consider:
- The parking lot can have many levels, each level has many spots
- A way to tell if parking lot is full
- Size of the spot, for example: a motorcycle can fit into a car or a truck space, but not vice versa

## Exercise Four

### Problem Description
Design a Game of Chess with different types of Chess pieces
Things to consider for each piece:
	- Type and movement
	- Implement a MoveTo() function, this function should return true or false based on if the board position is valid
	- A way to tell if the piece is available on the board or was removed by the adversary
- Represent the board with a boardManager

### Output
Define your classes and their interactions with subclasses and variables
Upload the UML diagram with your solutions
