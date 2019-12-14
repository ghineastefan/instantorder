using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public interface IQuantificabile {
    
    double Quantity { get; set; }

    string QuantityType { get; set; }
}
