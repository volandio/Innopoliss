package Date_25_09_17;

public class Summator {
    boolean booleanThreadBeer;
    boolean booleanThreadMilk;
    boolean booleanThreadBread;

    void addProduct(int countBread, int countMilk, int countBeer) throws InterruptedException {
        if (countBread == 0 && countMilk == 0 && countBeer != 0) {

            addBeerWare();
        }
        if (countBread == 0 && countMilk != 0 && countBeer == 0) {
            addMilkWare();
        }
        if (countBread != 0 && countMilk == 0 && countBeer == 0) {
            addBreadWare();
        }
    }

    synchronized void addBeerWare() throws InterruptedException {
        while (booleanThreadBeer) {
            Thread.yield();
        }
        booleanThreadBeer = true;
        BeerWare.countBeer++;
        booleanThreadBeer= false;
        notify();
    }


    synchronized void addMilkWare() throws InterruptedException {
        while (booleanThreadMilk) {
            Thread.yield();
        }
        booleanThreadMilk = true;
        MilkWare.countMilk++;
        booleanThreadMilk = false;
        notify();
    }

    synchronized void addBreadWare() throws InterruptedException {
        while (booleanThreadBread) {
            Thread.yield();
        }
        booleanThreadBread = true;
        BreadWare.countBread++;
        booleanThreadBread = false;
        notify();
    }
}
