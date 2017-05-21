package TO;

import java.util.ArrayList;

public class Reward {
    Fief fief;
    ArrayList<Knight> knights;

    public Reward(Fief fief, ArrayList<Knight> knights) {
        this.fief = fief;
        this.knights = knights;
    }
    public Reward(){
        fief=new Fief(0,0);
        knights=new ArrayList<>();
    }



    public void add(Fief fief){
        this.fief=fief;
    }
    public void add(Knight knight){
        knights.add(knight);
    }

    public void add(Reward reward){
        fief.merge(reward.fief);
        knights.addAll(reward.knights);
    }

}
