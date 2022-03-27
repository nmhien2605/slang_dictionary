import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class SearchPane extends JPanel {
    final String SLANG_WORD = "Slang word";
    final String DEFINITION = "Definition";

    public SearchPane() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String cbxTypeItems[] = { SLANG_WORD, DEFINITION };
        JComboBox cbxType = new JComboBox(cbxTypeItems);

        JTextField txtKey = new JTextField();

        JPanel valuePane = new JPanel();
        valuePane.setLayout(new BoxLayout(valuePane, BoxLayout.LINE_AXIS));
        JLabel lblValue = new JLabel(DEFINITION);
        valuePane.add(lblValue);
        valuePane.add(Box.createHorizontalGlue());

        JTextArea txtValue = new JTextArea(7, 1);
        txtValue.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtValue);


        cbxType.setEditable(false);
        cbxType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String searchKey = txtKey.getText();
                if (e.getItem() == DEFINITION) {
                    lblValue.setText(SLANG_WORD);
                    if (searchKey != "") {
                        ArrayList<String> ans = App.searchValue(searchKey);
                        txtValue.setText("");
                        ans.forEach((slang) -> txtValue.append(slang + "\n"));
                    }
                } else {
                    lblValue.setText(DEFINITION);
                    String value = App.searchKey(searchKey);
                    txtValue.setText(value);
                }
            }
        });


        txtKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchKey = txtKey.getText();
                if (cbxType.getSelectedItem() == SLANG_WORD) {
                    String value = App.searchKey(searchKey);
                    txtValue.setText(value);
                }
                else {
                    ArrayList<String> ans = App.searchValue(searchKey);
                    txtValue.setText("");
                    ans.forEach((slang) -> txtValue.append(slang + "\n"));
                }
            }
        });

        JPanel keyPane = new JPanel();
        keyPane.setLayout(new BoxLayout(keyPane, BoxLayout.LINE_AXIS));
        keyPane.add(cbxType);
        keyPane.add(Box.createHorizontalGlue());

        JButton btnBack = new JButton("Back");
        btnBack.setAlignmentX(Box.CENTER_ALIGNMENT);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.changePane(App.MAIN_PANEL);
            }
        });

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
}
