<details>
  <summary>Midterm 1 Snippets & Notes</summary>

# Midterm 1 Snippets

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

For loop & for each loop:

```Java
int[] testArr = {1, 2, 3, 4, 5};
for (int i = 0; i < testArr.length; i++) {
  System.out.print(testArr[i] + " "); // prints 1 2 3 4 5
}

// for each
for (int number : testArr) {
  System.out.print(number + " "); // prints each number in testArr
}

// for each with strings & chars
String line = "string";

for (Character c : line.toCharArray()) {
  System.out.println(c); // prints each char of line
}
```

While loop & Modulus operator (%):

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

*“They’re like backwards if statements” ~ Dr. C*

- Use when we're not certain something will run the same 100% of the time
- Ex:
  - When reading user input using `Scanner`
  - When reading from or writing to files
- When a problem occurs an error is thrown
- Java will be looking for that error and when found, it will execute
  the catch block
- Java can look for many types of errors ex: `IOException` and `Exception`
  (most common)
- Finally will ___always___ run regardless of what happens in the try catch
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

Git and GitHub:

Git:

- An extremely useful version control system
- Allows you to save the state of your files in a particular moment
  - Save the version in something called a *repository*
    - Save a state through something called a *commit*
  - This gives you the power to go back to a previous version if you make a mistake
  - It also allows you to go back to a previous version to test something
  - You can also make a new copy in the form of a branch to change something
    without altering what already works

GitHub:

- An online database of Git repositories

All Git & GitHub commands and what they do:

| Command | What it does:|
| -------------- | --------------- |
| git status     | shows current state of branch |
| git add . | stages all changes for a commit |
| git add /filepath/ | stages one specific path for a commit |
| git commit -m "" | commits currently staged files with a given message |
| git commit | opens up a VIM style terminal to write longer & more complex messages |
| git stash | must use after `git add`, takes all currently staged files and hides them from a commit or switch |
| git stash /filepath/  | stashes a specific filepath |
| git stash pop | unstash the last thing that was stashed |
| git log  | list all commits |
| git show | display last commit |
| git show <commit_hash> | each commit has a hash to identify it, you can use this command to see it |
| git checkout <branch_name> | moves you to a new branch |
| git switch <branch_name> | does the same thing as git checkout <branch_name> |
| git checkout -b <new_branch_name> | creates new branch |
| git remote -v | displays all remote repositories currently connected |
| git remote add origin <github_link.git> | add new remote repository under the name origin |
| git remote remove <name> | remove remote repository link at that name |
| git merge <branch_name> | merges <branch_name> into checked out branch |
| git rebase <branch_name> | takes commits from <branch_name> and places them on top of all commits of checked out branch |


## Constructors:

Used to initialize objects also used to set values.

__Default:__ When no constructor is created, a default constructor is called when instantiating an object
__Parameterized:__ If a constructor is created it will override the default and is custom to the programmer

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

## Access Modifiers & UML

|  | Class | Package | Subclass | Global |
| --------------- | --------------- | --------------- | --------------- | --------------- |
| Public | Yes | Yes | Yes | Yes |
| Protected | Yes | Yes | Yes | No |
| Default | Yes | Yes | No | No |
| Private | Yes | No | No | No |


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

## Primitives & Wrappers

__Primitive Types:__ int, double, char...
  - Simple types

__Wrapper Classes:__ Integer, Double, Character...
  - Objects containing methods to use such as .equals()

![Wrappers](./images/wrapper_class.png)

## Boxing & Unboxing
__Boxing:__ Converting a primitive type &rarr; wrapper class

```Java
int primitive = 50;
Integer wrapper = primitive;
```

__Unboxing:__ Converting a wrapper class &rarr; primitive type

```Java
Integer wrapper = 50;
int primitive = wrapper;
```

## ArrayList vs HashMap

### ArrayList:
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

### HashMap:

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

__Instance:__ `Card c = new Card();`
  - When you use the keyword "__new__", you create an instance of the object
  - They can be marked as final
  - They can't be marked abstract
  - They can't be marked static

__Static:__ `public static void m();`
  - Can be applied to: methods & fields
  - Static members can be accessed without creating an instance of the object

__Static Variables:__ `public static int num;`
  - Variable is shared by all instances of a class

__Final:__ `public final void m();`
  - Can be applied to: classes, methods, & fields
  - Makes things constant and prevents overriding

__Final Variables:__ `public final SIZE = 5;`
- Variables can only ever be assigned once and the value can never be changed
  - Variables marked with ALL_CAPS are typically final variables

## this, new, & super

___this___ &rarr; accesses the current object
`this.hp -= 10;`

___`this("parent", "child");`___ calls its own constructor within the given parameter

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

___new___ &rarr; creates a new instance of an object
`Object obj = new Object(param);`

___super___ &rarr; accesses the parent object (the class that the current class is extending)
```Java
ChildObject { // constructor
  super();
  hp = 100;
}
```

___`super(s1);`___ &rarr; calls the constructor in its parent class

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

__Abstract Classes:__ 
  - Instances can't be created
  - Can have abstract & concrete methods
  - Cannot be declared final (think about it)
  - Other classes can only extend at most __ONE__ abstract class

__Interface:__
  - Blueprint/behavior of the class
    - Specifies what a class must do and _not_ how
  - Used to achieve loose coupling
  - Other classes can implement __MANY__ interfaces

![Inheritance](./images/inheritance_1.png)

Reading the above definitions which of the snippets is correct?
```Java
A) Cat cat = new Animal();
B) Animal animal = new Dog();
C) Canine dog = new Canine();
```

__Answer (click to reveal):__
<details>
  <summary>Answer</summary>

  B) `Animal animal = new Dog();`

</details>

### Extend vs Implement

__Extending:__
  - When a class is inheriting from another class (abstract or not)
  - When an interface is inheriting from another interface

`public interface Card extends Deck {}`

__Implementing:__
  - When a class is inheriting from an interface

`public abstract class Monster implements Attack {}`

## Override vs Overload

__Override:__
  - Rewriting the code passed down from a parent class

Ex:

```Java
@Override
public String toString() {
  return "Hello World!";
}
```

__Overloading:__
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

## Testing: Black Box vs White Box

__White Box Testing:__
- When the tester has access to the code being tested
  - Path Testing
  - Loop Testing
  - Condition Testing

__Black Box Testing:__
- When the tester doesn't have access to the code
  - Functional Testing
  - Non-functional Testing
  - Regression Testing

![Black Box vs White Box Testing](./images/blackbox_vs_whitebox.png)

</details>

<details>
  <summary>Midterm 2 Snippets & Notes</summary>

</details>

<details>
  <summary>Midterm 3 Snippets & Notes</summary>

</details>
