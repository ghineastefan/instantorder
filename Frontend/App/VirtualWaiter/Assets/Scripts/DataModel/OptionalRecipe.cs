using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class OptionalRecipe : EntityBaseModel {
    
    public string SubMenuId { get; set; }
    
    public string CategoryId { get; set; }

    public bool IsRequired { get; set; }

    public double Price { get; set; }
}
