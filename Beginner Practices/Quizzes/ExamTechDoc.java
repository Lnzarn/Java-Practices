import java.util.*;

public class ExamTechDoc {

    // -------------------------------------------------------------------------
    // Acceptable-answers map: primary answer -> list of all accepted forms
    // Keys are lowercase trimmed. Values include all synonyms / alternate
    // phrasings.
    private static final Map<String, List<String>> SYNONYMS = new LinkedHashMap<>();
    static {
        SYNONYMS.put("concrete language, denotative language, objectivity, targeted audience, style, common format",
                List.of("concrete language denotative language objectivity targeted audience style common format",
                        "concrete language, denotative language, objectivity, targeted audience, style, common format"));
        SYNONYMS.put("divide-then-merge",
                List.of("divide then merge", "divide-then-merge"));
        SYNONYMS.put("side-by-side",
                List.of("side by side", "side-by-side"));
    }

    // -------------------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("    Technical Writing Quiz               ");
        System.out.println("==========================================\n");
        System.out.println("Commands available during the quiz:");
        System.out.println("  'hint' -> reveal the first letter of the answer");
        System.out.println("  'skip' -> skip this question (counts as wrong)\n");

        Scanner scanner = new Scanner(System.in);
        boolean playAgain;
        do {
            playAgain = runQuiz(scanner);
        } while (playAgain);

        System.out.println("\nThanks for studying! Good luck on your exam!");
        scanner.close();
    }

    // -------------------------------------------------------------------------
    private static boolean runQuiz(Scanner scanner) {
        String[] questions = {
                "This is a form of writing that explains a subject matter in a factual, straightforward style characterized by scientific vocabulary, graphic aids, conventional report formats, and strict objectivity.",
                "This is the use of dictionary or lexical meaning of a word, as opposed to connotative or emotional meanings, used to avoid ambiguity.",
                "This is an impartial, impersonal, or unemotional weighing of evidence; one of the fundamental characteristics of technical writing.",
                "Iterate the fundamental characteristics of technical writing.",
                "This is a writer's way of expressing thoughts and feelings in language; how a material is written.",
                "This style is plain, brief, and objective.",
                "This refers to unnecessary words or phrases that add length without adding meaning.",
                "This is high-flown or indirect language used to hide or cloud meaning.",
                "This is a verb construction in which the subject performs the action; preferred in technical writing for clarity and directness.",
                "This is the single most important aspect of technical writing; readers need facts, not hazy or imprecise terms.",
                "This principle states that every word counts; it saves time and increases forcefulness.",
                "This is a smooth flow of ideas; achieved by using transitional words.",
                "This involves avoiding sentence fragments, comma splices, and run-on sentences.",
                "This refers to natural word order, simple structure, and fairly short sentences.",
                "This identifies what mechanism or process to explain, experiment results to report, or research to propose.",
                "This is the role the writer assumes when writing.",
                "This involves considering the reader's knowledge level, point of view, relationship, attitude, and cultural influence.",
                "This involves finding a quiet place, choosing your best time of day, writing fast and full, and indicating reference placements.",
                "This involves checking arrangement and content, logic, style, graphics, and document design, then rewriting and rearranging.",
                "This involves checking mechanics, documentation, graphics accuracy, and document design.",
                "This is presenting another's work as your own.",
                "This is implying something untrue without stating it directly.",
                "This is selectively using or distorting data.",
                "This refers to graphs or images that misrepresent information.",
                "This is done when a project requires more than one area of specialization, or is too large or time-sensitive for one person.",
                "This is a writing process involving two or more people who jointly plan, draft, review, and revise a document, often used when a project requires multiple areas of expertise or perspectives.",
                "This is a document written at the start of a collaborative project that spells out the project's goals, anticipated problems, ethical issues, conflict strategies, skills mix, preliminary schedule, project standards, and individual responsibilities.",
                "This is the agreed-upon conventions for a collaborative document, including abbreviations and acronyms to use, formatting rules, handling of confidential information, and legal or policy compliance.",
                "This is when the team plans together, members write sections individually, then review and revise so it reads as one voice.",
                "This is when members write together, make all decisions jointly, then revise together.",
                "This is some combination of both the divide-then-merge and side-by-side approaches.",
                "This collaborative writing stage involves defining purpose, audience, scope, goals, schedule, and standards.",
                "This collaborative writing stage is usually more individual; it fleshes out details and develops ideas.",
                "This collaborative writing stage involves looking at the whole picture, taking the audience's role, and checking for gaps and other problems.",
                "This collaborative writing stage involves accepting criticism, making changes, and trying another way."
        };

        String[] answers = {
                "technical writing",
                "denotative language",
                "objectivity",
                "concrete language, denotative language, objectivity, targeted audience, style, common format",
                "style",
                "technical style",
                "verbal deadwood",
                "euphemism",
                "active voice",
                "clarity",
                "conciseness",
                "coherence",
                "conventions of standard english",
                "sentence structure and length",
                "topic and purpose",
                "persona",
                "audience",
                "rough draft",
                "revision",
                "editing",
                "plagiarism",
                "false implications",
                "manipulating data",
                "misleading visuals",
                "collaborate",
                "collaborative writing",
                "project planning memo",
                "project standard",
                "divide-then-merge",
                "side-by-side",
                "hybrid",
                "planning",
                "research",
                "reviewing",
                "revising"
        };

        // -- Integrity check --------------------------------------------------
        if (questions.length != answers.length) {
            System.err.printf("[WARNING] Mismatch: %d questions but %d answers. Fix the arrays before running.%n",
                    questions.length, answers.length);
            return false;
        }

        // -- Duplicate detection ----------------------------------------------
        Set<String> seen = new LinkedHashSet<>();
        List<Integer> dupeIndices = new ArrayList<>();
        for (int i = 0; i < questions.length; i++) {
            String key = questions[i].trim().toLowerCase();
            if (!seen.add(key)) {
                dupeIndices.add(i + 1);
            }
        }
        if (!dupeIndices.isEmpty()) {
            System.out.println("[NOTE] Duplicate question(s) found at index(es) " + dupeIndices
                    + " - they will still appear (may be intentional for reinforcement).\n");
        }

        // -- Shuffle (Fisher-Yates) -------------------------------------------
        Random rand = new Random();
        for (int i = questions.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            String tmp = questions[i];
            questions[i] = questions[j];
            questions[j] = tmp;
            tmp = answers[i];
            answers[i] = answers[j];
            answers[j] = tmp;
        }

        // -- Quiz loop --------------------------------------------------------
        int correct = 0;
        int skipped = 0;
        List<String[]> missed = new ArrayList<>();

        System.out.printf("Starting quiz - %d questions total.%n%n", questions.length);

        for (int i = 0; i < questions.length; i++) {
            System.out.printf("-- Question %d / %d ------------------------------------------%n", i + 1,
                    questions.length);
            System.out.println(questions[i]);

            final String correctAnswer = answers[i];
            final String questionText = questions[i];
            boolean answered = false;

            while (!answered) {
                System.out.print("Answer: ");
                String userAnswer = scanner.nextLine().trim();

                if (userAnswer.equalsIgnoreCase("skip")) {
                    System.out.println("[SKIPPED] The answer was: " + correctAnswer);
                    System.out.println();
                    skipped++;
                    missed.add(new String[] { questionText, correctAnswer });
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
                    missed.add(new String[] { questionText, correctAnswer });
                    answered = true;
                }
            }
        }

        // -- Results ----------------------------------------------------------
        int total = questions.length;
        double pct = (double) correct / total * 100.0;
        System.out.println("============================================");
        System.out.printf("  Score: %d / %d  (%.1f%%)%n", correct, total, pct);
        if (skipped > 0)
            System.out.printf("  Skipped: %d%n", skipped);
        System.out.printf("  Result: %s%n", pct >= 75 ? "PASSED" : "FAILED (passing mark: 75%)");
        System.out.println("============================================\n");

        if (!missed.isEmpty()) {
            System.out.println("Questions you missed:");
            for (String[] entry : missed) {
                System.out.println("  - " + entry[0]);
                System.out.println("    Answer: " + entry[1]);
            }
            System.out.println();
        }

        System.out.print("Would you like to take the quiz again? (yes / no): ");
        String reply = scanner.nextLine().trim().toLowerCase();
        return reply.equals("yes") || reply.equals("y");
    }

    // -------------------------------------------------------------------------
    /**
     * Checks whether the user's answer matches the expected answer.
     * Matching is case-insensitive, whitespace-trimmed, and synonym-aware.
     */
    private static boolean isCorrect(String userAnswer, String expected) {
        String normalUser = normalize(userAnswer);
        String normalExpected = normalize(expected);

        if (normalUser.equals(normalExpected))
            return true;

        List<String> alternatives = SYNONYMS.get(normalExpected);
        if (alternatives != null) {
            for (String alt : alternatives) {
                if (normalUser.equals(normalize(alt)))
                    return true;
            }
        }
        return false;
    }

    /** Lowercases, trims, and collapses internal whitespace. */
    private static String normalize(String s) {
        return s.toLowerCase().trim().replaceAll("\\s+", " ");
    }
}