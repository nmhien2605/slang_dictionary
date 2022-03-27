import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App{
    final static int width = 400, height = 400;
    JPanel cards;
    final static String MAIN_PANEL = "main";
    final static String TEXTPANEL = "Card with JTextField";

    public void addComponentToPane(Container pane) {
        JLabel appLabel = new JLabel("Slang Dictionary");
        appLabel.setFont(new Font("Serif", Font.PLAIN, 32));
        appLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //Create main panel
        JPanel mainPane = new JPanel();
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
        
        //Add component to main panel
        JButton btnSearch = new JButton("Search");
        btnSearch.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnEdit = new JButton("Edit Dictionary");
        btnEdit.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnRandom = new JButton("Random slang word");
        btnRandom.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnQuiz = new JButton("Funny Quiz");
        btnQuiz.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnExit = new JButton("Exit");
        btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPane.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPane.add(btnSearch);
        mainPane.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPane.add(btnEdit);
        mainPane.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPane.add(btnRandom);
        mainPane.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPane.add(btnQuiz);
        mainPane.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPane.add(btnExit);

        // JButton btnAdd = new JButton("Add Slang word");
        // JButton btnDelete = new JButton("Delete Slang word");
        // JButton btnReset = new JButton("Search");
        
        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));
        
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(mainPane, MAIN_PANEL);
        cards.add(card2, TEXTPANEL);
        
        pane.add(appLabel, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }
    
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
    
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(width, height));
        
        //Create and set up the content pane.
        App app = new App();
        app.addComponentToPane(frame.getContentPane());
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
    }

    public static void main(String[] args) {
        createAndShowGUI();
        // System.out.println("This is Slang Dictionary!");
    }
}
