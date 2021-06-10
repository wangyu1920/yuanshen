package calculateTools;

public class DefenceCalculate {
    public static float getDefence(
            int roleLevel,int enemyLevel
    ){
        return (float) (roleLevel+100)/(roleLevel+enemyLevel+200);
    }
    public static float getElementDefence(int ED){
        if (ED>=75){
            return 1/((float)1+(float) 4*ED/100);
        }else if (ED<0){
            return 1-(float)ED/200;
        }else {
            return 1 - (float) ED / 100;
        }

    }
}
