package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button saveData;

    private Button restoreData;

    private TextView name, age, married;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveData = (Button) findViewById(R.id.save_data);
        restoreData = (Button) findViewById(R.id.restore_data);
        name = (TextView) findViewById(R.id.name);
        age = (TextView) findViewById(R.id.age);
        married = (TextView) findViewById(R.id.married);

        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "Bear");
                editor.putInt("age", 19);
                editor.putBoolean("married", false);
                editor.apply();
                Toast.makeText(MainActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
            }
        });

        restoreData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
                String nameString = preferences.getString("name", "");
                int ageInt = preferences.getInt("age", 0);
                boolean marriedBoolean = preferences.getBoolean("married", false);

                name.setText(nameString);
                age.setText(String.valueOf(ageInt));
                married.setText(String.valueOf(marriedBoolean));

                Toast.makeText(MainActivity.this, "取出成功", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
