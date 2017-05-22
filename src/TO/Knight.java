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
        if(fief.isEmpty() && howManyWasals==0)
            System.out.println("blaaaaaaaad");
    }
}
