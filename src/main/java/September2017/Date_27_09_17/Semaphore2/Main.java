package September2017.Date_27_09_17.Semaphore2;

public class Main {
    public static void main(String[] args) {

        final AddProduct ap = new AddProduct();
        for (int i=0; i<3;i++) // Beer
        {
            Thread thr = new Thread(new Runnable() {
                @Override
                public void run() {
                 while(true) {
                     int[] mass = new int[3];
                     mass[0] = 1;
                     mass[1] = 0;
                     mass[2] = 0;
                     try {
                         ap.Add(mass);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
                }
            });
          thr.start();
        }

        for (int i=0; i<3;i++) // Bread
        {
            Thread thr = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        int[] mass = new int[3];
                        mass[0] = 0;
                        mass[1] = 1;
                        mass[2] = 0;
                        try {
                            ap.Add(mass);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thr.start();
        }
        for (int i=0; i<3;i++) // Milk
        {
            Thread thr = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        int[] mass = new int[3];
                        mass[0] = 0;
                        mass[1] = 0;
                        mass[2] = 1;
                        try {
                            ap.Add(mass);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thr.start();
        }

        while (true)
        {

            System.out.println(MilkWare.Count + " " + BeerWare.Count+ " " + BreadWare.Count);
        }
    }


}
