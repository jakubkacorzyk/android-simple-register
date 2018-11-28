package com.example.jakubkacorzyk.simpleregister;

import android.content.DialogInterface;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        ((Toolbar) findViewById(R.id.toolbar)).setOnMenuItemClickListener(
                new Toolbar.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return onOptionsItemSelected(item);
                    }
                });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.launcher:
                Toast.makeText(this, "Launcher selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.launcher_round:
                Toast.makeText(this, "LauncherRound selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }

        return true;
    }
}
