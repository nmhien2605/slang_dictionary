import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPane extends JPanel{
    JButton btnSearch, btnHistory, btnEdit, btnRandom, btnQuiz, btnExit;
    ButtonMainListener btnMainListener = new ButtonMainListener();

    public MainPane() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        btnSearch = new JButton("Search");
        btnSearch.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSearch.addActionListener(btnMainListener);

        btnHistory = new JButton("History");
        btnHistory.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnHistory.addActionListener(btnMainListener);

        btnEdit = new JButton("Edit Dictionary");
        btnEdit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEdit.addActionListener(btnMainListener);

        btnRandom = new JButton("On this day slang word");
        btnRandom.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRandom.addActionListener(btnMainListener);
        
        btnQuiz = new JButton("Funny Quiz");
        btnQuiz.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnQuiz.addActionListener(btnMainListener);
        
        btnExit = new JButton("Exit");
        btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnExit.addActionListener(btnMainListener);

        //Add component to pane
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnSearch);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnHistory);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnEdit);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnRandom);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnQuiz);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnExit);
    }

    class ButtonMainListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnSearch) {
                SearchPane.reset();
                App.changePane(App.SEARCH_PANEL);
            }
            else if (e.getSource() == btnHistory) {
                HistoryPane.reset();
                App.changePane(App.HISTORY_PANEL);
            }
            else if (e.getSource() == btnEdit) {
                EditMainPane.setList(App.slangs);
                App.changePane(App.EDIT_MAIN_PANEL);
            }
            else if (e.getSource() == btnRandom) {
                RandomSlangPane.setRandomSlang();
                App.changePane(App.RANDOM_PANEL);
            }
            else if (e.getSource() == btnQuiz) {
                App.changePane(App.QUIZ_MAIN_PANEL);
            }
            else if (e.getSource() == btnExit) {
                App.exit();
            }
        }
    }
}
