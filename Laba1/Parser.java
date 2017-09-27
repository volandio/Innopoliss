package main.java.Laba1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    private String[] array;
    private int result;

    Parser(String[] array) {
        this.array = array;
    }

    private synchronized void sumAndPrint(int temp) {
        result += temp;
        System.out.println(result);
    }

    int giveMeAllThreads() throws InterruptedException {
        Pattern pattern = Pattern.compile("[-]?\\d+");
        List<Thread> threads = new ArrayList<>();
        for (String str : array) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    StringBuilder tempSB = new StringBuilder();
                    try (BufferedReader reader = new BufferedReader(
                            new InputStreamReader(new FileInputStream(str), StandardCharsets.UTF_8))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            tempSB.append(line).append(" ");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Matcher matcher = pattern.matcher(tempSB.toString());
                    if (!matcher.find()) {
                        Thread.currentThread().interrupt();
                    }
                    while (matcher.find()) {
                        int tempInt = Integer.valueOf(matcher.group());
                        if (tempInt > 0 && tempInt % 2 == 0) {
                            sumAndPrint(tempInt);
                        }
                    }
                }
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread t : threads)
            t.join();
        return result;
    }
}

