import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.Movie;
import models.Store;

public class Main {

    static Store store = new Store();
        public static void main(String[] args) {

            System.out.println("\t\t****WELCOME TO THE JAVA VİDEO STORE****");
             try {
                 loadMovies("movies.txt");
             } catch(FileNotFoundException e) {
                 e.getMessage();
             } finally {
                System.out.println("MOVIES LOADED\n\n");
                System.out.println(store);
                manageMovies();
             }

        }

        
        public static void loadMovies(String fileName) throws FileNotFoundException  {
            FileInputStream fis = new FileInputStream(fileName);
            Scanner scan = new Scanner(fis);
            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] arr = line.split("--");
                store.addMovie(new Movie(arr[0], arr[1], Double.parseDouble(arr[2])));
            }
            scan.close();
        }


        public static void manageMovies() {
            Scanner scan = new Scanner(System.in);

            while(true) {
                System.out.println("\nWould you like to \n\ta) purchase\n\tb) rent \n\tc) return \n\td) exit.");
                String option = scan.nextLine();

                if(option.isBlank()) {
                    System.out.println("\n\nchoose option a,b,c or d\n"); 
                }

                if(option.equalsIgnoreCase("a")) {
                    System.out.println("Enter the movie name that you want to buy: ");
                    String movieName = scan.nextLine();

                    if(movieName.isBlank()) {
                        System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                    } else {
                        if(store.getMovie(movieName).isAvailable()) {
                            store.action(movieName, "sell");
                        }else {
                            System.out.println("\n\n\n\nThe movie is not available for purchase. Please try again\n");
                        }
                    }
                    

                } else if(option.equalsIgnoreCase("b")) {
                    System.out.println("Enter the movie name that you want to rent: ");
                    String movieName = scan.nextLine();

                    if(movieName.isBlank()) {
                        System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                    } else {
                        store.action(movieName, "rent");
                    }

                } else if(option.equalsIgnoreCase("c")) {
                    System.out.println("Enter the movie name that you want to return: ");
                    String movieName = scan.nextLine();
                    if(movieName.isBlank()) {
                        System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                    } else {
                        store.action(movieName, "return");
                    }

                } else if(option.equalsIgnoreCase("d")){
                    break;
                }
                System.out.println("\n\nUPDATED MOVIES\n\n" + store);
            }
            scan.close();

        }

}