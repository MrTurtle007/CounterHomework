package com.example.counterhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //variable que guarda en contador
    private int mCount = 0;
    //TextView para tener el id de él
    private TextView mShowCount;
    private TextView myText;
    private TextView myCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount = (TextView) findViewById(R.id.txtCount);
        //obtenemos nuestro TextView del editText del mensaje
        myText = findViewById(R.id.txtText);
        //obtenemos nuestro TextView del editText del contador
        myCounter = findViewById(R.id.txtCount);

        // Restore the saved state.
        // See onSaveInstanceState() for what gets saved.
        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");
            boolean isVisibleCounter = savedInstanceState.getBoolean("reply_visibleCounter");
            // Show both the header and the message views. If isVisible is
            // false or missing from the bundle, use the default layout.
            if (isVisible || isVisibleCounter) {
                //haceos visible nuestro editText
                myText.setVisibility(View.VISIBLE);
                //establecemos lo que hay en nuestro editText para colocarlo cuando se gire la pantalla
                myText.setText(savedInstanceState.getString("reply_text"));

                //hacemos visibble nuestro editText del contador
                myCounter.setVisibility(View.VISIBLE);
                //establecemos lo que hay en nuestro editText para colocarlo cuando se gire la pantalla
                myCounter.setText(savedInstanceState.getString("reply_counter"));
            }//fin del if
        }//fin del if
    }//fin del método onCreate

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //verificamos la visibilidad de nuestros editText del texto y del counter
        if (myText.getVisibility() == View.VISIBLE || myCounter.getVisibility() == View.VISIBLE) {
            //creamos una key llamada reply_visible con valor true
            outState.putBoolean("reply_visible", true);
            //obtenemos el valor que se tiene en el EditText del texto en la variable reply_text
            outState.putString("reply_text",myText.getText().toString());

            //creamos una key llamada reply_visibleCounter con valor true
            outState.putBoolean("reply_visibleCounter", true);
            //obtenemos el valor que se tiene en el EditText del texto en la variable reply_counter
            outState.putString("reply_counter", myCounter.getText().toString());
        }//fin del if
    }//fin del método onSaveInstanceState

    public void countUp(View view) {
        //se incrementa el contador
        mCount++;
        if (mShowCount != null) {
            //se inserta convertido a String
            mShowCount.setText(Integer.toString(mCount));
        }
    }
}