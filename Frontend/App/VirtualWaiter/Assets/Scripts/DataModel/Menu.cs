using System.Collections.Generic;

public class Menu : EntityBaseModel {

    public string Description { get; set; }

    public List<SubMenuPrice> SubMenuPrices;

    public Menu(string id, string description, List<SubMenuPrice> subMenuPrices)
    {
        Id = id;
        Description = description;
        SubMenuPrices = subMenuPrices;
    }
}

public class SubMenuPrice
{
    public SubMenu SubMenu;

    public double Price;

    public double OnSale;

    public SubMenuPrice(SubMenu subMenu, double price, double onSale)
    {
        SubMenu = subMenu;
        Price = price;
        OnSale = onSale;
    }
}