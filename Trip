import java.util.Scanner;


class Trip{
    private String name;
    private int price;
    public Trip(){
    }
    public Trip(String name, int price){
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getPrice(){
        return this.price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public static int minPrice(Trip[] niza, int n, Trip holiday){
        int minimum = Integer.MAX_VALUE;
        for(int i = 0 ; i < niza.length ; ++ i){
            if(niza[i] instanceof Vacation&&((Vacation)niza[i]).getDays() > ((Vacation)holiday).getDays()){
                ((Vacation)niza[i]).setPrice(((Vacation)niza[i]).getPrice() - 1000);
                if(((Vacation)niza[i]).getPrice() < minimum)
                    minimum = ((Vacation)niza[i]).getPrice();
            }
            else if(niza[i] instanceof FestiveTrip&&((FestiveTrip)niza[i]).getTotal() > ((Vacation)holiday).getDays()){
                if(((FestiveTrip)niza[i]).getPrice() < minimum)
                    minimum = ((FestiveTrip)niza[i]).getPrice();
            }
        }
        return minimum;
    }
}
class FestiveTrip extends  Trip{
    private int startDay;
    private int startMonth;
    private int endDay;
    private int endMonth;

    public FestiveTrip(){
    }
    public FestiveTrip(String name, int price, int sDay, int sMonth, int eDay, int eMonth) throws Exception {
        super(name, price);

        try{
            if(sMonth > eMonth) {
                throw new Exception("Exeption");
            }
            if(sMonth == eMonth&&sDay > eDay) {
                throw new Exception("Exeption");
            }
        }
        catch (Exception e){
            int temp = sMonth;sMonth = eMonth;eMonth = temp;
            temp = sDay;sDay = eDay;eDay = temp;
            System.out.println("Exception");
        }

        this.startDay = sDay;
        this.startMonth = sMonth;
        this.endDay = eDay;
        this.endMonth = eMonth;
    }
    public int getMonth(){
        return  this.startMonth;
    }
    public int getTotal(){
        return (this.endMonth - this.startMonth) * 30 + this.endDay - this.startDay;
    }
}
class Vacation extends Trip{
    private int days;

    public Vacation(){
    }
    public Vacation(String name, int price, int days){
        super(name, price);
        this.days = days;
    }
    public int getDays(){
        return this.days;
    }
}

class Test {


    public static void main(String[] args) throws Exception {


        int n;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();

        Trip[] nizaPatuvanje = new Trip[n];

        for (int i=0;i<n;i++){
            int tip=in.nextInt();
            if (tip==0){
                String ime=in.next();
                int cena =in.nextInt();
                int vreme=in.nextInt();
                nizaPatuvanje[i]=new Vacation(ime,cena,vreme);
            }
            else {
                String ime=in.next();
                int cena =in.nextInt();
                int pocD=in.nextInt();
                int pocM=in.nextInt();
                int krajD=in.nextInt();
                int krajM=in.nextInt();
                nizaPatuvanje[i]=new FestiveTrip(ime,cena,pocD,pocM, krajD,krajM);

            }
        }

        StringBuilder niza = new StringBuilder();
        for(int i = 0 ; i < n ; ++i){
            if(nizaPatuvanje[i] instanceof FestiveTrip&&((FestiveTrip) nizaPatuvanje[i]).getMonth() == 6){
                niza.append(nizaPatuvanje[i].getName());
                if(i == n - 1)
                    break;
                niza.append(" ");
            }
        }
        System.out.println(niza);

        double average = 0;
        for(int i = 0 ; i < n ; ++i){
            if(nizaPatuvanje[i] instanceof Vacation){
                average += ((Vacation)nizaPatuvanje[i]).getDays();
            }
            else if(nizaPatuvanje[i] instanceof FestiveTrip){
                average += ((FestiveTrip) nizaPatuvanje[i]).getTotal();
            }
        }
        System.out.println((double)average/n);

        String Vname = in.next();
        int Vprice = in.nextInt();
        int Vduration = in.nextInt();
        Vacation holiday = new Vacation(Vname, Vprice, Vduration);

        System.out.println(Trip.minPrice(nizaPatuvanje, n, holiday));

    }
}
