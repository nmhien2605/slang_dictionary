import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.*;

public class App{
    final static int width = 400, height = 400;
    final static String MAIN_PANEL = "main";
    final static String SEARCH_PANEL = "search";
    final static String HISTORY_PANEL = "history";
    final static String EDIT_MAIN_PANEL = "edit main";
    final static String RANDOM_PANEL = "random";
    final static String QUIZ_PANEL = "quiz";
    final static ButtonBackListener btnBackListener = new ButtonBackListener();

    static JPanel cards;

    static HashMap<String, String> slangs = new HashMap<>();
    static HashSet<String> history = new HashSet<>();

    public static class ButtonBackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            changePane(MAIN_PANEL);
        }
    }

    public void addComponentToPane(Container pane) {
        JLabel lblApp = new JLabel("Slang Dictionary");
        lblApp.setFont(new Font("Serif", Font.PLAIN, 32));
        lblApp.setHorizontalAlignment(SwingConstants.CENTER);
        lblApp.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
        MainPane mainPane = new MainPane();
        SearchPane searchPane = new SearchPane();
        HistoryPane historyPane = new HistoryPane();
        EditMainPane editMainPane = new EditMainPane();
        
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(mainPane, MAIN_PANEL);
        cards.add(searchPane, SEARCH_PANEL);
        cards.add(historyPane, HISTORY_PANEL);
        cards.add(editMainPane, EDIT_MAIN_PANEL);
        
        pane.add(lblApp, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }

    public static void changePane(String paneName) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, paneName);
    }

    public static String searchKey(String key) {
        if (slangs.containsKey(key)) {
            return (String)slangs.get(key);
        }
        return "";
    }

    public static ArrayList<String> searchValue(String value) {
        ArrayList<String> ans = new ArrayList<>();
        slangs.forEach((key, val) -> {
            if (((String) val).contains(value)) {
                ans.add(key + ": " + val);
            }
        });
        return ans;
    }

    public static void addHistory(String value) {
        history.add(value);
        System.out.println(history.size());
    }

    public static void addHistoryMultiple(ArrayList<String> values) {
        for (int i = 0; i < values.size(); i++) {
            history.add(values.get(i));
        }
        System.out.println(history.size());
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
        slangs = FileHelper.readSlangWord();
        // slangs.forEach(action);
        // System.out.println(slangs.get("key"));
        createAndShowGUI();
        // System.out.println("This is Slang Dictionary!");
    }
}
