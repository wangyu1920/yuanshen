package calculateTools;

public class Role {

    //AttackRate
    public float AttackRate=100;
    //Base
    public int level=1;
    public int attack_White=0;//攻击力白值
    public int attack_Green=0;//攻击力绿值
    public int elementMaster=0;//元素精通
    public float criticalRate=0;//暴击率
    public float criticalDamage=50;//暴击伤害
    public float elementDamage=0;//对应元素伤害加成
    //Add
    public float attackNumAdd=0;//攻击白值额外加成
    public float attackRateAdd=0;//攻击力百分比额外加成
    public float damageAdd=0;//伤害额外加成
    public float reactionRateAdd=0;//反应倍率额外加成
    public int ED_Down=0;//抗性下降
    public int DEF_Down=0;//防御力下降

    public Role(int level, double AttackRate,int attack_White,
                int attack_Green, int elementMaster,
                double criticalRate, double criticalDamage,
                double elementDamage) {
        this.level=level;
        this.AttackRate= (float) AttackRate;
        this.attack_White = attack_White;
        this.attack_Green = attack_Green;
        this.elementMaster = elementMaster;
        this.criticalRate = (float) criticalRate;
        this.criticalDamage = (float) criticalDamage;
        this.elementDamage = (float) elementDamage;

    }

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                "AttackRate=" + AttackRate +
                ", level=" + level +
                ", attack_White=" + attack_White +
                ", attack_Green=" + attack_Green +
                ", elementMaster=" + elementMaster +
                ", criticalRate=" + criticalRate +
                ", criticalDamage=" + criticalDamage +
                ", elementDamage=" + elementDamage +
                ", attackNumAdd=" + attackNumAdd +
                ", attackRateAdd=" + attackRateAdd +
                ", damageAdd=" + damageAdd +
                ", reactionRateAdd=" + reactionRateAdd +
                ", ED_Down=" + ED_Down +
                ", DEF_Down=" + DEF_Down +
                '}';
    }

    public void setAttack_White(int attack_White) {
        this.attack_White = attack_White;
    }

    public void setAttack_Green(int attack_Green) {
        this.attack_Green = attack_Green;
    }

    public void setElementMaster(int elementMaster) {
        this.elementMaster = elementMaster;
    }

    public void setCriticalRate(float criticalRate) {
        this.criticalRate = criticalRate;
    }

    public void setCriticalDamage(float criticalDamage) {
        this.criticalDamage = criticalDamage;
    }

    public void setElementDamage(float elementDamage) {
        this.elementDamage = elementDamage;
    }

    public void setAttackNumAdd(float attackNumAdd) {
        this.attackNumAdd = attackNumAdd;
    }

    public void setAttackRateAdd(float attackRateAdd) {
        this.attackRateAdd = attackRateAdd;
    }

    public void setDamageAdd(float damageAdd) {
        this.damageAdd = damageAdd;
    }

    public void setReactionRateAdd(float reactionRateAdd) {
        this.reactionRateAdd = reactionRateAdd;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setED_Down(int ED_Down) {
        this.ED_Down = ED_Down;
    }

    public void setDEF_Down(int DEF_Down) {
        this.DEF_Down = DEF_Down;
    }

    public void setAttackRate(float attackRate) {
        AttackRate = attackRate;
    }


}
