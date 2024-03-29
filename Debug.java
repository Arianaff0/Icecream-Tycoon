package application;

public class Debug {
    Player currentPlayer;
    CSVFile newfile;

    public Debug(){


    }

    public Debug(int diff,double cash, int weather,double rep,int cones,double sugar,double vanilla,double milk){
        System.out.println("coming in here");
        newfile= new CSVFile("Debug.csv");
        currentPlayer = new Player(newfile,"Debug",diff,diff,weather,rep,cash,cones,sugar,vanilla,milk);
        newfile.CSVWriter("debug",diff,diff,weather,rep,cash,cones,sugar,vanilla,milk);
    }

}
