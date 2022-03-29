import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.*;

public class QuizPane extends JPanel {
    static JPanel quesPane, ansPane, btnPane;
    static JButton btnAnsA, btnAnsB, btnAnsC, btnAnsD, btnNext, btnBack;
    static JLabel lblQues;

    ButtonAnsListener btnAnsListener = new ButtonAnsListener();
    ButtonNextListener btnNextListener = new ButtonNextListener();

    static enum TypeQuiz {
        SLANG_QUIZ,
        DEFINITION_QUIZ,
    }

    static TypeQuiz typeQuiz = TypeQuiz.SLANG_QUIZ;
    static int ansIndex = 0;
    static String ansSlang = "";

    public QuizPane() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lblQues = new JLabel(" had aisdhioa sd");

        ansPane = new JPanel();
        ansPane.setLayout(new BoxLayout(ansPane, BoxLayout.PAGE_AXIS));

        btnAnsA = new JButton("A. ");
        btnAnsA.addActionListener(btnAnsListener);
        btnAnsB = new JButton("B. ");
        btnAnsB.addActionListener(btnAnsListener);
        btnAnsC = new JButton("C. ");
        btnAnsC.addActionListener(btnAnsListener);
        btnAnsD = new JButton("D. ");
        btnAnsD.addActionListener(btnAnsListener);

        ansPane.add(btnAnsA);
        ansPane.add(Box.createRigidArea(new Dimension(0, 5)));
        ansPane.add(btnAnsB);
        ansPane.add(Box.createRigidArea(new Dimension(0, 5)));
        ansPane.add(btnAnsC);
        ansPane.add(Box.createRigidArea(new Dimension(0, 5)));
        ansPane.add(btnAnsD);

        btnPane = new JPanel();
        btnPane.setLayout(new BoxLayout(btnPane, BoxLayout.PAGE_AXIS));

        btnNext = new JButton("Next Quiz");
        btnNext.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnNext.addActionListener(btnNextListener);

        btnBack = new JButton("Back");
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnBack.addActionListener(App.btnBackListener);

        btnPane.add(btnNext);
        btnPane.add(Box.createRigidArea(new Dimension(0, 20)));
        btnPane.add(btnBack);

        add(lblQues);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(ansPane);
        add(btnPane);
        btnPane.setVisible(false);
    }

    public static void setQues(TypeQuiz type) {
        HashMap<String, String> ques = App.randomSlangQuiz();
        ArrayList<String> keys = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        ques.forEach((key, val) -> {
            keys.add(key);
            values.add(val);
        });
        Random ran = new Random();

        btnPane.setVisible(false);
        lblQues.setVisible(true);
        ansPane.setVisible(true);

        ansIndex = ran.nextInt(4);
        ansSlang = keys.get(ansIndex) + " ` " + values.get(ansIndex);

        if (type == TypeQuiz.SLANG_QUIZ) {
            lblQues.setText(keys.get(ansIndex));
            btnAnsA.setText("A. " + values.get(0));
            btnAnsB.setText("B. " + values.get(1));
            btnAnsC.setText("C. " + values.get(2));
            btnAnsD.setText("D. " + values.get(3));
        } else {
            lblQues.setText(values.get(ansIndex));
            btnAnsA.setText("A. " + keys.get(0));
            btnAnsB.setText("B. " + keys.get(1));
            btnAnsC.setText("C. " + keys.get(2));
            btnAnsD.setText("D. " + keys.get(3));
        }

        typeQuiz = type;
    }

    public class ButtonAnsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String res = "Incorrected";
            if ((e.getSource() == btnAnsA && ansIndex == 0) || (e.getSource() == btnAnsB && ansIndex == 1)
                    || (e.getSource() == btnAnsC && ansIndex == 2) || (e.getSource() == btnAnsD && ansIndex == 3)) {
                res = "Corrected";
            }
            JOptionPane.showConfirmDialog(null, ansSlang, res, JOptionPane.DEFAULT_OPTION);
            lblQues.setVisible(false);
            ansPane.setVisible(false);
            btnPane.setVisible(true);
        }
    }

    public class ButtonNextListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnPane.setVisible(false);
            lblQues.setVisible(true);
            ansPane.setVisible(true);
            setQues(typeQuiz);
        }
    }
}
