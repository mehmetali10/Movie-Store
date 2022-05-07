package models;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable = true;

    public Movie(String name, String format, double rating) {
        //unchecked exceptions
        if(!format.equalsIgnoreCase("dvd") && !format.equalsIgnoreCase("blue-ray")) {
            throw new IllegalArgumentException("format must be dvd/blue-ray");
        }
        if(rating > 10 || rating < 0) {
            throw new IllegalArgumentException("rating must be between 0-10");
        }
        if(name.equals(null) || name.isBlank() || format.equals(null) || format.isBlank()) {
            throw new IllegalArgumentException("MovieName / format cannot be null/blank");
        }
        //thisequals
        this.name = name;
        this.format = format;
        this.rating = rating;
        //sellingprice
        this.sellingPrice = format.equalsIgnoreCase("DVD") ? 2.25 : 4.25;
        //rentalprice
        this.rentalPrice = format.equalsIgnoreCase("dvd") ? 0.99 : 1.99;
     }

     public Movie(Movie source) {
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
        this.sellingPrice = source.getSellingPrice();
        this.rentalPrice = source.getRentalPrice();
        this.isAvailable = source.isAvailable();
     }


     public String getName() {
         return name;
     }

     public void setName(String name) {
         if(name.equals(null) || name.isBlank()) {
             throw new IllegalArgumentException("name cannot be null/blank");
         }
         this.name = name;
     }

     public String getFormat() {
         return format;
     }

     //here has todo-update prices
     public void setFormat(String format) {
        if(format.equalsIgnoreCase("Dvd") || !format.equalsIgnoreCase("blue-ray")) {
            throw new IllegalArgumentException("format must be dvd/blue-ray");
        }
         this.format = format;
         this.sellingPrice = format.equalsIgnoreCase("dvd") ? 2.25 : 4.25;
         this.rentalPrice = format.equalsIgnoreCase("dvd") ? 0.99 : 1.99;
     }

     public double getSellingPrice() {
         return sellingPrice;
     }

     private void setSellingPrice(double price) {
         if(price < 0) {
             throw new IllegalArgumentException("price cannot be negative");
         }
         this.sellingPrice = price;
     }

     private void setRentalPrice(double rentalPrice) {
        if(rentalPrice < 0) {
            throw new IllegalArgumentException("price cannot be negative");
        }
         this.rentalPrice = rentalPrice;
     }

     public double getRentalPrice() {
         return rentalPrice;
     }

     public double getRating() {
         return rating;
     }

     public void setRating(double rating) {
        if(rating > 10 || rating < 0) {
            throw new IllegalArgumentException("rating must be between 0-10");
        }
         this.rating = rating;
     }

     public boolean isAvailable() {
         return this.isAvailable;
     }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

     @Override
     public String toString() {
        return "\t Name: " + this.name + "\n" +

        "\t Format: " + this.format + "\n" +
        
        "\t Rating: " + this.rating + "\n" +
        
        "\t Selling Price: " + this.sellingPrice + "\n" +
        
        "\t Rental Price: " + this.rentalPrice + "\n" +
        
        "\t Availability: " + (this.isAvailable ? "in-stock" : "rented") + "\n";
     }

 }
