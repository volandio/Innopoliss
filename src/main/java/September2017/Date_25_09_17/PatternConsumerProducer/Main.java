package September2017.Date_25_09_17.PatternConsumerProducer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static int counter = 0;

    public static void main(String[] args) throws IOException, InterruptedException {

        final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Thread producer = new Thread("PRODUCER") {
            public void run() {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader
                        (new FileInputStream("book1.txt")))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        queue.put(line);
                    }
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        };
        producer.start();

        Thread consumer = new Thread("CONSUMER") {
            public void run() {
                try {
                    String temp;
                    Pattern pattern = Pattern.compile("страдания");
                    while ((temp = queue.take()) != null) {
                        Matcher matcher = pattern.matcher(temp);
                        while (matcher.find()) {
                            counter++;
                            System.out.println(counter);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        consumer.start();
    }
}
