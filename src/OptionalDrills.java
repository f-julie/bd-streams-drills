
import utilities.Car;
import utilities.Dish;
import utilities.Insurance;

import java.util.List;
import java.util.Optional;

public class OptionalDrills {

    /**
     * Print out the name of a dish that is vegetarian. If there is no vegetarian dish, do nothing.
     * @param menu - the list of dishes to look through
     */
    public static void printOutExampleVegetarianDish(List<Dish> menu) {
        //throw new UnsupportedOperationException();

        menu.stream()
                .filter(Dish::isVegetarian) // Assuming Dish has an isVegetarian() method
                .findFirst() // Get the first vegetarian dish
                .ifPresent(dish -> System.out.println(dish.getName())); // Print the name if present
    }

    /**
     * Return the name of the dish. There is a good chance the utilities.Dish coming in is null.
     * @param dish A dish (maybe null...)
     * @return the name of the dish if it exists
     */
    public static Optional<String> getDishName(Dish dish) {
        //throw new UnsupportedOperationException();

        return Optional.ofNullable(dish) // Wrap the dish in an Optional
                .map(Dish::getName); // Assuming Dish has a getName() method
    }

    /**
     * Return the name of the insurance for this car.
     * @param car A car
     * @return The name of the insurance if it exists
     */
    public static Optional<String> getExistingInsuranceName(Car car) {
        //throw new UnsupportedOperationException();

        //return Optional.ofNullable(car) // Wrap car in an Optional
        //        .map(Car::getInsurance) // Assuming Car has a getInsurance() method
        //        .map(Insurance::getName); // Call getName() on Insurance

        return Optional.ofNullable(car) // Wrap car in an Optional
                .flatMap(Car::getInsurance) // Assuming Car has a getInsurance() method
                .map(Insurance::getName); // Call getName() on Insurance

    }

    /**
     * Use the private 'otherService' method below to find the name of the
     * insurance that will be cheapest for me.  Be careful!
     * @param car A car
     * @return the name of the cheapest insurance if it exists
     */
    public static Optional<String> findCheapestInsuranceName(Car car) {
        //throw new UnsupportedOperationException();

        return Optional.ofNullable(car) // Wrap car in an Optional
                .map(OptionalDrills::otherService) // Call otherService
                .map(Insurance::getName); // Call getName() on Insurance
    }

    /**
     * Cool!  I wrote a new version of 'otherService' called
     * 'safeOtherService' that will never return null!  But now
     * the car being passed in is an Optional... what do I do???
     * @param car maybe a car?
     * @return the name of the car's cheapest insurance if it and the car exist
     */
    public static Optional<String> findCheapestInsuranceName(Optional<Car> car) {
        //throw new UnsupportedOperationException();

        //return car.flatMap(OptionalDrills::safeOtherService) // Use safeOtherService
        //        .map(Insurance::getName); // Call getName() on Insurance

        return car.map(OptionalDrills::safeOtherService) // Call safeOtherService, which returns Insurance
                .map(Insurance::getName); // Then map to get the name
    }

    /**
     * Tries to find the cheapest insurance, may be null.
     */
    private static Insurance otherService(Car car) {
        return null;
    }

    /**
     * Tries to find the cheapest insurance, may be null.
     */
    private static Insurance safeOtherService(Car car) {
        return new Insurance("Amazon utilities.Insurance");

        //return Optional.of(new Insurance("Amazon utilities.Insurance")); // Wrap the Insurance in an Optional
    }
}
