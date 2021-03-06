import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class EditPane extends JPanel{
    JPanel keyPane, valuePane, keyLinePane, valueLinePane, editPane, btnPane;
    JLabel lblKey, lblValue;
    static JTextField txtKey, txtValue;
    JButton btnSave, btnBack;

    ButtonSaveListener btnSaveListener = new ButtonSaveListener();
    ButtonBackListener btnBackListener = new ButtonBackListener();

    static String preKey;

    public EditPane() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        editPane = new JPanel();
        editPane.setLayout(new BoxLayout(editPane, BoxLayout.LINE_AXIS));

        keyPane = new JPanel();
        keyPane.setLayout(new BoxLayout(keyPane, BoxLayout.PAGE_AXIS));
        
        keyLinePane = new JPanel();
        keyLinePane.setLayout(new BoxLayout(keyLinePane, BoxLayout.LINE_AXIS));
        lblKey = new JLabel("Slang word");
        keyLinePane.add(lblKey);
        keyLinePane.add(Box.createHorizontalGlue());

        txtKey = new JTextField();

        keyPane.add(Box.createRigidArea(new Dimension(0, 100)));
        keyPane.add(keyLinePane);
        keyPane.add(txtKey);
        keyPane.add(Box.createRigidArea(new Dimension(0, 100)));

        valuePane = new JPanel();
        valuePane.setLayout(new BoxLayout(valuePane, BoxLayout.PAGE_AXIS));

        valueLinePane = new JPanel();
        valueLinePane.setLayout(new BoxLayout(valueLinePane, BoxLayout.LINE_AXIS));
        lblValue = new JLabel("Definition");
        valueLinePane.add(lblValue);
        valueLinePane.add(Box.createHorizontalGlue());

        txtValue = new JTextField();

        valuePane.add(Box.createRigidArea(new Dimension(0, 100)));
        valuePane.add(valueLinePane);
        valuePane.add(txtValue);
        valuePane.add(Box.createRigidArea(new Dimension(0, 100)));

        editPane.add(keyPane);
        editPane.add(valuePane);

        btnPane = new JPanel();
        btnPane.setLayout(new BoxLayout(btnPane, BoxLayout.LINE_AXIS));

        btnSave = new JButton("Save");
        btnSave.addActionListener(btnSaveListener);

        btnBack = new JButton("Back");
        btnBack.addActionListener(btnBackListener);

        btnPane.add(Box.createHorizontalGlue());
        btnPane.add(btnSave);
        btnPane.add(Box.createRigidArea(new Dimension(20, 0)));
        btnPane.add(btnBack);

        add(editPane);
        add(btnPane);
    }

    public static void setSlang(String pre, String key, String value) {
        preKey = pre;
        txtKey.setText(key);
        txtValue.setText(value);
    }

    class ButtonSaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String key = txtKey.getText();
            String value = txtValue.getText();
            if (preKey != null) {
                App.deleteSlang(preKey);
            }
            App.addSlang(key, value);
            EditMainPane.setList(App.slangs);
            App.changePane(App.EDIT_MAIN_PANEL);
        }
    }
    
    class ButtonBackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            App.changePane(App.EDIT_MAIN_PANEL);
        }
    }
}