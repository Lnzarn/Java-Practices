import java.util.Random;
import java.util.Scanner;

public class QuizDSA1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("List or Stack (1 or 2)? >");
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
            "This a number of connected items or names written or printed consecutively, typically one below the other.",
            "This an abstract concept denoting an indexed collection of entities with a fixed length which is either an array or linked list of any sort.",
            "This allows data to be linked to each other and handled in one lump.",
            "This is list of self-referential class objects.",
            "What is the pointer of the last node set to?",
            "What are the sections each node or cell of a list consist of?",
            "Data elements of the same type is sequentially lined up. List or Array?",
            "Allows data element to be inserted or deleted easily. List or Array",
            "Logical arrangement does not need to match the physical arrangement. List or Array?",
            "Requires local arrangement is the same with th physical arrangement of elements stored in a main memory unit. List or Array?",
            "This points to an object of type node, referred to as a link.",
            "This allocation obtains and releases memory during execution.",
            "This takes number of bytes to allocate, and returns pointer of type void.",
            "This deallocates memory allocated by malloc, takes a pointer as an argument.",
            "This is also called one-way list or singly-linked list.",
            "This is also called doubly-linked list, 2 pointer sections.",
            "This is also called circular list, a bi-directional list that contains null in the first cell.",
            "This is needed to track pointer one by one from the top one if one wishes to access specific data."
        };
        String[] answers = {
            "List", "Linked List", "Linked List", "Nodes", "Null", "Data and Pointer", "Array", "List",
            "List", "Array", "nextPtr", "Dynamic memory allocation", "malloc", "free", "Uni-directional List",
            "Bi-directional List", "Ring List", "Drawback"
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
            "This is a list in which all insertions and deletions are made at one end, called the top. Follows LIFO.",
            "What does LIFO mean?",
            "This operation creates an empty stack",
            "This operation pushes an item on the stack",
            "This operation removes the first item from the stack",
            "This operation returns the firs titem from the stack w/o removing it",
            "This operation return true if the stack is empty",
            "This is some sort of data together with a set of functions (interface) that operate on the data.",
            "This data type has its implementation details are 'hidden' from user, and access is only allowed through interface."
        };
        String[] answers = {
          "Stack", "Last In First Out", "InitStack", "Push", "Pop", "Top", "isEmpty", "Abstract", "Abstract" 
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
}
