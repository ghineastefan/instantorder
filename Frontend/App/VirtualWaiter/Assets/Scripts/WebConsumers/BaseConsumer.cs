using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Net;
using System.Threading.Tasks;
using UnityEngine;

public class BaseConsumer {

    public static readonly string SERVER_ROOT = "http://localhost:8080/instantorder/api/";

    /// <summary>
    /// 
    /// </summary>
    /// <typeparam name="T"></typeparam>
    /// <param name="beforeResponse">\Before parsing the reponse this will be add before json. Its usefull for the unity json list problem</param>
    /// <param name="path"></param>
    /// <returns></returns>
    public static async Task<T> Get<T>(string beforeResponse, string path,string afterResponse)
    {
        HttpWebRequest request = (HttpWebRequest)WebRequest.Create(SERVER_ROOT + path);
        HttpWebResponse response = (HttpWebResponse)(await request.GetResponseAsync());
        StreamReader reader = new StreamReader(response.GetResponseStream());
        string jsonResponse = reader.ReadToEnd();
        Debug.Log("Respond from server: " + jsonResponse);
        T info = JsonUtility.FromJson<T>(beforeResponse + jsonResponse + afterResponse);
        return info;
    }
}
