import java.util.Random;
import java.util.Scanner;

public class QuizOOP2 {
    public static void main(String[] args){
        System.out.println("You will now be taking Quiz 2 of OOP:\n");
        quiz1();
        
    }
    public static void quiz1(){
        String[] questions = {
            "This is a programming paradigm that organizes software design around objects rather than functions and logic.",
            "This is a self-contained united that contains both data (attributes) and behaviours (methods).",
            "This approach models real-world entities and their interactions, making it easier to design, understand, and maintain complex system.",
            "This emphasizes modularity, reusability, and scalability. particularly large and complex programs.",
            "This is a blueprint or template for creating objects. It defines the structure (attributes) and behavior (methods) that its objects will have.",
            "This is an instance of a class. Each object has its own state (values of attributes) and can perform actions through methods.",
            "Try to give the Concepts of Object Oriented Programming",
            "This is a mechanism where one class (child/subclass) can acquire properties and behaviors from another class(parent/superclass)",
            "This concept promotes code reuse and establishes a hierarchy",
            "This type of inheritance occurs when a child class inherits from only one parent class. This can use the parent's attributes and methods",
            "This type of inheritance occurs when a class is derived from a child class, creating a chain of inheritance. In other words, a class acts as both child and parent.",
            "This type of inheritance occurs when multiple classes inherit from the same parent class. Each child gets the properties of the parents but the children are independent.",
            "This type of inheritance occurs when a child class inherits from more than one parent class. This means the subclass can access attributes and methods from multiple superclasses.",
            "This is the OOP principle of wrapping data (variables) and methods (functions) together into a single unit (class), while restricting direct access to some components.",
            "This concept is often described as data hiding and data protection. With the goal of control access to fields and methods.",
            "This type of encapsulation refers to wrapping variables and methods into a class",
            "This type of encapsulation refers to hiding the internal details of methods and exposing only what's necessary",
            "This access modifier is accessible only within the same class",
            "This access modifier is accessible within the same package and by subclasses.",
            "This access modifier is accessible everywhere",
            "This access modifier is accessible only within the same package",
            "This is encapsulation with getters and setters where variables ensure that no outside class can directly change or misuse the data.",
            "This is encapsulation with getters and setters where public methods that allow you to read values of a private variable",
            "This is encapsulation with getters and setters where public methods that allow you to modify the value of private variables",
            "This comes from the greek words many and forms. It means one entity can take many forms depending on context.",
            "This allows the same method name or same interface to behave differently based on the object that is calling it.",
            "This type of polymorphism means the decision about which method to call is made at compile time.",
            "This is when multiple methods ahve the same name but different parameter lists (different number, type, or order of arguments). Called based on method signature.",
            "This type of polymorphism means the decision about which method to call is made at runtime.",
            "This is when a subclass provides its own version of a method that is already defined in the parent class. The method in the child class must ahve the same name, return type, and parameter.",
            "This is the process of hiding implementation details and showing only the essential features of an object.",
            "How can abstraction be achieved in java?"

        };
        String[] answers = {
           "Object Oriented Programming",
           "Object",
           "Object Oriented Programming",
           "Object Oriented Programming",
           "Class",
           "Object",
           "Inheritance, Encapsulation, Polymorphism, Abstraction",
           "Inheritance",
           "Inheritance",
           "Basic Inheritance",
           "Multilevel Inheritance",
           "Hierarchical Inheritance",
           "Multiple Inheritance",
           "Encapsulation",
           "Encapsulation",
           "Data Encapsulation",
           "Method Encapsulation",
           "Private",
           "Protected",
           "Public",
           "Default",
           "Private",
           "Getters",
           "Setters",
           "Polymorphism",
           "Polymorphism",
           "Compile-Time Polymorphism",
           "Method Overloading",
           "Run-Time Polymorphism",
           "Method Overriding",
           "Abstraction",
           "Abstract classes, Interfaces"
        };
        System.out.println("There are " + questions.length + " questions:\n");
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
}
