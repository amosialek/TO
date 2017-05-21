package TO;


public class Atena {
    public static void judgeWar(King king1, King king2) {
        System.out.println("Krol pierwszy: "+king1.countWasals().toString());
        System.out.println("Krol drugi: "+king2.countWasals().toString());
        if (king1.countWasals() > king2.countWasals()) {
            System.out.println("Krol pierwszy wygrał");
            king1.winWar(king2.loseWar());
        } else if (king1.countWasals() < king2.countWasals()) {
            System.out.println("Krol drugi wygrał");
            king2.winWar(king1.loseWar());
        }
    }
}
