using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Logger : MonoBehaviour
{
    private bool devMode = true;
    public Text logText;

    // Start is called before the first frame update
    void Start()
    {
        logText.text = "";
    }

    public void Log(string message)
    {
        Debug.Log(message);
        if (devMode)
        {
            logText.text += message + "\n";
        }
    }

    public void ResetLog()
    {
        logText.text = "";
    }
}
