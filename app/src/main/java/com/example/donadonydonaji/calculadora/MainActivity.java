package com.example.donadonydonaji.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, ListView.OnItemClickListener{
    TextView txtTitulo;
    TextView txtRes;
    SeekBar skBar;
    ListView listRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Referencias
        txtTitulo = (TextView) findViewById(R.id.txt_title);
        listRes = (ListView) findViewById(R.id.list_res);
        skBar = (SeekBar) findViewById(R.id.seekBar);

        skBar.setOnSeekBarChangeListener(this);
        listRes.setOnItemClickListener(this);


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        int num= Integer.parseInt(String.valueOf(progress));
        ArrayList milista = new ArrayList();
        milista.add(num);
        for(int i=1;i<=10;i++){
            milista.add(num + "*" + i + "=" + (num*i));

        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, milista );

        listRes.setAdapter(arrayAdapter);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    Toast.makeText(this, "Ha presionado " + adapterView.getItemAtPosition(i),
                Toast.LENGTH_LONG).show();
    }
}
