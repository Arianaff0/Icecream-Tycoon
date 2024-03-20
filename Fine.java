/**
 * This is the fine class which is designed to check if the user has paid to pay a fine or not.
 * This method wil ONLY be called if the user did not pay the license for the day.
 * TO-DO, this class doesn't check if the user paid or not yet.
 * TO-DO, ensure that if when the class returns 0, nothing happens.
 *
 */
import java.math.*;
public class Fine {
    // var that stores if the fine is going to be applied.
    boolean fine;

    // var that stores the value of the fine

    public double getFine(){
        fine = randomBoolean();
        // this is if the fine returns false, then no fine is paid.
        if(!fine){
            return 0;
        }


        else{
            return getFineRandomizer();
        }

    }

    private double getFineRandomizer(){
        return Math.floor(Math.random()*(50-30+1)+30);
    }
    public boolean randomBoolean(){
        return Math.random() < 0.5;
    }



}
