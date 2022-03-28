import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

public class EditMainPane extends JPanel {
    JPanel searchPane, keyPane, valuePane, btnEditPane, btnEndPane;
    JScrollPane scrollPane;
    JComboBox<String> cbxType;
    JLabel lblValue, lblSearch;
    JTextField txtKey;
    static JList lstSlang;
    JButton btnReset, btnAdd, btnEdit, btnDelete, btnBack;

    ButtonEditListener btnEditListener = new ButtonEditListener();
    ButtonResetListner btnResetListner = new ButtonResetListner();

    static ArrayList<String> slangItems = new ArrayList<>();

    public EditMainPane() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        searchPane = new JPanel();
        searchPane.setLayout(new BoxLayout(searchPane, BoxLayout.LINE_AXIS));
        lblSearch = new JLabel("Search");
        searchPane.add(lblSearch);
        searchPane.add(Box.createHorizontalGlue());

        keyPane = new JPanel();
        keyPane.setLayout(new BoxLayout(keyPane, BoxLayout.LINE_AXIS));
        String cbxTypeItems[] = { "Slang word", "Definition" };
        cbxType = new JComboBox<String>(cbxTypeItems);
        cbxType.setEditable(false);
        keyPane.add(cbxType);
        keyPane.add(Box.createHorizontalGlue());

        valuePane = new JPanel();
        valuePane.setLayout(new BoxLayout(valuePane, BoxLayout.LINE_AXIS));
        lblValue = new JLabel("Dictionary");
        valuePane.add(lblValue);
        valuePane.add(Box.createHorizontalGlue());

        txtKey = new JTextField();
        slangItems.add("e: e");
        slangItems.add("s: r");
        lstSlang = new JList(slangItems.toArray());
        lstSlang.setSelectedIndex(0);
        lstSlang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane = new JScrollPane(lstSlang);

        btnEditPane = new JPanel();
        btnEditPane.setLayout(new BoxLayout(btnEditPane, BoxLayout.LINE_AXIS));

        btnAdd = new JButton("Add new");
        btnAdd.addActionListener(btnEditListener);

        btnEdit = new JButton("Edit");
        btnEdit.addActionListener(btnEditListener);

        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(btnEditListener);

        btnEditPane.add(Box.createHorizontalGlue());
        btnEditPane.add(btnAdd);
        btnEditPane.add(Box.createRigidArea(new Dimension(10, 0)));
        btnEditPane.add(btnEdit);
        btnEditPane.add(Box.createRigidArea(new Dimension(10, 0)));
        btnEditPane.add(btnDelete);
        // btnEditPane.add(Box.createRigidArea(new Dimension(10, 0)));

        btnEndPane = new JPanel();
        btnEndPane.setLayout(new BoxLayout(btnEndPane, BoxLayout.LINE_AXIS));

        btnReset = new JButton("Reset Dictionary");
        btnReset.addActionListener(btnResetListner);

        btnBack = new JButton("Back");
        btnBack.addActionListener(App.btnBackListener);

        btnEndPane.add(btnReset);
        btnEndPane.add(Box.createHorizontalGlue());
        btnEndPane.add(btnBack);

        add(searchPane);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(keyPane);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(txtKey);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(valuePane);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(scrollPane);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(btnEditPane);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnEndPane);
    }

    public static void setList(HashMap<String, String> slangs) {
        ArrayList<String> data = new ArrayList<>();
        slangs.forEach((key, val) -> {
            data.add(key + ": " + val);
        });
        data.sort(null);
        lstSlang.setListData(data.toArray());
    }

    class ButtonEditListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (lstSlang.getSelectedValue() == null) {
                if (e.getSource() == btnAdd) {
                    EditPane.setSlang("", "");
                    App.changePane(App.EDIT_PANEL);
                }
            } else {
                String[] tmp = ((String) lstSlang.getSelectedValue()).split(": ");
                String key = tmp[0];
                String value = tmp[1];
                if (e.getSource() == btnDelete) {
                    int confirm = JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Delete slang word",
                            JOptionPane.YES_NO_OPTION);
                    if (confirm == 0) {
                        App.deleteSlang(key);
                        EditMainPane.setList(App.slangs);
                    }
                } else {
                    if (e.getSource() == btnAdd) {
                        EditPane.setSlang("", "");
                    } else {
                        EditPane.setSlang(key, value);
                        App.deleteSlang(key);
                    }
                    App.changePane(App.EDIT_PANEL);
                }
            }
        }
    }

    class ButtonResetListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int confirm = JOptionPane.showConfirmDialog(null, "Do you want reset dictionary?", "Reset dictionary",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == 0) {
                App.resetDictionary();
                EditMainPane.setList(App.slangs);
            }
        }
    }
}
