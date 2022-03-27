import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HistoryPane extends JPanel{
    public HistoryPane() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel historyPane = new JPanel();
        historyPane.setLayout(new BoxLayout(historyPane, BoxLayout.LINE_AXIS));
        JLabel lblValue = new JLabel("History");
        historyPane.add(lblValue);
        historyPane.add(Box.createHorizontalGlue());

        JTextArea txtHistory = new JTextArea();
        txtHistory.setEditable(false);

        JButton btnBack = new JButton("Back");
        btnBack.setAlignmentX(Box.CENTER_ALIGNMENT);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.changePane(App.MAIN_PANEL);
            }
        });

        add(historyPane);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(txtHistory);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnBack);
    }
}
