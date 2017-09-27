package Laba1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Пожалуйста введите имена файлов, каждое с новой строки, в конце нажмите Enter!");
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        List<String> list = new ArrayList<>();
//        String str;
//        while (!(str = bufferedReader.readLine()).equals("")) {
//            list.add(str);
//        }
        Parser parser = new Parser(args);
        System.out.println("Result: " + parser.giveMeAllThreads());
    }
}


