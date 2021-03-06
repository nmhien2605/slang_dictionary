import java.awt.*;

import javax.swing.*;

public class RandomSlangPane extends JPanel{
    JPanel titlePane, subTitlePane, btnPane;
    JLabel lblTitle, lblSubTitle;
    static JLabel lblKey, lblValue;
    JButton btnBack;

    public RandomSlangPane() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        titlePane = new JPanel();
        titlePane.setLayout(new BoxLayout(titlePane, BoxLayout.LINE_AXIS));
        lblTitle = new JLabel("On this day slang word");
        lblTitle.setFont(new Font("Monospace", Font.BOLD, 18));
        titlePane.add(lblTitle);
        titlePane.add(Box.createHorizontalGlue());

        subTitlePane = new JPanel();
        subTitlePane.setLayout(new BoxLayout(subTitlePane, BoxLayout.LINE_AXIS));
        lblSubTitle = new JLabel("Definition");
        subTitlePane.add(lblSubTitle);
        subTitlePane.add(Box.createHorizontalGlue());

        lblKey = new JLabel(" ");
        lblKey.setFont(new Font("Monospace", Font.ITALIC, 18));
        lblKey.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblValue = new JLabel(" ");
        lblValue.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnPane = new JPanel();
        btnPane.setLayout(new BoxLayout(btnPane, BoxLayout.LINE_AXIS));

        btnBack = new JButton("Back");
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnBack.addActionListener(App.btnBackListener);

        btnPane.add(Box.createHorizontalGlue());
        btnPane.add(btnBack);

        add(Box.createRigidArea(new Dimension(0, 20)));
        add(titlePane);
        add(lblKey);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(subTitlePane);
        add(lblValue);
        add(Box.createRigidArea(new Dimension(0, 50)));
        add(btnBack);
    }

    public static void setRandomSlang() {
        String tmp[] = App.randomSlangDay().split("`");
        String key = tmp[0], value = tmp[1];
        lblKey.setText(key);
        lblValue.setText(value);
    }
}
