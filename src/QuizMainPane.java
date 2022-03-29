import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class QuizMainPane extends JPanel {
    JButton btnSlangQuiz, btnDefinitionQuiz, btnBack;

    ButtonQuizListener btnQuizListener = new ButtonQuizListener();

    public QuizMainPane() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        btnSlangQuiz = new JButton("Slang word quiz");
        btnSlangQuiz.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSlangQuiz.addActionListener(btnQuizListener);
        
        btnDefinitionQuiz = new JButton("Definition quiz");
        btnDefinitionQuiz.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDefinitionQuiz.addActionListener(btnQuizListener);

        btnBack = new JButton("Back");
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnBack.addActionListener(App.btnBackListener);

        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnSlangQuiz);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnDefinitionQuiz);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnBack);
    }

    public class ButtonQuizListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnSlangQuiz) {
                QuizPane.setQues(QuizPane.TypeQuiz.SLANG_QUIZ);
            } else {
                QuizPane.setQues(QuizPane.TypeQuiz.DEFINITION_QUIZ);
            }
            App.changePane(App.QUIZ_PANEL);
        }
    }
}
