import java.util.ArrayList;
import java.util.*;
import java.math.*;

/**
 * This is the class that determines what the weather for the next work day will be.
 */
public class Weather {

    // this is the double weather that hold the weather
    double weatherInt;

    String weatherData;

    /**
     * This is the method that will be returning an object array
     * The 0th index will return a double that indicates the weather
     * the 1st index will return what kind of "weather" it is.
     * @return an object arrays
     */
    public Object[] getWeatherInt(){
        Object[] arr = new Object[2];
        weatherInt = weatherRandomizer();
        weatherData = setWeatherData(weatherInt);
        System.out.println(weatherInt);
        System.out.println(weatherData);
        arr[0] = weatherInt;
        arr[1] = weatherData;
        return arr;
    }


    /**
     * This function takes in the random value that was produced and finds its associating weather "descriptor"
     * @param num the random number that was generated.
     * @return a String with the associated descriptor
     */
    private String setWeatherData(double num){
        String weather;

        // if else statments that take in the random number generated and returns the associated weather "descriptor".
        if(num == 0){
            weather = "Freezing";
        }
        else if(num >0 && num <= 5){
            weather = "cold";
        } else if (num >6 && num <= 10) {
            weather = "cool";

        } else if (num >10 && num <= 15) {
            weather = "warm";
        } else if (num >15 && num <=20 ) {
            weather = "hot";
        }
        else{
            weather = "scolding hot";
        }
        return weather;
    }

    /**
     * this method is to randomize the weather. This will help generate the temperature value
     * for the next day.
     * @return a random number between 0 and 25.
     */
    private double weatherRandomizer(){
        // function that generates a double between the value of 0 and 25.
        return Math.floor(Math.random()*(25+1)+0);
    }


}
