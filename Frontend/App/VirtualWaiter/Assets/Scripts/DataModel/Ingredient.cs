﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Ingredient : EntityBaseModel {

    public string QuantityType;

    public Ingredient(string id, string quantityType)
    {
        Id = id;
        QuantityType = quantityType;
    }
}