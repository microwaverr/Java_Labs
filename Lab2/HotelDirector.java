public class HotelDirector {
    private HotelBuilder builder;
    private String defaultCity;
    private int defaultStars;

    public HotelDirector(HotelBuilder builder) {
        this.builder = builder;
        this.defaultCity = "Москва";
        this.defaultStars = 3;
    }

    public Hotel buildLuxuryHotel(String name) {
        if (!(builder instanceof LuxuryHotelBuilder luxury))
            throw new IllegalStateException("Director requires LuxuryHotelBuilder");
        
        luxury.reset();
        luxury.withName(name);
        luxury.withCity(defaultCity);
        luxury.withStars(5);
        luxury.withRoomCount(250);
        luxury.withPricePerNight(350.0);
        luxury.withPremiumSurchargePercent(10);
        
        return luxury.build();
    }

    public Hotel buildBudgetHotel(String name, String city) {
        if (!(builder instanceof BudgetHotelBuilder budget))
            throw new IllegalStateException("Director requires BudgetHotelBuilder");
        
        budget.reset();
        budget.withName(name);
        budget.withCity(city);
        budget.withStars(2);
        budget.withRoomCapacity(40);
        budget.withDiscountPercent(15);
        budget.withMinNightsForDiscount(3);
        
        return budget.build();
    }

    public Hotel buildCustomHotel(String name, String city, int stars) {
        if (builder instanceof LuxuryHotelBuilder luxury) {
            luxury.reset();
            luxury.withName(name);
            luxury.withCity(city);
            luxury.withStars(stars);
            luxury.withRoomCount(rooms);
            luxury.withPricePerNight(price);
            return luxury.build();
        } 
        
        if (builder instanceof BudgetHotelBuilder budget) {
            budget.reset();
            budget.withName(name);
            budget.withCity(city);
            budget.withStars(stars);
            budget.withRoomCapacity(rooms);
            budget.withPricePerNight(price);
            return budget.build();
        }
        
        throw new IllegalStateException("Unknown builder type");
    }

    public void setBuilder(HotelBuilder builder) {
        this.builder = builder;
    }
}