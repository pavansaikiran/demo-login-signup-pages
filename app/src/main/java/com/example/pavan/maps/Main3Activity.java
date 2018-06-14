package com.example.pavan.maps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final EditText name = (EditText) findViewById(R.id.signname);

        final EditText address = (EditText) findViewById(R.id.signaddress);

        final EditText number = (EditText) findViewById(R.id.signnumber);

        final EditText email = (EditText) findViewById(R.id.signemail);

        final EditText password = (EditText) findViewById(R.id.signpass);

        final EditText cpassword = (EditText) findViewById(R.id.signconf);


        Button b=(Button)findViewById(R.id.signbutton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=name.getText().toString();
                String add=address.getText().toString();
                int num=Integer.parseInt(number.getText().toString());
                String em=email.getText().toString();
                String p = password.getText().toString();
                String c = cpassword.getText().toString();
                if(!(p.equals(c)))
                {Toast.makeText(getApplicationContext(), "passwords donot match", Toast.LENGTH_SHORT).show();
                password.setText("");
                cpassword.setText("");
                }
                else {
                    database db = new database(getApplicationContext(),null,null,1);
                    db.adduser(new details(1,n,add,em,p,num));
                    MainActivity.x="";
                    String demo="";
                    demo+="name :"+n;
                    demo+="\naddress :"+add;
                    demo+="\nemail :"+em;
                    demo+="\nnumber :"+num;
                    MainActivity.x+=demo;
                    name.setText("");
                    address.setText("");
                    number.setText("");
                    email.setText("");
                    password.setText("");
                    cpassword.setText("");
                    startActivity(new Intent(getApplicationContext(),Main4Activity.class));

                }
            }
        });





    }
}
