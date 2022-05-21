import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int SHOPS = 3;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(SHOPS);
        TaxService taxService = new TaxService();
        Shop shop1 = new Shop(taxService);
        Shop shop2 = new Shop(taxService);
        Shop shop3 = new Shop(taxService);
        executorService.execute(() -> shop1.endShift(15000));
        executorService.execute(() -> shop2.endShift(20000));
        executorService.execute(() -> shop3.endShift(35000));
        try {
            executorService.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(taxService);
        executorService.shutdown();
    }
}