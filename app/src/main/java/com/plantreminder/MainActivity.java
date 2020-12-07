package com.plantreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSelect;
    private Button btnSetting;
    private Button btnConnect;
    private TextView textViewT;
    private TextView textViewM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setListener();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSelect :
                System.out.println("select!");
                textViewT.setText("select!!");
                break;
            case R.id.btnSetting :
                System.out.println("setting.");
                textViewM.setText("setting.");
                break;
            case R.id.btnConnect :
                System.out.println("connect~");
                try {
                    String result = new MyAsyncTask().execute("data", "a").get();
                    System.out.println(result);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                break;
        }
    }

    private void init() {
        textViewT = (TextView) findViewById(R.id.textViewT);
        textViewM = (TextView) findViewById(R.id.textViewM);
        btnSelect = (Button) findViewById(R.id.btnSelect);
        btnSetting = (Button) findViewById(R.id.btnSetting);
        btnConnect = (Button) findViewById(R.id.btnConnect);
    }

    private void setListener() {
        btnSelect.setOnClickListener(this);
        btnSetting.setOnClickListener(this);
        btnConnect.setOnClickListener(this);
    }
}