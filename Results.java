package application;

public class Results {

	public static double dayCash[];
	private int cashcounter;

	public static double repArray[];

	private int repcounter;

	public static double SugarArray[];
	private int sugarCounter;

	public static double CremeArray[];
	private int CremeCounter;

	public static double ConeArray[];
	private int ConeCounter;

	public static double VanArray[];
	private int VanCounter;


	Results() {
	
		repcounter = 0;
		cashcounter = 0;

	}

	// this is at the start of the day as a reference
	public Results(double startDayrep, double startDayCash,double sugar,double creme,double cones,double van) {

		repcounter = 0;
		cashcounter = 0;
		sugarCounter = 0;
		CremeCounter = 0;
		ConeCounter = 0;
		VanCounter = 0;


		dayCash = new double[11];
		dayCash[0] = startDayCash;
		cashcounter = cashcounter + 1;


		repcounter = repcounter + 1;
		repArray = new double[11];
		repArray[0] = startDayrep;

		sugarCounter ++;
		SugarArray = new double[11];
		SugarArray[0] = sugar;

		CremeCounter ++;
		CremeArray= new double[11];
		CremeArray[0] = creme;

		ConeCounter ++;
		ConeArray= new double[11];
		ConeArray[0] = cones;

		VanCounter ++;
		VanArray= new double[11];
		VanArray[0] = van;


	}

	public void addCash(double cash) {
		dayCash[cashcounter] = cash;
		cashcounter++;
	}

	public void addRep(double rep) {
		repArray[repcounter] = rep;
		repcounter++;
	}

	public void decreaseSugar(double sugar){
		SugarArray[sugarCounter] = sugar;
		sugarCounter++;
	}

	public void decreaseCreme(double creme){
		CremeArray[CremeCounter] = creme;
		CremeCounter++;
	}

	public void decreaseVan(double van){
		VanArray[VanCounter] = van;
		VanCounter++;
	}

	public void decreaseCones(double cones){
		ConeArray[ConeCounter] = cones;
		ConeCounter++;
	}

	public void SugarAmount(int sugar){

	}

	public double[] getDayCash() {
		return dayCash;
	}

	public double[] getRepArray() {
		return repArray;
	}

	public void printResults() {
		System.out.println("Here are the Cash");
		for (int i = 0; i < 11; i++) {
			System.out.print(dayCash[i] + " ");
		}

		System.out.println("Here are the rep");
		for (int i = 0; i < 11; i++) {
			System.out.print(repArray[i] + " ");
		}
	}
}