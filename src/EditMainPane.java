import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EditMainPane extends JPanel{
    public EditMainPane() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel keyPane = new JPanel();
        keyPane.setLayout(new BoxLayout(keyPane, BoxLayout.LINE_AXIS));
        String cbxTypeItems[] = { "Slang word", "Definition" };
        JComboBox cbxType = new JComboBox(cbxTypeItems);
        cbxType.setEditable(false);
        keyPane.add(cbxType);
        keyPane.add(Box.createHorizontalGlue());

        JPanel valuePane = new JPanel();
        valuePane.setLayout(new BoxLayout(valuePane, BoxLayout.LINE_AXIS));
        JLabel lblValue = new JLabel("Definition");
        valuePane.add(lblValue);
        valuePane.add(Box.createHorizontalGlue());

        JTextField txtKey = new JTextField();
        JTextArea txtValue = new JTextArea();
        txtValue.setEditable(false);

        JPanel btnPane = new JPanel();
        btnPane.setLayout(new BoxLayout(btnPane, BoxLayout.LINE_AXIS));

        JButton btnEdit = new JButton("Edit");

        JButton btnDelete = new JButton("Delete");

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.changePane(App.MAIN_PANEL);
            }
        });

        btnPane.add(btnEdit);
        btnPane.add(Box.createRigidArea(new Dimension(20, 0)));
        btnPane.add(btnDelete);
        btnPane.add(Box.createRigidArea(new Dimension(20, 0)));
        btnPane.add(btnBack);

        add(keyPane);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(txtKey);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(valuePane);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(txtValue);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnPane);
    }
}
