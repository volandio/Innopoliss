package September2017.Date_27_09_17;

import java.io.*;
import java.util.Scanner;

public class RedactorFile {
    public static void main(String[] args) {
        System.out.println("Please enter 3 command(read, write, append), name of file, text - " +
                "for read method enter 2 command");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String nameOfFile = scanner.nextLine();
        String text = null;
        if (command.equals("write") || command.equals("append")) {
            text = scanner.nextLine();
        }
        scanner.close();
        if (command.equals("read")) {
            readFromFile(nameOfFile);
        } else if (command.equals("write")) {
            writeToFile(nameOfFile, text);
        } else if (command.equals("append")) {
            appendToFile(nameOfFile, text);
        } else {
            System.out.println("You have error in your command!");
        }
    }

    public static void writeToFile(String nameOfFile, String text) {
        try (FileWriter fileWriter = new FileWriter(nameOfFile);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFile(String nameOfFile) {
        try (FileReader fileReader = new FileReader(nameOfFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String x;
            while ((x = bufferedReader.readLine()) != null) {
                System.out.println(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendToFile(String nameOfFile, String text) {
        try (FileWriter f = new FileWriter(nameOfFile, true);
             BufferedWriter b = new BufferedWriter(f); PrintWriter p = new PrintWriter(b)) {
            p.println(text);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
