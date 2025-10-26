import java.util.Random;
import java.util.Scanner;

public class QuizOOP1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lesson 1 or Lesson 2 (1 or 2)? >");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                quiz1();
                break;
            case 2:
                quiz2();
            default:
                System.out.println("Pick 1 or 2.");
        scanner.close();
        }
    }
    public static void quiz1(){
        String[] questions = {
            // TOPIC 1: Basic Data Structures and Algorithms
            "Which data structure stores elements of the same type in contiguous memory and supports O(1) access using an index?",
            "Which data structure is made of nodes with pointers and can grow or shrink dynamically?",
            "Which data structure follows the Last In, First Out (LIFO) principle?",
            "Which data structure follows the First In, First Out (FIFO) principle?",
            "Which data structure is hierarchical and consists of nodes connected by edges?",

            // TOPIC 2: Data Types, ADTs, Data Structures
            "What defines the type of value a variable can hold and the operations allowed on it?",
            "What data concept specifies what operations can be done but not how they are implemented, promoting abstraction?",
            "What refers to the ways of organizing and storing data for efficient manipulation?",

            // Categories of Data Structures
            "Which category of data structure includes basic building blocks such as integers, characters, and floats?",
            "Which category of data structure is formed by combining primitive types like arrays, strings, and records?",
            "Which category of data structure includes structures with multiple levels and connections like lists, stacks, and trees?",
            "Which category combines other structures to store complex relationships like arrays of records?",
            "Which category is designed for reliable large-scale storage such as sequential or indexed files?",

            // Data Structure Operations
            "Which data structure operation adds new data elements?",
            "Which operation removes specific elements from a structure?",
            "Which operation systematically visits each element in a structure?",
            "Which operation locates an element based on a key or value?",
            "Which operation arranges data elements in a certain order such as ascending or descending?",
            "Which operation combines two structures into one?",
            "Which operation modifies existing data elements in a structure?",

            // TOPIC 3: Importance of Data Structures
            "What benefit of data structures focuses on optimizing time and memory during program execution?",
            "What benefit of data structures allows programs to handle growing data sizes?",
            "Which advantage of data structures helps simplify code updates and error handling?",
            "Which advantage of data structures allows structures to be used in multiple programs?",
            "Which advantage of data structures supports building efficient algorithms?"
        };

        String[] answers = {
            // TOPIC 1
            "Arrays",
            "Linked Lists",
            "Stacks",
            "Queues",
            "Trees",

            // TOPIC 2
            "Data Types",
            "Abstract Data Types (ADTs)",
            "Data Structures",

            // Categories
            "Primitive Data Structures",
            "Simple Data Structures",
            "Complex Data Structures",
            "Compound Data Structures",
            "File Organization",

            // Operations
            "Insertion",
            "Deletion",
            "Traversal",
            "Searching",
            "Sorting",
            "Merging",
            "Updating",

            // Importance of Data Structures
            "Efficiency",
            "Scalability",
            "Maintainability",
            "Reusability",
            "Foundation for Algorithms"
        };


        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        String useranswer;
        int correct = 0;
        for (int i = questions.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            String temp = questions[i];
            questions[i] = questions[j];
            questions[j] = temp;
            temp = answers[i];
            answers[i] = answers[j];
            answers[j] = temp;
        }

        for (int i = 0; i < questions.length; i++){
            System.out.println(questions[i]);
            System.out.print("Answer: ");
            useranswer = scanner.nextLine();
            if (answers[i].equalsIgnoreCase(useranswer)) {
                System.out.println("Correct!\n");
                correct++;
            } else {
                System.out.println("Wrong! The answer is "+ answers[i]);
                System.out.print("\n");
            }
        }
        System.out.printf("\n\nYou have gotten %d out of %d.", correct, answers.length);
        scanner.close();
    }
     public static void quiz2(){
        String[] questions = {
            "This is a data structure that considered as a collection of elements having the same data type.",
            "Give me the characteristics of an array:",
            "Give me the common pitfalls of array",
            "This is a utility class in the java.util package in JAva, It provudes vairous static methods for manipulating arrays.",
            "Give me the array manipulations:",
            "This is one of the new data types, but actually a class built in to Java.",
            "Give me the string manipulations:",
            "This is a collection of statements that perform a psecific task and are grouped together under a name.",
            "These are used to organize code into logical blocks, promote reusability, and make programs more modular.",
            "Give me the two types of methods:",
            "This is a method that performs an action but does not return any value.",
            "This is a method that performs an action and returns a result",
            "This is when multiple methods have the same name but different parameter lists. This is also called compile-time polymorphism.",
            "This is when a child class provides its own implementation of a method that is already defined in the parent class. This is runtime polymorphism.",
            "This is a method used to sort any array of integers",
            "This is the method usede to find the index of a specific element in the sorted array",
            "This is the method used ot fill an array with a specified value.",
            "This is the method used to convert an array to a string representation",
            "This is the method used ot check the equality of two arrays",
            "This is the mthod used to create a copy of an array with a specified lenght",
            "This is the method used to calculate the hash code of an array",
            "This returns the character at the specified index in the string.",
            "This returns the lenght of the string.",
            "This returns a substring starting from the specified index",
            "This converts all characters in the string to lowercase",
            "This converts all characters in the string to uppercase",
            "This removes the leading and trailing whitespaces from the string",
            "This compares the string to the specified object for equality",
            "This compares the string to another string, ignoring case differences",
            "This checks if the string starts with the specified prefix",
            "This checks if the string ends with the specified suffix",
            "This checks if the string contains the specific sequence of characters"
        };
        String[] answers = {
            "Array",
            "Homogenous, Indexed, Fixed, Stored in contiguous memory",
            "ArrayIndexOutOfBoundsException, Fixed Size, Default Values, Using == to compare arrays, Null values in object arrays, Confusing .length vs .length()",
            "Array",
            "Sort, BinarySearch, Fill, ToString, Equals, CopyOf, HashCode",
            "String",
            "CharAt, Lenght, subtring, tolowercase, touppercase, trim, equals, equalsignorecase, startswith, endswith, contains",
            "Method",
            "Method",
            "Pre-defined methods, user-defined methods",
            "Void method",
            "Method with return value",
            "Method Overloading",
            "Method Overriding",
            "Sort", "binarySearch", "fill", "toString", "equals", "copyOf", "hashCode",
            "charAt", "length", "substring", "toLowerCase", "toUpperCase", "trim", "equals", "equalIgnoreCase", "startsWith", "endsWith", "contains" 
            
        };

        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        String useranswer;
        int correct = 0;
        System.out.printf("\n\nThis is %d and %d\n", questions.length, answers.length);
        for (int i = questions.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            String temp = questions[i];
            questions[i] = questions[j];
            questions[j] = temp;
            temp = answers[i];
            answers[i] = answers[j];
            answers[j] = temp;
        }

        for (int i = 0; i < questions.length; i++){
            System.out.println(questions[i]);
            System.out.print("Answer: ");
            useranswer = scanner.nextLine();
            if (answers[i].equalsIgnoreCase(useranswer)) {
                System.out.println("Correct!\n");
                correct++;
            } else {
                System.out.println("Wrong! The answer is "+ answers[i]);
                System.out.print("\n");
            }
        }
        System.out.printf("\n\nYou have gotten %d out of %d.", correct, answers.length);
        scanner.close();
    }
}
