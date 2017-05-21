package TO;


public class Knight extends Person implements  Rewardable{
    @Override
    public boolean isFief() {
        return false;
    }
    public Knight(Map map){
        this.map=map;
        King king = map.goToRandomKing();
        king.addWasal(this);
    }
}
