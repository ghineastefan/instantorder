using System.Collections;
using System.Collections.Generic;
using System.Threading.Tasks;
using UnityEngine;

public class AdminManager : MonoBehaviour
{

    public GameObject Log;

    private Logger logger;

    private Task<BaseEntityList> restaurantTypesTask;
    
    // Start is called before the first frame update
    void Start()
    {
        logger = Log.GetComponent<Logger>();
        restaurantTypesTask = RestaurantConsumer.GetRestaurantTypesAsync();
    }

    // Update is called once per frame
    void Update()
    {
        if (restaurantTypesTask.IsCompleted)
        {
            string resTypesList = "";
            
            new List<EntityBaseModel>(restaurantTypesTask.Result.entityBases).ForEach(x => resTypesList += x.id.ToString() + "\n");

            Debug.Log(resTypesList);
            logger.Log("" + resTypesList);
        }
    }
}
