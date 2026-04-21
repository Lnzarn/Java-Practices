import java.util.*;

public class ExamIM {

    // -------------------------------------------------------------------------
    // Acceptable-answers map: primary answer -> list of all accepted forms
    // Keys are lowercase trimmed. Values include all synonyms / alternate
    // phrasings.
    private static final Map<String, List<String>> SYNONYMS = new LinkedHashMap<>();
    static {
        // Questions whose "answer" column contains a comma-separated list often have
        // many acceptable phrasings. Add extra aliases here as needed.
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
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("       OOP Quiz 2 - Database Concepts     ");
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
                "This is defined as facts, text, graphics, images, sound, and video segments.",
                "This refers to data that has been processed to be useful in decision making and is actionable.",
                "This is a central repository of shared data that is stored in a standardized, convenient form.",
                "This is the software for managing the database - a collection of programs that enables users to create and maintain a database.",
                "This is the descriptions of the properties or characteristics of the data.",
                "This is a person, place, object, event, or concept in the user environment which the organization wishes to maintain data.",
                "A property or characteristic of an entity type.",
                "This stores data for each individual application separately, leading to isolated and decentralized files.",
                "This logically stores data centrally, managed by a DBMS.",
                "This era of database evolution is characterized by experimental proof-of-concept models. (Decade)",
                "This era of database evolution is about the Hierarchical Model, organized in a tree-like structure with one-to-many relationships. (Years)",
                "This era of database evolution is about the Network Model, which permits many-to-many relationships. (Years)",
                "This era of database evolution is about the Relational Model, where relationships between entities are represented by common fields called a relation. (Years)",
                "This era of database evolution is about OOP, where information is represented by objects. (Years)",
                "This era of database evolution is about Object-Relational models, providing a middle ground between relational and OOP. (Years)",
                "This era of database evolution is about NoSQL - non-relational - a new generation addressing the challenges of big data. (Years)",
                "Iterate the phases of the System Development Life Cycle (SDLC) in order.",
                "The purpose of this SDLC phase is to develop a preliminary understanding of a business situation and determine how information systems can solve problems.",
                "This SDLC phase involves identifying and defining the requirements of the system.",
                "This SDLC phase is to elicit and structure all information requirements and develop technology and organization specifications.",
                "This SDLC phase is to write programs, build data files, test and install the system, train users, and finalize documentation.",
                "This SDLC phase is to monitor the system's operation and usefulness, repair errors, and provide enhancements.",
                "Iterate the objectives of the Planning phase in order.",
                "Iterate the objectives of the Analysis phase in order.",
                "Iterate the objectives of the Design phase in order.",
                "Iterate the objectives of the Implementation phase in order.",
                "Iterate the objectives of the Maintenance phase in order.",
                "This is a model that represents data in the form of two-dimensional tables.",
                "This is a named table consisting of columns and an arbitrary number of unnamed rows.",
                "This is a named column within a relation.",
                "This is a row within a relation that contains data.",
                "This attribute classification means the attribute must have a value.",
                "This attribute classification means the attribute may be null.",
                "This attribute classification means the attribute cannot be broken down further.",
                "This attribute classification means the attribute has meaningful component parts.",
                "This attribute classification means the attribute has only one value.",
                "This attribute classification means the attribute may take on more than one value.",
                "This attribute classification means values are provided by the user.",
                "This attribute classification means values are computed from other attributes.",
                "This is an attribute or combination of attributes that uniquely identifies each row in a relation.",
                "This is a primary key consisting of more than one attribute.",
                "This is an attribute used to establish a relationship between tables by pointing to the primary key of another relation.",
                "This is a set of allowable values assigned to an attribute, defined by datatype, size, and meaning.",
                "This ensures every relation has a valid, non-null primary key.",
                "This maintains consistency by ensuring foreign key values either match a primary key in another table or are null.",
                "This is a technique for producing a set of relations with desirable properties by efficiently organizing data and removing redundancy.",
                "This describes a relationship where attribute B is functionally dependent on A if each value of A is associated with exactly one value of B.",
                "Iterate the modification anomalies.",
                "Iterate the three normal forms.",
                "This is a detailed, logical representation of the data for an organization.",
                "In ER modeling, this is a person, place, object, event, or concept the organization wishes to maintain data about.",
                "In ER modeling, this is a single occurrence of an entity type.",
                "In ER modeling, this is a property or characteristic of an entity type.",
                "In ER modeling, this is an association representing an interaction among entity types.",
                "This is an entity type that exists independently of other entity types and possesses its own unique identifier.",
                "This is an entity type whose existence depends on some other entity type and does not have a unique identifier of its own.",
                "This is a relationship represented as an entity type, typically when all participating relations are 'many' and the entity has independent meaning or extra attributes.",
                "This is an attribute that has meaningful component parts, such as a name broken down into first, middle, and last names.",
                "This is an attribute that may take on more than one value for a single entity instance.",
                "This is the number of entity types that participate in a relationship.",
                "This specifies the number of instances of an entity type that can be associated with instances of another entity type.",
                "This is the minimum number of instances of entity B that may be associated with each instance of entity A.",
                "This is the maximum number of instances of entity B that may be associated with each instance of entity A.",
                "itirate the disadvantages of traditional file processing",
                "itirate the advantages of database approach",
                "what are some agile software development"
            };

        String[] answers = {
                "data",
                "information",
                "database",
                "database management system",
                "metadata",
                "entity",
                "attribute",
                "traditional file processing",
                "database approach",
                "1960s",
                "1970-1990",
                "1970-1990",
                "1980-present",
                "1990-present",
                "1990-present",
                "early 2000s-present",
                "planning, analysis, design, implementation, maintenance",
                "planning",
                "analysis",
                "design",
                "implementation",
                "maintenance",
                "enterprise modeling, justification, scope indentification, requirements analysis",
                "preliminary modeling, enterprise comparison, detailed modeling, consistency check, repository population",
                "logical database design, physical database design and definition",
                "coding and testing, documentation, installation",
                "performance monitoring, optimization, correction and recovery",
                "relational data model",
                "relation",
                "attribute",
                "record",
                "required",
                "optional",
                "simple",
                "composite",
                "singlevalued",
                "multivalued",
                "stored",
                "derived",
                "primary key",
                "composite key",
                "foreign key",
                "domain constraints",
                "entity integrity",
                "referential integrity",
                "database normalization",
                "functional dependency",
                "insertion, update, deletion",
                "1nf, 2nf, 3nf",
                "entity-relationship model",
                "entity",
                "entity instance",
                "attribute",
                "relationship",
                "strong entity",
                "weak entity",
                "associative entity",
                "composite attribute",
                "multivalued attribute",
                "degree",
                "cardinality",
                "minimum cardinality",
                "maximum cardinality",
                "data redundancy, limited data sharing, program-data dependence",
                "program-data independence, planned data redundancy, improved data sharing, enforcement of standards, improved data quality, better data accessibility",
                "scrum, kanban, lean, xp",
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
                dupeIndices.add(i + 1); // 1-based for display
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
        // Store missed items as {question, answer} string pairs - captured immediately
        // so they are immune to any later array mutation or index confusion.
        List<String[]> missed = new ArrayList<>();

        System.out.printf("Starting quiz - %d questions total.%n%n", questions.length);

        for (int i = 0; i < questions.length; i++) {
            System.out.printf("-- Question %d / %d ------------------------------------------%n", i + 1,
                    questions.length);
            System.out.println(questions[i]);

            final String correctAnswer = answers[i]; // capture before any loop interference
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

        // Check synonym list keyed by the expected answer
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