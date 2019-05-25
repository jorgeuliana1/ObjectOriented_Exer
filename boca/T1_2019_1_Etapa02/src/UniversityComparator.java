import java.util.Comparator;

public class UniversityComparator implements Comparator<University> {
    public int compare(University u1, University u2) {
        String sn_1, sn_2,
               ln_1, ln_2;

        sn_1 = u1.getShortName(); sn_2 = u2.getShortName();
        ln_1 = u1.getName();      ln_2 = u2.getName();

        // Comparing the short names;
        int compare = sn_1.compareTo(sn_2);
        if(compare != 0)
            return compare;

        // If they are equal, we compare the long ones.
        else return ln_1.compareTo(ln_2);
    }
}
