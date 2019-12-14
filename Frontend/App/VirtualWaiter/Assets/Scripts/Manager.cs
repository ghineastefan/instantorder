using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Manager : MonoBehaviour
{

    public Text MenuId;
    public Text DescriptionMenu;

    private Menu menuDataModel = RandomDataModelGenerator.GetRandomMenu();

    // Start is called before the first frame update
    void Start()
    {
        MenuId.text = menuDataModel.id;
        DescriptionMenu.text = menuDataModel.Description;

        for(int i = 0; i < menuDataModel.SubMenuPrices.Count; i ++)
        {
            var submenuGo = InstantiatePrefab("SubMenuPreFab", "SubMenuListGO");
            submenuGo.transform.localPosition = new Vector2(0,-420 * (i-1));

            mapSubMenuPreFab(submenuGo, menuDataModel.SubMenuPrices[i]);
            
        }
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    public GameObject InstantiatePrefab(string prefabName, string parentName)
    {
        var go = Instantiate(Resources.Load("PreFab/" + prefabName), Vector3.zero, Quaternion.identity) as GameObject;

        go.transform.SetParent(GameObject.Find(parentName).transform);

        go.transform.localScale = Vector3.one;
        go.transform.localPosition = Vector3.zero;

        return go;
    }

    private void mapSubMenuPreFab(GameObject subMenuPrefab, SubMenuPrice subMenuPrice)
    {
        // TODO continue
        subMenuPrefab.GetComponentInChildren<Button>().GetComponent<Image>().sprite = ResourceManager.GetSpriteFromPath("DefaultRestaurant", subMenuPrice.SubMenu.PathToPhoto);
    }
}
