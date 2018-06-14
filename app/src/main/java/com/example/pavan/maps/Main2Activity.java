package com.example.pavan.maps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    public static ArrayList <details> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final EditText editText1 = (EditText) findViewById(R.id.loginnumber);

        final EditText editText2 = (EditText) findViewById(R.id.password);

        final database db = new database(this, null, null, 1);
        Button b = (Button) findViewById(R.id.logbutton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(editText1.getText().toString());
                String s = editText2.getText().toString();
                db.getdatabase();
                editText1.setText("");
                editText2.setText("");
                for (details d : users) {

                    if (d.getNumber() == x ) {
                        if(d.getPassword().equals(s)){
                        MainActivity.x = "";
                        String demo = "";
                        demo += "name :" + d.getName();
                        demo += "\naddress :" + d.getAddress();
                        demo += "\nemail :" + d.getEmail();
                        demo += "\nnumber :" + d.getNumber();
                        MainActivity.x += demo;
                        startActivity(new Intent(getApplicationContext(), Main4Activity.class));}
                        else {
                            Toast.makeText(getApplicationContext(), "incorrect number or password entered", Toast.LENGTH_SHORT).show();
                            editText1.setText("");
                            editText2.setText("");

                        }

                    } }



                }

        });
      /*  Button button=(Button)findViewById(R.id.displaydata);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.getdatabase();
                MainActivity.x=" ";
                for(details d: Main2Activity.users)
                {
                    MainActivity.x+=d.getName()+"\n "+d.getNumber()+"\n "+d.getEmail()+" \n"+d.getAddress()+"\n"+d.getPassword()+"\n";
                    startActivity(new Intent(getApplicationContext(),Main4Activity.class));
                }

            }
        });*/






        }
    public void signinfunc(View v)
    {
        startActivity(new Intent(this,Main3Activity.class));
    }
}
