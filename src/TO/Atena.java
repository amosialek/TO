package TO;


public class Atena {
    public static void judgeWar(King king1, King king2) {
        System.out.println("Krol pierwszy: "+king1.countVassals().toString());
        System.out.println("Krol drugi: "+king2.countVassals().toString());
        if (king1.countVassals() > king2.countVassals()) {
            System.out.println("Krol pierwszy wygrał");
            king1.winWar(king2.loseWar());
        } else if (king1.countVassals() < king2.countVassals()) {
            System.out.println("Krol drugi wygrał");
            king2.winWar(king1.loseWar());
        }
    }
}
