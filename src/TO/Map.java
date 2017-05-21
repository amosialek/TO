package TO;

import java.util.Random;

/**
 * Created by Albert Mosiałek on 21.05.2017.
 */
public class Map {
    private Random random=new Random();
    private King[] kings;
    public Map(int kingdomsCount, double landFiefSize, int urbanFiefCount){
        kings=new King[kingdomsCount];
        for(int i=0;i<kingdomsCount;i++){
            Fief kingdomFief = new Fief(urbanFiefCount/kingdomsCount,landFiefSize/kingdomsCount);
            kings[i]=new King(this,kingdomFief);
        }


    }

    public void initKnights(int knightsCount){
        for(int i=0;i<knightsCount;i++) {
            Knight knight = new Knight(this);
        }
    }

    public King goToRandomKing(){
        return kings[Math.abs(random.nextInt())%kings.length];
    }
}
