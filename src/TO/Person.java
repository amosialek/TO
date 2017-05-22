package TO;


import java.util.Random;

public class Person {
    private Random random = new Random();
    protected Person senior;
    protected Map map;
    public  Fief fief;
    private Knight[] vassals =new Knight[7];
    protected int howManyVassals;

    public boolean canHaveAnothervassal(){
        if(howManyVassals >=7 || fief.isEmpty()) {

            return false;
        }
        return true;
    }
    public void addVassal(Knight vassal){
        if(canHaveAnothervassal()){
            vassal.fief=this.fief.getPartOfFief();
            vassals[howManyVassals]=vassal;
            vassals[howManyVassals].senior=this;
            howManyVassals++;
        }
  else {
                if(howManyVassals ==0) {
                    King king;
                    while((king=map.goToRandomKing())==this){}
                    king.addVassal(vassal);
                }
                else
                    vassals[Math.abs(random.nextInt()) % howManyVassals].addVassal(vassal);

            }

    }
    public Rewardable getReward() {
        if(!fief.isEmpty())
            return fief.getPartOfFief();
        else {
            howManyVassals--;
            return vassals[howManyVassals];
        }
    }

    public Integer countVassals(){
        if(howManyVassals ==0)
            return 0;
        int sum=0;
        for(int i = 0; i< howManyVassals; i++)
            sum+= vassals[i].countVassals();
        sum+= howManyVassals;
        return sum;
    }

    public Reward loseWar() {
        Reward reward=new Reward();
        if(fief.isEmpty() && howManyVassals ==0)
            return reward;
        if(fief.isEmpty()) {
            howManyVassals--;
            reward.add(vassals[howManyVassals]);
            vassals[howManyVassals]=null;
        }
        else
            reward.add(fief.getPartOfFief());
        for(int i = 0; i< howManyVassals; i++)
            reward.add(vassals[i].loseWar());
        if(fief.isEmpty() && howManyVassals ==0) {
            if(senior!=null){
                senior.freeVassal(this);
                map.goToRandomKing().addVassal((Knight) this);
            }
        }
        return reward;
    }

    private void freeVassal(Person vassal){
        if(howManyVassals ==1){
            howManyVassals =0;
            vassals[0]=null;
            if(fief.isEmpty())
                if(senior!=null) {
                    senior.freeVassal(this);
                    map.goToRandomKing().addVassal((Knight)this);
                }
        }
        for(int i = 0; i< howManyVassals; i++)        {
            if(vassals[i]==vassal){
                howManyVassals--;
                vassals[i]= vassals[howManyVassals];
                vassals[howManyVassals]=null;
            }
        }
    }

    public void winWar(Reward reward) {
        fief.merge(reward.fief);
        for(Knight k :reward.knights){
            addVassal(k);
        }
    }
}
