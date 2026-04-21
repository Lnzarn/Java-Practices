import java.util.*;

public class ExamDAA {

    // -------------------------------------------------------------------------
    // Acceptable-answers map: primary answer -> list of all accepted forms
    private static final Map<String, List<String>> SYNONYMS = new LinkedHashMap<>();
    static {
        SYNONYMS.put("planning, analysis, design, implementation, maintenance",
                List.of("planning analysis design implementation maintenance",
                        "planning, analysis, design, implementation, maintenance"));
        SYNONYMS.put("insertion, update, deletion",
                List.of("insertion update deletion", "insertion, update, deletion",
                        "update, insertion, deletion", "deletion, update, insertion"));
        SYNONYMS.put("1nf, 2nf, 3nf",
                List.of("1nf 2nf 3nf", "1nf, 2nf, 3nf", "first second third normal form"));
        SYNONYMS.put("enterprise modeling, justification, scope indentification, requirements analysis",
                List.of("enterprise modeling justification scope identification requirements analysis",
                        "enterprise modeling, justification, scope identification, requirements analysis"));
        SYNONYMS.put(
                "preliminary modeling, enterprise comparison, detailed modeling, consistency check, repository population",
                List.of("preliminary modeling enterprise comparison detailed modeling consistency check repository population"));
        SYNONYMS.put("logical database design, physical databasse design and definition",
                List.of("logical database design physical database design and definition",
                        "logical database design, physical database design and definition"));
        SYNONYMS.put("coding and testing, documentation, installation",
                List.of("coding and testing documentation installation",
                        "coding and testing, documentation, installation"));
        SYNONYMS.put("performance monitoring, optimization, correction and recovery",
                List.of("performance monitoring optimization correction and recovery",
                        "performance monitoring, optimization, correction and recovery"));
        SYNONYMS.put("database management system",
                List.of("database management system", "dbms"));
        SYNONYMS.put("traditional file procession",
                List.of("traditional file procession", "traditional file processing"));
    }

    // -------------------------------------------------------------------------
    // All questions and answers as constants so we can always reset to full set
    private static final String[] ALL_QUESTIONS = {
           "This is a sequence of unambiguous steps used to solve a problem.",
            "This ensures that an algorithm finishes in a finite amount of time.",
            "This ensures that every step of an algorithm is clearly defined.",
            "This refers to the data given to an algorithm.",
            "This refers to the result produced by an algorithm.",
            "This refers to the study of algorithm efficiency.",
            "This refers to solving a problem exactly.",
            "This refers to solving a problem approximately.",
            "This is a general approach used to design algorithms.",
            "This method uses a mix of natural language and programming constructs.",
            "This method represents an algorithm using diagrams and symbols.",
            "This ensures that an algorithm produces the correct result.",
            "This measures how fast an algorithm runs.",
            "This measures how much memory an algorithm uses.",
            "This is the final implementation of an algorithm in a programming language.",
            "This refers to rearranging data in order.",
            "This refers to finding a specific value in a dataset.",
            "This deals with processing and analyzing strings.",
            "This deals with nodes and edges in structures.",
            "This involves finding arrangements that satisfy constraints.",
            "This deals with geometric objects like points and lines.",
            "This involves solving mathematical computations and equations.",
            "This is the study of computers, algorithms, and information processing.",
            "This is the study of numbers, structure, and patterns.",
            "This is a logical argument proving a statement is true.",
            "This is the study of reasoning and valid arguments.",
            "This proof method starts from known facts to reach a conclusion.",
            "This proof method proves a base case and then proves for n+1.",
            "This proof method assumes the opposite and finds a contradiction.",
            "This defines a sequence using previous terms.",
            "This method solves recurrence by guessing and verifying.",
            "This method solves recurrence by expanding step-by-step.",
            "This method solves recurrence using a tree structure.",
            "Iterate the criteria of a good algorithm.",
            "Iterate common algorithm design techniques.",
            "Iterate the steps in algorithm design process.",
            "Iterate important problem types.",
            "Iterate proof techniques.",
            "Iterate methods for solving recurrence relations.",
            "This measures the time and space required by an algorithm based on input size.",
            "This factor refers to the size of the input affecting running time.",
            "This refers to how fast an algorithm executes.",
            "This refers to the amount of memory used by an algorithm.",
            "This describes the slowest possible execution of an algorithm.",
            "This describes the fastest possible execution of an algorithm.",
            "This describes the expected runtime over all inputs.",
            "This notation represents the upper bound of an algorithm.",
            "This notation represents the lower bound of an algorithm.",
            "This notation represents a tight bound of an algorithm.",
            "This notation represents a non-tight upper bound.",
            "This notation represents a non-tight lower bound.",
            "This is a straightforward approach that tries all possibilities.",
            "This sorting algorithm repeatedly selects the minimum element.",
            "This sorting algorithm compares adjacent elements and swaps them.",
            "This search algorithm checks elements one by one.",
            "This string matching technique compares pattern characters sequentially.",
            "This is another term for brute-force search.",
            "This problem finds the shortest route visiting all cities once.",
            "This problem maximizes value within a weight constraint.",
            "This problem assigns tasks to resources minimizing cost or time.",
    };

    private static final String[] ALL_ANSWERS = {
           "algorithm",
            "finiteness",
            "definiteness",
            "input",
            "output",
            "algorithm analysis",
            "exact problem solving",
            "approximate problem solving",
            "algorithm design technique",
            "pseudocode",
            "flowchart",
            "correctness",
            "time complexity",
            "space complexity",
            "coding",
            "sorting",
            "searching",
            "string processing",
            "graph problems",
            "combinatorial problems",
            "geometric problems",
            "numerical problems",
            "computer science",
            "mathematics",
            "proof",
            "logic",
            "direct proof",
            "proof by induction",
            "proof by contradiction",
            "recurrence relation",
            "substitution method",
            "iteration method",
            "recursion tree method",
            "input, output, finiteness, definiteness, effectiveness",
            "brute force, greedy, divide and conquer, dynamic programming, backtracking, linear programming",
            "understand the problem, ascertain capabilities, choose exact or approximate, select data structure, choose design technique, prove correctness, analyze, coding",
            "sorting, searching, string processing, graph problems, combinatorial, geometric, numerical",
            "direct proof, proof by induction, proof by contradiction",
            "substitution method, iteration method, recursion tree method",
            "complexity",
            "problem size",
            "time complexity",
            "space complexity",
            "worst case",
            "best case",
            "average case",
            "big-o notation",
            "omega notation",
            "theta notation",
            "small-o notation",
            "small-omega notation",
            "brute force",
            "selection sort",
            "bubble sort",
            "sequential search",
            "brute force string matching",
            "exhaustive search",
            "travelling salesman problem",
            "knapsack problem",
            "assignment problem",
    };

    // -------------------------------------------------------------------------
    public static void main(String[] args) {
        // Integrity check at startup
        if (ALL_QUESTIONS.length != ALL_ANSWERS.length) {
            System.err.printf("[ERROR] Mismatch: %d questions but %d answers. Fix before running.%n",
                    ALL_QUESTIONS.length, ALL_ANSWERS.length);
            return;
        }

        System.out.println("==========================================");
        System.out.println("       DAA Quiz - Algorithm Concepts     ");
        System.out.println("==========================================\n");
        System.out.println("Commands available during the quiz:");
        System.out.println("  'hint' -> reveal the first letter of the answer");
        System.out.println("  'skip' -> skip this question (counts as wrong)\n");

        Scanner scanner = new Scanner(System.in);

        // Outer loop: let the user start a full new session repeatedly
        boolean startNewSession;
        do {
            startNewSession = runSession(scanner);
        } while (startNewSession);

        System.out.println("\nThanks for studying! Good luck on your exam!");
        scanner.close();
    }

    // -------------------------------------------------------------------------
    /**
     * Runs one full quiz session (all questions + wrong-answer retry loop).
     * Returns true if the user wants to start a brand-new session afterward.
     */
    private static boolean runSession(Scanner scanner) {

        // Build working copies from the master arrays so we never mutate the originals
        List<String> questions = new ArrayList<>(Arrays.asList(ALL_QUESTIONS));
        List<String> answers   = new ArrayList<>(Arrays.asList(ALL_ANSWERS));

        // Shuffle initial order
        shufflePairs(questions, answers);

        System.out.printf("Starting quiz - %d questions total.%n%n", questions.size());

        int iteration = 0; // counts how many rounds we've done (including first)

        // ── First full round ────────────────────────────────────────────────
        RoundResult rr;
        iteration++;
        rr = runRound(scanner, questions, answers, iteration);

        // ── Wrong-answer retry loop ──────────────────────────────────────────
        while (!rr.missed.isEmpty()) {
            // Ask whether the user wants to retry wrong answers or start fresh
            System.out.println("You got " + rr.missed.size() + " question(s) wrong.");
            System.out.println("What would you like to do?");
            System.out.println("  [1] Focus on wrong answers only");
            System.out.println("  [2] Restart with ALL questions");
            System.out.println("  [3] End session");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("2")) {
                // Full restart within this session
                questions = new ArrayList<>(Arrays.asList(ALL_QUESTIONS));
                answers   = new ArrayList<>(Arrays.asList(ALL_ANSWERS));
                shufflePairs(questions, answers);
                iteration++;
                System.out.printf("%n--- Restarting with all %d questions (Round %d) ---%n%n",
                        questions.size(), iteration);
                rr = runRound(scanner, questions, answers, iteration);

            } else if (choice.equals("1")) {
                // Focus mode: only the questions that were wrong
                questions = new ArrayList<>();
                answers   = new ArrayList<>();
                for (String[] pair : rr.missed) {
                    questions.add(pair[0]);
                    answers.add(pair[1]);
                }
                shufflePairs(questions, answers);
                iteration++;
                System.out.printf("%n--- Round %d: Focusing on %d wrong question(s) ---%n%n",
                        iteration, questions.size());
                rr = runRound(scanner, questions, answers, iteration);

            } else if (choice.equals("3")) {
                break; // exit the retry loop without completing
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }

        // ── Session summary ──────────────────────────────────────────────────
        if (rr.missed.isEmpty()) {
            System.out.println("============================================");
            System.out.println("   You got everything correct!");
            System.out.printf("  Total rounds taken: %d%n", iteration);
            System.out.println("============================================\n");
        } else {
            System.out.println("============================================");
            System.out.printf("  Session ended after %d round(s).%n", iteration);
            System.out.printf("  %d question(s) were still unanswered correctly.%n",
                    rr.missed.size());
            System.out.println("============================================\n");
        }

        // ── Ask whether to start a brand-new session ─────────────────────────
        System.out.print("Would you like to start a brand-new quiz with ALL questions? (yes / no): ");
        String reply = scanner.nextLine().trim().toLowerCase();
        return reply.equals("yes") || reply.equals("y");
    }

    // -------------------------------------------------------------------------
    /** Holds the result of one quiz round. */
    private static class RoundResult {
        final int correct;
        final int skipped;
        final List<String[]> missed; // {question, answer} pairs

        RoundResult(int correct, int skipped, List<String[]> missed) {
            this.correct = correct;
            this.skipped = skipped;
            this.missed  = missed;
        }
    }

    // -------------------------------------------------------------------------
    /** Runs a single quiz round over the given question/answer lists. */
    private static RoundResult runRound(Scanner scanner,
                                        List<String> questions,
                                        List<String> answers,
                                        int roundNumber) {
        int correct = 0;
        int skipped = 0;
        List<String[]> missed = new ArrayList<>();

        for (int i = 0; i < questions.size(); i++) {
            System.out.printf("-- Round %d | Question %d / %d --------------------------------%n",
                    roundNumber, i + 1, questions.size());
            System.out.println(questions.get(i));

            final String correctAnswer = answers.get(i);
            final String questionText  = questions.get(i);
            boolean answered = false;

            while (!answered) {
                System.out.print("Answer: ");
                String userAnswer = scanner.nextLine().trim();

                if (userAnswer.equalsIgnoreCase("skip")) {
                    System.out.println("[SKIPPED] The answer was: " + correctAnswer + "\n");
                    skipped++;
                    missed.add(new String[]{questionText, correctAnswer});
                    answered = true;

                } else if (userAnswer.equalsIgnoreCase("hint")) {
                    String hint = correctAnswer.trim();
                    System.out.println("[HINT] The answer starts with '" + hint.charAt(0) + "'" +
                            (hint.length() > 1 ? " and has " + hint.length() + " character(s)." : "."));

                } else if (isCorrect(userAnswer, correctAnswer)) {
                    System.out.println("Correct!\n");
                    correct++;
                    answered = true;

                } else {
                    System.out.println("Wrong! The answer is: " + correctAnswer + "\n");
                    missed.add(new String[]{questionText, correctAnswer});
                    answered = true;
                }
            }
        }

        // Round score summary
        int total = questions.size();
        double pct = (double) correct / total * 100.0;
        System.out.println("============================================");
        System.out.printf("  Round %d Score: %d / %d  (%.1f%%)%n", roundNumber, correct, total, pct);
        if (skipped > 0)
            System.out.printf("  Skipped: %d%n", skipped);
        System.out.printf("  Result: %s%n", pct >= 75 ? "PASSED" : "FAILED (passing mark: 75%)");
        System.out.println("============================================\n");

        if (!missed.isEmpty()) {
            System.out.println("Questions you missed this round:");
            for (String[] entry : missed) {
                System.out.println("  - " + entry[0]);
                System.out.println("    Answer: " + entry[1]);
            }
            System.out.println();
        }

        return new RoundResult(correct, skipped, missed);
    }

    // -------------------------------------------------------------------------
    /** Fisher-Yates shuffle on two parallel lists. */
    private static void shufflePairs(List<String> questions, List<String> answers) {
        Random rand = new Random();
        for (int i = questions.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Collections.swap(questions, i, j);
            Collections.swap(answers,   i, j);
        }
    }

    // -------------------------------------------------------------------------
    private static boolean isCorrect(String userAnswer, String expected) {
        String normalUser     = normalize(userAnswer);
        String normalExpected = normalize(expected);

        if (normalUser.equals(normalExpected)) return true;

        List<String> alternatives = SYNONYMS.get(normalExpected);
        if (alternatives != null) {
            for (String alt : alternatives) {
                if (normalUser.equals(normalize(alt))) return true;
            }
        }
        return false;
    }

    private static String normalize(String s) {
        return s.toLowerCase().trim().replaceAll("\\s+", " ");
    }
}