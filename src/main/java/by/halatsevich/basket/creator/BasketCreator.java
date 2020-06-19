package by.halatsevich.basket.creator;

import by.halatsevich.basket.entity.Basket;
import by.halatsevich.basket.exception.InputDataException;
import by.halatsevich.basket.validator.BasketValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to create baskets
 *
 * @author Vladislav Halatsevich
 */
public class BasketCreator {

    /**
     * Create list of baskets
     *
     * @param basketsData list of data to create list of baskets
     * @return list of baskets
     * @throws InputDataException if data to create baskets are null or empty
     */
    public List<Basket> createAllBaskets(List<double[]> basketsData) throws InputDataException {
        if (basketsData == null) {
            throw new InputDataException("Data to create baskets are null");
        }
        if (basketsData.isEmpty()) {
            throw new InputDataException("List with data to create baskets is empty");
        }
        List<Basket> baskets = new ArrayList<>();
        for (double[] data : basketsData) {
            baskets.add(createBasket(data));
        }
        return baskets;
    }

    /**
     * Create a basket
     *
     * @param basketData data to create basket
     * @return basket
     * @throws InputDataException if data to create basket are null or count of params are less or more than 2,
     *                            or data incorrect
     */
    public Basket createBasket(double[] basketData) throws InputDataException {
        if (basketData == null) {
            throw new InputDataException("Data to create basket are null");
        }
        if (basketData.length != 2) {
            throw new InputDataException("Count of parameters is less or more than 2");
        }
        double weightCapacity = basketData[0];
        double basketVolume = basketData[1];
        if (!BasketValidator.isValidCapacity(weightCapacity)
                || !BasketValidator.isValidVolume(basketVolume)) {
            throw new InputDataException("Invalid data to create basket");
        }
        return new Basket(weightCapacity, basketVolume);
    }
}
