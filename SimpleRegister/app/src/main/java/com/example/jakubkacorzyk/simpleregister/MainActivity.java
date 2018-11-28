package com.example.jakubkacorzyk.simpleregister;

import android.content.DialogInterface;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button register = (Button)findViewById(R.id.register);
        RadioButton male = (RadioButton)findViewById(R.id.male);
        male.setChecked(true);
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView email = (TextView) findViewById(R.id.email);
                TextView username = (TextView)findViewById(R.id.username);
                TextView password = (TextView)findViewById(R.id.password);
                TextView repeat = (TextView)findViewById(R.id.repeatPassword);

                if(!email.getText().toString().equals("") && !username.getText().toString().equals("") && !password.getText().toString().equals("") && password.getText().toString().equals(repeat.getText().toString())){
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("New user registered : " + username.getText());
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        });
    }
}
