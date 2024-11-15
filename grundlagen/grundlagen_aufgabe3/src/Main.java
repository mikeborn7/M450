class TestPriceCalculation {

    // Methode zum Testen der Preisberechnung
    public static boolean test_calculate_price() {
        boolean test_ok = true;

        // Test: Grundlegende Überprüfung der Berechnung
        double price = calculatePrice(1000, 200, 300, 2, 5);
        if (Math.abs(price - 1450) > 0.01) {
            System.out.println("Test fehlgeschlagen: " + price);
            test_ok = false;
        }

        return test_ok;
    }

    public static void main(String[] args) {
        TestPriceCalculation test = new TestPriceCalculation();
        if (test.test_calculate_price()) {
            System.out.println("Test erfolgreich bestanden.");
        } else {
            System.out.println("Test fehlgeschlagen.");
        }
    }

    // Beispielmethode zur Preisberechnung
    public static double calculatePrice(double baseprice, double specialprice, double extraprice, int extras, double discount) {
        double addon_discount = (extras >= 5) ? 15 : (extras >= 3) ? 10 : 0;
        addon_discount = Math.max(addon_discount, discount);

        return baseprice * (1 - discount / 100.0) + specialprice
                + extraprice * (1 - addon_discount / 100.0);
    }
}
