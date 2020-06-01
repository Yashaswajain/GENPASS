package com.example.genpass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private Button btn;
private TextView display,stored;
SharedPreferences mypref;
    private  final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz!@#$%^&*()-+<>?";
protected void GENERATOR(int count)
{
    StringBuilder builder = new StringBuilder();
    while (count-- != 0) {
        int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
        builder.append(ALPHA_NUMERIC_STRING.charAt(character));
    }
display.setText(builder.toString());
    mypref=getSharedPreferences("PASS", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor=mypref.edit();
    editor.putString("key",display.getText().toString());
    editor.apply();//so that data is stored and will run in background usefull
                   //editor.commit() no background running


}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById((R.id.genbtn));
        display=(TextView)findViewById(R.id.generated);
        stored=(TextView)findViewById(R.id.stored);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                GENERATOR(9);


                btn.setEnabled(false);


            }
        });
        mypref=getSharedPreferences("PASS", Context.MODE_PRIVATE);
        stored.setText(mypref.getString("key",""));

    }
}
