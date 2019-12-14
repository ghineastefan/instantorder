using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using BarcodeScanner.Scanner;
using BarcodeScanner.Parser;
using BarcodeScanner.Webcam;
using BarcodeScanner;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

#if PLATFORM_ANDROID
using UnityEngine.Android;
#endif

public class QRScanner : MonoBehaviour
{
    public Scanner scanner;
    public RawImage image;

    readonly string type, value;
    bool started;

    public void Test()
    {
        Debug.Log("TEST!!");
    }


    public void Start()
     {     
        #if PLATFORM_ANDROID
            if (!Permission.HasUserAuthorizedPermission(Permission.Camera))
            {
                Permission.RequestUserPermission(Permission.Camera);
                    
            }
#endif

    }

    void Update()
    {
        //#if PLATFORM_ANDROID
        //if (Permission.HasUserAuthorizedPermission(Permission.Camera))
        {
            if (started == false)
            {
                scanner = new Scanner();
                // Start playing the camera
                scanner.Camera.Play();

                started = true;

                scanner.OnReady += (sender, arg) =>
                {
                        // Bind the Camera texture to the RawImage
                        image.texture = scanner.Camera.Texture;

                    scanner.Scan((type, value) =>
                    {
                        PlayerPrefs.SetString("url", value);
                        Debug.Log("QR url is: " + value);
                        scanner.Camera.Stop();
                        this.gameObject.SetActive(false);
                        //SceneManager.LoadScene(1);
                    });

                };
            }
            else
            {
                // The barcode scanner has to be updated manually
                scanner.Update();
            }
        }
        //#endif
    }


}
