import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class HistoryPane extends JPanel{
    JPanel historyPane;
    JLabel lblValue;
    JScrollPane scrollPane;
    static JTextArea txtHistory;
    JButton btnBack;

    public HistoryPane() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        historyPane = new JPanel();
        historyPane.setLayout(new BoxLayout(historyPane, BoxLayout.LINE_AXIS));
        lblValue = new JLabel("History");
        historyPane.add(lblValue);
        historyPane.add(Box.createHorizontalGlue());

        txtHistory = new JTextArea(10, 1);
        txtHistory.setEditable(false);
        scrollPane = new JScrollPane(txtHistory);

        btnBack = new JButton("Back");
        btnBack.setAlignmentX(Box.CENTER_ALIGNMENT);
        btnBack.addActionListener(App.btnBackListener);

        add(historyPane);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(txtHistory);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnBack);
    }

    public static void reset() {
        txtHistory.setText("");
        ArrayList<String> history = new ArrayList<>(App.history);
        for (int i = 0; i < history.size(); i++) {
            txtHistory.append(history.get(i) + "\n");
        }
    }
}
