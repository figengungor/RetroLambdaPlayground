package com.figengungor.retrolambdaplayground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Lambda can be used only with single method interface(functional interface)

        /**Lambda expression structure
         *
         *1. Parameter(s)
         *2. ->
         *3. Method body
         *
         */

        /*************EXAMPLE 1******************/
        // One parameter -> One line method body  ( x -> x+1 )

        //Let's add a click listener to our button
        Button button = (Button) findViewById(R.id.button);

        //Before Lambda
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("tag", "Button is clicked");
            }
        });

        //After Lambda
        button.setOnClickListener(v -> Log.d("tag", "Button is clicked"));


        /*************EXAMPLE 2******************/
        //No parameter -> One line body ( ()->Log.d("tag", "hello") )

        //Let's create a thread with Runnable Interface as parameter

        //Before lambda
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("tag", "run, Thread, run!");
            }
        });

        //After lambda
        thread = new Thread(() -> Log.d("tag", "run, Thread, run!"));

        /*************EXAMPLE 3******************/
        //Multiple parameters -> One line body ( (x,y) -> x+y )

        //Let's create an Interface whose only method takes multiple parameters

        //Before lambda
        Blabla blabla = new Blabla() {
            @Override
            public int bla(int x, int y) {
                return x + y;
            }
        };

        //After lambda
        blabla = (x, y) -> x + y;

        /*************EXAMPLE 4******************/
        //Multiple parameters -> Multiple lines body ( (x,y) -> {......})

        blabla = (x, y) -> {
            Log.d("tag", "bla bla");
            return x + y;
        };


        /*************EXAMPLE 5******************/
        //Method Reference
        HebeleHubele hebeleHubele = new HebeleHubele();
        blabla = hebeleHubele::hebele; // instead of (x,y) -> hebeleHubele.hebele(x,y)
        blabla.bla(3,5);

    }

    interface Blabla {
        int bla(int x, int y);
    }

    class HebeleHubele {

         int hebele(int x, int y){
            Log.d("tag", "hebele");
            return x + y;
        }
    }
}
