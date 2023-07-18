package com.suhun.filereadwrite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private EditText userInput;
    private  TextView resultLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        userInput = findViewById(R.id.lineInput);
        resultLog = findViewById(R.id.readLog);
    }

    public void writeFun(View view){
        try {
            FileOutputStream fout = openFileOutput("input_result.txt", MODE_APPEND);
            fout.write((userInput.getText().toString()+"\n").getBytes());
//            FileOutputStream fout = openFileOutput("input_result.txt", MODE_PRIVATE);
//            fout.write("".getBytes());
            fout.flush();
            fout.close();
            Toast.makeText(this, "success!", Toast.LENGTH_SHORT);
            userInput.setText("");
        }catch(Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT);
        }
    }

    public void readFun(View view){
        try {
            FileInputStream fin = openFileInput("input_result.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
            String line;
            while((line = reader.readLine())!=null){
                resultLog.append(line + "\n");
            }
            fin.close();
        }catch(Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT);
        }
    }
}