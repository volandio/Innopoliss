package Labs.Laba1;

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
    private volatile boolean isActive = true;
    List<Integer> resultList = new ArrayList<>();

    Parser(String[] array) {
        this.array = array;
    }

    private synchronized void sumAndPrint(int temp) {
        resultList.add(temp);
        System.out.println(resultList.stream().mapToInt(a -> a).sum());
    }

    private void stopWork() {
        isActive = false;
    }

    int giveMeAllThreads() throws InterruptedException {
        Pattern pattern = Pattern.compile("[-]?\\d+");
        List<Thread> threads = new ArrayList<>();
        for (String str : array) {
            Thread thread = new Thread(() -> {
                while (isActive) {
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
                    while (matcher.find()) {
                        int tempInt = Integer.valueOf(matcher.group());
                        if (tempInt > 0 && tempInt % 2 == 0) {
                            sumAndPrint(tempInt);
                        }
                    }
                    return;
                }
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread t : threads)
            t.join();
        if (!isActive) {
            System.out.println("Имеются файлы с неподходящими данными! Результат суммы не верен!");
        }
        return resultList.stream().mapToInt(a -> a).sum();
    }
}

