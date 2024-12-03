package dev.compiani;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PeteBakerTest {
    @Test
    public void basicTest() {
        Map<String, Integer> recipe = new HashMap<>();
        recipe.put("flour", 500);
        recipe.put("sugar", 200);
        recipe.put("eggs", 1);

        Map<String, Integer> available = new HashMap<>();
        available.put("flour", 1200);
        available.put("sugar", 1200);
        available.put("eggs", 5);
        available.put("milk", 200);

        assertEquals("For recipe " + recipe + " and ingredients " + available, 2, PeteBaker.cakes(recipe, available));
    }

    @Test
    public void missingIngredient() {
        Map<String, Integer> recipe = new HashMap<>();
        recipe.put("flour", 500);
        recipe.put("sugar", 200);
        recipe.put("eggs", 1);
        recipe.put("cinnamon", 300);

        Map<String, Integer> available = new HashMap<>();
        available.put("flour", 1200);
        available.put("sugar", 1200);
        available.put("eggs", 5);
        available.put("milk", 200);

        assertEquals("For recipe " + recipe + " and ingredients " + available, 0, PeteBaker.cakes(recipe, available));
    }
}