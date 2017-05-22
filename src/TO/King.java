package TO;


public class King extends Person {
    public void fightWithSomeone(){
        King anotherKing=map.goToRandomKing();
        while(anotherKing==this)
            anotherKing=map.goToRandomKing();
        Atena.judgeWar(this,map.goToRandomKing());
    }
    public King(Map map,Fief fief){
        this.fief=fief;
        this.map=map;
    }
}
