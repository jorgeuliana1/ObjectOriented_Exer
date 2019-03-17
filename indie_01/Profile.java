class Date {
    int day;
    int month;
    int year;

    public Date(int day, int month, int year) {
        this.day   = day;
        this.month = month;
        this.year  = year;
    }

    public void Print() {
        System.out.println(day + "/" + month + "/" + year);
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
    String country       = "";
    String state         = "";
    String region        = "";
    String city          = "";
    String neighbourhood = "";
    boolean IdCom        = false;
    Identify id;

    public Location(String country, String city) {
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
}

class Name {
    String first = "";
    String last  = "";
    String middle;
    String preffix;
    String suffix;
    String nick;

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
    Name     name;
    Identify id;
    String   eMail = "null";
    Date     birthday;
    Location city;

    public Person(String firstName, String lastName, String id) {
        
        Name fullName = new Name(firstName, lastName);
        this.name = fullName;

        Identify serial = new Identify(id, 100000);
        this.id = serial;
        
    }

    public String getName() {
        return this.name.getName();
    }
    
}

public class Profile {
    public static void main(String[] args) {

        Person eu;
        eu = new Person("Jorge", "Uliana", "jorgeuliana1");

        System.out.println(eu.getName());
        
    }

}