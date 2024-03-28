package application;
/**
 * This is the main gameplay class
 * Remember to fix the weater and the reputation.
 *
 */

public class MainGamePlayClass {

    private SpriteNode head;
    private SpriteNode tail;

    public static boolean SpriteOrder[] = new boolean[10];
    /** simply a placeholder for the currentPlayer variable*/
    private Player currentPlayer;

    public  MainGamePlayClass(Player player) {
        this.currentPlayer = player;
        // remember to change this down
        int iceCreameCounter = currentPlayer.inventory.getMaxSellableProduct();
        System.out.println(iceCreameCounter);
        Weather weather = new Weather();
        double weatherNum= (double) weather.getWeatherInt()[2];
        // change this later
        double iceCremePrice = currentPlayer.recipe.getConePrice();


        Reputation rep = new Reputation();
        // TODO remember to change this
        rep.setReputation(1.0);
        int repNum =(int)rep.getReputation();

        // this is going to be a customer counter for the sprite, can't let it go over 20.
        int customerCounter;

        head = null;
        tail = null;

        // this gets the Sprites hardness, then creates a new application.Sprite Linked list.
        for (customerCounter = 0; customerCounter < 10; customerCounter++) {
            int range;
            String hard;
            int test =(int) SpriteHardnessMaker();
            if (test == 1) {
                range = -2;
                hard = " red ";
            } else if (test == 2) {
                range = -1;
                hard = " blue ";
            } else if (test == 3) {
                range = 1;
                hard = " green ";
            } else if (test == 4) {
                range = 2;
                hard = " black ";
            } else {
                range = 3;
                hard = " gold ";

            }

            // this part is to put that into a node.
            SpriteNode newNode = new SpriteNode(hard,range);

            // first case when there is no nodes in the list.
            if(head == null){

                head = newNode;
                tail = newNode;
                newNode.setNewRange((int)weatherNum);
            }
            // second case when there is a head node
            // we first have to traverse the linked list
            else{
                // setting this to the head node
                SpriteNode currNode = head;
                while(currNode.getNext()!= null){
                    currNode = currNode.getNext();
                }
                currNode.setNext(newNode);
                tail = newNode;
                newNode.setNewRange((int)weatherNum + repNum);
            }
        }

        SpriteNode currNode = head;
        while(currNode!= null){
            System.out.print(currNode.getRange());
            System.out.print(currNode.getColor());
            System.out.print(currNode.getNewrange());

            // this is an if statement to stimulate if they will buy or not.
            if(iceCreameCounter > 0 && 0<currNode.getNewrange() && currNode.getNewrange()>=iceCremePrice){
                iceCreameCounter --;
                System.out.print(" buy");
                // seeing if they buy
                currNode.setBuy(true);
            }
            else{
                System.out.print(" don't buy");
                currNode.setBuy(false);
            }
            System.out.println();
            currNode = currNode.getNext();
        }


        // this is for the boolean
        SpriteNode BooleanNode = head;
        int arrayCount = 0;
        while(BooleanNode!= null){
            // this is an if statement to stimulate if they will buy or not.
            if(!BooleanNode.getbuy()){
                SpriteOrder[arrayCount] = false;
            }
            else{
                SpriteOrder[arrayCount] = true;
            }
            arrayCount = arrayCount +1;
            BooleanNode = BooleanNode.getNext();
        }
        currentPlayer.getNewFile().CSVWriter(currentPlayer.getNewFile().returnLastDay()[0] ,
                Integer.parseInt(currentPlayer.getNewFile().returnLastDay()[1]),
                Integer.valueOf(currentPlayer.getNewFile().returnLastDay()[2])+1,
                 Integer.valueOf((int) weatherNum),
                repNum, currentPlayer.getBalance(),
                currentPlayer.inventory.getCones(),
                currentPlayer.inventory.getSugar(),
                currentPlayer.inventory.getVanilla(),
                currentPlayer.inventory.getCream());
    }

    /**
     * Function that figures out the sprite hardness
     * @return a number between 1 and 6 to indicate how small the range of buying is.
     */
    public  double SpriteHardnessMaker(){
        return( (Math.random()*(5))+1);
    }
}