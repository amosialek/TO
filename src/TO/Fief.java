package TO;


public class Fief implements Rewardable {
    private int urban;
    private double land;
    public int getUrbanSize(){
        return urban;
    }
    public double getLandSize(){
        return land;
    }

    public Fief(int urban, double land) {
        this.urban = urban;
        this.land = land;
    }

    public boolean isEmpty(){
        if(urban==0 && land==0)
            return true;
        return false;
    }
    public Fief getPartOfFief(){
        if(isEmpty())
            throw new EmptyFiefDivision();
        if (urban==0)
        {
            Fief f = new Fief(0, 0.1*land);
            land-=0.1*land;
            return f;
        }
        else
        {
            urban--;
            return new Fief(1,0);

        }

    }

    public void merge(Fief fief){
        this.land=fief.land;
        this.urban=fief.urban;
    }


    @Override
    public boolean isFief() {
        return true;
    }
}
