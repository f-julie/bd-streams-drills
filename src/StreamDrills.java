
import utilities.Dish;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * To solve these you may need to go look at the stream java docs and look at what methods are available.
 * https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
 */
public class StreamDrills {

    /**
     * Return only the dishes that are vegetarian.
     * @param menu every dish on the menu
     * @return a list of all of the vegetarian dishes on the menu
     */
    public static List<Dish> vegetarianDishes(List<Dish> menu) {
        //throw new UnsupportedOperationException();

        return menu.stream() // Step 1: Create a stream from the menu
                .filter(Dish::isVegetarian) // Step 2: Filter for vegetarian dishes
                .collect(Collectors.toList()); // Step 3: Collect the results into a List
    }

    /**
     * Return all unique even numbers.
     * @param numbers a list of numbers
     * @return all of the unique, even numbers in the list
     */
    public static List<Integer> uniqueEvenNumbers(List<Integer> numbers) {
        //throw new UnsupportedOperationException();

        return numbers.stream() // Step 1: Create a stream from the list
                .filter(n -> n % 2 == 0) // Step 2: Filter for even numbers
                .distinct() // Step 3: Ensure uniqueness
                .collect(Collectors.toList()); // Step 4: Collect into a List
    }

    /**
     * Return the length of each dish's name.
     * @param menu every dish on the menu
     * @return a list with the length of each dish's name.
     */
    public static List<Integer> lengthOfDishNames(List<Dish> menu) {
        //throw new UnsupportedOperationException();

        return menu.stream() // Step 1: Create a stream from the list
                .map(dish -> dish.getName().length()) // Step 2: Map to the length of each dish's name
                .collect(Collectors.toList()); // Step 3: Collect into a List

    }

    /**
     * Can a vegetarian eat anything at this restaurant????
     * @param menu every dish on the menu
     * @return true, if there is at least one vegetarian dish on the menu
     */
    public static boolean isMenuVegetarianFriendly(List<Dish> menu) {
        //throw new UnsupportedOperationException();

        return menu.stream() // Step 1: Create a stream from the list
                .anyMatch(Dish::isVegetarian); // Step 2: Check if any dish is vegetarian
    }

    /**
     * What's an example of a dish I can eat as a vegetarian?  If I can eat anything...
     * @param menu every dish on the menu
     * @return a vegetarian dish, if one exists on the menu
     */
    public static Optional<Dish> vegetarianDish(List<Dish> menu) {
        //throw new UnsupportedOperationException();

        return menu.stream() // Step 1: Create a stream from the list
                .filter(Dish::isVegetarian) // Step 2: Filter for vegetarian dishes
                .findFirst(); // Step 3: Return the first vegetarian dish as an Optional
    }

    /**
     * Is everything on the menu under 1000 calories?
     * @param menu every dish on the menu
     * @return true, if every dish on the menu is under 1,000 calories
     */
    public static boolean isEverythingUnder1000Calories(List<Dish> menu) {
        //throw new UnsupportedOperationException();

        return menu.stream() // Step 1: Create a stream from the list
                .allMatch(dish -> dish.getCalories() < 1000); // Step 2: Check if all dishes are under 1000 calories
    }

    /**
     * We want to validate our menu to make sure there is nothing over 1,000 calories.
     * @param menu every dish on the menu
     * @return true, if there isn't a dish on the menu over 1,000 calories
     */
    public static boolean isNothingOver1000Calories(List<Dish> menu) {
        //throw new UnsupportedOperationException();

        return menu.stream() // Step 1: Create a stream from the list
                .noneMatch(dish -> dish.getCalories() > 1000); // Step 2: Check if no dishes are over 1000 calories
    }

    /**
     * Return any 3 names of dishes where the calories are greater than 300.
     * @param menu every dish on the menu
     * @return the name of 3 dishes with more than 300 calories
     */
    public static List<String> threeHighCaloricDishNames(List<Dish> menu) {
        //throw new UnsupportedOperationException();

        return menu.stream() // Step 1: Create a stream from the list
                .filter(dish -> dish.getCalories() > 300) // Step 2: Filter for dishes over 300 calories
                .limit(3) // Step 3: Limit to the first 3 dishes
                .map(Dish::getName) // Step 4: Map to the names of the dishes
                .collect(Collectors.toList()); // Step 5: Collect into a List
    }

    /**
     * How many dishes are on the menu?
     * @param menu every dish on the menu
     * @return the number of dishes on the menu
     */
    public static long howManyDishes(List<Dish> menu) {
        //throw new UnsupportedOperationException();

        return menu.stream() // Step 1: Create a stream from the list
                .count(); // Step 2: Count the number of dishes
    }

    /**
     * List the countries of origin for the menu.
     * @param menu every dish on the menu
     * @return the country of origin for every dish
     */
    public static Set<String> listCountriesOfOrigin(List<Dish> menu) {
        //throw new UnsupportedOperationException();

        return menu.stream() // Step 1: Create a stream from the list
                .map(dish -> {
                    try {
                        return dish.getCountryOfOrigin(); // Attempt to get the country of origin
                    } catch (Exception e) {
                        // Handle the exception (e.g., log it or return a default value)
                        return null; // Or some default country, or you could filter it out later
                    }
                })
                .filter(Objects::nonNull) // Remove any null values that may have resulted from exceptions
                .collect(Collectors.toSet()); // Step 3: Collect into a Set for uniqueness
    }

}
