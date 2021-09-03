import java.util.Scanner;
interface IMarathon{
    Athlete bestTime();
    int AthletesFrom(String s);
}
class Athlete{
    private String name;
    private String gender;
    private int age;
    private double time;
    private String country;

    public Athlete(){
    }
    public Athlete(String name, String gender, int age, double time, String country){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.time = time;
        this.country = country;
    }
    @Override
    public String toString(){
        return this.name + "\n" + this.age + "\n" + this.country + "\n" + this.time + "\n";
    }
    public double getTime(){
        return this.time;
    }
    public String getCountry(){
        return this.country;
    }
}
class Marathon implements IMarathon {
    private IMarathon iMarathon;
    private String host;
    private int year;
    private Athlete[] athletes;

    public Marathon(){
        athletes = null;
    }
    public Marathon(String host, int year, Athlete[] athletes){
        this.host = host;
        this.year = year;
        this.athletes = new Athlete[athletes.length];
        this.athletes = athletes;
    }
    private String print(){
        String allTogether = "";
        for(int i = 0 ; i < athletes.length ; ++i)
            allTogether += athletes[i].toString();
        return allTogether;
    }
    @Override
    public String toString(){
        return "\n" + this.host + "\n" + this.year + "\n" + print() ;
    }
    @Override
    public Athlete bestTime() {
        if(athletes.length >= 2) {
            Athlete tmp = null;
            double bestTime = athletes[0].getTime();
            for (int i = 1; i < athletes.length; ++i) {
                if (athletes[i].getTime() < bestTime) {
                    bestTime = athletes[i].getTime();
                    tmp = athletes[i];
                }
            }
            return tmp;
        }
        else
            return athletes[0];
    }

    @Override
    public int AthletesFrom(String s){
        int num = 0;
        for(int i = 0 ; i < athletes.length ; ++i){
            if(athletes[i].getCountry().equals(s))
                num += 1;
        }

        return num;
    }
}
class Test {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        Athlete[] atleticari = new Athlete[n];

        String ime;
        String pol;
        int vozrast;
        double vreme;
        String zemja;

        input.nextLine();

        for(int i=0;i<n;i++)
        {
            ime = input.nextLine();
            pol = input.nextLine();
            vozrast = input.nextInt();
            vreme = input.nextDouble();
            input.nextLine();
            zemja = input.nextLine();
            atleticari[i]=new Athlete(ime,pol,vozrast,vreme,zemja);
        }

        String mesto;
        int godina;
        String zemjaP;
        mesto = input.nextLine();
        godina = input.nextInt();
        input.nextLine();

        Marathon m1 = new Marathon(mesto, godina, atleticari);
        System.out.print(m1.toString());

        zemjaP = input.nextLine();
        System.out.println("Prvo mesto: " + m1.bestTime().toString());
        System.out.println("Ima vkupno " + m1.AthletesFrom(zemjaP) + " atleticar/i od " + zemjaP);
    }
}
