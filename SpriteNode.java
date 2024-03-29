/**
 * This class is what creates the single linked list for the sprites.
 * "I cooked doing this class" - Kevin Russel
 *
 * @param <Color> String param that gives the color of the sprite- This color will determine the difficulty
 *               and can be used in the GUI.
 * @param <range> - gives the range of the sprite (Before Range additives).
 */
package application;


public class SpriteNode<Color,range> {

    // var that gets the next node in the single linked list
    private SpriteNode<Color,range> next;
    // var that determines the color
    private Color color;

    private  boolean buy;
    // var that determines the range
    private range range;

    private int newrange;

    // constructor that sets everything to null
    public SpriteNode(){
        range = null;
        color = null;
        next = null;
    }

    public SpriteNode(Color col,range range){
        this.color=col;
        this.range = range;
        next = null;
    }

    public void setRange(range range) {
        this.range = range;
    }

    public range getRange() {
        return range;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setNext(SpriteNode<Color, range> next) {
        this.next = next;
    }

    public SpriteNode<Color, range> getNext() {
        return next;
    }
    public void setNewRange(int num){
        // this condition is so that we don't get negative numbers in the buying power
        if(((int) range)+num <= 0){
            newrange = 0;
        }
        else {
            newrange= (int) range + num;
        }
    }

    public int getNewrange(){
        return newrange;
    }

    public boolean getbuy(){
        return this.buy;
    }

    public void setBuy(boolean val){
        this.buy = val;
    }

}