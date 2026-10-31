public class BudgetHotelBuilder extends HotelBuilder {
    private int roomCapacity;
    private double discountPercent;
    private int minNightsForDiscount;

    @Override
    public Hotel build() {
        if (!validate()) throw new IllegalStateException("Invalid budget hotel configuration");
        Hotel hotel = new Hotel();
        hotel.setName(name);
        hotel.setCity(city);
        hotel.setStars(stars);
        hotel.setRoomCount(roomCapacity);
        hotel.setPricePerNight(100.0 / roomCapacity);
        return hotel;
    }

    @Override
    public void reset() {
        name = null;
        city = null;
        stars = 0;
        roomCapacity = 0;
        discountPercent = 0;
        minNightsForDiscount = 0;
    }

    @Override
    public boolean validate() {
        return name != null && !name.isBlank()
            && city != null && !city.isBlank()
            && stars >= 1 && stars <= 3
            && roomCapacity > 0
            && discountPercent >= 0 && discountPercent <= 100;
    }

    public double calculateFinalPrice(double pricePerNight, int nights) {
        double total = pricePerNight * nights;
        if (nights >= minNightsForDiscount) {
            total *= (1 - discountPercent / 100.0);
        }
        return total;
    }

    public BudgetHotelBuilder withRoomCapacity(int c) {
        this.roomCapacity = c;
        return this;
    }

    public BudgetHotelBuilder withDiscountPercent(double d) {
        this.discountPercent = d;
        return this;
    }

    public BudgetHotelBuilder withMinNightsForDiscount(int n) {
        this.minNightsForDiscount = n;
        return this;
    }
}