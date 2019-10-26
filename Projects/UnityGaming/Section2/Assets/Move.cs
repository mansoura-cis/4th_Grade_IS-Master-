using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Move : MonoBehaviour
{
    public Rigidbody2D reg;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        reg = GetComponent<Rigidbody2D>();
        int x = 0;
        int y = 0;
        if (Input.GetKey("rigit"))
        {
            x = 40;
        }
        else if (Input.GetKey("left"))
        {
            x = -40;
        }
        else if (Input.GetKey("up"))
        {
            y = 40;
        }
        reg.AddForce(new Vector2(x, y));


    }
}
