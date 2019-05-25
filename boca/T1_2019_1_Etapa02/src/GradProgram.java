import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author J. Jorge M. Uliana
 * @version 1.1
 */

public class GradProgram {

    private String program_id; /* graduate program id */
    private String program_name; /* graduate program name */
    private Map<String, University> university_map; /* tree containing universities */

    public GradProgram(String id, String n) {
        program_id = id;
        program_name = n;
        university_map = new HashMap<>();
    }

    public void addUniversity(University u) {
        university_map.put(u.getHashKey(), u);
    }

    public String getID() {
        return program_id;
    }

    public String getName() {
        return program_name;
    }

    @Override
    public boolean equals(Object a) {

        GradProgram ao = (GradProgram) a;
        return this.getID().equals(ao.getID());

    }

    @Override
    public int hashCode() {
        String lower_name = (program_id).toLowerCase().trim();

        // Getting a hash code from the string:
        int sum = 0;
        for(int i = 0; i < lower_name.length(); i++) {
            sum += (int)lower_name.charAt(i);
        }

        return 1;
    }

    public String getHashKey() {
        return (program_id);
    }

    public int getUniversitiesNumber() {
        return university_map.size();
    }

    @Override
    public String toString() {
        return (program_id + ": " + program_name);
    }

    public void printUniversitiesList() {

        Object[] key_set = university_map.keySet().toArray();
        Arrays.sort(key_set);

        for(Object key : key_set) {
            System.out.printf("\t- %s\n", university_map.get(key).toString());
        }
    }

}