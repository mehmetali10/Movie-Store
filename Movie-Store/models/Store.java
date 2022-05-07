package models;

import java.util.ArrayList;

public class Store {
    ArrayList<Movie> collection;
    private double earnedMoney;

    public Store() {
        collection = new ArrayList<Movie>();
    }

    public Movie getMovie(int index) {
        if(index < collection.size()) {
            throw new IndexOutOfBoundsException("your index is greater than collection size");
        }
        return new Movie(collection.get(index));
    }

    public Movie getMovie(String movieName) {
        for(int i=0; i<collection.size(); i++) {
            if(collection.get(i).getName().equals(movieName)) {
                return collection.get(i);
            }
        }
        return null;
    }

    public void setMovie(int index, Movie movie) {
        collection.set(index, new Movie(movie));
    }

    public void addMovie(Movie movie) {
        collection.add(movie);
    }

    public void removeMovie(String name) {
        if(name.equals(null) || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        }
        for(int i=0; i<collection.size(); i++) {
            if(collection.get(i).getName().equalsIgnoreCase(name)) {
                collection.remove(i);
                System.out.println("removing movie action processed.");
            }
        }
    }

    public void removeMovie(Movie movie) {
        collection.remove(movie);
        System.out.println("removing movie action processed.");
    }


    public void action(String movieName, String action) {
        if(collection.isEmpty()) {
            throw new IllegalStateException("The collection list is empty.");
        }
        if(movieName.equals(null) || movieName.isBlank()) {
            throw new IllegalArgumentException("movie name cannot be null/blank");
        }
        switch(action) {
            case ("sell") : for(int i=0; i<collection.size(); i++) {
                              if(collection.get(i).getName().equalsIgnoreCase(movieName)) {
                                  if(!collection.get(i).isAvailable()) {
                                      System.out.println(movieName + " has been rented.");
                                  } else {
                                     earnedMoney += collection.get(i).getSellingPrice();
                                     this.removeMovie(movieName);
                                  }
                               }
                            }  break;

            case("rent") :  for(int i=0; i<collection.size(); i++) {
                              if(collection.get(i).getName().equalsIgnoreCase(movieName)) {
                                  earnedMoney += collection.get(i).getRentalPrice();
                                  collection.get(i).setAvailable(false);
                                }
                            }    break;
                            
            case("return") :    for(int i=0; i<collection.size(); i++) {
                                  if(collection.get(i).getName().equalsIgnoreCase(movieName)) {
                                    collection.get(i).setAvailable(true);
                                  }
                                }  break;
                                
            default:   System.out.println("invalid action");                    
        }
    }

    @Override
    public String toString() {
        String temp = "";
        for(int i=0; i<collection.size(); i++) {
            temp += collection.get(i).toString() + "\n\n"; 

        }
        return temp += "\tEarned money so far: " + this.earnedMoney;
    }
    
}
