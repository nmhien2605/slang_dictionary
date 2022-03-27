import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPane extends JPanel{
    public MainPane() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        //Add component to main panel
        JButton btnSearch = new JButton("Search");
        btnSearch.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.changePane(App.SEARCH_PANEL);
            }
        });

        JButton btnHistory = new JButton("History");
        btnHistory.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.changePane(App.HISTORY_PANEL);
            }
        });

        JButton btnEdit = new JButton("Edit Dictionary");
        btnEdit.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnRandom = new JButton("Random slang word");
        btnRandom.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnQuiz = new JButton("Funny Quiz");
        btnQuiz.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnExit = new JButton("Exit");
        btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.exit();
            }
        });
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
}
