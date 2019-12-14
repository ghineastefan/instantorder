using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ResourceManager {

    public static Sprite GetSpriteFromPath(string restaurantId, string photoPath)
    {
        var sprt =  Resources.Load<Sprite>(restaurantId + "\\" + photoPath);
    
        if(sprt == null)
        {
            throw new System.Exception("Sprite not found");
        }

        return sprt;
    }
}
