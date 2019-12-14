using System.Collections.Generic;

public class SubMenu : EntityBaseModel {

    public string PathToPhoto;

    public List<Recipe> Recipes;

    public List<OptionalRecipe> OptionalRecipes;

    public SubMenu() : base()
    {
        Recipes = new List<Recipe>();
        OptionalRecipes = new List<OptionalRecipe>();
    }

    public SubMenu(string id, string pathToPhoto, List<Recipe> recipes) : this()
    {
        base.id = id;
        Recipes = new List<Recipe>();
        PathToPhoto = pathToPhoto;
        OptionalRecipes = new List<OptionalRecipe>();
    }

    public SubMenu(string id, string pathToPhoto, List<Recipe> recipes, List<OptionalRecipe> optionalRecipes)
    {
        base.id = id;
        Recipes = recipes;
        PathToPhoto = pathToPhoto;
        OptionalRecipes = optionalRecipes;
    }
}
