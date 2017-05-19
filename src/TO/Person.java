package TO;


public class Person {
    public  Fief fief;
    private Knight[] wasale;
    private int howManyWasals;

    public boolean canHaveAnotherWasal(){
        if(howManyWasals>=7 || fief.isEmpty())
            return false;
        return true;
    }
    public void addWasal(Knight wasal){
        if(canHaveAnotherWasal()){
            wasal.fief=this.fief.getPartOfFief();
            wasale[howManyWasals]=wasal;
            howManyWasals++;
        }

    }
    public Rewardable getReward() {
        if(!fief.isEmpty())
            return fief.getPartOfFief();
        else {
            howManyWasals--; //TODO: co jeśli nie ma wasali ani lenn?
            return wasale[howManyWasals];
        }
    }
}
