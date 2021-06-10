package calculateTools.enemys;

import calculateTools.Enemy;

public class SHI_LAI_MU implements Enemy {
    int level;
    public SHI_LAI_MU(int level){
        this.level=level;
    }
    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getED_LEI() {
        return 10;
    }

    @Override
    public int getED_HUO() {
        return 10;
    }

    @Override
    public int getED_SHU() {
        return 10;
    }

    @Override
    public int getED_BIN() {
        return 10;
    }

    @Override
    public int getED_FEN() {
        return 10;
    }

    @Override
    public int getED_YAN() {
        return 10;
    }

    @Override
    public int getED_WU() {
        return 10;
    }
}
