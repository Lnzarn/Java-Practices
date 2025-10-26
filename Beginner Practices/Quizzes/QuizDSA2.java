import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class QuizDSA2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.print("Welcome to this Quiz!\n[1] Overview\n[2] Algorithm Analysis\n[3] Arrays\n[4] Linked Lists, Stacks, Queues\n[5] Tree\n[6] Exit\n> ");

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number from 1 to 6.\n");
                scanner.nextLine(); 
                continue; 
            }

            switch (choice) {
                case 1: quiz1(); break;
                case 2: quiz2(); break;
                case 3: quiz3(); break;
                case 4: quiz4(); break;
                case 5: quiz5(); break;
                case 6:
                    System.out.println("Byee!!");
                    break;
                default:
                    System.out.println("Pick a number from 1 to 6.");
            }

        } while (choice != 6);

        scanner.close();
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
            "Abstract Data Types",
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

        System.out.println("This is Overview of DSA! There are " + questions.length + " questions and " + answers.length + " answers!");
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
            // TOPIC 1: Algorithms
            "What do we call a finite sequence of logical steps designed to solve a specific problem?",
            "Which characteristic of a good algorithm ensures it ends after a finite number of steps?",
            "Which characteristic of a good algorithm requires every step to be clear and unambiguous?",
            "Which characteristic states that an algorithm must have zero or more data values to operate on?",
            "Which characteristic requires that an algorithm must produce at least one result?",
            "Which characteristic ensures every step of an algorithm can be executed with available resources within finite time?",
            "What do we call an algorithm that solves a problem using the least possible time and memory resources?",
            "What do we call the process of determining the computational efficiency of an algorithm?",
            "What refers to how effectively an algorithm uses time and memory resources to solve a problem?",
            "What type of efficiency measures how fast an algorithm executes?",
            "What type of efficiency measures how much memory an algorithm uses?",

            // TOPIC 2: Time & Space Complexity
            "What measures how runtime grows as the input size increases?",
            "What complexity case refers to the minimum steps an algorithm may execute?",
            "What complexity case refers to the expected performance for typical inputs?",
            "What complexity case guarantees a performance upper bound with maximum steps?",
            "What measures the total memory required by an algorithm including input and auxiliary space?",

            // TOPIC 3: Big O Notation
            "What notation represents the upper bound or worst-case growth rate of an algorithm?",
            "Which Big O simplification rule states that constant factors should be ignored?",
            "Which simplification rule states to keep only the highest-order term?",
            "In Big O analysis, what do we do with complexities of sequential steps?",
            "In Big O analysis, what do we do with nested loop complexities?",
            "Which complexity class represents constant time?",
            "Which complexity class is logarithmic time?",
            "Which complexity class is linear time?",
            "Which complexity class is linearithmic time?",
            "Which class describes polynomial time?",
            "Which class describes exponential time?",
            "Which class describes factorial time?",
            "What common behavior repeatedly divides input size, such as in binary search?",

            // TOPIC 4: Running Time Analysis
            "What do we call the actual count of operations executed by an algorithm for a given input?",
            "In running time analysis, what step identifies the most repeated key instruction?",
            "In running time analysis, what step determines how many times the operation runs for input size n?",
            "What function do we express the number of operations as in running time analysis?",
            "What mathematical notation is used to simplify T(n) into a complexity class?"
        };

        String[] answers = {
            // TOPIC 1
            "Algorithm",
            "Finiteness",
            "Definiteness",
            "Input",
            "Output",
            "Effectiveness",
            "Efficient Algorithm",
            "Algorithm Analysis",
            "Efficiency",
            "Time Efficiency",
            "Space Efficiency",

            // TOPIC 2
            "Time Complexity",
            "Best Case",
            "Average Case",
            "Worst Case",
            "Space Complexity",

            // TOPIC 3
            "Big O Notation",
            "Ignore constant factors",
            "Keep the highest-order term only",
            "Add",
            "Multiply",
            "O(1)",
            "O(log n)",
            "O(n)",
            "O(n log n)",
            "O(n2), O(n3), Polynomial Time",
            "O(2n)",
            "O(n!)",
            "Logarithmic behavior",

            // TOPIC 4
            "Running Time",
            "Identify the basic operation",
            "Count the repetitions of the basic operation",
            "T(n)",
            "Big O"
        };

        System.out.println("This is Algorithm Analysis! There are " + questions.length + " questions and " + answers.length + " answers!");
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
    public static void quiz3(){
        String[] questions = {
            "What allows arrays to access elements directly using an index?",
            "What is the time complexity for accessing an array element?",
            "What indexing does an array use where the first element is index 0?",
            "Which operation has a worst-case complexity of O(n) because elements need shifting?",
            "Which array operation has the best case O(1) when adding at the end?",
            "What type of search is O(n) in arrays?",
            "What type of search in arrays has O(log n) time complexity?",
            "Which array operation replaces a value at a specific index?",
            "What is the time complexity of updating an element in an array?",
            "Which array operation arranges elements in sorted order?",
            "Name one sorting algorithm used for arrays.",
            "What describes where array elements are stored continuously in memory?",
            "What is the formula to compute the address of an array element?",
            "Which data structure has a fixed size and cannot grow automatically?",
            "Which type of array can automatically resize when full?",
            "In Java, what class represents dynamic arrays?",
            "What happens when a dynamic array reaches capacity?",
            "What is the complexity of accessing a dynamic array element?",
            "What is the complexity of resizing a dynamic array when growing?",
            "What do you call arrays with more than one index?",
            "What is the access time for an element in a multi-dimensional array?",
            "What is the traversal time complexity of a 2D array with nm elements?",
            "Which memory ordering stores 2D arrays row by row (like in C/C++)?",
            "Which operation visits every element of an array exactly once?",
            "Which array operation requires shifting elements to the left after removal?"
        };

        String[] answers = {
            "Random Access",
            "O(1)",
            "Zero-based Indexing",
            "Insertion",
            "Insertion",
            "Linear Search",
            "Binary Search",
            "Updating",
            "O(1)",
            "Sorting",
            "Bubble Sort, Insertion Sort, Merge Sort, Quick Sort (Any one)",
            "Contiguous Memory Allocation",
            "Base Address + (index * Size of element)",
            "Static Array",
            "Dynamic Array",
            "ArrayList",
            "A new bigger array is created and elements are copied",
            "O(1)",
            "O(n)",
            "Multi-dimensional Array",
            "O(1)",
            "O(nm)",
            "Row-major Order",
            "Traversal",
            "Deletion"
        };


        System.out.println("This is Arrays! There are " + questions.length + " questions and " + answers.length + " answers!");
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
     public static void quiz4(){
        String[] questions = {
            "What is the fundamental building block of a linked list?",
            "What are the two main parts of a singly linked list node?",
            "What is the purpose of the pointer in a linked list node?",
            "Why do linked lists support dynamic memory allocation?",
            "What does the head pointer represent in a linked list?",
            "What does it mean when the head pointer is NULL?",
            "What is the time complexity of traversing a linked list?",
            "Which linked list allows traversal only in one direction?",
            "Which linked list has nodes containing prev, data, and next pointers?",
            "What does the last node of a singly circular linked list point to?",
            "Which linked list structure allows backward traversal?",
            "Which operation in a linked list has O(1) time when performed at the beginning?",
            "Which operation usually requires traversal when done in the middle or end of a linked list?",
            "Why is searching in a linked list O(n)?",
            "What does the tail pointer point to in some linked list implementations?",
            "What linear data structure follows the Last In, First Out principle?",
            "In the LIFO principle, which element is removed first?",
            "From which part of the stack do we insert and remove elements?",
            "Which stack operation inserts an element onto the stack?",
            "Which stack operation removes the most recent element?",
            "Which stack operation allows you to see the top element without removing it?",
            "Which operation checks whether the stack contains no elements?",
            "Which operation checks whether the stack has reached its maximum capacity?",
            "What real-life object is commonly used to visualize stack behavior?",
            "What principle ensures the newest element is processed first?",
            "Which linear data structure follows the FIFO principle?",
            "In FIFO, which element is removed first?",
            "Where is data added in a queue?",
            "Where is data removed in a queue?",
            "Which operation adds an element to the rear of the queue?",
            "Which operation removes an element from the front of the queue?",
            "Which operation allows viewing the front element without removing it?",
            "Which check determines if a queue has no elements?",
            "Which check determines if a fixed-size queue has reached capacity?",
            "What type of queue connects the last position back to the first to avoid wasted space?"
        };

        String[] answers = {
            "Node",
            "Data field and pointer to the next node",
            "To store the address/reference of the next node",
            "Because nodes are created and deleted at runtime using dynamic memory allocation",
            "It points to the first node in the list",
            "The list is empty",
            "O(n)",
            "Singly linked list",
            "Doubly linked list",
            "It points back to the head",
            "Doubly linked list",
            "Insertion at the beginning",
            "Insertion or deletion",
            "Because you must visit each node sequentially to find a value",
            "It points to the last node in the list",
            "Stack",
            "The last element inserted",
            "The top of the stack",
            "Push",
            "Pop",
            "Peek or Top",
            "isEmpty",
            "isFull",
            "A stack of plates",
            "LIFO (Last In, First Out)",
            "Queue",
            "The first element inserted",
            "Rear",
            "Front",
            "Enqueue",
            "Dequeue",
            "Peek or Front",
            "isEmpty",
            "isFull",
            "Circular Queue"
        };


        System.out.println("This is Lists, Stacks, Queues! There are " + questions.length + " questions and " + answers.length + " answers!");
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

    public static void quiz5(){
        String[] questions = {
            "What type of data structure is a tree?",
            "What do we call the basic unit in a tree that stores data and links to children?",
            "What is the topmost node of a tree called?",
            "What do you call a node that has children?",
            "What do you call nodes that directly descend from a parent?",
            "What is a node with no children called?",
            "What do we call nodes that share the same parent?",
            "What is the connection between a parent and child node called?",
            "What do we call the sequence of nodes from root to any node?",
            "What is the number of edges from the root to a node called?",
            "What is the longest path from a node down to a leaf referred to as?",
            "What do you call the number of children a node has?",
            "What do we call a smaller portion of a tree including a node and all its descendants?",
            "What refers to a node’s distance from the root in terms of generations?",
            "What type of tree has at most two children per node?",
            "Which binary tree type has every node with either 0 or 2 children?",
            "Which binary tree type has all levels filled except possibly the last, filled left to right?",
            "Which binary tree type has all internal nodes with 2 children and all leaves at the same level?",
            "Which binary tree type has each node with only one child, forming a linear chain?",
            "What do we call the process of visiting all nodes in a tree?",
            "Which traversal goes Root → Left → Right?",
            "Which traversal goes Left → Root → Right and produces sorted order in a BST?",
            "Which traversal goes Left → Right → Root and is useful for deleting trees?",
            "Which traversal visits nodes level by level using a queue?",
            "What type of binary tree maintains the rule: left < root < right?",
            "In BST deletion, what do you replace a node with two children with?"
        };

        String[] answers = {
            "A non-linear hierarchical data structure",
            "Node",
            "Root",
            "Parent node",
            "Child node",
            "Leaf node",
            "Sibling nodes",
            "Edge",
            "Path",
            "Depth",
            "Height",
            "Degree",
            "Subtree",
            "Level",
            "Binary tree",
            "Full binary tree",
            "Complete binary tree",
            "Perfect binary tree",
            "Skewed binary tree",
            "Tree traversal",
            "Preorder traversal",
            "Inorder traversal",
            "Postorder traversal",
            "Breadth-first traversal",
            "Binary Search Tree",
            "Inorder successor"
        };


        System.out.println("This is Trees! There are " + questions.length + " questions and " + answers.length + " answers!");
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
