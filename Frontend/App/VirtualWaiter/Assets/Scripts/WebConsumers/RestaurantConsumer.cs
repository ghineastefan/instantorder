using System.Collections;
using System.Collections.Generic;
using System.Threading.Tasks;
using UnityEngine;

public class RestaurantConsumer : BaseConsumer {

    public static async Task<BaseEntityList> GetRestaurantTypesAsync()
    {
        return await Get<BaseEntityList>("{\"entityBases\":", "public/restaurant/find-all-restaurant-types","}");
    }
}
