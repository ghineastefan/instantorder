using System.Collections.Generic;

public class Recipe : EntityBaseModel, IDescriptable {

    public string Description { get; set; }

    public int CookTime;

    public List<IngredientQuantity> IngredientQuantities;

    public Recipe(string id, string description, int cookTime, List<IngredientQuantity> ingredientQuantities)
    {
        base.id = id;
        Description = description;
        CookTime = cookTime;
        IngredientQuantities = ingredientQuantities;
    }
}

public class IngredientQuantity
{
    public Ingredient ingredient;

    public double quantity;

    public IngredientQuantity(Ingredient ingredient, double quantity)
    {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }
}

