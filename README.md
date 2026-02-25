<details>
  <summary>Midterm 1 Notes</summary>

# Midterm 1 Snippets

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

  public void execute() {
    light.on();
  }
}

class LightOffCommand implements Command {
  Light light;
  public LightOffCommand(Light light) {
    this.light = light;
  }
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

  public void execute() {
    stereo.off();
  }
}

class StereoOnWithCDCommand implements Command {
  Stereo stereo;
  public StereoOnWithCDCommand(Stereo stereo) {
    this.stereo = stereo;
  }
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

<details>
  <summary>Midterm 2 Notes</summary>

  Ha! You thought you could get a jump start didn't you?!

</details>

<details>
  <summary>Final Notes</summary>


  Well that was a mistake :)

  HashMop<Inheritance, Spaghetti> hm = new HashMop<>();

  hm.put(0, Look); <br>
  hm.put(1, if); <br>
  hm.put(2, you); <br>
  hm.put(3, had); <br>
  hm.put(4, one); <br>
  hm.put(5, shot); <br>
  hm.put(6, or); <br>
  hm.get(4); <br>
  hm.put(8, opportunity); <br>
  hm.put(9, To); <br>
  hm.put(10, seize); <br>
  hm.put(11, everything); <br>
  hm.get(2); <br>
  hm.put(13, ever); <br>
  hm.put(14, wanted); <br>
  hm.put(15, in); <br>
  hm.get(4); <br>
  hm.put(17, moment); <br>
  hm.put(18, Would); <br>
  hm.get(2); <br>
  hm.put(20, capture); <br>
  hm.put(21, it); <br>
  hm.get(6); <br>
  hm.put(23, just); <br>
  hm.put(24, let); <br>
  hm.get(21); <br>
  hm.put(26, slip); <br>
  hm.put(27, Yo); <br>
  hm.put(28, His); <br>
  hm.put(29, palms); <br>
  hm.put(30, are); <br>
  hm.put(31, sweaty); <br>
  hm.put(32, knees); <br>
  hm.put(33, weak); <br>
  hm.put(34, arms); <br>
  hm.get(30); <br>
  hm.put(36, heavy); <br>
  hm.put(37, There); <br>
  hm.put(38, s); <br>
  hm.put(39, vomit); <br>
  hm.put(40, on); <br>
  hm.put(41, his); <br>
  hm.put(42, sweater); <br>
  hm.put(43, already); <br>
  hm.put(44, mom); <br>
  hm.get(38); <br>
  hm.put(46, spaghetti); <br>
  hm.put(47, He); <br>
  hm.get(38); <br>
  hm.put(49, nervous); <br>
  hm.put(50, but); <br>
  hm.get(40); <br>
  hm.put(52, the); <br>
  hm.put(53, surface); <br>
  hm.put(54, he); <br>
  hm.put(55, looks); <br>
  hm.put(56, calm); <br>
  hm.put(57, and); <br>
  hm.put(58, ready); <br>
  hm.get(9); <br>
  hm.put(60, drop); <br>
  hm.put(61, bombs); <br>
  hm.get(50); <br>
  hm.get(54); <br>
  hm.put(64, keeps); <br>
  hm.get(40); <br>
  hm.put(66, forgetting); <br>
  hm.put(67, What); <br>
  hm.get(54); <br>
  hm.put(69, wrote); <br>
  hm.put(70, down); <br>
  hm.get(52); <br>
  hm.put(72, whole); <br>
  hm.put(73, crowd); <br>
  hm.put(74, goes); <br>
  hm.put(75, so); <br>
  hm.put(76, loud); <br>
  hm.get(47); <br>
  hm.put(78, opens); <br>
  hm.get(41); <br>
  hm.put(80, mouth); <br>
  hm.get(50); <br>
  hm.get(52); <br>
  hm.put(83, words); <br>
  hm.put(84, won); <br>
  hm.put(85, t); <br>
  hm.put(86, come); <br>
  hm.put(87, out); <br>
  hm.get(47); <br>
  hm.get(38); <br>
  hm.put(90, chokin); <br>
  hm.put(91, how); <br>
  hm.put(92, Everybody); <br>
  hm.get(38); <br>
  hm.put(94, jokin); <br>
  hm.put(95, now); <br>
  hm.put(96, The); <br>
  hm.put(97, clock); <br>
  hm.get(38); <br>
  hm.put(99, run); <br>
  hm.get(87); <br>
  hm.put(101, time); <br>
  hm.get(38); <br>
  hm.put(103, up); <br>
  hm.put(104, over); <br>
  hm.put(105, blaow); <br>
  hm.put(106, Snap); <br>
  hm.put(107, back); <br>
  hm.put(108, to); <br>
  hm.put(109, reality); <br>
  hm.put(110, ope); <br>
  hm.put(111, there); <br>
  hm.get(74); <br>
  hm.put(113, gravity); <br>
  hm.put(114, Ope); <br>
  hm.get(111); <br>
  hm.get(74); <br>
  hm.put(117, Rabbit); <br>
  hm.get(54); <br>
  hm.put(119, choked); <br>
  hm.get(54); <br>
  hm.get(38); <br>
  hm.get(75); <br>
  hm.put(123, mad); <br>
  hm.put(124, But); <br>
  hm.get(54); <br>
  hm.get(84); <br>
  hm.get(85); <br>
  hm.put(128, give); <br>
  hm.get(103); <br>
  hm.put(130, that); <br>
  hm.put(131, easy); <br>
  hm.put(132, no); <br>
  hm.get(54); <br>
  hm.get(84); <br>
  hm.get(85); <br>
  hm.put(136, have); <br>
  hm.get(21); <br>
  hm.get(47); <br>
  hm.put(139, knows); <br>
  hm.get(41); <br>
  hm.get(72); <br>
  hm.get(107); <br>
  hm.get(38); <br>
  hm.get(108); <br>
  hm.put(145, these); <br>
  hm.put(146, ropes); <br>
  hm.get(21); <br>
  hm.put(148, don); <br>
  hm.get(85); <br>
  hm.put(150, matter); <br>
  hm.get(47); <br>
  hm.get(38); <br>
  hm.put(153, dope); <br>
  hm.get(54); <br>
  hm.get(139); <br>
  hm.get(130); <br>
  hm.get(50); <br>
  hm.get(54); <br>
  hm.get(38); <br>
  hm.put(160, broke); <br>
  hm.get(54); <br>
  hm.get(38); <br>
  hm.get(75); <br>
  hm.put(164, stagnant); <br>
  hm.get(47); <br>
  hm.get(139); <br>
  hm.put(167, when); <br>
  hm.get(54); <br>
  hm.get(74); <br>
  hm.get(107); <br>
  hm.get(108); <br>
  hm.put(172, this); <br>
  hm.put(173, mobile); <br>
  hm.put(174, home); <br>
  hm.get(130); <br>
  hm.get(38); <br>
  hm.get(167); <br>
  hm.get(21); <br>
  hm.get(38); <br>
  hm.put(180, Back); <br>
  hm.get(108); <br>
  hm.get(52); <br>
  hm.put(183, lab); <br>
  hm.put(184, again); <br>
  hm.put(185, yo); <br>
  hm.get(172); <br>
  hm.put(187, old); <br>
  hm.put(188, rhapsody); <br>
  hm.put(189, Better); <br>
  hm.put(190, go); <br>
  hm.get(20); <br>
  hm.get(172); <br>
  hm.get(17); <br>
  hm.get(57); <br>
  hm.put(195, hope); <br>
  hm.get(21); <br>
  hm.get(148); <br>
  hm.get(85); <br>
  hm.put(199, pass); <br>
  hm.put(200, him); <br>
  hm.put(201, You); <br>
  hm.put(202, better); <br>
  hm.put(203, lose); <br>
  hm.put(204, yourself); <br>
  hm.get(15); <br>
  hm.get(52); <br>
  hm.put(207, music); <br>
  hm.get(96); <br>
  hm.get(17); <br>
  hm.get(2); <br>
  hm.put(211, own); <br>
  hm.get(21); <br>
  hm.get(2); <br>
  hm.get(202); <br>
  hm.put(215, never); <br>
  hm.get(24); <br>
  hm.get(21); <br>
  hm.get(190); <br>
  hm.put(219, Go); <br>
  hm.get(201); <br>
  hm.put(221, only); <br>
  hm.put(222, get); <br>
  hm.get(4); <br>
  hm.get(5); <br>
  hm.put(225, do); <br>
  hm.put(226, not); <br>
  hm.put(227, miss); <br>
  hm.put(228, your); <br>
  hm.put(229, chance); <br>
  hm.get(108); <br>
  hm.put(231, blow); <br>
  hm.put(232, This); <br>
  hm.get(8); <br>
  hm.put(234, comes); <br>
  hm.put(235, once); <br>
  hm.get(15); <br>
  hm.put(237, a); <br>
  hm.put(238, lifetime); <br>
  hm.get(185); <br>
  hm.get(201); <br>
  hm.get(202); <br>
  hm.get(203); <br>
  hm.get(204); <br>
  hm.get(15); <br>
  hm.get(52); <br>
  hm.get(207); <br>
  hm.get(96); <br>
  hm.get(17); <br>
  hm.get(2); <br>
  hm.get(211); <br>
  hm.get(21); <br>
  hm.get(2); <br>
  hm.get(202); <br>
  hm.get(215); <br>
  hm.get(24); <br>
  hm.get(21); <br>
  hm.get(190); <br>
  hm.get(219); <br>
  hm.get(201); <br>
  hm.get(221); <br>
  hm.get(222); <br>
  hm.get(4); <br>
  hm.get(5); <br>
  hm.get(225); <br>
  hm.get(226); <br>
  hm.get(227); <br>
  hm.get(228); <br>
  hm.get(229); <br>
  hm.get(108); <br>
  hm.get(231); <br>
  hm.get(232); <br>
  hm.get(8); <br>
  hm.get(234); <br>
  hm.get(235); <br>
  hm.get(15); <br>
  hm.get(237); <br>
  hm.get(238); <br>
  hm.get(185); <br>
  hm.get(201); <br>
  hm.get(202); <br>
  hm.get(28); <br>
  hm.put(282, soul); <br>
  hm.get(38); <br>
  hm.put(284, escaping); <br>
  hm.put(285, through); <br>
  hm.get(172); <br>
  hm.put(287, hole); <br>
  hm.get(130); <br>
  hm.put(289, is); <br>
  hm.put(290, gaping); <br>
  hm.get(232); <br>
  hm.put(292, world); <br>
  hm.get(289); <br>
  hm.put(294, mine); <br>
  hm.put(295, for); <br>
  hm.get(52); <br>
  hm.put(297, taking); <br>
  hm.put(298, make); <br>
  hm.put(299, me); <br>
  hm.put(300, king); <br>
  hm.put(301, As); <br>
  hm.put(302, we); <br>
  hm.put(303, move); <br>
  hm.put(304, toward); <br>
  hm.get(237); <br>
  hm.put(306, new); <br>
  hm.get(292); <br>
  hm.put(308, order); <br>
  hm.put(309, A); <br>
  hm.put(310, normal); <br>
  hm.put(311, life); <br>
  hm.get(289); <br>
  hm.put(313, boring); <br>
  hm.get(50); <br>
  hm.put(315, superstardom); <br>
  hm.get(38); <br>
  hm.put(317, Close); <br>
  hm.get(108); <br>
  hm.put(319, post-mortem); <br>
  hm.get(21); <br>
  hm.get(221); <br>
  hm.put(322, grows); <br>
  hm.put(323, harder); <br>
  hm.put(324, Homie); <br>
  hm.get(322); <br>
  hm.put(326, hotter); <br>
  hm.get(54); <br>
  hm.put(328, blows); <br>
  hm.get(21); <br>
  hm.get(38); <br>
  hm.put(331, all); <br>
  hm.get(104); <br>
  hm.put(333, These); <br>
  hm.put(334, hoes); <br>
  hm.get(289); <br>
  hm.get(331); <br>
  hm.get(40); <br>
  hm.get(200); <br>
  hm.put(339, coast-to-coast); <br>
  hm.put(340, shows); <br>
  hm.get(47); <br>
  hm.get(38); <br>
  hm.put(343, known); <br>
  hm.put(344, as); <br>
  hm.get(52); <br>
  hm.put(346, Globetrotter); <br>
  hm.put(347, lonely); <br>
  hm.put(348, roads); <br>
  hm.put(349, God); <br>
  hm.get(221); <br>
  hm.get(139); <br>
  hm.get(54); <br>
  hm.get(38); <br>
  hm.put(354, grown); <br>
  hm.put(355, farther); <br>
  hm.put(356, from); <br>
  hm.get(174); <br>
  hm.get(54); <br>
  hm.get(38); <br>
  hm.get(132); <br>
  hm.put(361, father); <br>
  hm.get(47); <br>
  hm.get(74); <br>
  hm.get(174); <br>
  hm.get(57); <br>
  hm.put(366, barely); <br>
  hm.get(139); <br>
  hm.get(41); <br>
  hm.get(211); <br>
  hm.put(370, daughter); <br>
  hm.get(124); <br>
  hm.put(372, hold); <br>
  hm.get(228); <br>
  hm.put(374, nose); <br>
  hm.put(375, cause); <br>
  hm.put(376, here); <br>
  hm.get(74); <br>
  hm.get(52); <br>
  hm.put(379, cold); <br>
  hm.put(380, water); <br>
  hm.get(333); <br>
  hm.get(334); <br>
  hm.get(148); <br>
  hm.get(85); <br>
  hm.put(385, want); <br>
  hm.get(200); <br>
  hm.get(132); <br>
  hm.put(388, mo); <br>
  hm.get(54); <br>
  hm.get(38); <br>
  hm.get(379); <br>
  hm.put(392, product); <br>
  hm.put(393, They); <br>
  hm.put(394, moved); <br>
  hm.get(40); <br>
  hm.get(108); <br>
  hm.get(52); <br>
  hm.put(398, next); <br>
  hm.put(399, schmoe); <br>
  hm.put(400, who); <br>
  hm.put(401, flows); <br>
  hm.get(47); <br>
  hm.put(403, nose-dove); <br>
  hm.get(57); <br>
  hm.put(405, sold); <br>
  hm.put(406, nada); <br>
  hm.get(57); <br>
  hm.get(75); <br>
  hm.get(52); <br>
  hm.put(410, soap); <br>
  hm.put(411, opera); <br>
  hm.put(412, Is); <br>
  hm.put(413, told); <br>
  hm.get(21); <br>
  hm.put(415, unfolds); <br>
  hm.put(416, I); <br>
  hm.put(417, suppose); <br>
  hm.get(21); <br>
  hm.get(38); <br>
  hm.get(187); <br>
  hm.put(421, partner); <br>
  hm.get(124); <br>
  hm.get(52); <br>
  hm.put(424, beat); <br>
  hm.get(74); <br>
  hm.get(40); <br>
  hm.put(427, da-da-dom); <br>
  hm.put(428, da-dom); <br>
  hm.put(429, dah-dah-dah-dah); <br>
  hm.get(201); <br>
  hm.get(202); <br>
  hm.get(203); <br>
  hm.get(204); <br>
  hm.get(15); <br>
  hm.get(52); <br>
  hm.get(207); <br>
  hm.get(96); <br>
  hm.get(17); <br>
  hm.get(2); <br>
  hm.get(211); <br>
  hm.get(21); <br>
  hm.get(2); <br>
  hm.get(202); <br>
  hm.get(215); <br>
  hm.get(24); <br>
  hm.get(21); <br>
  hm.get(190); <br>
  hm.get(219); <br>
  hm.get(201); <br>
  hm.get(221); <br>
  hm.get(222); <br>
  hm.get(4); <br>
  hm.get(5); <br>
  hm.get(225); <br>
  hm.get(226); <br>
  hm.get(227); <br>
  hm.get(228); <br>
  hm.get(229); <br>
  hm.get(108); <br>
  hm.get(231); <br>
  hm.get(232); <br>
  hm.get(8); <br>
  hm.get(234); <br>
  hm.get(235); <br>
  hm.get(15); <br>
  hm.get(237); <br>
  hm.get(238); <br>
  hm.get(185); <br>
  hm.get(201); <br>
  hm.get(202); <br>
  hm.get(203); <br>
  hm.get(204); <br>
  hm.get(15); <br>
  hm.get(52); <br>
  hm.get(207); <br>
  hm.get(96); <br>
  hm.get(17); <br>
  hm.get(2); <br>
  hm.get(211); <br>
  hm.get(21); <br>
  hm.get(2); <br>
  hm.get(202); <br>
  hm.get(215); <br>
  hm.get(24); <br>
  hm.get(21); <br>
  hm.get(190); <br>
  hm.get(219); <br>
  hm.get(201); <br>
  hm.get(221); <br>
  hm.get(222); <br>
  hm.get(4); <br>
  hm.get(5); <br>
  hm.get(225); <br>
  hm.get(226); <br>
  hm.get(227); <br>
  hm.get(228); <br>
  hm.get(229); <br>
  hm.get(108); <br>
  hm.get(231); <br>
  hm.get(232); <br>
  hm.get(8); <br>
  hm.get(234); <br>
  hm.get(235); <br>
  hm.get(15); <br>
  hm.get(237); <br>
  hm.get(238); <br>
  hm.get(185); <br>
  hm.get(201); <br>
  hm.get(202); <br>
  hm.put(510, No); <br>
  hm.put(511, more); <br>
  hm.put(512, games); <br>
  hm.get(416); <br>
  hm.put(514, ma); <br>
  hm.put(515, change); <br>
  hm.put(516, what); <br>
  hm.get(2); <br>
  hm.put(518, call); <br>
  hm.put(519, rage); <br>
  hm.put(520, Tear); <br>
  hm.get(172); <br>
  hm.put(522, motherfuckin); <br>
  hm.put(523, roof); <br>
  hm.put(524, off); <br>
  hm.put(525, like); <br>
  hm.put(526, two); <br>
  hm.put(527, dogs); <br>
  hm.put(528, caged); <br>
  hm.get(416); <br>
  hm.put(530, was); <br>
  hm.put(531, playin); <br>
  hm.get(15); <br>
  hm.get(52); <br>
  hm.put(534, beginning); <br>
  hm.get(52); <br>
  hm.put(536, mood); <br>
  hm.get(331); <br>
  hm.put(538, changed); <br>
  hm.get(416); <br>
  hm.put(540, ve); <br>
  hm.put(541, been); <br>
  hm.put(542, chewed); <br>
  hm.get(103); <br>
  hm.get(57); <br>
  hm.put(545, spit); <br>
  hm.get(87); <br>
  hm.get(57); <br>
  hm.put(548, booed); <br>
  hm.get(524); <br>
  hm.put(550, stage); <br>
  hm.get(124); <br>
  hm.get(416); <br>
  hm.put(553, kept); <br>
  hm.put(554, rhymin); <br>
  hm.get(57); <br>
  hm.put(556, stepped); <br>
  hm.put(557, right); <br>
  hm.get(15); <br>
  hm.get(52); <br>
  hm.get(398); <br>
  hm.put(561, cypher); <br>
  hm.put(562, Best); <br>
  hm.put(563, believe); <br>
  hm.put(564, somebody); <br>
  hm.get(38); <br>
  hm.put(566, payin); <br>
  hm.get(52); <br>
  hm.put(568, Pied); <br>
  hm.put(569, Piper); <br>
  hm.put(570, All); <br>
  hm.get(52); <br>
  hm.put(572, pain); <br>
  hm.put(573, inside); <br>
  hm.put(574, amplified); <br>
  hm.put(575, by); <br>
  hm.get(52); <br>
  hm.put(577, Fact); <br>
  hm.get(130); <br>
  hm.get(416); <br>
  hm.put(580, can); <br>
  hm.get(85); <br>
  hm.get(222); <br>
  hm.get(575); <br>
  hm.put(584, with); <br>
  hm.put(585, my); <br>
  hm.put(586, nine-to-); <br>
  hm.put(587, Five); <br>
  hm.get(57); <br>
  hm.get(416); <br>
  hm.get(580); <br>
  hm.get(85); <br>
  hm.put(592, provide); <br>
  hm.get(52); <br>
  hm.get(557); <br>
  hm.put(595, type); <br>
  hm.put(596, of); <br>
  hm.get(311); <br>
  hm.get(295); <br>
  hm.get(585); <br>
  hm.put(600, family); <br>
  hm.put(601, Cause); <br>
  hm.put(602, man); <br>
  hm.get(145); <br>
  hm.put(604, goddamn); <br>
  hm.put(605, food); <br>
  hm.put(606, stamps); <br>
  hm.get(148); <br>
  hm.get(85); <br>
  hm.put(609, buy); <br>
  hm.put(610, diapers); <br>
  hm.put(611, And); <br>
  hm.get(111); <br>
  hm.get(38); <br>
  hm.get(132); <br>
  hm.put(615, movie); <br>
  hm.get(111); <br>
  hm.get(38); <br>
  hm.get(132); <br>
  hm.put(619, Mekhi); <br>
  hm.put(620, Phifer); <br>
  hm.get(172); <br>
  hm.get(289); <br>
  hm.get(585); <br>
  hm.get(311); <br>
  hm.get(611); <br>
  hm.get(145); <br>
  hm.put(627, times); <br>
  hm.get(30); <br>
  hm.get(75); <br>
  hm.put(630, hard); <br>
  hm.get(57); <br>
  hm.get(21); <br>
  hm.get(38); <br>
  hm.put(634, gettin); <br>
  hm.put(635, even); <br>
  hm.get(323); <br>
  hm.put(637, Tryna); <br>
  hm.put(638, feed); <br>
  hm.get(57); <br>
  hm.get(380); <br>
  hm.get(585); <br>
  hm.put(642, seed); <br>
  hm.put(643, plus); <br>
  hm.put(644, teeter-totter); <br>
  hm.put(645, Caught); <br>
  hm.get(103); <br>
  hm.put(647, between); <br>
  hm.put(648, bein); <br>
  hm.get(237); <br>
  hm.get(361); <br>
  hm.get(57); <br>
  hm.get(237); <br>
  hm.put(653, prima); <br>
  hm.put(654, donna); <br>
  hm.put(655, Baby-mama); <br>
  hm.put(656, drama); <br>
  hm.put(657, screamin); <br>
  hm.get(40); <br>
  hm.put(659, her); <br>
  hm.put(660, too); <br>
  hm.put(661, much); <br>
  hm.get(295); <br>
  hm.get(299); <br>
  hm.get(108); <br>
  hm.put(665, wanna); <br>
  hm.put(666, Stay); <br>
  hm.get(15); <br>
  hm.get(4); <br>
  hm.put(669, spot); <br>
  hm.put(670, another); <br>
  hm.put(671, day); <br>
  hm.get(596); <br>
  hm.put(673, monotony); <br>
  hm.get(38); <br>
  hm.put(675, gotten); <br>
  hm.get(299); <br>
  hm.get(9); <br>
  hm.get(52); <br>
  hm.put(679, point); <br>
  hm.get(416); <br>
  hm.put(681, m); <br>
  hm.get(525); <br>
  hm.get(237); <br>
  hm.put(684, snail); <br>
  hm.get(416); <br>
  hm.get(540); <br>
  hm.put(687, got); <br>
  hm.get(9); <br>
  hm.put(689, formulate); <br>
  hm.get(237); <br>
  hm.put(691, plot); <br>
  hm.get(6); <br>
  hm.put(693, end); <br>
  hm.get(103); <br>
  hm.get(15); <br>
  hm.put(696, jail); <br>
  hm.get(6); <br>
  hm.get(5); <br>
  hm.put(699, Success); <br>
  hm.get(289); <br>
  hm.get(585); <br>
  hm.get(221); <br>
  hm.get(522); <br>
  hm.put(704, option); <br>
  hm.put(705, failure); <br>
  hm.get(38); <br>
  hm.get(226); <br>
  hm.put(708, Mom); <br>
  hm.get(416); <br>
  hm.put(710, love); <br>
  hm.get(2); <br>
  hm.get(50); <br>
  hm.get(172); <br>
  hm.put(714, trailer); <br>
  hm.get(38); <br>
  hm.get(687); <br>
  hm.get(9); <br>
  hm.get(190); <br>
  hm.get(416); <br>
  hm.put(720, cannot); <br>
  hm.put(721, grow); <br>
  hm.get(187); <br>
  hm.get(15); <br>
  hm.put(724, Salem); <br>
  hm.get(38); <br>
  hm.put(726, Lot); <br>
  hm.put(727, So); <br>
  hm.get(376); <br>
  hm.get(416); <br>
  hm.get(190); <br>
  hm.get(21); <br>
  hm.get(38); <br>
  hm.get(585); <br>
  hm.get(5); <br>
  hm.put(735, feet); <br>
  hm.put(736, fail); <br>
  hm.get(299); <br>
  hm.get(226); <br>
  hm.get(232); <br>
  hm.put(740, may); <br>
  hm.put(741, be); <br>
  hm.get(52); <br>
  hm.get(221); <br>
  hm.get(8); <br>
  hm.get(130); <br>
  hm.get(416); <br>
  hm.get(687); <br>
  hm.get(201); <br>
  hm.get(202); <br>
  hm.get(203); <br>
  hm.get(204); <br>
  hm.get(15); <br>
  hm.get(52); <br>
  hm.get(207); <br>
  hm.get(96); <br>
  hm.get(17); <br>
  hm.get(2); <br>
  hm.get(211); <br>
  hm.get(21); <br>
  hm.get(2); <br>
  hm.get(202); <br>
  hm.get(215); <br>
  hm.get(24); <br>
  hm.get(21); <br>
  hm.get(190); <br>
  hm.get(219); <br>
  hm.get(201); <br>
  hm.get(221); <br>
  hm.get(222); <br>
  hm.get(4); <br>
  hm.get(5); <br>
  hm.get(225); <br>
  hm.get(226); <br>
  hm.get(227); <br>
  hm.get(228); <br>
  hm.get(229); <br>
  hm.get(108); <br>
  hm.get(231); <br>
  hm.get(232); <br>
  hm.get(8); <br>
  hm.get(234); <br>
  hm.get(235); <br>
  hm.get(15); <br>
  hm.get(237); <br>
  hm.get(238); <br>
  hm.get(185); <br>
  hm.get(201); <br>
  hm.get(202); <br>
  hm.get(203); <br>
  hm.get(204); <br>
  hm.get(15); <br>
  hm.get(52); <br>
  hm.get(207); <br>
  hm.get(96); <br>
  hm.get(17); <br>
  hm.get(2); <br>
  hm.get(211); <br>
  hm.get(21); <br>
  hm.get(2); <br>
  hm.get(202); <br>
  hm.get(215); <br>
  hm.get(24); <br>
  hm.get(21); <br>
  hm.get(190); <br>
  hm.get(219); <br>
  hm.get(201); <br>
  hm.get(221); <br>
  hm.get(222); <br>
  hm.get(4); <br>
  hm.get(5); <br>
  hm.get(225); <br>
  hm.get(226); <br>
  hm.get(227); <br>
  hm.get(228); <br>
  hm.get(229); <br>
  hm.get(108); <br>
  hm.get(231); <br>
  hm.get(232); <br>
  hm.get(8); <br>
  hm.get(234); <br>
  hm.get(235); <br>
  hm.get(15); <br>
  hm.get(237); <br>
  hm.get(238); <br>
  hm.get(185); <br>
  hm.get(201); <br>
  hm.get(202); <br>
  hm.get(201); <br>
  hm.get(580); <br>
  hm.get(225); <br>
  hm.put(831, anything); <br>
  hm.get(2); <br>

</details>
