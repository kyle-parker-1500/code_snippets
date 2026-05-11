<details>
  <summary>Midterm 1</summary>
    
[To Midterm 2](#midterm-2-snippets) <br>
[To Final](#final-snippets-and-questions)
  
# Midterm 1 Snippets

**Disclaimer:** These notes were copied from these wonderful [slides](https://docs.google.com/presentation/d/1QUFehTo8uTQZLbUBuO_WuoZ_PHYFviEtaXXUoniMYtk/edit?slide=id.p#slide=id.p) made by some (wonderful) past TAs.

## Table of Contents

- [Fundamentals of Java](#fundamentals-of-java)
  1. [Git and GitHub](#git-and-github)
  2. [Constructors](#constructors)
  3. [Access Modifiers and UML](#access-modifiers-and-uml)
  4. [Primitives and Wrappers](#primitives-and-wrappers)
  5. [Boxing and Unboxing](#boxing-and-unboxing)
  6. [ArrayList vs HashMap](#arraylist-vs-hashmap)
  7. [Java Class Keywords](#java-class-keywords)
  8. [this, new, and super](#this-new-and-super)
  9. [Abstract vs Interface](#abstract-vs-interface)
  10. [Extend vs Implement](#extend-vs-implement)
  11. [Override vs Overload](#override-vs-overload)
  12. [Testing: White Box vs Black Box](#black-box-vs-white-box)
- [Comparing Objects](#comparing-objects)
- [Four Pillars of OOP](#four-pillars-of-oop)
  1. [Abstraction](#abstraction)
  2. [Inheritance](#inheritance)
  3. [Encapsulation](#encapsulation)
  4. [Polymorphism](#polymorphism)
- [Design Patterns](#design-patterns)
  1. [Singleton](#singleton)
  2. [Command](#command)
  3. [Strategy](#strategy)

## Fundamentals of Java

If statements:

```Java
int a = 5;
int b = 10;
if (a > b) {
  System.out.println(a + " is greater than " + b);
}

String str1 = "apple";
String str2 = "banana";
if (str1.equals(str2)) {
  System.out.println(str1 + " is equal to " + str2);
}
```

For loop and for each loop:

```Java
int[] testArr = {1, 2, 3, 4, 5};
for (int i = 0; i < testArr.length; i++) {
  System.out.print(testArr[i] + " "); // prints 1 2 3 4 5
}

// for each
for (int number : testArr) {
  System.out.print(number + " "); // prints each number in testArr
}

// for each with strings and chars
String line = "string";

for (Character c : line.toCharArray()) {
  System.out.println(c); // prints each char of line
}
```

While loop and Modulus operator (%):

```Java
int[] arr = {1, 2, 3, 4, 5};
int i = 0;

while(i < arr.length) {
  System.out.print(arr[i] + " "); // prints 1 2 3 4 5
  i++; // must manually increment
}

// mod
int x = 10;
if (x % 2 == 0) {
  System.out.println(x + " is even!"); // returns/prints remainder of division
  // x%2 == 0 because 10 is evenly divisible by 2 = no remainder
}

// can also do
x = 9;
if (x % 2 == 1) {
  System.out.println(x + " is odd!");
  // 9 / 2 will result in a remainder of 1 so we know that 9
  // is odd because it can't be evenly divided by 2
}
```

Switch Case:

- `switch()` expression evaluated once
- the value of the expression is compared to each of the cases
- if a match is found that case block will be executed
- when a break keyword is reached, java will break out of the case block

```Java
int userInput = 5;

switch (userInput) {
  case 1:
    System.out.printf("You picked: %d%n", userInput);
    break;
  case 2:
    System.out.printf("You picked: %d%n", userInput);
    break;
  case 3:
    System.out.printf("You picked: %d%n", userInput);
    break;
  case 4:
    System.out.printf("You picked: %d%n", userInput);
    // if we forget the break, the case block will execute and then
    // go execute the next case block
  case 5:
    System.out.printf("You picked: %d%n", userInput);
    break;
  default:
    // runs only if no case matches
    System.out.println("I'm lonely down here");
}

// outputs: You picked: 5
```

Try Catch:

_“They’re like backwards if statements” ~ Dr. C_

- Use when we're not certain something will run the same 100% of the time
- Ex:
  - When reading user input using `Scanner`
  - When reading from or writing to files
- When a problem occurs an error is thrown
- Java will be looking for that error and when found, it will execute
  the catch block
- Java can look for many types of errors ex: `IOException` and `Exception`
  (most common)
- Finally will **_always_** run regardless of what happens in the try catch
  - Good for closing things like scanners or files

Syntax:

```Java
// 2 ways to do:
// 1:
Scanner scan;
try {
  String line = "";
  scan = new Scanner(System.in); // place problematic code within try catch

  line = scan.nextLine();
  System.out.println(line);
} catch (Exception e) {
  System.out.println("Oh no! We ran into an error!");
  System.out.println("Error: " + e);
} finally {
  System.out.println("I always execute.");
  System.out.println("This means that I can close pesky files or console inputs.");
  scan.close(); // make sure not to close me too early!
                // that can lead to later problems!
}
```

```Java
// 2:
FileWriter file = new FileWriter(filename);
try (Scanner scan = new Scanner(file)) {
  // this version will automatically close the scanner when we're done with it
  String line = "";

  while(scan.hasNextLine()) {
    line = scan.nextLine();
    System.out.println("Current line: " + line);
  }
} catch (IOException | Exception e) { // we can also look for multiple Exception
                                      // with the '|' operator
  System.out.println("This is an error: " + e);
}
```

## Git and GitHub

Git:

- An extremely useful version control system
- Allows you to save the state of your files in a particular moment
  - Save the version in something called a _repository_
    - Save a state through something called a _commit_
  - This gives you the power to go back to a previous version if you make a mistake
  - It also allows you to go back to a previous version to test something
  - You can also make a new copy in the form of a branch to change something
    without altering what already works

GitHub:

- An online database of Git repositories

All Git and GitHub commands and what they do:

| Command                                 | What it does:                                                                                     |
| --------------------------------------- | ------------------------------------------------------------------------------------------------- |
| git status                              | shows current state of branch                                                                     |
| git add .                               | stages all changes for a commit                                                                   |
| git add /filepath/                      | stages one specific path for a commit                                                             |
| git commit -m ""                        | commits currently staged files with a given message                                               |
| git commit                              | opens up a VIM style terminal to write longer and more complex messages                           |
| git stash                               | must use after `git add`, takes all currently staged files and hides them from a commit or switch |
| git stash /filepath/                    | stashes a specific filepath                                                                       |
| git stash pop                           | unstash the last thing that was stashed                                                           |
| git log                                 | list all commits                                                                                  |
| git show                                | display last commit                                                                               |
| git show <commit_hash>                  | each commit has a hash to identify it, you can use this command to see it                         |
| git checkout <branch_name>              | moves you to a new branch                                                                         |
| git switch <branch_name>                | does the same thing as git checkout <branch_name>                                                 |
| git checkout -b <new_branch_name>       | creates new branch                                                                                |
| git remote -v                           | displays all remote repositories currently connected                                              |
| git remote add origin <github_link.git> | add new remote repository under the name origin                                                   |
| git remote remove <name>                | remove remote repository link at that name                                                        |
| git merge <branch_name>                 | merges <branch_name> into checked out branch                                                      |
| git rebase <branch_name>                | takes commits from <branch_name> and places them on top of all commits of checked out branch      |

## Constructors

Used to initialize objects also used to set values.

**Default:** When no constructor is created, a default constructor is called when instantiating an object
**Parameterized:** If a constructor is created it will override the default and is custom to the programmer

```Java
Card card = new Card();
Card card = new Card("Diamonds", 5);
```

Constructor Example:

```Java
// parameterized:
public Monster() {
  this.type = "ghoul";
  this.strength = 100;
  this.health = 1000;
}

// parameterized with parameters
public Monster(string type, int strength, int health) {
  this.type = type;
  this.strength = strength;
  this.health = health;
}
```

## Access Modifiers and UML

|           | Class | Package | Subclass | Global |
| --------- | ----- | ------- | -------- | ------ |
| Public    | Yes   | Yes     | Yes      | Yes    |
| Protected | Yes   | Yes     | Yes      | No     |
| Default   | Yes   | Yes     | No       | No     |
| Private   | Yes   | No      | No       | No     |

_Remember!_ Package-private and default mean the same thing since variables and methods are set as package-private if not access modifier is specified!

### UML

_Remember!_ UML Access Modifier symbols in UML are based on location!

- Abstract (Pool ball symbol): ![Abstract](./images/abstract.png)

- Final (top left symbol): ![Final](./images/final.png)

- Static (bottom left and/or underlined): ![Static](./images/static.png)

- Public (open lock or +): ![Public](./images/public.png)

- Private (closed lock or -): ![Private](./images/private.png)

- Protected (key or #): ![Protected](./images/protected.png)

- Default/Package Private (circle or ~): ![Default](./images/default.png)

- Extends (solid arrow): ![Extends](./images/extends.png)

- Implements (dashed arrow): ![Implements](./images/implements.png)

- Direction arrow points: Can provide all the methods of the class the arrow is pointing at.

## Primitives and Wrappers

**Primitive Types:** int, double, char...

- Simple types

**Wrapper Classes:** Integer, Double, Character...

- Objects containing methods to use such as .equals()

![Wrappers](./images/wrapper_class.png)

## Boxing and Unboxing

**Boxing:** Converting a primitive type &rarr; wrapper class

```Java
int primitive = 50;
Integer wrapper = primitive;
```

**Unboxing:** Converting a wrapper class &rarr; primitive type

```Java
Integer wrapper = 50;
int primitive = wrapper;
```

## ArrayList vs HashMap

### ArrayList

ArrayList &rarr; A list of single data types
Declaration:
`ArrayList<Reference_Type> name = new ArrayList<>();`

```Java
ArrayList<String> arr = new ArrayList<>();

arr.add("Hello");
arr.add("My");
arr.add("Name");
arr.add("Is");
arr.add("Bob");

int arrayListSize = arr.size(); // returns size of list
System.out.println("Size: " + arrayListSize);

// get specific element at specified index (0 in this case)
String ele = arr.get(0);
System.out.println(ele); // prints "Hi"

arr.remove(2); // removes "Name"
// list is now: {Hello, My, "Is", "Bob"}

arr.set(2, "Hola");
// list is now: {Hello, My, Hola, Bob}

// if you want to run this code make sure you use: import java.util.ArrayList;
for (String s : arr) {
  System.out.printf("%s%t", s);
}
```

### HashMap

HashMap = A list of key and value pairs

```Java
HashMap<Integer, String> hm = new HashMap<>();

hm.put(0, "Hi");
hm.put(1, "My");
hm.put(3, "Is");
hm.put(2, "Name");
hm.put(4, "Bob");

int mapSize = hm.size(); // returns size of map
String ele = hm.get(1); // finds the key provided and returns the value associated with it
System.out.println(mapSize + " " + ele);
hm.remove(3);
// current hm:
/*
  * Hi
  * My
  * Name
  * Bob
  */
hm.replace(2, "Charlie");
/*
  * Hm is now:
  * Hi
  * My
  * Charlie
  * Bob
  */

System.out.println("Hm key 2 value: " + hm.get(2));
hm.put(0, "Hola"); // also replaces value at key 0 with "Hola"

// make sure if you run this code to use import java.util.HashMap;

// prints only keys
System.out.println("Keys:");
for (Integer key : hm.keySet()) {
  System.out.println(key);
}

// prints only values
System.out.println("Values:");
for (String value : hm.values()) {
  System.out.println(value);
}
```

## Java Class Keywords

### Instance vs Static vs Final

**Instance:** `Card c = new Card();`

- When you use the keyword "**new**", you create an instance of the object
- They can be marked as final
- They can't be marked abstract
- They can't be marked static

**Static:** `public static void m();`

- Can be applied to: methods and fields
- Static members can be accessed without creating an instance of the object

**Static Variables:** `public static int num;`

- Variable is shared by all instances of a class

**Final:** `public final void m();`

- Can be applied to: classes, methods, and fields
- Makes things constant and prevents overriding

**Final Variables:** `public final SIZE = 5;`

- Variables can only ever be assigned once and the value can never be changed
  - Variables marked with ALL_CAPS are typically final variables

## this new and super

**_this_** &rarr; accesses the current object
`this.hp -= 10;`

**_`this("parent", "child");`_** calls its own constructor within the given parameter

Example:

```Java
public class Parent {
  private String parentString;

  Parent(String s) {
    this.parentString = s;
  }
}


class Child extends Parent {
  private String childString;

  Child() {
    this("parent", "child"); // calls own constructor with passed values
  }

  Child(String s1, String s2) {
    super(s1); // calls parent constructor with passed value
    this.childString = s2;
  }
}
```

**_new_** &rarr; creates a new instance of an object
`Object obj = new Object(param);`

**_super_** &rarr; accesses the parent object (the class that the current class is extending)

```Java
ChildObject { // constructor
  super();
  hp = 100;
}
```

**_`super(s1);`_** &rarr; calls the constructor in its parent class

Example:

```Java
public class Parent {
  private String parentString;

  Parent(String s) {
    this.parentString = s;
  }
}

class Child extends Parent {
  private String childString;

  Child() {
    this("parent", "child"); // calls own constructor with passed values
  }

  Child(String s1, String s2) {
    super(s1); // calls parent constructor with passed value
    this.childString = s2;
  }
}
```

## Abstract vs Interface

**Abstract Classes:**

- Instances can't be created
- Can have abstract and concrete methods
- Cannot be declared final (think about it)
- Other classes can only extend at most **ONE** abstract class

**Interface:**

- Blueprint/behavior of the class
  - Specifies what a class must do and _not_ how
- Used to achieve loose coupling
- Other classes can implement **MANY** interfaces

![Inheritance](./images/inheritance_1.png)

Reading the above definitions which of the snippets is correct?

```Java
A) Cat cat = new Animal();
B) Animal animal = new Dog();
C) Canine dog = new Canine();
```

**Answer (click to reveal):**

  <details>
    <summary>Answer</summary>

    B) `Animal animal = new Dog();`

  </details>

### Extend vs Implement

**Extending:**

- When a class is inheriting from another class (abstract or not)
- When an interface is inheriting from another interface

`public interface Card extends Deck {}`

**Implementing:**

- When a class is inheriting from an interface

`public abstract class Monster implements Attack {}`

## Override vs Overload

**Override:**

- Rewriting the code passed down from a parent class

Ex:

```Java
@Override
public String toString() {
  return "Hello World!";
}
```

**Overloading:**

- Making multiple variants of a method with the same name but different parameters

Ex:

```Java
int myMethod(int x) {
  return x;
}

float myMethod(float x) {
  return x;
}

double myMethod(double x, double y) {
  return x + y;
}
```

## Black Box vs White Box

**White Box Testing:**

- When the tester has access to the code being tested
  - Path Testing
  - Loop Testing
  - Condition Testing

**Black Box Testing:**

- When the tester doesn't have access to the code
  - Functional Testing
  - Non-functional Testing
  - Regression Testing

![Black Box vs White Box Testing](./images/blackbox_vs_whitebox.png)

## Comparing Objects

### Checking Object Type

"**instanceof**" &rarr; a keyword for checking if a reference variable is containing a given type of object reference or not

- returns a boolean (true/false)

```Java
for (Animal a : animals) {
  if (a instanceof Dog) {
    System.out.println("True!");
  }
}
```

## Four Pillars of OOP

Don't forget PIE-A!

### Abstraction

Using abstract methods and classes to provide the ability to reuse and modify code as needed.

```Java
// Abstract class
abstract class Animal {
  // abstract method (no body)
  public abstract void animalSound();
  // concrete method
  public void sleep() {
    System.out.println("Zzz");
  }
}
```

```Java
// Subclass (inherits from Animal)
class Pig extends Animal {
  public void animalSound() {
    System.out.println("The pig says: 'Sup boss");
  }
}
```

```Java
class Main {
  public static void main(String[] args) {
    Animal animal = new Animal(); // will create error:
    // must inherit from another class to access the abstract class
    Pig pig = new Pig();
    pig.animalSound(); // prints 'Sup boss
    pig.animalSound(); // prints Zzz
  }
}
```

### Inheritance

Passing down fields and methods for other classes to use

- Extending classes and implementing interfaces

```Java
class Vehicle {
  protected String brand = "Ford";
  public void honk() {
    System.out.println("Tuut, tuut!");
  }
}
```

```Java
class Car extends Vehicle {
  private String model = "Mustang";
  public static void main(String[] args) {
    Car car = new Car();

    // honk defined inside vehicle class
    car.honk();

    // display brand and model
    System.out.println(car.brand + " " + car.model);
  }
}
```

### Encapsulation

Hiding explicit data from objects that don't need to know about that data

- Storing specific data into classes

```Java
class Person {
  private String name;

  // getter
  public String getName() {
    return name;
  }

  // setter
  public void setName(String newName) {
    this.name = newName;
  }
}
```

```Java
public class Main {
  public static void main(String[] args) {
    Person person = new Person();
    person.name = "John"; // error, can't access directly
    System.out.println(person.name); // error; still can't access directly
    person.setName("Dr. C");
    System.out.println(person.getName()); // prints "Dr. C"
  }
}
```

### Polymorphism

Storing multiple objects into a single instance

- Using a parent class as a container for the child class but not vice versa

```Java
class Animal {
  public void animalSound() {
    System.out.println("The animal sounds like schrodinger's cat");
  }
}

class Cat extends Animal {
  public void animalSound() {
    System.out.println("The cat says: ....");
  }
}

class Dog extends Animal {
  public void animalSound() {
    System.out.println("The dog says: You killed him!");
  }
}
```

```Java
class Main {
  public static void main(String[] args) {
    Animal animal = new Animal(); // create Animal object
    Animal cat = new Cat();
    Animal dog = new Dog();
    animal.animalSound(); // prints: The animal sounds like schrodinger's cat
    cat.animalSound(); // prints: The cat says: ....
    dog.animalSound(); // prints: The dog says: You killed him!
  }
}
```

### Questions

Given the code: Which of the following are correct?

```Java
class Monster{}

class Ghoul extends Monster{}

class Werewolf extends Monster{}

class Vampire extends Monster{}

class Dracula extends Vampire{}
```

```Java
A) Ghoul ghoul = new Monster();
B) Vampire vampire = new Dracula();
C) Monster monster = new Werewolf();
D) Dracula dracula = new Vampire();
```

  <details>
    <summary>Answer:</summary>
    
    B) `Vampire vampire = new Dracula();`

    C) `Monster monster = new Werewolf();`

    __Explanation:__
    A parent class can be instantiated as its child class, but a child class cannot be instantiated as a parent class.

  </details>

<br>

Given the code: Which of the following are correct?

```Java
class Animal{}

class Dog extends Animal{}

class Cat extends Animal{}

class Bird extends Animal{}

class Lion extends Cat{}
```

```Java
A) Lion lion = new Cat();
B) Bird bird = new Animal();
C) Animal animal = new Dog();
D) Cat cat = new Lion();
```

  <details>
    <summary>Answers:</summary>

    C) `Animal animal = new Dog();`

    D) `Cat cat = new Lion();`

  </details>

## Design Patterns

### Singleton

- Only one instance of an object may exist
- You must use Class.getInstance() to access the object
  - Cannot instantiate the object

```Java
public class Singleton {
  private static Singleton instance = null;
  private int singletonInt;

  Singleton() {
    singletonInt = 10;
  }

  public static Singleton getInstance() { // static methods require
                                          // the class name to call: Singleton.getInstance()
    if (instance == null) { // if a singleton doesn't exist yet instantiate one
      instance = new Singleton();
    }

    return instance;
  }

  public static void main(String[] args) {
    Singleton x = Singleton.getInstance();
    Singleton y = Singleton.getInstance();
    Singleton z = Singleton.getInstance();

    System.out.println("x : " + x.singletonInt);
    System.out.println("y : " + y.singletonInt);
    System.out.println("z : " + z.singletonInt);

    x.singletonInt = 15;

    System.out.println("x : " + x.singletonInt);
    System.out.println("y : " + y.singletonInt);
    System.out.println("z : " + z.singletonInt);
  }
}
// Prints:
/*
x : 10
y : 10
z : 10
x : 15
y : 15
z : 15
*/
```

![Singleton](./images/singleton.png)

```Java
public class SingleObject {
  // create object of SingleObject
  private static SingleObject instance = new SingleObject();

  // make constructor private so class can't be instantiated
  private SingleObject(){}

  // get only object available
  public static SingleObject getInstance() {
    return instance;
  }

  public void showMessage() {
    System.out.println("Hello world!");
  }

  public static void main(String[] args) {
    // illegal construct
    // Compile time error: constructor SingleObject() is not visible
    // SingleObject object = new SingleObject();

    // only object available
    SingleObject object = SingleObject.getInstance();

    // show message
    object.showMessage();
  }
}
```

### Command

Encapsulates a request as an object

- Allows you to parameterize clients with different requests
- Stores actions or commands
  - Copying commands into history list
    - E.g.:
    - Instant replay
    - Undo/redo commands
    - On/off commands

```Java
Queue queue;

queue.add(Cara.do(surpriseAttack));
queue.add(Mando.do(fightBack));
queue.add(BabyYoda.do(sipTea));
```

```Java
if (buttonPressed == button1) {
  lights.on();
}
```

Example Code:

```Java
interface Command {
  public void execute(); // command will always have something named similar to execute
}

class Light {
  public void on() {
    System.out.println("Light is on");
  }

  public void off() {
    System.out.println("Light is off");
  }
}

class LightOnCommand implements Command {
  Light light;

  // constructor is passed the light it will control
  public LightOnCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.on();
  }
}

class LightOffCommand implements Command {
  Light light;
  public LightOffCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.off();
  }
}
```

```Java
class Stereo {
  public void on() {
    System.out.println("Stereo is on");
  }

  public void off() {
    System.out.println("Stereo is off");
  }

  public void setCD() {
    System.out.println("Stereo is set for CD input");
  }

  public void setDVD() {
    System.out.println("Stereo is set for DVD input");
  }

  public void setRadio() {
    System.out.println("Stereo is set for Radio input");
  }

  public void setVolume(int volume) {
    System.out.printf("Stereo volume is set to %d volume%n", volume);
  }
}
```

```Java
class StereoOffCommand implements Command {
  Stereo stereo;
  public StereoOffCommand(Stereo stereo) {
    this.stereo = stereo;
  }

  @Override
  public void execute() {
    stereo.off();
  }
}

class StereoOnWithCDCommand implements Command {
  Stereo stereo;
  public StereoOnWithCDCommand(Stereo stereo) {
    this.stereo = stereo;
  }

  @Override
  public void execute() {
    stereo.on();
    stereo.setCD();
    stereo.setVolume(11);
  }
}
```

```Java
// simple remote control with one button
class SimpleRemoteControl {
  Command slot; // only one button

  public SimpleRemoteControl(){}

  public void setCommand(Command command) {
    // set the command the remote will execute
    this.slot = command;
  }

  public void buttonWasPressed() {
    slot.execute();
  }
}
```

```Java
// Driver class
class RemoteControlTest {
  public static void main(String[] args) {
    SimpleRemoteControl remote = new SimpleRemoteControl();
    Light light = new Light();
    Stereo stereo = new Stereo();

    // change command dynamically
    remote.setCommand(new LightOnCommand(light));
    remote.buttonWasPressed();
    remote.setCommand(new StereoOnWithCDCommand(stereo));
    remote.buttonWasPressed();
    remote.setCommand(new StereoOffCommand(stereo));
    remote.buttonWasPressed();
  }
}
```

### Strategy

Multiple variants of the same behavior

- Interchangable encapsulated behaviors

```Java
dog.setAction(new Howl());
dog.doSomething();

dog.setAction(new Sleep());
dog.doSomething();
```

![Strategy](./images/strategy.png)

```Java
public interface Strategy {
    public int doOperation(int num1, int num2);
}
```

```Java
// Addition Strategy
public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

// Subtraction Strategy
public class OperationSubstract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

// Multiplication Strategy
public class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
```

```Java
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
```

```Java
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
```

</details>

---

<details>
  <summary>Midterm 2</summary>
    
[To Midterm 1](#midterm-1-snippets) <br>
[To Final](#final-snippets-and-questions)

# Midterm 2 Snippets

## Table of Contents

- [Key Concepts](#key-concepts)
  1. [Definitions](#definitions)
  2. [Operators](#additional-concepts)
- [Test Your Knowledge](#sample-questions)
  1. [UML](#test-your-knowledge-uml)
  2. [Access Levels UML](#access-levels-uml)
  3. [Inheritance](#test-your-knowledge-inheritance)
  4. [Constructors](#test-your-knowledge-constructors)
  5. [Types](#test-your-knowledge-types)
- [JavaFX](#javafx)
  1. [What is JavaFX](#what-is-javafx)
  2. [Application Lifecycle](#application-lifecycle)
  3. [Inheritance](#javafx-inheritance)
  4. [Stage, Scene, Graph](#stage-scene-graph)
  5. [Creating Controls](#code-creating-controls)
  6. [Building The Scene](#code-building-the-scene-graph)
  7. [Lambda](#lambda-expressions-event-handling)
  8. [Anonymous Inner Classes](#anonymous-inner-classes-event-handling)
  9. [Common Layout Containers](#common-layout-containers)
  10. [Slide Overview](#slide-overview-javafx)
- [Tips For The Exam](#tips-for-the-exam-and-your-notes)
  1. [Exam](#exam)
  2. [Notes](#notes)
  3. [Studying](#studying)
- [Fun Things You Probably Missed](#fun-things-we-did-in-zoom-that-you-missed)

By: Gabrielle Lake & Ignacio Gramajo &rarr; [Link to Slides](https://docs.google.com/presentation/d/1o4e36VhxbfPviAVb78mYuzaCNPVdI7zsbw7wAqcCOS0/edit?usp=sharing)

## Key Concepts:

### Definitions:

- Abstract Class
  - Template class containing 1 or more methods for child classes to implement
  - **Can't** be instantiated
- Interface
  - Can't have any logic, only template code
  - Methods are public & abstract by **default**
  - **Can't** be instantiated
- Concrete Class
  - Can extend one abstract class or implement any number of interfaces
  - Can't have abstract methods
  - **_Can_** be instantiated

### Additional Concepts:

- Boolean Operators:
  - || &rarr; or
  - && &rarr; and
  - ! &rarr; not
- HashMaps:
  - get() &rarr; access value in HashMap (remember [key, value] pairs!)
  - remove() &rarr; remove item from HashMap
  - size() &rarr; find out how many items are in HashMap
- Use **.equals()** when checking the equality of Objects (Strings, HashMaps, ArrayLists, etc.)

## Sample Questions:

Questions for you to write code snippets for.

### Test Your Knowledge (UML):

What is this:<br>
![Abstract Class](./images/midterm2/abstract.png)

<details>
  <summary>Answer:</summary>
  Abstract Class
</details>

What is this:<br>
![Interface](./images/midterm2/interface.png)

<details>
  <summary>Answer:</summary>
  Interface
</details>

What is this:<br>
![Abstract Method](./images/midterm2/abstract_method.png)

<details>
  <summary>Answer:</summary>
  Abstract Method
</details>

What is this:<br>
![Final Method](./images/midterm2/final_method.png)

<details>
  <summary>Answer:</summary>
  Final Method 
</details>

What is this:<br>
![Static Field](./images/midterm2/static_field.png)

<details>
  <summary>Answer:</summary>
  Static Field
</details>

What is this:<br>
![Implementing](./images/midterm2/inheritance_implement.png)

<details>
  <summary>Answer:</summary>
  Implementing (Inheritance)
  What are its limitations?
</details>

What is this:<br>
![Extend](./images/midterm2/extend.png)

<details>
  <summary>Answer:</summary>
  Extending (Inheritance)
  What are its limitations?
</details>

You can study this information here: [JetBrains UML Symbols](https://www.jetbrains.com/help/idea/class-diagram-toolbar-and-context-menu.html#toolbar)

### Access Levels UML:

What is this:<br>
![Public](./images/midterm2/public.png)

<details>
  <summary>Answer:</summary>
  Public
</details>

What is this:<br>
![Private](./images/midterm2/private.png)

<details>
  <summary>Answer:</summary>
  Private
</details>

What is this:<br>
![Protected](./images/midterm2/protected.png)

<details>
  <summary>Answer:</summary>
  Protected
</details>

What is this:<br>
![Default/Package Private](./images/midterm2/default.png)

<details>
  <summary>Answer:</summary>
  Default or Package Private
</details>

### Test Your Knowledge (Inheritance):

```Java
public class Child extends Parent
```

- Child extends parent and has a method `cleanDishes(Dish dish)`

**TASK:** Use the `cleanDishes` method from the parent class to assign a Dish object using the current Child object as a parameter for the Dish class object.<br>
The Dish class has a constructor with the signature `Dish(Parent)`.

<details>
  <summary>Answer:</summary>

```Java
  Dish pans = new Dish(this);
  this.cleanDishes(pans);
```

</details>

---

Imagine Dish implements an interface `KitchenObject`

**TASK:** Write the `KitchenObject` interface. The interface has one method with the signature `boolean washable(int size);`

<details>
  <summary>Answer:</summary>

```Java
public interface KitchenObject {
  public abstract boolean washable(int size);
}
```

</details>

### Test Your Knowledge (Constructors)

Imagine you are writing the constructor for the Child class.
**TASK:** How would you call the constructor from the parent class and pass the String parameter "favColor".

<details>
  <summary>Answer:</summary>

```Java
super(favColor);
```

</details>

**TASK:** How would you call the parameterized constructor in the same class with a string value of "Green".

<details>
  <summary>Answer:</summary>

```Java
this("Green");
```

</details>

### Test Your Knowledge (Types)

Imagine you have a variable `jen` of type `Parent`
**TASK:** How would you check if it is of type Child?

<details>
  <summary>Answer:</summary>

`jen instanceof Child`

Remember! `instanceof` looks at the object type at runtime so
if we have a class Dog that extends Cat and an Interface Food that Cat implements. Then we do:

```Java
Cat cat = new Dog();
if (cat instanceof Food)
  System.out.println("True!");
else
  System.out.println("False!");
```

Then `True!` will be printed.

</details>

Imagine you have a variable `jen` of type `Foo`
**TASK:** How would you check what `jen`'s type is?

<details>
  <summary>Answer:</summary>

```Java
jen.getClass();

if (jen.getClass() == Foo.class)
  System.out.println("True!");
else
  System.out.println("False!");
```

</details>

---

Imagine you have a variable `number`.
**TASK:** How would you check if it's even?

<details>
  <summary>Answer:</summary>

`number % 2 == 0`

</details>

---

Imagine you have a variable `number`.
**TASK:** How would you check if it's odd?

<details>
  <summary>Answer:</summary>

`number % 2 != 0`

</details>

---

What are 2 ways of testing equality?

<details>
  <summary>Answer:</summary>

`equals()` and `==`

</details>

## JavaFX:

Link to slides &rarr; [Slides](https://csumb.instructure.com/courses/31852/files/6939470?module_item_id=2142033) &rarr; By: Dr. C

### What is JavaFX?

- Modern GUI toolkit for Java

### Application Lifecycle

```Java
public class HelloWorldApp extends Application {
  public static void main(String[] args) {
    launch(args); //<-- entry point
  }

  @Override
  public void start(Stage primaryStage) {
    // build UI here
    primaryStage.show();
  }
}
```

- App class inherits from abstract class Application
- `main()` calls `launch(args)` and hands control to JavaFX
- JavaFX calls overridden `start(Stage)` method
- Build UI inside `start()` and call `stage.show()`

### JavaFX Inheritance

- HelloWorldApp extends Application
  - Application is abstract &rarr; must @Override start
  - `launch()` is inherited from Application
- All UI controls share class hierarchy:
  - Object &rarr; Node &rarr; Parent &rarr; Region &rarr; Control &rarr; ...
  - Label, Button, and TextField all extend Control
  - StackPane, VBox, HBox all extend Pane

### Stage, Scene, Graph

- Stage &rarr; the OS window
  - Has title bar, minimize/maximize/close buttons
- Scene &rarr; the content area inside the window
  - Holds root node of the scene graph
  - Defines width & height of the content
- Scene Graph &rarr; the tree of all visual nodes
  - Root node is layout container (e.g. StackPane)
  - Children are UI controls or nested containers

### Code: Creating Controls

- Each UI element is created by constructing a Java object `new Label(...)`
- Properties are set via setter methods: `setFill(), setFont(), etc.`
- Label & Button extend Control; Ellipse and Text extend Shape/Node
- No special syntax - standard Java object construction

```Java
@Override
public void start(Stage primaryStage) {
  Label label = new Label("Hello World!");
  Button mainButton = new Button("I am alive!");

  Ellipse e = new Ellipse(110, 70);
  e.setFill(Color.GREENYELLOW);
  Text t = new Text("Ahh yiss shapes");
  t.setFont(new Font("Times New Roman", 24));
```

### Code: Building the Scene Graph

- `StackPane` is the root layout &rarr; stacks children on top of each other, centered
- `getChildren()` return an `ObservableList<Node>` &rarr; add controls to it
- `Scene` wraps the root node with a fixed size
- Stage receives the `Scene` and becomes visible with `show()`

```Java
StackPane root = new StackPane(label); // label passed to constructor
root.getChildren().addAll(mainButton, ellipse, text);

Scene scene = new Scene(root, 400, 300); // root node, width, height
primaryStage.setTitle("JavaFX Hello World!");
primaryStage.setScene(scene);
primaryStage.show();
```

### Lambda Expressions: Event Handling

```Java
// anonymous class
mainButton.setOnAction(
  new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
      toggle(mainButton);
    }
  }
);
```

Same code as anonymous inner class (in the form of a lambda):

```Java
// lambda
mainButton.setOnAction(
  actionEvent -> {
    toggle(mainButton);
  }
);
```

- `setOnAction()` expects `EventHandler<ActionEvent>`
- Lambda expressions are shorthand for single-method anonymous classes
- Both approaches valid; lambdas preferred for readability
- `toggle()` method shows plain Java string logic

### Anonymous Inner Classes: Event Handling

```Java
mainButton.setOnMouseEntered(new EventHandler<MouseEvent> () {
  // anonymous class declaration
  @Override
  public void handle(MouseEvent event) {
    double x = mainButton.getTranslateX();
    double cX = event.getSceneX();
    System.out.println("Where does this print?");
  }
});
```

- Anonymous inner classes implement an interface inline
  - Same inheritance concepts
- `EventHandler<MouseEvent>` interface has one method &rarr; `handle(MouseEvent)`

### Common Layout Containers

- StackPane
  - Stacks children on top of each other, centered
- VBox
  - Arranges children vertically, top to bottom
- HBox
  - Arranges children horizontally, left to right
- BorderPane
  - Five regions: top, bottom, left, right, center
- GridPane
  - Row/Column grid layout

```Java
// vbox example:
// 10px spacing
VBox vbox = new VBox(10);
vbox.getChildren().addAll(
  label, button1, button2
);

// Hbox example
HBox hbox = new HBox(10);
hbox.getChildren().addAll(
  btnA, btnB, btnC
);
// all extend Pane: extends region
// same getChildren().add() pattern
```

### Slide Overview JavaFX

- JavaFX is just Java classes &rarr; uses same OOP concepts
- Our class `extends Application` & overrides `start(Stage)`
- Scene graph is a tree: Stage &rarr; Scene &rarr; Root Layout &rarr; Child Nodes
- UI Controls (Label, Button, etc.) are objects with getters, setters, and event handlers
- Events are handled via functional interfaces
  - Use lambdas (preferred) or anonymous inner classes
- Gradle automates building & dependency management

**I didn't touch on everything the slides cover so make sure to go look through them!**

## Tips for the Exam (And your notes!)

### Exam:

- Read the prompt:
  - Don't read too fast because you may glaze over important details of the question
    - Good rule of thumb: Read the question 2 times before attempting to answer it
- Use scratch paper!
  - Bring some scratch paper (or even use open space on your notes) to help with coding problems
    - Keeping track of variable values in your head gets hard sometimes
- Take your time!
  - Don't rush through the exam! It'll still be there in 30 minutes.
- The other side of that is: Don't take too long on one question!
  - If you're stuck on one problem for... let's say more than 10 minutes, move on
  - Sometimes answering further questions will help you answer the other question
  - Also varying the information that you're taking in will help your brain not become foggy
- When you're done what should you do?
  1. Submit immediately even if you're unsure of your answers for some questions.
  2. Review your answers carefully making sure that your answers are the correct ones.
  3. Call Dr. C over and ask him to click 'Submit' for you so that you don't have to deal with the burden of clicking 'Submit'.
  - The answer was 2. Make sure, before submitting, that you review your answers. I like to mark answers that I'm unsure of using the bookmark feature of Canvas exams.

### Notes:

- Use shorthand: Small words or pieces of code that remind you of the content you were studying
- Put symbols & diagrams on your notes
- Write legibly, you want to be able to read your notes
- Group your notes by sections
  - It helps to plan out what you're going to put on your note sheet before

### Studying:

- Use AI to quiz yourself on the material (I find this super effective!)
- Use Quizlet to create flashcards for yourself and then play the fun matching game
- Use a friend and have them quiz you based on content from your notecard
  - Make them write the content too, it's good for them
- Write out questions that you have, then answer those questions.
- Review the quizzes &rarr; he uses A LOT of the same questions on the exams
- Review the past exams &rarr; there will be a surprising amount of similar content

## Fun Things We Did In Zoom That You Missed

If you got to this before the Zoom session: Good job! Keep up this early studying!

<details>
  <summary>Questions:</summary>

1. How do we write the main method in Java?
2. What are the three general ways to write a print statement in Java?
3. Draw the access modifier table. (This should be on your notes!)
4. What are the 2 names for this access modifier? (to be clear you need to know both names)
5. What does calling `launch(args)` do in JavaFX?
6. How does StackPane work?
7. What's the difference between VBox and HBox?
8. When should you use lambdas?
9. How do you write a lambda function?
10. How do you write an anonymous inner class?
11. What does `stage.show()` do?
12. What abstract class does our program extend?

</details>

</details>

<hr>

<details>
  <summary>Final</summary>
  
[To Midterm 1](#midterm-1-snippets)<br>
[To Midterm 2](#midterm-2-snippets)<br>
[To Credits](#credits)
  
# Final Snippets and Questions

## Prep Code Snippets (Don't run these in your IDE &rarr; these are for your brain)

Assume all imports are satisfied.

<hr>
Problem 1

```Java
interface DoesStuff {
    int age = 25;
    String name = "Bryan";
    void sayMyName();    
}
```

```Java
1. public class TestError implements DoesStuff {
2.   int age = 25;
3.   public String name = "Kyle"; 
4.   public List<String> classes; 
5.   
6.   TestError(String n, int a) {
7.     name = n;
8.     classes = new ArrayList<>();
9.   }
10.   
11.   private void addClass(String myClass) {
12.     classes.add(myClass);
13.   }
14.   
15.   private void showClasses() {
16.     classes.forEach((c) -> {
17.         System.out.println("Class: " + c);
18.     });
19.   }
20.   
21.   @Override
22.   public void sayMyName() {
23.     System.out.println("Why don't I output?");
24.   }
25.   
26.   public static void main(String[] args) {
27.     TestError test = new TestError("Steven (emotional support TA for the TAs Sp2026)", 23);
28.     System.out.printf("%n%s%n", test.name); // what is this not an example of
29.     test.addClass("CST205");
30.     test.addClass("CST338");
31.     test.addClass("CST438");
32. 
33.     test.showClasses();
34.     
35.     TestError test2 = new TestError("Dr. C", 42) {
36.         @Override
37.         public void sayMyName() {
38.             System.out.println("My name is " + name);
39.         }  
40.     };
41.     test2.sayMyName();
42.   } 
```

Question 1: What is outputted?

Question 2: What is line 15 an example of?

Question 3: What is the access modifier for `age`?

Question 4: What is the runtime class of `classes`?

Sub-Question: On line 27 &rarr; what PIE-A concept is `test.name` not an example of?

<hr>

Problem 2:

```Java
TextField inputField = new TextField();
inputField.setPromptText("Ferb what are we gonna do today?");
Button addBtn  = new Button("Add");
Button backBtn = new Button("Back");

addBtn.setOnAction(e -> {
    String text = inputField;
    if (!text.isEmpty()) {
        db.insertItem(text);
        listView.getItems().setAll(db.getAllItems());  // refresh list
        inputField.clear();
    }
});
```

<details>
    <summary>Answer</summary>

    String text = inputField.getText().trim();

</details>

Question 1: What is the error with this code?

Question 2: What code is needed to fix it?

<hr>

Problem 3:

```Java
public static DatabaseManager getInstance() {
  if (DatabaseManager.getInstance() == null) {
      return new DatabaseManager;
  }
  return DatabaseManager.getInstance();
}
```

<details>
    <summary>Answer</summary>

    public static DatabaseManager instance = null;
    
    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

</details>

Question 1: What is wrong with this singleton?

Question 2: What code is needed to fix it?

Question 3: Why do we need a singleton for a Database instance?

<hr>

Problem 4:

```Java
private void createTables() {
    String sql = """
        CREATE TABLE items (
            id      INTEGER PRIMARY KEY AUTOINCREMENT,
            name    TEXT    NOT NULL,
            done    INTEGER NOT NULL DEFAULT 0,
            created TEXT    DEFAULT (datetime('now'))
        )
        """;
    try (Statement stmt = connection.createStatement()) {
        stmt.execute();
    } catch (SQLException e) {
        System.err.println("createTables failed: " + e.getMessage());
    }
}
```

Question 1: What are the 2 issues with this code? (Hint: 1 issue is with SQL, 1 issue is in Java)

<details>
    <summary>Answer (Because I think SQL one is hard)</summary>
    
    CREATE TABLE IF NOT EXISTS items (...)
    
    This is bad because we can overwrite data if we don't do this. Could possibly erase millions
    of records.
    
    You got the Java one on your own.

</details>

Question 2: What does the `.execute()` method do?

Sub-Question: What does the `.executeUpdate()` method do?

<hr>

Observer Design Pattern:

```Java
public class Main extends Application { // this part is important too! why?

    @Override
    public void start(Stage stage) {
        Slider slider = new Slider(0, 100, 50);

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {
                System.out.println("Slider moved to: " + newValue);
            }
        });

        VBox root = new VBox(slider);
        stage.setScene(new Scene(root, 300, 200));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

No questions. This is review!

<hr>

Scene Factory Design Pattern:

```Java
public static Scene create(SceneType type, Stage stage, DatabaseManager db) {
    return cache.computeIfAbsent(type, t -> switch (t) {
        case MAIN      -> buildMainScene(stage, db);
        case DASHBOARD -> buildDashboardScene(stage, db);
    });
}
```


<hr>

Singleton Design Pattern:

```Java
public class Singleton {

    private static Singleton instance = null;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

<hr>

General Questions:

Answering all of these will more than prepare you for the final. You'll almost be ready to push .env to prod.

1. What is a lambda expression?
2. What is an anonymous inner class?
3. What's the benefit of an anonymous inner class over a lambda expression?
4. What's the benefit of a lambda expression over an anonymous inner class?
5. What's the easiest way to loop over an `ArrayList` of Strings?
6. What is a `HashMap`? Name it's 3 main methods.
7. How do we loop through all values in a `HashMap`?
8. How do we access a value in a `HashMap`?
9. What are the 2 values in a `HashMap` referred to as?
10. What are generics? 
11. Why do we use them?
12. What are design patterns?
13. Name your 5 favorite design patterns and give a 1 sentence reason you like each (it must be a valid reason)
14. Why are design patterns important?
15. Will you be using design patterns again in the tech industry (hint: the answer is yes &rarr; better learn them now)
16. Can we instantiate a static class?
17. What about an abstract class?
18. What can't abstract classes be declared as?
19. What does calling `super()` in a child class do?
20. Can we pass values to a parent class through a child class?
21. What does calling `this()` in a parent class do? 
22. How about a child class?
23. What does the line of an arrow that points to an `interface` look like?
24. What about a concrete class? 
25. What about an abstract class?
26. What does the UML symbol for an abstract class look like?
27. Name all 4 elements of PIE-A as fast as you can.
28. Explain the observer design pattern to your youngest cousin or least intelligent friend (just kidding about the 2nd one) &rarr; make sure you explain it like you're talking to a 5 year old. *For right now explain it to the person sitting next to you. (review session)*
29. What does the JavaFX main class look like? 
30. What is a stage in JavaFX?
31. Name your favorite SQLite types and give a bs reason for each.
32. What does an observer look like in JavaFX? No, seriously, I only know what it looks like in Android. 🥲
33. Don't forget about inheritance stuff!
34. It would be really funny if each of you brought a different color of construction paper (cardstock) to the final exam &rarr; coordinate with each other and *don't* tell Dr. C. This is technically what you would call a prank (it doubles as a way to take the edge off for finals). It would be even funnier if you didn't acknowledge how weird it was until he does (so don't laugh if you do this or you see someone else doing it). 

Final final prep notes:
- Your old notesheet will be super helpful since the exam is cumulative
- You can and should go back and memorize all the questions from all quizzes (and the midterms) &rarr; remember you can put stuff on your notesheet too!
- Be sure to review plicker questions too!
- Look at past assignments (especially JavaFX assignments) and make sure you know how to do the stuff still
- Review design patterns: Observer, factory, singleton (the others)

Good luck on the Final!

Reach out to (insert current TA name here) if you have any final super urgent questions before the final.


### Credits
Sincere Thanks to:

**Gabrielle Lake** and **Ignacio Gramajo**

for letting me stea \*cough\* ... borrow\* their materials <br>
and finally Bryan for being extremely helpful and Dr. C for being an awesome professor!

Hope this helps future people too!
</details>