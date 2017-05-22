package TO;


import java.util.Random;

public class Person {
    private Random random = new Random();
    protected Person senior;
    protected Map map;
    public  Fief fief;
    private Knight[] wasale=new Knight[7];
    protected int howManyWasals;

    public boolean canHaveAnotherWasal(){
        if(howManyWasals>=7 || fief.isEmpty()) {

            return false;
        }
        return true;
    }
    public void addWasal(Knight wasal){
        if(canHaveAnotherWasal()){
            wasal.fief=this.fief.getPartOfFief();
            wasale[howManyWasals]=wasal;
            wasale[howManyWasals].senior=this;
            howManyWasals++;
        }
      /*  else
            if(fief.isEmpty() && howManyWasals==0)
                System.out.println("niemozliwe");
       */ else {
                if(howManyWasals==0) {
                    King king;
                    while((king=map.goToRandomKing())==this){}
                    king.addWasal(wasal);
                }
                else
                    wasale[Math.abs(random.nextInt()) % howManyWasals].addWasal(wasal);

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

    public Integer countWasals(){
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
        if(fief.isEmpty() && howManyWasals==0)
            return reward;
        if(fief.isEmpty()) {
            howManyWasals--;
            reward.add(wasale[howManyWasals]);
            wasale[howManyWasals]=null;
        }
        else
            reward.add(fief.getPartOfFief());
        for(int i=0;i<howManyWasals;i++)
            reward.add(wasale[i].loseWar());
        if(fief.isEmpty() && howManyWasals==0) {
            if(senior!=null){
                senior.freeWasal(this);
                map.goToRandomKing().addWasal((Knight) this);
            }
        }
        return reward;
    }

    private void freeWasal(Person wasal){
        if(howManyWasals==1){
            howManyWasals=0;
            wasale[0]=null;
            if(fief.isEmpty())
                if(senior!=null) {
                    senior.freeWasal(this);
                    map.goToRandomKing().addWasal((Knight)this);
                }
        }
        for(int i=0;i<howManyWasals;i++)        {
            if(wasale[i]==wasal){
                howManyWasals--;
                wasale[i]=wasale[howManyWasals];
                wasale[howManyWasals]=null;
            }
        }
    }

    public void winWar(Reward reward) {
        fief.merge(reward.fief);
        for(Knight k :reward.knights){
            addWasal(k);
        }
    }
}
