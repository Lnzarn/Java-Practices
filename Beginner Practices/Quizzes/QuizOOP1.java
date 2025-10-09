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
            "This is the process of creating a set of instructions that a computer can execute to perform specific tasks.",
            "This is style or way of thinking about programming. It provides a structured approach to writing software based on certain principles and methodologies.",
            "Give the Different PRogramming Paradigms:", "Why do we need to study programming?", 
            "This is a programming paradigm centered around concepts of objects.",
            "Give me the key concepts of OOP:",
            "Give me the programming languages for OOP:",
            "This is where you java program always starts. It begins with this keyword.",
            "This is an access modifier. Access modifiers are keywords that can be used to control the visibility of fields, methods, and constructors.",
            "Give me the access modifiers:",
            "This is the keyword to identify that this line of code is a class declaration.",
            "This is where the program starts its execution or simple entry point of Java programs",
            "This is used when there is no object instance for the class.",
            "These are nouns of a programming language that is, they are entities (values and data) that act or are acted upon.",
            "This refers to the type of value a variable has and what type of mathematical, relational, or logical operations can be applied",
            "Try to give me the rules for variable names:",
            "Give me the naming conventions in Java:",
            "Naming convention for variables and methods.",
            "Naming convention for classes, interfaces, annotations, enums, records",
            "Naming convention for constants.",
            "Naming convention for packages and property files.",
            "Naming convention not recommended.",
            "Give me the data types:",
            "The process of converting the value of one data type to another data type.",
            "Give me the two types of type casting:",
            "Give me the operators:",
            "This is a java class to read text from an input stream by vuffering characteristics that seamlessly reads characters, arrays, or lines.",
            "This is used to get user input of the primitive types",
            "This provices your programs to selectively execute other statements based on criteria",
            "This conditionally performs statements based on some expression"
        };
        String[] answers = {
            "Programming", "Programming Paradigm", "Imperative, Procedural, Object Oriented, Functional, Logical, Declarative", 
            "Develops problem-solving skills, understanding software and technology", "Object Oriented Programming", 
            "Objects, Classes, Encapsulation, Abstraction, Inheritance, Polymorphism", "Java, C++, Python, Ruby, C#",
            "Class",
            "Public",
            "Public, Protected, Default, Private",
            "Class",
            "Main",
            "Static",
            "Variables",
            "Data Type",
            "Not keyword, or boolean, no same name in same scope, lowercase then uppercase",
            "Lower Camel, Upper Camel, Screaming Snake, Lower dot, Kebab",
            "Lower Camel",
            "Upper Camel",
            "Screaming Snake",
            "Lower Dot",
            "Kebab",
            "Byte, Short, Int, Long, Float, Double, Boolean, Char",
            "Type Casting",
            "Widening Type, Narrowing Type",
            "Arithmetic, Unary, Increment and Decrement, Relational, Conditional",
            "BufferedReader",
            "Scanner",
            "If-Else",
            "Switch"
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
