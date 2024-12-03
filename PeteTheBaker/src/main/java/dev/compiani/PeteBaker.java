package dev.compiani;

import java.util.HashMap;
import java.util.Map;

public class PeteBaker {
    public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {
        Map<String, Integer> mutable = new HashMap<>(available);
        int cakes = 0;
        if (!recipe.entrySet().stream().allMatch(recipeItem -> mutable.containsKey(recipeItem.getKey()))) {
            return cakes;
        }

        while (mutable.entrySet().stream().allMatch(recipeItem -> recipeItem.getValue() >= 0)) {
            for (Map.Entry<String, Integer> recipeItem : recipe.entrySet()) {
                mutable.put(recipeItem.getKey(), mutable.get(recipeItem.getKey()) - recipeItem.getValue());
            }

            cakes++;
        }

        return --cakes;
    }
}
