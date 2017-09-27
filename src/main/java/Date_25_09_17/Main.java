package Date_25_09_17;

public class Main {
    public static void main(String[] args) {
        Summator summator = new Summator();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    summator.addProduct(0,0,1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    summator.addProduct(0,1,0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    summator.addProduct(1,0,0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread3.start();

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    summator.addProduct(0,0,1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread4.start();

        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    summator.addProduct(0,1,0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread5.start();

        Thread thread6 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    summator.addProduct(1,0,0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread6.start();
        System.out.println(BeerWare.countBeer +" " + BreadWare.countBread + " " + MilkWare.countMilk);
    }
}
