package Date_20_09_17;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        readFromFile();
    }

    public static void readFromFile() {
        try (FileReader fileReader = new FileReader("1.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile() {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter("1.txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Privet");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null)
                    fileWriter.close();
                if (bufferedWriter != null)
                    bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeToFile2() {
        try (FileWriter fileWriter = new FileWriter("1.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write("Privet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
