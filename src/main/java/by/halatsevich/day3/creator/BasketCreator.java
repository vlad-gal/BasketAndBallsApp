package by.halatsevich.day3.creator;

import by.halatsevich.day3.entity.Basket;
import by.halatsevich.day3.exception.InputDataException;
import by.halatsevich.day3.validator.BasketValidator;

import java.util.ArrayList;
import java.util.List;

public class BasketCreator {

    public List<Basket> createAllBaskets(List<double[]> basketsData) throws InputDataException {
        if (basketsData.isEmpty()) {
            throw new InputDataException("List with data to create baskets is empty");
        }
        List<Basket> baskets = new ArrayList<>();
        for (double[] data : basketsData) {
            baskets.add(createBasket(data));
        }
        return baskets;
    }

    public Basket createBasket(double[] basketData) throws InputDataException {
        if (basketData.length != 2 || basketData == null) {
            throw new InputDataException("Count of parameters is less or more than 2, or there is no parameters at all");
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
