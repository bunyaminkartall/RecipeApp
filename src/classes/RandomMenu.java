package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomMenu extends RecipeCreator {
    // Lists to store food and soup recipes
    private List<String> foodRecipes = new ArrayList<>(6);
    private List<String> soupRecipes = new ArrayList<>(6);

    // Constructor to initialize recipes from file data
    public RandomMenu(String filename1, String filename2) throws FileNotFoundException {
        File file1 = new File(filename1);
        File file2 = new File(filename2);
        Scanner scanner1 = new Scanner(file1);
        Scanner scanner2 = new Scanner(file2);

        // Populate foodRecipes list
        while (scanner1.hasNextLine()) {
            String line = scanner1.nextLine();
            if (line.startsWith("Ingredients:")) {
                foodRecipes.add(scanner1.nextLine() + "\n" + line + "\n" + scanner1.nextLine() + "\n" +
                                scanner1.nextLine() + "\n" + scanner1.nextLine() + "\n" + scanner1.nextLine());
            }
        }

        // Populate soupRecipes list
        while (scanner2.hasNextLine()) {
            String line = scanner2.nextLine();
            if (line.startsWith("Ingredients:")) {
                soupRecipes.add(scanner2.nextLine() + "\n" + line + "\n" + scanner2.nextLine() + "\n" +
                                scanner2.nextLine() + "\n" + scanner2.nextLine() + "\n" + scanner2.nextLine());
            }
        }
    }

    // Method to get a random recipe from the given list
    public String getRandomRecipe(List<String> recipes) {
        Random random = new Random();
        int index = random.nextInt(recipes.size());
        return recipes.get(index);
    }

    // Method to display the random menu
    public void getMenu() {
        String foodRecipe = getRandomRecipe(foodRecipes);
        String soupRecipe = getRandomRecipe(soupRecipes);
        disp("Today's Menu");
        System.out.println(foodRecipe.split("\n")[0] + "\n");
        System.out.println(foodRecipe.split("\n")[1]);
        System.out.println(foodRecipe.split("\n")[2]);
        System.out.println(foodRecipe.split("\n")[4]);
        System.out.println(foodRecipe.split("\n")[5] + "\n" + "\n");

        System.out.println(soupRecipe.split("\n")[0] + "\n");
        System.out.println(soupRecipe.split("\n")[1]);
        System.out.println(soupRecipe.split("\n")[2]);
        System.out.println(foodRecipe.split("\n")[4]);
        System.out.println(foodRecipe.split("\n")[5] + "\n");
    }

    // Method to prompt user for further actions
    @Override
    public void ask() {
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        System.out.printf("If you want another menu, press 1. If you want to go back to the main menu, press 2: ");
        String option = sc.nextLine();

        switch (Integer.parseInt(option)) {
            case 1:
                System.out.print("\033[H\033[2J");
                disp("Own Ingredients to Recipe");
                getMenu();
                this.ask();
                break;
            case 2:
                break;
            default:
                System.out.println("Invalid Option");
                this.ask();
        }
    }
}
