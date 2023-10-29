import java.util.HashMap;

public class MainClass {
    public static void main(String[] args) {
        HashMap<Integer, Adventurer> adventurers = new HashMap<>();
        FightMod logg = new FightMod();
        Scanf scanf = new Scanf(adventurers,logg);
        scanf.getInput();
    }
}