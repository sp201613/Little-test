import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FightMod {
    private ArrayList<Adventurer> ads = new ArrayList<>();    //进入战斗模式的冒险者
    private ArrayList<String> mes = new ArrayList<>();    //存储战斗日志的字符串信息
    private ArrayList<FightLog> fl = new ArrayList<>();   //存储每一个有效日志的具体信息

    public ArrayList<String> getMes() { return mes; }

    public ArrayList<Adventurer> getAds() { return ads; }

    public ArrayList<FightLog> getFl() { return fl; }

    public void addAdventurer(Adventurer x) { ads.add(x); }

    public void addMessage(String x) { mes.add(x); }

    public void adClear() {
        ads.clear();
    }

    public Adventurer adQuery(String x) {
        for (Adventurer value : ads) {
            if (value.getName().equals(x)) {
                return value;
            }
        }
        return null;
    }

    public void checkMessage(int start) {
        String s1 = "(\\d{1,4})/((1[0-2])|(0?[1-9]))-([^@#-]*)-([^@#-]*)";
        String s2 = "(\\d{1,4})/((1[0-2])|(0?[1-9]))-([^@#-]*)@([^@#-]*)-([^@#-]*)";
        String s3 = "(\\d{1,4})/((1[0-2])|(0?[1-9]))-([^@#-]*)@#-([^@#-]*)";
        Pattern pattern1 = Pattern.compile(s1);
        Pattern pattern2 = Pattern.compile(s2);
        Pattern pattern3 = Pattern.compile(s3);
        for (int i = start; i < mes.size(); ++i) {
            String strs = mes.get(i);
            Matcher matcher1 = pattern1.matcher(strs);
            Matcher matcher2 = pattern2.matcher(strs);
            Matcher matcher3 = pattern3.matcher(strs);
            boolean flag = true;
            if (matcher1.find()) {
                //System.out.println(strs);
                flag = match1Solve(matcher1);
            }
            else if (matcher2.find()) {
                //System.out.println(strs);
                flag = match2Solve(matcher2);
            }
            else if (matcher3.find()) {
                //System.out.println(strs);
                flag = match3Solve(matcher3);
            }
            if (!flag) {
                System.out.println("Fight log error");
            }
        }
    }

    public boolean match1Solve(Matcher m) {
        int i = 1;
        Adventurer ad = new Adventurer(1,"1",1,1);
        String date = null;
        String ubt = null;
        for (String s : m.group().split("-")) {
            if (i == 1) {
                date = s;
            }
            if (i == 2) {
                ad = adQuery(s);
                if (ad == null) {
                    return false;
                }
            }
            if (i == 3) {
                ubt = s;
                int pid = ad.tryuseBottle(s);
                if (pid == -1) {
                    return false;
                }
                else {
                    System.out.println(pid + " " + ad.getHitPoint());
                }
            }
            ++i;
        }
        FightLog mm = new FightLog(0,0,date,ad,ubt,null);
        fl.add(mm);
        return true;
    }

    public boolean match2Solve(Matcher m) {
        int i = 1;
        String date = null;
        Adventurer ad1 = new Adventurer(1,"1",1,1);
        Adventurer ad2 = new Adventurer(2,"2",1,1);
        Equipment ep = new Equipment(1,"1",1,1,"RegularEquipment");
        Pattern pattern0 = Pattern.compile("([^@#-]*)@([^@#-]*)");
        for (String s : m.group().split("-")) {
            if (i == 1) { date = s; }
            if (i == 2) {
                Matcher m0 = pattern0.matcher(s);
                if (!m0.find()) { return false; }
                int j = 1;
                for (String t : m0.group().split("@")) {
                    if (j == 1) {
                        ad1 = adQuery(t);
                        if (ad1 == null) {
                            return false;
                        }
                    }
                    else {
                        ad2 = adQuery(t);
                        if (ad2 == null) { return false; }
                    }
                    ++j;
                }
            }
            if (i == 3) {
                boolean ff = false;
                for (Equipment j : ad1.getPack().getPeq()) {
                    if (j.getName().equals(s)) {
                        ep = j;
                        ff = true;
                        break;
                    }
                }
                if (!ff) { return false; }
                else {
                    int hip = 0;
                    if (ep instanceof RegularEquipment) {
                        hip = ad1.getLevel() * ep.getStar();
                    } else if (ep instanceof CritEquipment) {
                        CritEquipment ctep = (CritEquipment) ep;
                        hip = ctep.hurt(ad2.getHitPoint(), ad1.getLevel());
                    } else {
                        EpicEquipment ecep = (EpicEquipment) ep;
                        hip = ecep.hurt(ad2.getHitPoint(), ad1.getLevel());
                    }
                    ad2.Beattacked(hip);
                    System.out.println(ad2.getId() + " " + ad2.getHitPoint());
                }
            }
            ++i;
        }
        FightLog mm = new FightLog(1,0,date,ad1,null,ep);
        mm.addBtr(ad2);
        fl.add(mm);
        return true;
    }

    public boolean match3Solve(Matcher m) {
        int i = 1;
        String date = null;
        Adventurer ad = new Adventurer(1,"1",1,1);
        Equipment ep = new Equipment(1,"1",1,1,"a");
        for (String s : m.group().split("-")) {
            if (i == 1) { date = s; }
            if (i == 2) {
                StringBuilder sb = new StringBuilder(s);
                int si = s.length();
                sb.delete(si - 2,si);
                String ss = sb.toString();
                ad = adQuery(ss);
                if (ad == null) {
                    return false;
                }
            }
            if (i == 3) {
                boolean ff = false;
                for (Equipment j : ad.getPack().getPeq()) {
                    if (j.getName().equals(s)) {
                        ep = j;
                        ff = true;
                        break;
                    }
                }
                if (!ff) { return false; }
                else {
                    int hip = 0;
                    for (Adventurer adi : ads) {
                        if (adi.getName().equals(ad.getName())) { continue; }
                        if (ep instanceof RegularEquipment) {
                            hip = ad.getLevel() * ep.getStar();
                        } else if (ep instanceof CritEquipment) {
                            CritEquipment ctep = (CritEquipment) ep;
                            hip = ctep.hurt(adi.getHitPoint(), ad.getLevel());
                        } else {
                            EpicEquipment ecep = (EpicEquipment) ep;
                            hip = ecep.hurt(adi.getHitPoint(), ad.getLevel());
                        }
                        adi.Beattacked(hip);
                        System.out.print(adi.getHitPoint() + " ");
                    }
                    System.out.print("\n");
                }
            }
            ++i;
        }
        FightLog mm = new FightLog(1,1,date,ad,null,ep);
        for (Adventurer adi : ads) {
            if (adi.getName().equals(ad.getName())) { continue; }
            mm.addBtr(adi);
        }
        fl.add(mm);
        return true;
    }

    public void mesdateQuery(String x) {
        boolean flag = false;
        for (FightLog i : fl) {
            if (i.getDate().equals(x)) {
                flag = true;
                if (i.getIsAttack() == 0) {
                    System.out.println(x + " " + i.getAtr().getName() + " used " + i.getUbt());
                } else {
                    if (i.getIsAoe() == 0) {
                        String a1 = i.getAtr().getName();
                        String a2 = i.getBtr().get(0).getName();
                        String a3 = i.getEp().getName();
                        System.out.println(x + " " + a1 + " attacked " + a2 + " with " + a3);
                    } else {
                        String a1 = i.getAtr().getName();
                        String a3 = i.getEp().getName();
                        System.out.println(x + " " + a1 + " AOE-attacked with " + a3);
                    }
                }
            }
        }
        if (!flag) {
            System.out.println("No Matched Log");
        }
    }

    public void mesatQuery(String x) {
        boolean flag = false;
        for (FightLog i : fl) {
            if (i.getAtr().getName().equals(x) && i.getIsAttack() == 1) {
                flag = true;
                if (i.getIsAoe() == 0) {
                    String a1 = i.getBtr().get(0).getName();
                    String a2 = i.getEp().getName();
                    System.out.println(i.getDate() + " " + x + " attacked " + a1 + " with " + a2);
                } else {
                    String a2 = i.getEp().getName();
                    System.out.println(i.getDate() + " " + x + " AOE-attacked with " + a2);
                }
            }
        }
        if (!flag) {
            System.out.println("No Matched Log");
        }
    }

    public void mesbatQuery(String x) {
        boolean flag = false;
        for (FightLog i : fl) {
            if (i.getIsAoe() == 1 && i.isBtr(x)) {
                flag = true;
                String a1 = i.getAtr().getName();
                String a2 = i.getEp().getName();
                System.out.println(i.getDate() + " " + a1 + " AOE-attacked with " + a2);
            }
            if (i.getIsAoe() == 0 && i.getIsAttack() == 1
                    && i.getBtr().get(0).getName().equals(x)) {
                flag = true;
                String a1 = i.getAtr().getName();
                String a2 = i.getEp().getName();
                System.out.println(i.getDate() + " " + a1 + " attacked " + x + " with " + a2);
            }
        }
        if (!flag) {
            System.out.println("No Matched Log");
        }
    }
}
