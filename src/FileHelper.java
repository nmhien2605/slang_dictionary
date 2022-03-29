import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class FileHelper {
    public static HashMap<String, String> readSlangFile() {
        HashMap<String, String> slangs = new HashMap<>();
        try {
            DataInputStream fin = new DataInputStream(new FileInputStream("data/slang.dat"));

            String key, value;
            while (fin.available() > 0) {
                try {
                    key = fin.readUTF();
                    value = fin.readUTF();
                    slangs.put(key, value);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return slangs;
    }

    public static void writeSlangFile(HashMap<String, String> slangs) {
        try {
            DataOutputStream fout = new DataOutputStream(new FileOutputStream("data/slang.dat"));    

            slangs.forEach((key, value) -> {
                try {
                    fout.writeUTF(key);
                    fout.writeUTF(value);                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            fout.flush();
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, String> readSlangDefaultFile() {
        HashMap<String, String> slangs = new HashMap<>();
        try {
            BufferedReader fin = new BufferedReader(new FileReader("data/slang_default.txt"));

            String st;
            st = fin.readLine();
            while ((st = fin.readLine()) != null) {
                String tmp[] = st.split("`");
                slangs.put(tmp[0], tmp[1]);
            }

            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return slangs;
    }

    public static HashSet<String> readHistoryFile() {
        HashSet<String> history = new HashSet<>();
        try {
            DataInputStream fin = new DataInputStream(new FileInputStream("data/history.dat"));

            String his;
            while (fin.available() > 0) {
                try {
                    his = fin.readUTF();
                    history.add(his);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return history;
    }

    public static void writeHistoryFile(HashSet<String> history) {
        try {
            DataOutputStream fout = new DataOutputStream(new FileOutputStream("data/history.dat"));    

            history.forEach((his) -> {
                try {
                    fout.writeUTF(his);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            fout.flush();
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HashSet<String> readHistoryDayFile() {
        HashSet<String> historyDay = new HashSet<>();
        try {
            DataInputStream fin = new DataInputStream(new FileInputStream("data/history_day.dat"));

            String his;
            while (fin.available() > 0) {
                try {
                    his = fin.readUTF();
                    historyDay.add(his);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historyDay;
    }

    public static void writeHistoryDayFile(HashSet<String> historyDay) {
        try {
            DataOutputStream fout = new DataOutputStream(new FileOutputStream("data/history_day.dat"));    

            historyDay.forEach((his) -> {
                try {
                    fout.writeUTF(his);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            fout.flush();
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String readSlangDayFile() {
        String randomDay = "", keySlangDay = "";
        try {
            DataInputStream fin = new DataInputStream(new FileInputStream("data/slang_day.dat"));

            try {
                randomDay = fin.readUTF();
                keySlangDay = fin.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }

            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return randomDay + "`" + keySlangDay;
    }

    public static void writeSlangDayFile(String randomDay, String keySlangDay) {
        try {
            DataOutputStream fout = new DataOutputStream(new FileOutputStream("data/slang_day.dat"));    

            try {
                fout.writeUTF(randomDay);
                fout.writeUTF(keySlangDay);
            } catch (IOException e) {
                e.printStackTrace();
            }

            fout.flush();
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
