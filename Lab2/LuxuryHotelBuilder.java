public class LuxuryHotelBuilder extends HotelBuilder {
    private int roomCount;
    private double pricePerNight;
    private double premiumSurchargePercent;

    @Override
    public Hotel build() {
        if (!validate()) throw new IllegalStateException("Invalid luxury hotel configuration");
        Hotel hotel = new Hotel();
        hotel.setName(name);
        hotel.setCity(city);
        hotel.setStars(stars);
        hotel.setRoomCount(roomCount);
        hotel.setPricePerNight(pricePerNight * (1 + premiumSurchargePercent / 100.0));
        return hotel;
    }

    @Override
    public void reset() {
        name = null;
        city = null;
        stars = 0;
        roomCount = 0;
        pricePerNight = 0;
        premiumSurchargePercent = 0;
    }

    @Override
    public boolean validate() {
        return name != null && !name.isBlank()
            && city != null && !city.isBlank()
            && stars >= 4
            && roomCount > 0
            && pricePerNight > 0;
    }

    public double calculateEstimatedRevenue(int nights) {
        double price = pricePerNight * (1 + premiumSurchargePercent / 100.0);
        return price * roomCount * nights;
    }

    public LuxuryHotelBuilder withRoomCount(int roomCount) {
        this.roomCount = roomCount;
        return this;
    }

    public LuxuryHotelBuilder withPricePerNight(double p) {
        this.pricePerNight = p;
        return this;
    }

    public LuxuryHotelBuilder withPremiumSurchargePercent(double p) {
        this.premiumSurchargePercent = p;
        return this;
    }
}