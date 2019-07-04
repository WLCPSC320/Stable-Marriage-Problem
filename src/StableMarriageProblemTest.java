import Model.Man;
import Model.Woman;
import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class StableMarriageProblemTest {
    private Man m1;
    private Man m2;
    private Woman w1;
    private Woman w2;
    private StableMarriageProblem smp;

    @Before
    public void runBefore() {
        m1 = new Man("m1");
        m2 = new Man("m2");
        w1 = new Woman("w1");
        w2 = new Woman("w2");
    }

    @Test
    public void testTrivialCase() {
        ArrayList<Man> mPL = new ArrayList<>();
        ArrayList<Woman> wPL = new ArrayList<>();
        mPL.add(m1);
        wPL.add(w1);
        m1.setPrefernceList(wPL);
        w1.setPrefernceList(mPL);


        smp = new StableMarriageProblem(mPL, wPL);
        HashSet<Pair<Man,Woman>> result = smp.findMatches(1);

        Pair<Man,Woman> expectedPair = new Pair<>(m1,w1);
        HashSet<Pair<Man,Woman>> expected = new HashSet<>();
        expected.add(expectedPair);

        assertEquals(result,expected);
    }

    @Test
    public void testSmallCase1() {
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

        smp = new StableMarriageProblem(men, women);
        HashSet<Pair<Man,Woman>> result = smp.findMatches(1);

        Pair<Man,Woman> expectedPair1 = new Pair<>(m1,w1);
        Pair<Man,Woman> expectedPair2 = new Pair<>(m2,w2);
        HashSet<Pair<Man,Woman>> expected = new HashSet<>();
        expected.add(expectedPair1);
        expected.add(expectedPair2);

        assertEquals(result,expected);
    }

    @Test
    public void testSmallCase2() {
        ArrayList<Woman> mPL = new ArrayList<>();
        mPL.add(w1);
        mPL.add(w2);
        ArrayList<Man> wPL = new ArrayList<>();
        wPL.add(m1);
        wPL.add(m2);
        ArrayList<Man> wPL1 = new ArrayList<>();
        wPL1.add(m2);
        wPL1.add(m1);

        m1.setPrefernceList(mPL);
        m2.setPrefernceList(mPL);
        w1.setPrefernceList(wPL);
        w2.setPrefernceList(wPL1);

        ArrayList<Man> men = new ArrayList<>();
        men.add(m1);
        men.add(m2);
        ArrayList<Woman> women = new ArrayList<>();
        women.add(w1);
        women.add(w2);

        smp = new StableMarriageProblem(men, women);
        HashSet<Pair<Man,Woman>> result = smp.findMatches(1);

        Pair<Man,Woman> expectedPair1 = new Pair<>(m1,w1);
        Pair<Man,Woman> expectedPair2 = new Pair<>(m2,w2);
        HashSet<Pair<Man,Woman>> expected = new HashSet<>();
        expected.add(expectedPair1);
        expected.add(expectedPair2);

        assertEquals(result,expected);
    }

    @Test
    public void testSmallCase3() {
        Man m3 = new Man("m3");
        Woman w3 = new Woman("w3");

        ArrayList<Woman> mPL = new ArrayList<>();
        mPL.add(w1);
        mPL.add(w2);
        mPL.add(w3);
        ArrayList<Woman> mPL1 = new ArrayList<>();
        mPL1.add(w1);
        mPL1.add(w3);
        mPL1.add(w2);
        ArrayList<Man> wPL = new ArrayList<>();
        wPL.add(m1);
        wPL.add(m3);
        wPL.add(m2);
        ArrayList<Man> wPL1 = new ArrayList<>();
        wPL1.add(m2);
        wPL1.add(m1);
        wPL1.add(m3);
        ArrayList<Man> wPL2 = new ArrayList<>();
        wPL2.add(m1);
        wPL2.add(m2);
        wPL2.add(m3);

        m1.setPrefernceList(mPL);
        m2.setPrefernceList(mPL1);
        m3.setPrefernceList(mPL);
        w1.setPrefernceList(wPL);
        w2.setPrefernceList(wPL1);
        w3.setPrefernceList(wPL2);

        ArrayList<Man> men = new ArrayList<>();
        men.add(m1);
        men.add(m2);
        men.add(m3);
        ArrayList<Woman> women = new ArrayList<>();
        women.add(w1);
        women.add(w2);
        women.add(w3);

        smp = new StableMarriageProblem(men, women);
        HashSet<Pair<Man,Woman>> result = smp.findMatches(1);

        Pair<Man,Woman> expectedPair1 = new Pair<>(m1,w1);
        Pair<Man,Woman> expectedPair2 = new Pair<>(m2,w3);
        Pair<Man,Woman> expectedPair3 = new Pair<>(m3,w2);
        HashSet<Pair<Man,Woman>> expected = new HashSet<>();
        expected.add(expectedPair1);
        expected.add(expectedPair2);
        expected.add(expectedPair3);

        assertEquals(result,expected);
    }
}