package models;

public class Flower {
    private String manufacturerCountry;
    private int shelfLifeInDays;
    private String color;
    private int price;

    public Flower() {
    }

    public Flower(String manufacturerCountry, int shelfLifeInDays, String color, int price) {
        this.manufacturerCountry = manufacturerCountry;
        this.shelfLifeInDays = shelfLifeInDays;
        this.color = color;
        this.price = price;
    }

    public String getManufacturerCountry() {
        return manufacturerCountry;
    }

    public void setManufacturerCountry(String manufacturerCountry) {
        this.manufacturerCountry = manufacturerCountry;
    }

    public int getShelfLifeInDays() {
        return shelfLifeInDays;
    }

    public void setShelfLifeInDays(int shelfLifeInDays) {
        this.shelfLifeInDays = shelfLifeInDays;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return " models.Flower{" +
                "manufacturerCountry='" + manufacturerCountry + '\'' +
                ", shelfLifeInDays='" + shelfLifeInDays + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
