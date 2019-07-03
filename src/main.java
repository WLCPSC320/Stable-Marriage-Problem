import Model.Man;
import Model.Woman;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        System.out.println("Basic Case:");
        // Basic Case:
        Man m1 = new Man("m1");
        Man m2 = new Man("m2");
        Woman w1 = new Woman("w1");
        Woman w2 = new Woman("w2");

        ArrayList<Woman> mPL = new ArrayList<>();
        mPL.add(w1);
        mPL.add(w2);
        ArrayList<Man> wPL = new ArrayList<>();
        wPL.add(m1);
        wPL.add(m2);

        m1.setPrefernceList(mPL);
        m2.setPrefernceList(mPL);
        w1.setPrefernceList(wPL);
        w1.setPrefernceList(wPL);

        ArrayList<Man> men = new ArrayList<>();
        men.add(m1);
        men.add(m2);
        ArrayList<Woman> women = new ArrayList<>();
        women.add(w1);
        women.add(w2);

        StableMarriageProblem smp = new StableMarriageProblem(men, women);
        // Men Propose Case:
        smp.findMatches(1);
        smp.printMatches();
        // Women Propose Case:
        //smp.findMatches(2);
        //smp.printMatches();

        System.out.println("Another Case:");

        // Another Case:
        Man m11 = new Man("m1");
        Man m22 = new Man("m2");
        Man m33 = new Man("m3");
        Woman w11 = new Woman("w1");
        Woman w22 = new Woman("w2");
        Woman w33 = new Woman("w3");

        ArrayList<Woman> m1PL = new ArrayList<>();
        m1PL.add(w11);
        m1PL.add(w33);
        m1PL.add(w22);
        ArrayList<Woman> m2PL = new ArrayList<>();
        m2PL.add(w11);
        m2PL.add(w33);
        m2PL.add(w22);
        ArrayList<Woman> m3PL = new ArrayList<>();
        m3PL.add(w11);
        m3PL.add(w22);
        m3PL.add(w33);
        ArrayList<Man> w1PL = new ArrayList<>();
        w1PL.add(m11);
        w1PL.add(m22);
        w1PL.add(m33);
        ArrayList<Man> w2PL = new ArrayList<>();
        w2PL.add(m33);
        w2PL.add(m11);
        w2PL.add(m22);
        ArrayList<Man> w3PL = new ArrayList<>();
        w3PL.add(m11);
        w3PL.add(m33);
        w3PL.add(m22);

        m11.setPrefernceList(m1PL);
        m22.setPrefernceList(m2PL);
        m33.setPrefernceList(m3PL);
        w11.setPrefernceList(w1PL);
        w22.setPrefernceList(w2PL);
        w33.setPrefernceList(w3PL);

        ArrayList<Man> men1 = new ArrayList<>();
        men1.add(m11);
        men1.add(m22);
        men1.add(m33);
        ArrayList<Woman> women1 = new ArrayList<>();
        women1.add(w11);
        women1.add(w22);
        women1.add(w33);
        StableMarriageProblem smp1 = new StableMarriageProblem(men1, women1);
        // Men Propose Case:
        smp1.findMatches(1);
        smp1.printMatches();
        // Women Propose Case:
        //smp1.findMatches(2);
        //smp1.printMatches();
    }
}