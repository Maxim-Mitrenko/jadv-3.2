public class Shop {

    private final TaxService taxService;

    public Shop(TaxService taxService) {
        this.taxService = taxService;
    }

    public void endShift(long sum) {
        taxService.add(new Bill(sum));
    }
}