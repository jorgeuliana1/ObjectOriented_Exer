import java.util.Scanner;

public class J2_05 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s1;
        s1 = in.nextLine();

        int n;
        n = Integer.parseInt(s1);

        Book[] b;
        CompactDisc[] c;
        MovieDisc[] d;

        b = new Book[n];
        c = new CompactDisc[n];
        d = new MovieDisc[n];
        
        for(int i = 0; i < n; i++) {
            
            String s = in.nextLine();
            String[] s2 = s.split(",");

            
            if(s2[0].equals("L")) {
                for(int j = 0; j < (b.length - 1) && b[j] != null; j++) {
                    if(b[j + 1] == null) {
                        b[j + 1] = new Book(Integer.parseInt(s2[1]), s2[2], Double.parseDouble(s2[3]), s2[4]);
                    }
                }
            }

            else if(s2[0].equals("C")) {
                for(int j = 0; j < (c.length - 1) && c[j] != null; j++) {
                    if(c[j + 1] == null) {
                        c[j + 1] = new CompactDisc(Integer.parseInt(s2[1]), s2[2], Double.parseDouble(s2[3]), Integer.parseInt(s2[4]));
                    }
                }
            }

            else if(s2[0].equals("D")) {
                for(int j = 0; j < (d.length - 1) && d[j] != null; j++) {
                    if(d[j + 1] == null) {
                        d[j + 1] = new MovieDisc(Integer.parseInt(s2[1]), s2[2], Double.parseDouble(s2[3]), Integer.parseInt(s2[4]));
                    }
                }
            }
            
        }

        String s = in.nextLine();
        String[] s2 = s.split(",");

        if(s2[0].equals("L")) {
            int r = searchIndex(b, Integer.parseInt(s2[1]));
            if(r == -1)
                System.out.println("Produto nao encontrado.");
            else
                System.out.println(Integer.toString(r));
        }

        else if(s2[0].equals("C")) {
            int r = searchIndex(c, Integer.parseInt(s2[1]));
            if(r == -1)
                System.out.println("Produto nao encontrado.");
            else
                System.out.println(Integer.toString(r));
        }

        else if(s2[0].equals("D")) {
            int r = searchIndex(d, Integer.parseInt(s2[1]));
            if(r == -1)
                System.out.println("Produto nao encontrado.");
            else
                System.out.println(Integer.toString(r));
        }

    }

    static int searchIndex(Item[] i, int i2) {

        System.out.println(i2 + " ");

        for(int j = 0; j < i.length; j++) {

            System.out.println(j + " ");

            if(i[j] == null) {
                System.out.println("DEURUIM");
                break;
            }
            if(i[j].equals(i2))
                return j;
        }

        return -1;

    }
}
