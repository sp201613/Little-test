import java.util.ArrayList;

public class FightLog {
    private int isAttack;
    private int isAoe;
    private String date;
    private Adventurer atr;
    private ArrayList<Adventurer> btr;
    private String ubt;
    private Equipment ep;

    public FightLog(int isAttack,int isAoe,String date,
                    Adventurer atr,String ubt,Equipment ep) {
        this.isAttack = isAttack;
        this.isAoe = isAoe;
        this.date = date;
        this.atr = atr;
        this.btr = new ArrayList<>();
        this.ubt = ubt;
        this.ep = ep;
    }

    public void addBtr(Adventurer x) { btr.add(x); }

    public boolean isBtr(String x) {
        for (Adventurer i : btr) {
            if (i.getName().equals(x)) { return true; }
        }
        return false;
    }

    public ArrayList<Adventurer> getBtr() { return btr; }

    public String getDate() { return date; }

    public int getIsAttack() { return isAttack; }

    public int getIsAoe() { return isAoe; }

    public Adventurer getAtr() { return atr; }

    public String getUbt() { return ubt; }

    public Equipment getEp() { return ep; }
}
