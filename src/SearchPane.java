import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class SearchPane extends JPanel {
    final String SLANG_WORD = "Slang word";
    final String DEFINITION = "Definition";
    JComboBox<String> cbxType;
    JPanel valuePane, keyPane;
    JScrollPane scrollPane;
    JLabel lblValue;
    static JTextField txtKey;
    static JTextArea txtValue;
    JButton btnBack;

    public SearchPane() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String cbxTypeItems[] = { SLANG_WORD, DEFINITION };
        cbxType = new JComboBox<String>(cbxTypeItems);

        txtKey = new JTextField();

        valuePane = new JPanel();
        valuePane.setLayout(new BoxLayout(valuePane, BoxLayout.LINE_AXIS));
        lblValue = new JLabel(DEFINITION);
        valuePane.add(lblValue);
        valuePane.add(Box.createHorizontalGlue());

        txtValue = new JTextArea(7, 1);
        txtValue.setEditable(false);
        scrollPane = new JScrollPane(txtValue);

        cbxType.setEditable(false);
        cbxType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String searchKey = txtKey.getText();
                if (e.getItem() == DEFINITION) {
                    lblValue.setText(SLANG_WORD);
                    searchValue(searchKey);
                } else {
                    lblValue.setText(DEFINITION);
                    searchKey(searchKey);
                }
            }
        });

        txtKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchKey = txtKey.getText();
                if (cbxType.getSelectedItem() == SLANG_WORD) {
                    searchKey(searchKey);
                }
                else {
                    searchValue(searchKey);
                }
            }
        });

        keyPane = new JPanel();
        keyPane.setLayout(new BoxLayout(keyPane, BoxLayout.LINE_AXIS));
        keyPane.add(cbxType);
        keyPane.add(Box.createHorizontalGlue());

        btnBack = new JButton("Back");
        btnBack.setAlignmentX(Box.CENTER_ALIGNMENT);
        btnBack.addActionListener(App.btnBackListener);

        add(keyPane);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(txtKey);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(valuePane);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(scrollPane);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnBack);
    }

    public static void reset() {
        txtKey.setText("");
        txtValue.setText("");
    }

    void searchKey(String key) {
        if (key.length() == 0) return;
        String value = App.searchKey(key);
        txtValue.setText(value);
        if (value.length() > 0) {
            App.addHistory(key + " ` " + value);
        }
    }

    void searchValue(String key) {
        if (key.length() == 0) return;
        ArrayList<String> ans = App.searchValue(key);
        txtValue.setText("");
        ans.forEach((slang) -> txtValue.append(slang + "\n"));
        App.addHistoryMultiple(ans);
    }
}
