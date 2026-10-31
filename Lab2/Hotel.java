public class Hotel {
    private String name;
    private String city;
    private int stars;
    private int roomCount;
    private double pricePerNight;

    public Hotel() { }

    public String getName() { return name; }
    public String getCity() { return city; }
    public int getStars() { return stars; }
    public int getRoomCount() { return roomCount; }
    public double getPricePerNight() { return pricePerNight; }

    public void setName(String name) { this.name = name; }
    public void setCity(String city) { this.city = city; }
    public void setStars(int stars) { this.stars = stars; }
    public void setRoomCount(int roomCount) { this.roomCount = roomCount; }
    public void setPricePerNight(double price) { this.pricePerNight = price; }

    public double calculateStayPrice(int nights) {
        if (nights <= 0) throw new IllegalArgumentException("nights must be > 0");
        return pricePerNight * nights;
    }

    public String getCategory() {
        if (stars >= 5) return "Luxury";
        if (stars >= 4) return "Business";
        if (stars >= 3) return "Standard";
        return "Economy";
    }

    public boolean isLuxury() {
        return stars >= 5 && pricePerNight >= 200;
    }

    public String getFullDescription() {
        return String.format(
            "Hotel{name='%s', city='%s', stars=%d, rooms=%d, price per night=%.2f}",
            name, city, stars, roomCount, pricePerNight);
    }
}