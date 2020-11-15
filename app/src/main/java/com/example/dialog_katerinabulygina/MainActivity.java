package com.example.dialog_katerinabulygina;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bgButton;
    ConstraintLayout relativeLayout;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bgButton = (Button)findViewById(R.id.id_btnBgColor);
        relativeLayout = (ConstraintLayout)findViewById(R.id.id_relativelayout);
        context = MainActivity.this;
        bgButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final CharSequence[] items = {
                getText(R.string.alert_red),
                getText(R.string.alert_yellow),
                getText(R.string.alert_green)
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.dialog_title);

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        relativeLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.red));
                        Toast.makeText(context,R.string.alert_red,Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        relativeLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.yellow));
                        Toast.makeText(context,R.string.alert_yellow,Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        relativeLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.green));
                        Toast.makeText(context,R.string.alert_green,Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}