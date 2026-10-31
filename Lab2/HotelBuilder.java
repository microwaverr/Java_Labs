public abstract class HotelBuilder {
    protected String name;
    protected String city;
    protected int stars;

    public abstract Hotel build();
    public abstract void reset();
    public abstract boolean validate();

    public HotelBuilder withName(String name) { this.name = name; return this; }
    public HotelBuilder withCity(String city) { this.city = city; return this; }
    public HotelBuilder withStars(int stars) { this.stars = stars; return this; }
}