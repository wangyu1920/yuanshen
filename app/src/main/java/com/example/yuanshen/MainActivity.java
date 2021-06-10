package com.example.yuanshen;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import calculateTools.DamageCalculate;
import calculateTools.Enemy;
import calculateTools.Role;
import calculateTools.enemys.SHI_LAI_MU;

public class MainActivity extends AppCompatActivity {
    Button button_crate;
    ListView mainListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建数据文件
        try {
            FileOutputStream fos=openFileOutput("RoleFile.txt", MODE_PRIVATE);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        button_crate = findViewById(R.id.crateNewRole);
        mainListView = findViewById(R.id.RoleList);
        button_crate.setOnClickListener(v -> {
            startActivityForResult(new Intent(this,CrateRoleClass.class),0);
        });

    }
    //重写

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 0) {
            if (data != null) {
                Bundle bundle=data.getExtras();

            }
        }
    }
}
/*
* Role role=new Role(90,93.3,848,
                515,79, 48.6,
                 144.1, 117.6) ;
        Enemy enemy=new SHI_LAI_MU(86);
        role.reactionRateAdd=15;
        int damage= DamageCalculate.getMaxDamage(role,6,200,enemy);
        Toast.makeText(this,"damage= "+damage,Toast.LENGTH_LONG).show();*/