# Midterm 2 Review

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

## Tips for the Exam (And your notes!)

**Exam:**

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
  t.setFont("Times New Roman", 24);
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

Same code as lambda:

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

### Event Handling: Anonymous Inner Classes

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

I didn't touch on everything the slides cover so make sure to go look through them!

Notes:

- Use shorthand: Small words or pieces of code that remind you of the content you were studying
- Put symbols & diagrams on your notes
- Write legibly, you want to be able to read your notes
- Group your notes by sections
  - It helps to plan out what you're going to put on your note sheet before

Studying:

- Use AI to quiz yourself on the material (I find this super effective!)
- Use Quizlet to create flashcards for yourself and then play the fun matching game
- Use a friend and have them quiz you based on content from your notecard
  - Make them write the content too, it's good for them
- Write out questions that you have, then answer those questions.
- Review the quizzes &rarr; he uses A LOT of the same questions on the exams
- Review the past exams &rarr; there will be a surprising amount of similar content

## Fun Things We Did In Zoom That You Missed

<details>
  <summary>Questions:</summary>

1. How do we write the main method in Java?
2. What are the three general ways to write a print statement in Java?
3. Draw the access modifier table. (This should be on your notes!)
4. What are the 2 names for this access modifier? (to be clear you need to know both names)

</details>
