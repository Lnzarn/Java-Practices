import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class TerminalQuiz {
    private String[] questionsArr = {};
    private String[] answerArr = {};
    private String[] correctAnswers = {};
    private int score = 0;
    private Scanner scanner;

    public TerminalQuiz() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            displayWelcomeMenu();
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                String subject = selectSubject();
                if (subject != null && loadQuizFromFile(subject)) {
                    runQuiz();
                }
            } else if (choice.equals("2")) {
                System.out.println("\nThank you for using the Quiz Application!");
                break;
            } else {
                System.out.println("\nInvalid choice. Please try again.\n");
            }
        }
        scanner.close();
    }

    private void displayWelcomeMenu() {
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║       QUIZ APPLICATION MENU        ║");
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║  1. Start New Quiz                 ║");
        System.out.println("║  2. Exit                           ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.print("\nEnter your choice: ");
    }

    private String selectSubject() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║       SELECT A SUBJECT             ║");
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║  1. DSA                            ║");
        System.out.println("║  2. DS2                            ║");
        System.out.println("║  3. MODSIM                         ║");
        System.out.println("║  4. Cancel                         ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.print("\nEnter your choice: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                return "DSA";
            case "2":
                return "DS2";
            case "3":
                return "MODSIM";
            case "4":
                return null;
            default:
                System.out.println("\nInvalid choice. Returning to main menu.\n");
                return null;
        }
    }

    private boolean loadQuizFromFile(String subject) {
        String filename = subject + ".txt";
        ArrayList<String> questions = new ArrayList<>();
        ArrayList<String> answers = new ArrayList<>();
        ArrayList<String> correct = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;


                questions.add(line);

               
                for (int i = 0; i < 4; i++) {
                    line = br.readLine();
                    if (line != null) {
                        answers.add(line.trim());
                    }
                }

                line = br.readLine();
                if (line != null) {
                    correct.add(line.trim());
                }
            }

            questionsArr = questions.toArray(new String[0]);
            answerArr = answers.toArray(new String[0]);
            correctAnswers = correct.toArray(new String[0]);

    
            if (questionsArr.length > 0) {
                shuffleQuiz();
            }

            System.out.println("\n Successfully loaded " + questionsArr.length + " questions from " + filename + "\n");
            return questionsArr.length > 0;

        } catch (IOException e) {
            System.out.println("\n Error loading quiz file: " + filename);
            System.out.println("  " + e.getMessage() + "\n");
            return false;
        }
    }

    private void shuffleQuiz() {
        Random rand = new Random();
        int numQuestions = questionsArr.length;

        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < numQuestions; i++) {
            indices.add(i);
        }
        Collections.shuffle(indices, rand);

      
        String[] shuffledQuestions = new String[numQuestions];
        String[] shuffledAnswers = new String[numQuestions * 4];
        String[] shuffledCorrect = new String[numQuestions];

        for (int i = 0; i < numQuestions; i++) {
            int oldIndex = indices.get(i);

   
            shuffledQuestions[i] = questionsArr[oldIndex];
            shuffledCorrect[i] = correctAnswers[oldIndex];

          
            String[] currentAnswers = new String[4];
            for (int j = 0; j < 4; j++) {
                currentAnswers[j] = answerArr[oldIndex * 4 + j];
            }

            ArrayList<String> answerList = new ArrayList<>();
            for (String ans : currentAnswers) {
                answerList.add(ans);
            }
            Collections.shuffle(answerList, rand);

            for (int j = 0; j < 4; j++) {
                shuffledAnswers[i * 4 + j] = answerList.get(j);
            }
        }

        questionsArr = shuffledQuestions;
        answerArr = shuffledAnswers;
        correctAnswers = shuffledCorrect;
    }

    private void runQuiz() {
        score = 0;
        
        System.out.println("════════════════════════════════════════════════════════════");
        System.out.println("                    QUIZ STARTED");
        System.out.println("════════════════════════════════════════════════════════════\n");

        for (int q = 0; q < questionsArr.length; q++) {
            displayQuestion(q);
            String userAnswer = getUserAnswer();
            
            if (userAnswer.equals("EXIT")) {
                System.out.println("\nQuiz terminated by user.\n");
                break;
            }
            
            checkAnswer(q, userAnswer);
            System.out.println();
        }

        displayFinalResults();
        System.exit(0);
    }

    private void displayQuestion(int questionIndex) {
        int answerIndex = questionIndex * 4;

        System.out.println("════════════════════════════════════════════════════════════");
        System.out.println("Question " + (questionIndex + 1) + " of " + questionsArr.length);
        System.out.println("════════════════════════════════════════════════════════════");
        System.out.println("\n" + questionsArr[questionIndex] + "\n");
        System.out.println("  A) " + answerArr[answerIndex]);
        System.out.println("  B) " + answerArr[answerIndex + 1]);
        System.out.println("  C) " + answerArr[answerIndex + 2]);
        System.out.println("  D) " + answerArr[answerIndex + 3]);
        System.out.println();
    }

    private String getUserAnswer() {
        String answer = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Your answer (A/B/C/D) or 'exit'/'x' to quit: ");
            answer = scanner.nextLine().trim().toUpperCase();

            if (answer.equals("A") || answer.equals("B") || answer.equals("C") || answer.equals("D")) {
                validInput = true;
            } else if (answer.equals("EXIT") || answer.equals("X")) {
                return "EXIT";
            } else {
                System.out.println("Invalid input. Please enter A, B, C, D, or exit/x.\n");
            }
        }

        return answer;
    }

    private void checkAnswer(int questionIndex, String userAnswer) {
        int answerIndex = questionIndex * 4;
        String selectedAnswerText = "";

        switch (userAnswer) {
            case "A":
                selectedAnswerText = answerArr[answerIndex];
                break;
            case "B":
                selectedAnswerText = answerArr[answerIndex + 1];
                break;
            case "C":
                selectedAnswerText = answerArr[answerIndex + 2];
                break;
            case "D":
                selectedAnswerText = answerArr[answerIndex + 3];
                break;
        }

        String correctAnswerText = correctAnswers[questionIndex];

        System.out.println("\n────────────────────────────────────────────────────────────");
        if (selectedAnswerText.equals(correctAnswerText)) {
            System.out.println("  CORRECT!");
            score++;
        } else {
            System.out.println("  INCORRECT!");
            System.out.println("  Correct Answer: " + correctAnswerText);
        }
        System.out.println("────────────────────────────────────────────────────────────");
    }

    private void displayFinalResults() {
        double percentage = (double) score / questionsArr.length * 100;

        System.out.println("\n\n════════════════════════════════════════════════════════════");
        System.out.println("                   QUIZ COMPLETED!");
        System.out.println("════════════════════════════════════════════════════════════");
        System.out.println("\n  Your Score: " + score + " out of " + questionsArr.length);
        System.out.printf("  Percentage: %.2f%%\n", percentage);
        
        System.out.println("\n  Performance: ");
        if (percentage >= 90) {
            System.out.println("  Excellent! Outstanding work!");
        } else if (percentage >= 80) {
            System.out.println("  Great job! Well done!");
        } else if (percentage >= 70) {
            System.out.println("  Good effort! Keep it up!");
        } else if (percentage >= 60) {
            System.out.println("  Fair performance. Keep studying!");
        } else {
            System.out.println("  Needs improvement. Review the material!");
        }
        
        System.out.println("\n════════════════════════════════════════════════════════════\n");

        // Reset for next quiz
        questionsArr = new String[0];
        answerArr = new String[0];
        correctAnswers = new String[0];
        score = 0;
    }

    public static void main(String[] args) {
        TerminalQuiz quiz = new TerminalQuiz();
        quiz.start();
    }
}