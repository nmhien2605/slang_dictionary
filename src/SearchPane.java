import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SearchPane extends JPanel{
    public SearchPane() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel valuePane = new JPanel();
        valuePane.setLayout(new BoxLayout(valuePane, BoxLayout.LINE_AXIS));
        JLabel lblValue = new JLabel("Definition");
        valuePane.add(lblValue);
        valuePane.add(Box.createHorizontalGlue());

        JPanel keyPane = new JPanel();
        keyPane.setLayout(new BoxLayout(keyPane, BoxLayout.X_AXIS));
        String cbxTypeItems[] = { "Slang word", "Definition" };
        JComboBox cbxType = new JComboBox(cbxTypeItems);
        cbxType.setEditable(false);
        cbxType.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getItem() == "Definition") {
                    lblValue.setText("Slang word");
                }
                else {
                    lblValue.setText("Definition");
                }
                
            }

        });;
        keyPane.add(cbxType);
        keyPane.add(Box.createHorizontalGlue());

        JTextField txtKey = new JTextField();
        JTextArea txtValue = new JTextArea();
        txtValue.setEditable(false);

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
        add(txtValue);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnBack);
    }
}
