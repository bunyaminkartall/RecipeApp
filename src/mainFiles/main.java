package mainFiles;              
//We need to declare our package.

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import classes.*;
//And also we need to import our class package.




public class Main{
    public static void main(String[] args) throws FileNotFoundException{
        RecipeCreator rc = new RecipeCreator();
        ValuesOfFoods vof = new ValuesOfFoods();
        //We are contruct our class here except one RandomMenu class because we need that class's contructor much later.

        String disp = "--------";

        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("\033[H\033[2J");
            // This will clear the console.
            disp("Main Menu");
            System.out.println("1. Own Ingredients to Recipe");
            // Allows user to create a recipe using their own ingredients.
            System.out.println("2. Nutritional Values of Dishes");
            // Provides nutritional values of dishes.
            System.out.println("3. Random Menu"); 
            // Generates a random menu.
            System.out.println("4. Exit");
            // Exits the program.

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            
            

            switch (choice) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    disp("Own Ingredients to Recipe");
                    rc.getUserIngredients();
                    // Get user's ingredients.
                    rc.IngredientsSearch();
                    // Search for ingredients.
                    
                    rc.ask();
                    // Ask user to continue to search another recipe or get back to menu.
                    
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    disp("Nutritional Values of Dishes");
                    vof.searchFood();
                    // Get a dish name from user and search it from our database automatically.
                    vof.ask();
                    // Ask user to continue to look another dish or get back to menu.
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    RandomMenu rm = new RandomMenu("lunchPrep/src/datas/foodlist.txt", "lunchPrep/src/datas/souplist.txt");
                    rm.getMenu();
                    // Print out randomly generated menu.
                    rm.ask();
                    // Ask user to continue to search another recipe or get back to main menu.
                    break;

                case 4:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
            
        } while (choice != 4);
        // Continue the loop until user chooses to exit.
    }
    // Method to display a title on the console.
    public static void disp (String menu){
        String disp = "--------";
        System.out.println(disp+menu+disp);
        
    }
}

    
  

            

    
        


    


