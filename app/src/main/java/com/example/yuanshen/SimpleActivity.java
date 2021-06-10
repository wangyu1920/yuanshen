package com.example.yuanshen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import calculateTools.DamageCalculate;
import calculateTools.Role;
import calculateTools.enemys.SHI_LAI_MU;

public class SimpleActivity extends AppCompatActivity {
    static int AddAttackRate=1;
    static int AddAttackNum=2;
    static int AddCriticalRate=3;
    static int AddCriticalDamage=4;
    static int AddElementMaster=5;
    static int AddElementDamage=6;
    static int AddDamageAdd=7;
    static int AddED_Down=8;

    Button startCalculate;
    TextView showDamage;
    TextView showDamageGrowth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        startCalculate = findViewById(R.id.Calculate);
        showDamage = findViewById(R.id.showDamage);
        showDamageGrowth = findViewById(R.id.showDamageGrowth);
        startCalculate.setOnClickListener(v ->{
            showDamage.setText(
                    getAllDamageText(
                            getMaxDamage(getRole()),getMinDamage(getRole()),getAverageDamage(getRole())
                    )
            );
            showDamageGrowth.setText(getAllDamageAddText());
        } );
    }

    private String getAllDamageText(int max, int min, int ave) {
        return "伤害计算结果：\n平均：" +
                ave +
                "  " +
                "暴击：" +
                max +
                "  " +
                "不暴击：" +
                min;
    }

    private String getAllDamageAddText() {
        return  "伤害增幅：\n" +
                "19数值攻击："+
                getDamageAdd(getRole(),getRoleAdd(AddAttackNum)) +
                "\n"+
                "5.8百分比攻击：" +
                getDamageAdd(getRole(),getRoleAdd(AddAttackRate)) +
                "\n" +
                "3.9暴击率：" +
                getDamageAdd(getRole(),getRoleAdd(AddCriticalRate))+
                "\n"+
                "7.8爆伤：" +
                getDamageAdd(getRole(),getRoleAdd(AddCriticalDamage)) +
                "\n" +
                "23精通：" +
                getDamageAdd(getRole(),getRoleAdd(AddElementMaster)) +
                "\n" +
                "5.8元素伤害加成：" +
                getDamageAdd(getRole(),getRoleAdd(AddElementDamage)) +
                "\n" +
                "5.8对应伤害提升：" +
                getDamageAdd(getRole(),getRoleAdd(AddDamageAdd))+
                "\n" +
                "5.8减抗：" +
                getDamageAdd(getRole(),getRoleAdd(AddED_Down))
        ;
    }

    private Role getRole(){
        Role role = new Role(
                getIntFromView(findViewById(R.id.Role_Level)),
                getDoubleFromView(findViewById(R.id.Role_AttackRate)),
                getIntFromView(findViewById(R.id.Role_Attack_White)),
                getIntFromView(findViewById(R.id.Role_Attack_Green)),
                getIntFromView(findViewById(R.id.Role_ElementMaster)),
                getDoubleFromView(findViewById(R.id.Role_CriticalRate)),
                getDoubleFromView(findViewById(R.id.Role_CriticalDamage)),
                getDoubleFromView(findViewById(R.id.Role_ElementDamage)));
        role.reactionRateAdd=getIntFromView(findViewById(R.id.Role_ReactionRateAdd));
        role.ED_Down = getIntFromView(findViewById(R.id.Role_ED_Down));
        role.damageAdd=getIntFromView(findViewById(R.id.Role_DamageAdd));
        return role;
    }

    private int getMinDamage(Role role) {
        System.out.println(role.toString());
        return DamageCalculate.getMinDamage(
                role,3,
                getIntFromView(findViewById(R.id.ReactRate)),
                new SHI_LAI_MU(getIntFromView(findViewById(R.id.EnemyLevel)))
        );
    }

    private int getMaxDamage(Role role) {
        System.out.println(role.toString());
        return DamageCalculate.getMaxDamage(
                role,3,
                getIntFromView(findViewById(R.id.ReactRate)),
                new SHI_LAI_MU(getIntFromView(findViewById(R.id.EnemyLevel)))
        );
    }

    private int getAverageDamage(Role role) {
        System.out.println(role.toString());
        return DamageCalculate.getAverageDamage(
                role,3,
                getIntFromView(findViewById(R.id.ReactRate)),
                new SHI_LAI_MU(getIntFromView(findViewById(R.id.EnemyLevel)))
        );
    }

    private int getDamageAdd(Role role,Role roleAdd){
        return getAverageDamage(roleAdd) - getAverageDamage(role);
    }

    private Role getRoleAdd(int which) {
        Role role=getRole();
        switch (which) {
            case 2:role.attack_Green+=19.4375;break;
            case 1:role.attack_Green+=role.attack_White*0.05825;break;
            case 3:role.criticalRate+=3.8875;break;
            case 4:role.criticalDamage+=7.775;break;
            case 5:role.elementMaster+=23.375;break;
            case 6:role.elementDamage+=5.825;break;
            case 7:role.damageAdd+=5.825;break;
            case 8:role.ED_Down+=5.825;break;
        }
        return role;
    }

    private int getIntFromView(EditText text) {
        return Integer.parseInt(text.getText().toString());
    }

    private double getDoubleFromView(EditText text) {
        return Double.parseDouble(text.getText().toString());
    }

}