package application;

public class Results {
    private double day1Cash;

    private double dayRep;
    private Player currentplayer;

    private double dayCash[];
    private int cashcounter;

    private double repArray[];

    private int repcounter;


    Results(){
        day1Cash = 0;
        dayRep = 0;
        repcounter = 0;
        cashcounter = 0;

    }


    // this is at the start of the day as a reference
    public  Results(double startDayrep, double startDayCash){
        repcounter = 0;
        cashcounter = 0;
        System.out.println("results");
        System.out.println(startDayrep);
        System.out.println(startDayCash);
        dayCash = new double[11];
        dayCash[0] = startDayCash;
        repcounter = repcounter +1;
        cashcounter = cashcounter +1;

        repArray = new double[11];
        repArray[0] = startDayrep;

    }

    public void addCash(double cash){
        dayCash[cashcounter] = cash;
        cashcounter ++;
    }

    public void addRep(double rep){
        repArray[repcounter] = rep;
        repcounter ++;
    }

    public double[] getDayCash() {
        return dayCash;
    }

    public double[] getRepArray() {
        return repArray;
    }

    public void printResults(){
        System.out.println("Here are the Cash");
        for(int i = 0; i < 11; i ++){
            System.out.print(dayCash[i] + " ");
        }

        System.out.println("Here are the rep");
        for(int i = 0; i < 11; i ++){
            System.out.print(repArray[i] + " ");
        }
    }
}
