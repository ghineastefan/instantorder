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
        Id = id;
        Recipes = new List<Recipe>();
        PathToPhoto = pathToPhoto;
        OptionalRecipes = new List<OptionalRecipe>();
    }

    public SubMenu(string id, string pathToPhoto, List<Recipe> recipes, List<OptionalRecipe> optionalRecipes)
    {
        Id = id;
        Recipes = recipes;
        PathToPhoto = pathToPhoto;
        OptionalRecipes = optionalRecipes;
    }
}
