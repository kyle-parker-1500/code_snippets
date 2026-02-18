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
| git stash pop /filepath/ | |
| | |
| | |
| | |
| | |
| | |
| | |
