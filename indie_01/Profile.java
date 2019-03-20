class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {

        this.day   = day;
        this.month = month;
        this.year  = year;

        this.correctDate();
    }

    public void increaseDay(int d) {
        this.day += d;
        this.correctDate();
    }

    public void increaseMonth(int m) {
        this.month += m;
        this.correctDate();
    }

    public void increaseYear(int y) {
        this.year += y;
        this.correctDate();
    }

    public String Get(boolean isAmerican) {
        String sDay;
        String sMonth;
        String sYear;

        if(this.day < 10)
            sDay = "0" + this.day;
        else
            sDay = String.valueOf(this.day);

        if(this.month < 10)
            sMonth = "0" + this.month;
        else
            sMonth = String.valueOf(this.month);
        
        sYear = String.valueOf(this.year);

        if(isAmerican)
            return (sMonth + "/" + sDay + "/" + sYear);

        return (sDay + "/" + sMonth + "/" + sYear);
    }

    private void correctDate() {

        //Correcting month
        while(this.month > 12) {
            this.month -= 12;
            this.year  += 1;
        }

        //Verifying if the year is leap
        boolean isLeap;

        if(this.year % 4 == 0)
            isLeap = true;
        else
            isLeap = false;

        //Discovering the month duration
        int monthLength = 31;

        if(this.month == 2 && isLeap)
            monthLength = 29;
        else
            monthLength = 28;

        if(this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11)
            monthLength = 30;

        //Correcting the day
        while(this.day > monthLength) {
            this.day   -= monthLength;
            this.month += 1;
        }

        //Correcting month again
        while(this.month > 12) {
            this.month -= 12;
            this.year  += 1;
        }

    }
}

class Identify {
    String at;
    int    serial;

    public Identify(String at, int serial) {
        this.at     = at;
        this.serial = serial;
    }

}

class Location {
    private String country       = "";
    private String state         = "";
    private String region        = "";
    private String city          = "";
    private String neighbourhood = "";
    private boolean IdCom        = false;
    private Identify id;

    public Location(String city, String country) {
        this.country = country;
        this.city    = city;
    }

    public void addCountry(String name) {
        this.country = name;
    }

    public void addState(String name) {
        this.state = name;
    }

    public void addRegion(String name) {
        this.region = name;
    }

    public void addCity(String name) {
        this.city = name;
    }

    public void addNeighbourhood(String name) {
        this.neighbourhood = name;
    }

    public void addID(String at, int serial) {
        Identify id = new Identify(at, serial);
        this.IdCom = true;
        this.id = id;
    }

    public String getCity() {
        if(this.city == "")
            return "null";
        return this.city + ", " + this.country;
    }
}

class Name {
    private String first = "";
    private String last  = "";
    private String middle;
    private String preffix;
    private String suffix;
    private String nick;

    public Name(String first, String last) {
        this.first = first;
        this.last  = last;
    }

    public void addMiddle(String middle) {
        this.middle = middle;
    }

    public void addPre(String pre) {
        this.preffix = pre;
    }

    public void addSuff(String suf) {
        this.suffix = suf;
    }

    public void addNick(String nick) {
        this.nick = nick;
    }

    public String getName() {

        String returnName = "";

        if(this.preffix != null)
            returnName += this.preffix += " ";

        returnName += this.first + " ";

        if(this.middle != null)
            returnName += this.middle;

        returnName += this.last;

        if(this.suffix != null)
            returnName += ", " + this.suffix;

        return returnName;
    }

    public String getNick() {
        return this.nick;
    }
}

class Person {
    private Name     name;
    private Identify id;
    private String   eMail = "null";
    private Date     birthday;
    private Location city  = new Location("", "");

    public Person(String firstName, String lastName, String id) {
        
        Name fullName = new Name(firstName, lastName);
        this.name = fullName;

        Identify serial = new Identify(id, 100000);
        this.id = serial;
        
    }

    public String getName() {
        return this.name.getName();
    }

    public String getEmail() {
        return this.eMail;
    }

    public void setBirthday(int year, int month, int day) {
        this.birthday = new Date(day, month, year);
    }

    public void setEmail(String eMail) {
        this.eMail = eMail;
    }

    public void setCity(String city, String country) {
        this.city = new Location(city, country);
    }

    public void Print() {

        System.out.println("Id:       " + this.id.at);
        System.out.println("Name:     " + this.name.getName());
        System.out.println("eMail:    " + this.eMail);
        System.out.println("City:     " + this.city.getCity());
        System.out.println("Birthday: " + this.birthday.Get(false));

    }
    
}

public class Profile {
    public static void main(String[] args) {

        String interpretation = Interpreter(args);

        if(interpretation.equals("CreateProfile")) {
            //args[2] should contain the person name.

        }

        //Testing the class Person:

        /*
        Person eu;
        eu = new Person("Jorge", "Uliana", "jorgeuliana1");
        eu.setBirthday(1999, 7, 6);
        eu.setCity("Vila Velha", "Brazil");
        eu.setEmail("ulianamjjorge@gmail.com");
        System.out.println("");
        eu.Print();
        */
        
        
    }

    public static String Interpreter(String[] args) {
        for(int i = 0; i < args.length; i++) {
            System.out.println( i + " - " + args[i]);
        }

        // String.equals("String to be compared") returns true if the strings are equal.

        if(args[0].equals("new")) {
            if(args[1].equals("profile")) {
                if(args.length >= 5)
                    return "CreateProfile";
            }
        }

        return "Null";
    }

}