using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Moving : MonoBehaviour
{
    public Rigidbody2D reg;
    public GameObject sky;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        int x = 0;
        int y = 0;
        reg = GetComponent<Rigidbody2D>();
        if (Input.GetKey(KeyCode.W))
        {
            y += 1;
        }
        else if (Input.GetKey(KeyCode.D))
        {
            x -= 1;
            transform.localScale = new Vector2(0.5f, 0.5f);
            sky.transform.position += Vector3.left * 10 * Time.deltaTime/5;
        }
        else if (Input.GetKey(KeyCode.A))
        {
            x += 10;
            transform.localScale = new Vector2(-0.5f, 0.5f);
            sky.transform.position += Vector3.left * -10 * Time.deltaTime/5;

        }
        reg.AddForce(new Vector2(x, y));
    }
}
