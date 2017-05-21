package TO;


import java.util.Random;

public class Person {
    private Random random = new Random();
    protected Map map;
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
        else
            wasale[random.nextInt()%howManyWasals].addWasal(wasal);

    }
    public Rewardable getReward() {
        if(!fief.isEmpty())
            return fief.getPartOfFief();
        else {
            howManyWasals--; //TODO: co jeśli nie ma wasali ani lenn?
            return wasale[howManyWasals];
        }
    }

    public int countWasals(){
        if(howManyWasals==0)
            return 0;
        int sum=0;
        for(int i=0;i<howManyWasals;i++)
            sum+=wasale[i].countWasals();
        sum+=howManyWasals;
        return sum;
    }

    public Reward loseWar() {
        Reward reward=new Reward();
        if(fief.isEmpty()) {
            howManyWasals--;
            reward.add(wasale[howManyWasals]);
            wasale[howManyWasals]=null;
        }
        return reward;
    }


    public void winWar(Reward reward) {
        fief.merge(reward.fief);
    }
}
