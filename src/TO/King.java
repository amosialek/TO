package TO;


public class King extends Person {
    public void fightWithSomeone(){
        map.goToRandomKing();

    }
    public King(Map map,Fief fief){
        this.fief=fief;
        this.map=map;
    }
}
