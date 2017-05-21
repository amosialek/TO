package TO;


public class Atena {
    public static void JudgeWar(King king1, King king2){
        if(king1.countWasals()>king2.countWasals()){
            king1.winWar(king2.loseWar());
        }
    }
}
