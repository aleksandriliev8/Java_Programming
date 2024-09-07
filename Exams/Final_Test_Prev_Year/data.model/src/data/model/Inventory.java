package data.model;

import java.security.InvalidParameterException;

public class Inventory {
    private final String ID;
    private Category category;
    private double price;
    private final String description;

    public Inventory(String ID, Category category, double price) {
        this.ID = ID;
        setCategory(category);
        setPrice(price);
        this.description = "Product - " + ID;
    }

    public String getId() {
        return ID;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        if(category == null){
            throw new InvalidParameterException();
        }
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price > 0){
            this.price = price;
        } else {
            this.price = 5.00;
        }
    }

    private String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("Product: %s\ncategory: %s\nprice: %.2f\nsuppliers: %s\n", ID, category, price, category.getSuppliers());
    }
}
