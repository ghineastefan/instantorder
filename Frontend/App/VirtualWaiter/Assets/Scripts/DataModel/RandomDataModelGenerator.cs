using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RandomDataModelGenerator {

    public static Ingredient GetRandomIngredient() {
        return new Ingredient("Apple","KG");
    }

    public static Recipe GetRandomRecipe()
    {
        return  new Recipe("Pie", "The best pie ever", 30, 
                new List<IngredientQuantity>() { new IngredientQuantity(GetRandomIngredient(), 1.5),
                new IngredientQuantity(GetRandomIngredient(),0.6) });
    }

    public static SubMenu GetRandomSubMenu()
    {
        return new SubMenu("Pie + Cola", "pie", new List<Recipe>() { GetRandomRecipe(), GetRandomRecipe() });
    }

    public static Menu GetRandomMenu()
    {
        return new Menu("Every day menu", "Come eat our best food!", new List<SubMenuPrice>() {
            new SubMenuPrice(GetRandomSubMenu(),12.5,15),
            new SubMenuPrice(GetRandomSubMenu(),11.5,30),
            new SubMenuPrice(GetRandomSubMenu(),19.5,20),
            new SubMenuPrice(GetRandomSubMenu(),2.5,20)
        }) ;
    }
}
