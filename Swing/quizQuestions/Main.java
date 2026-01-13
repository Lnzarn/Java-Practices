import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.*;

class quizQuestions extends JFrame implements ActionListener {
    JPanel mainPanel = new JPanel();
    JPanel topPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JPanel midPanel = new JPanel();

    JLabel questionAmount = new JLabel(" ");
    JTextArea questionLabel = new JTextArea();
    JLabel boolAnswer = new JLabel(" ");
    JTextArea correctAnswer = new JTextArea();

    JButton optionOneBtn = new JButton();
    JButton optionTwoBtn = new JButton();
    JButton optionThreeBtn = new JButton();
    JButton optionFourBtn = new JButton();
    JButton nextQuestionBtn = new JButton("Start Quiz");

    String[] questionsArr = {};
    String[] answerArr = {};
    String[] correctAnswers = {};

    int q = 0;
    int a = 0;
    int score = 0;
    
    public quizQuestions(){
        this.setTitle("Quiz Questions");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setPreferredSize(new Dimension(750,450));
        this.pack();
        this.setResizable(false);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        topPanel.setLayout(new BorderLayout(10, 10));
        topPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        
        midPanel.setLayout(new GridLayout(2,2,10,10));
        midPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        bottomPanel.setLayout(new BorderLayout(5, 5));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        questionAmount.setHorizontalAlignment(JLabel.CENTER);
        questionAmount.setFont(new Font("Arial", Font.PLAIN, 14));

        questionLabel.setLineWrap(true);
        questionLabel.setWrapStyleWord(true);
        questionLabel.setEditable(false);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionLabel.setBackground(this.getBackground());
        questionLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        questionLabel.setRows(3);

        correctAnswer.setLineWrap(true);
        correctAnswer.setWrapStyleWord(true);
        correctAnswer.setEditable(false);
        correctAnswer.setFont(new Font("Arial", Font.PLAIN, 12));
        correctAnswer.setBackground(this.getBackground());
        correctAnswer.setForeground(Color.BLACK);
        correctAnswer.setBorder(null);
        correctAnswer.setRows(2);

        boolAnswer.setHorizontalAlignment(JLabel.CENTER);
        boolAnswer.setFont(new Font("Arial", Font.BOLD, 14));

    
        configureButton(optionOneBtn);
        configureButton(optionTwoBtn);
        configureButton(optionThreeBtn);
        configureButton(optionFourBtn);

        optionOneBtn.setEnabled(false);
        optionTwoBtn.setEnabled(false);
        optionThreeBtn.setEnabled(false);
        optionFourBtn.setEnabled(false);


        JPanel questionPanel = new JPanel(new BorderLayout());
        questionPanel.add(questionAmount, BorderLayout.NORTH);
        JScrollPane questionScroll = new JScrollPane(questionLabel);
        questionScroll.setBorder(null);
        questionPanel.add(questionScroll, BorderLayout.CENTER);
        topPanel.add(questionPanel);

   
        midPanel.add(optionOneBtn);
        midPanel.add(optionTwoBtn);
        midPanel.add(optionThreeBtn);
        midPanel.add(optionFourBtn);

        JPanel bottomTopPanel = new JPanel(new BorderLayout());
        bottomTopPanel.add(nextQuestionBtn, BorderLayout.CENTER);
        
        JPanel feedbackPanel = new JPanel(new BorderLayout(5, 5));
        feedbackPanel.add(boolAnswer, BorderLayout.NORTH);
        JScrollPane correctScroll = new JScrollPane(correctAnswer);
        correctScroll.setBorder(null);
        feedbackPanel.add(correctScroll, BorderLayout.CENTER);

        bottomPanel.add(bottomTopPanel, BorderLayout.NORTH);
        bottomPanel.add(feedbackPanel, BorderLayout.CENTER);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(midPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        nextQuestionBtn.addActionListener(this);
        optionOneBtn.addActionListener(this);
        optionTwoBtn.addActionListener(this);
        optionThreeBtn.addActionListener(this);
        optionFourBtn.addActionListener(this);

        this.add(mainPanel);
        this.setVisible(true);
    }

    private void configureButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 12));
        button.setMargin(new Insets(10, 10, 10, 10));
        button.setFocusPainted(false);
        button.setVerticalAlignment(SwingConstants.CENTER);
        button.setHorizontalAlignment(SwingConstants.CENTER);
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
            
            return questionsArr.length > 0;
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, 
                "Error loading quiz file: " + filename + "\n" + e.getMessage(),
                "File Error", 
                JOptionPane.ERROR_MESSAGE);
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

    private String wrapButtonText(String text) {
        return "<html><div style='width: 200px; padding: 5px;'>" + text + "</div></html>";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == nextQuestionBtn){
            if (questionsArr.length == 0 && q == 0) {
                String[] subjects = {"DSA", "DS2", "MODSIM"};
                String selectedSubject = (String) JOptionPane.showInputDialog(
                    this,
                    "Select a subject for the quiz:",
                    "Subject Selection",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    subjects,
                    subjects[0]
                );
                
                if (selectedSubject == null) {
                    return; // User cancelled
                }
                
                if (!loadQuizFromFile(selectedSubject)) {
                    return; // Failed to load
                }
                
                score = 0;
            }
            
            if (questionsArr.length == q) {
                questionAmount.setText("Quiz Completed!");
                questionLabel.setText("You have completed the quiz with a score of " + score + " out of " + questionsArr.length + ".");
                optionOneBtn.setText("");
                optionTwoBtn.setText("");
                optionThreeBtn.setText("");
                optionFourBtn.setText("");
                nextQuestionBtn.setText("Start Quiz");
                
                questionsArr = new String[0];
                answerArr = new String[0];
                correctAnswers = new String[0];
                q = 0;
                a = 0;
                score = 0;
                return;
            }
            
            nextQuestionBtn.setText("Next Question");
            questionAmount.setText("Question " + (q+1) + " of " + questionsArr.length);
            questionLabel.setText(questionsArr[q]);
            
            optionOneBtn.setText(wrapButtonText(answerArr[a]));
            optionTwoBtn.setText(wrapButtonText(answerArr[a+1]));
            optionThreeBtn.setText(wrapButtonText(answerArr[a+2]));
            optionFourBtn.setText(wrapButtonText(answerArr[a+3]));
            
            boolAnswer.setText(" ");
            correctAnswer.setText(" ");
            optionOneBtn.setEnabled(true);
            optionTwoBtn.setEnabled(true);
            optionThreeBtn.setEnabled(true);
            optionFourBtn.setEnabled(true);
            q++;
            a +=4;
        } 
        if (e.getSource() == optionOneBtn || e.getSource() == optionTwoBtn || 
            e.getSource() == optionThreeBtn || e.getSource() == optionFourBtn) {
            JButton clickedButton = (JButton) e.getSource();
            String selectedAnswer = clickedButton.getText();
            
            selectedAnswer = selectedAnswer.replaceAll("<[^>]*>", "").trim();
            
            String correctAnswerText = correctAnswers[q-1];

            if(selectedAnswer.equals(correctAnswerText)){
                boolAnswer.setText("Correct!");
                boolAnswer.setForeground(new Color(11, 251, 11));
                correctAnswer.setText(" ");
                score++;
            } else {
                boolAnswer.setText("Incorrect!");
                boolAnswer.setForeground(new Color(251, 11, 11));
                correctAnswer.setText("Correct Answer: " + correctAnswerText);
            }

            optionOneBtn.setEnabled(false);
            optionTwoBtn.setEnabled(false);
            optionThreeBtn.setEnabled(false);
            optionFourBtn.setEnabled(false);
        }
    }
}

public class Main {
    public static void main(String[] args){
        new quizQuestions();
    }
}