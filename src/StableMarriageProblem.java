import Model.Man;
import Model.Woman;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.ListIterator;

public class StableMarriageProblem {
    private ArrayList<Man> men;
    private ArrayList<Woman> women;
    private HashSet<Pair<Man, Woman>> matchedPairs;
    private ArrayList<Man> notEngagedMen;
    private ArrayList<Woman> notEngagedWomen;

    public StableMarriageProblem() {
        // Do nothing
    }

    public StableMarriageProblem(ArrayList<Man> men, ArrayList<Woman> women) {
        this.men = men;
        this.women = women;
    }

    // MODIFIES: this
    // EFFECTS: adds m to men
    public void addMan(Man m) {
        men.add(m);
    }

    // MODIFIES: this
    // EFFECTS: adds w to women
    public void addWoman(Woman w) {
        women.add(w);
    }

    // MODIFIES: this
    // EFFECTS: removes m from men
    public void removeMan(Man m) {
        men.remove(m);
    }

    // MODIFIES: this
    // EFFECTS: removes w from women
    public void removeWoman(Woman w) {
        women.remove(w);
    }

    // REQUIRES: The size of men and women are the same.
    // MODIFIES: this
    // EFFECT: i determines whether men proposes (1) or whether women proposes (2)
    //         Returns a set representing the pairing between all the men and women in the sets in which
    //         it represents a stable perfect pairing.
    public HashSet<Pair<Man, Woman>> findMatches(int i) {
        HashSet<Pair<Man, Woman>> retval = new HashSet<>();

        if (men.size() == 0) {
            matchedPairs = retval;
            return retval;
        }

        initializeEngaged();

        if (i == 1) {
            menPropose();
        } else {
            womenPropose(); // Could add exceptions but I am not going to bother...
        }

        retval = generateMatches();
        matchedPairs = retval;
        return retval;
    }

    // EFFECT: Prints to console the pairing
    public void printMatches() {
        if (matchedPairs == null) {
            return;
        }

        for (Pair<Man, Woman> pair : matchedPairs) {
            System.out.println(pair.getKey().getName() + " is engaged to " + pair.getValue().getName());
        }
    }

    // EFFECTS: initializes notEngagedMen and notEngagedWomen and sets all m and w in men and women to null
    private void initializeEngaged() {
        notEngagedMen = new ArrayList<>();
        for (Man m : men) {
            notEngagedMen.add(m);
            m.setEngagedTo(null);
        }
        notEngagedWomen = new ArrayList<>();
        for (Woman w : women) {
            notEngagedWomen.add(w);
            w.setEngagedTo(null);
        }
    }

    // MODIFIES: this
    // EFFECTS: Pairs all men to women with men proposing using the Gale-Shapley Algorithm
    private void menPropose() {
        ListIterator<Man> iter = men.listIterator();
        while (iter.hasNext()) {
            Man m = iter.next();
                for (Woman w : m.getPreferenceList()) {
                    if (w.getIsEngaged() == false) {
                        m.setEngagedTo(w);
                        w.setEngagedTo(m);
                        break;
                    } else if (w.getIsEngaged() == true) {
                        if (w.prefers(m)) {
                            Man temp = w.getEngaged();
                            temp.setEngagedTo(null);
                            iter.add(temp);
                            w.setEngagedTo(m);
                            m.setEngagedTo(w);
                        }
                    }

            }
        }
    }

    // MODIFIES: this
    // EFFECTS: Pairs all men to women with women proposing using the Gale-Shapley Algorithm
    private void womenPropose() {
        ListIterator<Woman> iter = women.listIterator();
        while (iter.hasNext()) {
            Woman w = iter.next();
            for (Man m : w.getPreferenceList()) {
                if (m.getIsEngaged() == false) {
                    m.setEngagedTo(w);
                    w.setEngagedTo(m);
                    break;
                } else if (m.getIsEngaged() == true) {
                    if (m.prefers(w)) {
                        Woman temp = m.getEngaged();
                        temp.setEngagedTo(null);
                        iter.add(temp);
                        w.setEngagedTo(m);
                        m.setEngagedTo(w);
                    }
                }

            }
        }
    }

    // EFFECTS: Creates a HashSet based on engagements of m in men
    private HashSet<Pair<Man, Woman>> generateMatches() {
        HashSet<Pair<Man, Woman>> retval = new HashSet<>();
        for (Man m : men) {
            Pair<Man, Woman> temp = new Pair<>(m, m.getEngaged());
            retval.add(temp);
        }
        return retval;
    }
}
