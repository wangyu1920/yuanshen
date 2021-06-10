package calculateTools;

public class DamageCalculate {
    final static float REACTION_COEFFICIENT_ZF= (float) 2.78;
    final static float REACTION_COEFFICIENT_JB= (float) 6.66;

    /**
     * 计算最低伤害的方法
     * @param role:角色
     * @param ele：伤害元素类型 1火 2冰 3水 4雷 5风 6岩 7物理
     * @param react：反应类型对应的基本倍率，填100则不反应
     * @param enemy:攻击的对象
     * @return 返回不产生暴击的伤害
     */
    public static int getMinDamage(Role role,int ele,int react,Enemy enemy){
        int ED=0;
        switch (ele) {
            case 1:ED=enemy.getED_HUO();break;
            case 2:ED=enemy.getED_BIN();break;
            case 3:ED=enemy.getED_SHU();break;
            case 4:ED=enemy.getED_LEI();break;
            case 5:ED=enemy.getED_FEN();break;
            case 6:ED=enemy.getED_YAN();break;
            case 7:ED=enemy.getED_WU();break;
        }
        //攻击力
        float attack = getAttack(role);
        //元素伤害加成
        float elementDamageAdd = getElementDamage(role.elementDamage);
        //攻击倍率
        float attackRate= role.AttackRate/100;
        //反应倍率
        float reactDamageRate=((float) react/100
                )*(1+(react==100?0:(role.reactionRateAdd/100+getReactDamageAdd(
                role.elementMaster, REACTION_COEFFICIENT_ZF))));
        //额外伤害加成
        float extraDamageAdd=(1+(float)role.damageAdd/100);
        //防御衰减
        float DEF_Rate=DefenceCalculate.getDefence(role.level,enemy.getLevel());
        //抗性衰减
        float ED_Rate=DefenceCalculate.getElementDefence(ED-role.ED_Down);
        //攻击力*元素伤害加成*倍率*反应倍率*额外伤害加成*防御力衰减*抗性衰减
        return (int) (attack * attackRate * DEF_Rate * ED_Rate * extraDamageAdd * reactDamageRate * elementDamageAdd);
    }
    /**
     * 计算最高伤害的方法
     * @param role:角色
     * @param ele：伤害元素类型 1火 2冰 3水 4雷 5风 6岩 7物理
     * @param react：反应类型对应的基本倍率，填100则不反应
     * @param enemy:攻击的对象
     * @return 返回产生暴击的伤害
     */
    public static int getMaxDamage(Role role,int ele,int react,Enemy enemy){
        return (int)(getMinDamage(role, ele,react,enemy)
                *getCritical(role.criticalDamage));
    }
    /**
     * 计算平均伤害的方法
     * @param role:角色
     * @param ele：伤害元素类型 1火 2冰 3水 4雷 5风 6岩 7物理
     * @param react：反应类型对应的基本倍率，填100则不反应
     * @param enemy:攻击的对象
     * @return 返回伤害期望值
     */
    public static int getAverageDamage(Role role,int ele,int react,Enemy enemy){
        return (int)(getMaxDamage(role, ele,react,enemy)*(role.criticalRate/100)
                +getMinDamage(role, ele,react,enemy)*(1-role.criticalRate/100));
    }
    //返回精通获得的增幅反应伤害增益
    public static float getReactDamageAdd(float elementMaster,float coefficient){
        return coefficient/(1+(float)1400/elementMaster);
    }
    //返回攻击力总数值
    public static float getAttack(Role role){
        return role.attack_White*(1+(float)role.attackRateAdd/100)+role.attack_Green+
                role.attackNumAdd;
    }
    //返回暴击倍率乘区
    public static float getCritical(float criticalDamage){
        return criticalDamage/100+1;
    }
    //返回元素伤害加成乘区
    public static float getElementDamage(float elementDamage){
        return elementDamage/100+1;
    }
}
