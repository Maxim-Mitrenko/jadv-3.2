import java.util.concurrent.atomic.LongAdder;

public class TaxService {

    LongAdder longAdder = new LongAdder();

    public void add(Bill bill) {
        longAdder.add(bill.getSum());
    }

    @Override
    public String toString() {
        return "Выручка за день по городу: " + longAdder.sum();
    }
}