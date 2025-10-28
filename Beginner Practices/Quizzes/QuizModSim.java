import java.util.Random;
import java.util.Scanner;

public class QuizModSim{
    public static void main(String[] args){
        System.out.println("Welcome to the Quiz for Modeling and Simulator!\n");
        quiz1();
        }

    public static void quiz1(){
        String[] questions = {
            // Topic 1 - Intro to Model and Simulation
            "Simplified version of a system that imitates its structures behavior and relationships. Used to predict outcomes or study effects of changes.",
            "How can a model be developed using Mathematical Methods?",
            "How can a model be developed using Numerical computer-based simulation?",
            "What are the processes in designing a model? Enumerate them, there are 6 steps.",
            "It is the process of using a model to study the performance of a system, real or hypothetical. It is an act of using a model for simulation.",
            "What is the procedure in conducting a simulation study? Enumerate them, there are 12 steps.",

            // Topic 2 - History of Simulation
            "Monte Carlo Method was developed by John von Neumann, Stanislaw Ulam, Edward Teller, and Herman Khan as part of the Manhattan Project to study neutron behavior. What decade did this happen?",
            "Simulation was costly and time-consuming, relying on early analog and digital computers. What decade did this happen?",
            "GPSS (General Purpose Simulation System). Who made this invention?",
            "SIMSCRIPT(Rand Corporation). Who made this invention?",
            "CSL (Control and Simulation Language) by J. Buxton and J. Laski (England). Who made this invention?",
            "SIMULA (early version). Who made this invention?",
            "Art of Simulation. What decade did this happen?",
            "Development of PC-based software, graphical user interfaces (GUI), and object-oriented programming (OOP). What decades did this happen?",
            "IBM ceased support for GPSS around 1972, creating a market for alternatives on newer machines (VAX & UNIX). What decade did this happen?",
            "Alan Pritsker and David Pegden created SLAM (Simulation Language for Alternative Modeling). What year did this happen?",
            "Dennis Pegden developed SIMAN (SIMulation ANalysis). What year did this happen?",
            "PCs became dominant over mainframes due to cost, memory limitations, and constraints. What decade did this happen?",
            "SIMAN introduced the CINEMA animation package (an add-on). What decade did this happen?",
            "SLAM responded with a PC version of SLAM that also included animation. What decade did this happen?",

            // Topic 3 - Kinds of System
            "State changes at specific times (events). What type of system is this?",
            "State variables change continuously over time. What type of system is this?",
            "Contains random variables creating unpredictable outcomes. What type of system is this?",
            "Predictable outcomes without randomness. What type of system is this?",
            "No change over time. They are fixed by design. What type of system is this?",
            "Change with time and input to be useful. What type of system is this?",
            "Tangible or the material entities. Visible and countable. What type of system is this?",
            "Conceptual or non-physical entities. May be formulas or relationships among models. What type of system is this?",
            "Output depends upon present and past inputs. What type of system is this?",
            "Depends on the future input to produce an output. What type of system is this?",
            "Follow the superposition and homogenous principle. They have one operating point at a time. What type of system is this?",
            "Multiple operating point with indefinite response. Depends upon both real time output and the input. What type of system is this?",
            "Objects that move through the system (e.g., customers, products). What do you call these?",
            "Waiting lines where entities pause for service (FIFO, LIFO, etc). What do you call these?",
            "Facilities or workers that process entities (idle or busy states). What do you call these?",
            "Total amount of time an entity spends in the system (arrival-departure). What is this?",
            "Time spent waiting in the queue before being processed. What is this?",
            "Expected number of entities waiting in the queue over time. What is this?",
            "Ratio of busy time to total available time for resources. What is this?",

            // Topic 4 - System Definitions
            "An object or collection of objects (entities) that act and interact together toward the accomplishment of some logical end. What is this?",
            "Systems that are part of nature; not man-made. What type of system is this?",
            "Systems that are manufactured by man. What type of system is this?",
            "State changes only occur at specific points in time (events). What type of system is this?",
            "State variables change continuously over time. What type of system is this?",
            "An object of interest in the system. What is this?",
            "A property of an entity. What is this?",
            "A time period of specified length. What is this?",
            "A collection of variables that describe the system at any time. What is this?",
            "An instantaneous occurrence that might change the state. What is this?",
            "Activities and events occurring within the system. What is this?",
            "Activities and events occurring within the environment; not controlled by the system. What is this?",
            "The system's state or behavior can be measured or monitored. What is this?",
            "The system's behavior can be influenced through its inputs. What is this?",

            // Topic 5 - Models
            "Tangible representations built to mimic properties and test structure/design before implementation. What model is this?",
            "Use mathematical notions to portray reality. Show relationships among system variables using equations. What model is this?",
            "Models based on physical and mathematical foundations processed using high-level tools to construct virtual prototypes. What model is this?",
            "A combination of all classes (Physical, Mathematical, Simulation) to represent an entire system and its operations. What model is this?",
            "Derived from statikos (equilibrium). Do not include time as a factor; represent systems at steady-state. What model is this?",
            "Derived from dynamis (force/power). Includes time; simulates time-dependent system behavior. What model is this?",
            "Variable values evolve continuously over time. What type of model is this?",
            "Variable values change only at discrete points in time. What type of model is this?",
            "Output is completely determined by the inputs; contains no randomness. What type of model is this?",
            "Uses statistics or probability methods; contains random variables. Outcomes vary with each run. What type of model is this?",
            "Represented by arbitrary functions and equations; focus on the relationship among variables. What model is this?",
            "Use functional blocks connected by input/output relationships. Focus on logical function. What model is this?",
            "What are the three key characteristics of Discrete Event Simulation (DES)? Enumerate them, there are 3.",
            "Model development is typically an iterative process that progresses through three levels. What are these three levels?",
            "Following model development stages, what are the two critical steps afterward?",

            // Topic 6 - Problem Types
            "A clear description of an issue or issues. It is the crucial first step in the problem formulation process. What is this?",
            "Known are knowns (Simple and clear). Solutions are evident; best practices exist. What type of problem is this?",
            "Known are unknowns (Requires expertise). What type of problem is this?",
            "Unknown are unknowns (Difficult to define). Cause-effect is only known in retrospect. What type of problem is this?",
            "Unknown are unknowable (Out of control). Requires immediate response to establish order/stability. What type of problem is this?",
            "Anything outside the four types (Ignored, 'always done that way'). Existing problems no one is solving. What type of problem is this?"
        };

        String[] answers = {
            // Topic 1
            "Model",
            "Mathematical Methods",
            "Numerical computer-based simulation",
            "Start at the end, Problem orientation, Model simple, think complicated, Start small and add, Avoid mega models, Let the model decide the input",
            "Simulation",
            "Problem Formulation, Set Objectives & Project Plan, Model Conceptualization, Data Collection, Model Translation, Verification, Validation, Experimental Design, Production & Analysis, More Runs?, Documentation & Reporting, Implementation",

            // Topic 2
            "1940s",
            "1950s",
            "Geoffrey Gordon",
            "Harry Markowitz, Bernard Hausner, and Herbert Karr",
            "J. Buxton and J. Laski",
            "O. Dahl, K. Nygaard, Don Knuth, and J. McNeley",
            "1960s",
            "1970s to 1980s",
            "1970s",
            "1979",
            "1983",
            "1980s",
            "1980s",
            "Late 1980s",

            // Topic 3
            "Discrete System",
            "Continuous System",
            "Stochastic System",
            "Deterministic System",
            "Static System",
            "Dynamic System",
            "Physical System",
            "Abstract System",
            "Casual System",
            "Non-Casual System",
            "Linear System",
            "Non-Linear System",
            "Entities",
            "Queues",
            "Resources",
            "System Time",
            "Queue Time",
            "Time-Average Number in Queue",
            "Utilization",

            // Topic 4
            "System",
            "Natural Systems",
            "Artificial Systems",
            "Discrete System",
            "Continuous System",
            "Entity",
            "Attribute",
            "Activity",
            "State",
            "Event",
            "Endogenous",
            "Exogenous",
            "Observable",
            "Controllable",

            // Topic 5
            "Conceptual/Physical Models",
            "Abstract/Mathematical Models",
            "Simulation Models",
            "Heterogeneous Models",
            "Static Model",
            "Dynamic Model",
            "Continuous Time Model",
            "Discrete Time Model",
            "Deterministic Model",
            "Stochastic Model",
            "Equation Oriented Models",
            "Block Oriented Models",
            "Stochastic, Dynamic, Discrete-Event",
            "Conceptual, Specification, Computational",
            "Verification and Validation",

            // Topic 6
            "Problem Statement",
            "Obvious",
            "Complicated",
            "Complex",
            "Chaotic",
            "Disorder"
        };

        System.out.printf("There are %d questions and %d answers in this.\n", questions.length, answers.length);
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
            System.out.println("No." + (i+1) + "\n" + questions[i]);
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
