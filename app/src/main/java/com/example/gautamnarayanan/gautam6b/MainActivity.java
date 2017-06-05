package com.example.gautamnarayanan.gautam6b;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int red;
    int green;
    int blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences SharedPref = getSharedPreferences("Details", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = SharedPref.edit();


        red=SharedPref.getInt("Red",0);
        green=SharedPref.getInt("Green",0);
        blue=SharedPref.getInt("Blue",0);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RelativeLayout Glayout=(RelativeLayout)findViewById(R.id.Glayout);
        Button Gbutton=(Button)findViewById(R.id.Gbutton);
        Button Gbutton2=(Button)findViewById(R.id.Gbutton2);
        Button Gbutton3=(Button)findViewById(R.id.Gbutton3);
        Button Greset=(Button)findViewById(R.id.Gbutton4);
        final EditText Gtext=(EditText)findViewById(R.id.Et);
        final EditText Gtext2=(EditText)findViewById(R.id.Et2);
        final EditText Gtext3=(EditText)findViewById(R.id.Et3);
        Gtext.setTextColor(Color.RED);
        Gtext2.setTextColor(Color.GREEN);
        Gtext3.setTextColor(Color.BLUE);
        Gtext.setEnabled(false);
        Gtext2.setEnabled(false);
        Gtext3.setEnabled(false);
        Gtext.setText(String.valueOf(red));
        Gtext2.setText(String.valueOf(green));
        Gtext3.setText(String.valueOf(blue));
        Glayout.setBackgroundColor(Color.rgb(red,green,blue));

        Gbutton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v)
                    {
                        if(red+5>255)
                        {red=red-255;}
                        else
                        {red=red+5;}
                        Glayout.setBackgroundColor(Color.rgb(red,green,blue));
                        String s = String.valueOf(red);
                        Gtext.setText(s);
                        editor.putInt("Red",red);
                        editor.apply();


                    }
                }

        );

        Gbutton2.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v)
                    {
                        if(green+5>255)
                        {green=green-255;}
                        else
                        {green=green+5;}
                        Glayout.setBackgroundColor(Color.rgb(red,green,blue));
                        String s = String.valueOf(green);
                        Gtext2.setText(s);
                        editor.putInt("Green",green);
                        editor.apply();

                    }

                }

        );

        Gbutton3.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v)
                    {
                        if(blue+5>255)
                        {blue=blue-255;}
                        else
                        {blue=blue+5;}
                        Glayout.setBackgroundColor(Color.rgb(red,green,blue));
                        String s = String.valueOf(blue);
                        Gtext3.setText(s);
                        editor.putInt("Blue",blue);
                        editor.apply();


                    }
                }

        );

        Greset.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        green=0;
                        red=0;
                        blue=0;
                        Gtext.setText("0");
                        Gtext2.setText("0");
                        Gtext3.setText("0");
                        Glayout.setBackgroundColor(Color.rgb(red,green,blue));
                        editor.putInt("Red",red);
                        editor.putInt("Blue",blue);
                        editor.putInt("Green",green);
                        editor.apply();



                    }

                }

        );


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
