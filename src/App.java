import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

import javax.swing.*;

public class App {
    final static int width = 400, height = 400;
    final static String MAIN_PANEL = "main";
    final static String SEARCH_PANEL = "search";
    final static String HISTORY_PANEL = "history";
    final static String EDIT_MAIN_PANEL = "edit main";
    final static String EDIT_PANEL = "edit";
    final static String RANDOM_PANEL = "random";
    final static String QUIZ_PANEL = "quiz";
    final static ButtonBackListener btnBackListener = new ButtonBackListener();

    static JPanel cards;

    static HashMap<String, String> slangs = new HashMap<>();
    static HashSet<String> history = new HashSet<>();
    static HashSet<String> historyDay = new HashSet<>();
    static String randomDay = "28/03/2022";
    static String keySlangDay = "key2";

    public static class ButtonBackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            changePane(MAIN_PANEL);
        }
    }

    public void addComponentToPane(Container pane) {
        JLabel lblApp = new JLabel("Slang Dictionary");
        lblApp.setFont(new Font("Serif", Font.BOLD, 32));
        lblApp.setHorizontalAlignment(SwingConstants.CENTER);
        lblApp.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        MainPane mainPane = new MainPane();
        SearchPane searchPane = new SearchPane();
        HistoryPane historyPane = new HistoryPane();
        EditMainPane editMainPane = new EditMainPane();
        EditPane editPane = new EditPane();
        RandomSlangPane randomSlang = new RandomSlangPane();

        // Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(mainPane, MAIN_PANEL);
        cards.add(searchPane, SEARCH_PANEL);
        cards.add(historyPane, HISTORY_PANEL);
        cards.add(editMainPane, EDIT_MAIN_PANEL);
        cards.add(editPane, EDIT_PANEL);
        cards.add(randomSlang, RANDOM_PANEL);

        pane.add(lblApp, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }

    public static void changePane(String paneName) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, paneName);
    }

    public static String searchKey(String key) {
        if (slangs.containsKey(key)) {
            return (String) slangs.get(key);
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

    public static void addSlang(String key, String value) {
        slangs.put(key, value);
    }

    public static void deleteSlang(String key) {
        slangs.remove(key);
    }

    public static void resetDictionary() {
        slangs.clear();
        slangs = FileHelper.readSlangWord();
    }

    public static String randomSlang() {
        String key, value;

        Date now = new Date();
        String date = (new SimpleDateFormat("dd/MM/yyyy")).format(now);
        if (date.compareTo(randomDay) == 0) {
            key = keySlangDay;
            value = slangs.get(key);
        } else {
            ArrayList<String> keys = new ArrayList<String>(slangs.keySet());
            Random ran = new Random();
            int index;
            if (historyDay.size() == slangs.size()) {
                historyDay.clear();
            }
            do {
                index = ran.nextInt(keys.size());
                key = keys.get(index);
                value = slangs.get(key);
            } while (historyDay.contains(key));
            historyDay.add(key);
        }
        return key + ":" + value;
    }

    public static void exit() {
        System.exit(0);
    }

    public static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("Slang Dictionary");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(width, height));

        // Create and set up the content pane.
        App app = new App();
        app.addComponentToPane(frame.getContentPane());

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        slangs = FileHelper.readSlangWord();
        historyDay.add("key3");
        // slangs.forEach(action);
        // System.out.println(slangs.get("key"));
        createAndShowGUI();
        // System.out.println("This is Slang Dictionary!");
    }
}
