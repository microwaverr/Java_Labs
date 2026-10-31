public class Main {
    public static void main(String[] args) {
        System.out.println("1. Director + LuxuryHotelBuilder");
        HotelDirector director = new HotelDirector(new LuxuryHotelBuilder());
        Hotel grand = director.buildLuxuryHotel("Grand Royale");
        System.out.println(grand.getFullDescription());
        System.out.println("Category - " + grand.getCategory()
                + "\nIs luxury - " + grand.isLuxury()
                + "\nPrice for 3 nights - " + String.format("%.2f", grand.calculateStayPrice(3)));

        System.out.println("\n2. Director + BudgetHotelBuilder");
        director.setBuilder(new BudgetHotelBuilder());
        Hotel economy = director.buildBudgetHotel("Sunrise Inn", "Казань");
        System.out.println(economy.getFullDescription());
        System.out.println("Category - " + economy.getCategory()
                + "\nPrice for 5 nights - " + economy.calculateStayPrice(5));

        System.out.println("\n3. Only one builder\n");
        LuxuryHotelBuilder lb = new LuxuryHotelBuilder();
        
        lb.withName("Sky Palace");
        lb.withCity("Сочи");
        lb.withStars(5);
        lb.withRoomCount(120);
        lb.withPricePerNight(420.0);
        lb.withPremiumSurchargePercent(15);
        
        Hotel custom = lb.build();
        System.out.println(custom.getFullDescription());
        System.out.println("Predicted salary for 10 days: "
                + String.format("%.2f", lb.calculateEstimatedRevenue(10)) + "\n");

        BudgetHotelBuilder bb = new BudgetHotelBuilder();
        
        bb.withName("Hostel Mini");
        bb.withCity("Тверь");
        bb.withStars(1);
        bb.withRoomCapacity(15);
        bb.withDiscountPercent(10);
        bb.withMinNightsForDiscount(7);
        
        Hotel small = bb.build();
        System.out.println(small.getFullDescription());
        System.out.println("Full price for 7 days with discount: "
                + String.format("%.2f", bb.calculateFinalPrice(small.getPricePerNight(), 7)));
    }
}