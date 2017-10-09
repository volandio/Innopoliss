package September2017.Date_27_09_17.Semaphore2;

public class AddProduct {
    boolean isZanyato1 = false;
    boolean isZanyato2 = false;
    boolean isZanyato3 = false;


    public void Add(int[] a) throws InterruptedException {
        if (a[0] != 0) {
            AddMilk(a[0]);
        }
        if (a[1] != 0) {
            AddBeer(a[1]);
        }

        if (a[2] != 0) {
            AddBread(a[2]);
        }
    }

    private void AddMilk(int count) throws InterruptedException {
        while (isZanyato1) {
            Thread.yield();
        }
        isZanyato1 = true;
//        synchronized (MilkWare.class) {
            Thread.sleep(1000);
            MilkWare.Count += count;
//        }
        isZanyato1 = false;
    }

    private void AddBeer(int count) throws InterruptedException {
        while (isZanyato2) {
            Thread.yield();
        }
        isZanyato2 = true;
//        synchronized (BeerWare.class) {
            Thread.sleep(1000);
            BeerWare.Count += count;
//        }
        isZanyato2 = false;
    }

    private synchronized void AddBread(int count) throws InterruptedException {
        while (isZanyato3) {
            Thread.yield();
        }
//        synchronized (BreadWare.class) {
            Thread.sleep(1000);
            BreadWare.Count += count;
//        }
        isZanyato3 = false;
    }


}
