import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App{
    final static int width = 400, height = 400;
    static JPanel cards;
    final static String MAIN_PANEL = "main";
    final static String SEARCH_PANEL = "search";
    final static String HISTORY_PANEL = "history";

    public void addComponentToPane(Container pane) {
        JLabel lblApp = new JLabel("Slang Dictionary");
        lblApp.setFont(new Font("Serif", Font.PLAIN, 32));
        lblApp.setHorizontalAlignment(SwingConstants.CENTER);

        MainPane mainPane = new MainPane();
        SearchPane searchPane = new SearchPane();
        HistoryPane historyPane = new HistoryPane();
        
        // JPanel card2 = new JPanel();
        // card2.add(new JTextField("TextField", 20));
        
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(mainPane, MAIN_PANEL);
        cards.add(searchPane, SEARCH_PANEL);
        cards.add(historyPane, HISTORY_PANEL);
        
        pane.add(lblApp, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }

    public static void changePane(String paneName) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, paneName);
    }

    public static void exit() {
        System.exit(0);
    }
    
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Slang Dictionary");
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
