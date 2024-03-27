package application;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.*;

import com.opencsv.*;

/**
 * TO-DO: Make sure that the paths are fixed (both for the com.opencsv) as well as the FileReader
 */
public class CSVFile{

    CSVReader reader;
    String fileName;
    List<String[]> records;
    public CSVFile(String fileName) {
        this.fileName = fileName;
        try{
        reader = new CSVReader(new FileReader(fileName));
        records = reader.readAll();
        }
        catch (FileNotFoundException e){
            System.out.println("file is not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // prints out the entire CSV file (meh at working currently)
    public void ReadCSV()
    {
        try
        {
//parsing a CSV file into CSVReader class constructor
            String [] nextLine;
//reads one line at a time
            for(String[] record : records){
                for (String field : record){
                    System.out.print(field + " | ");
                }
                System.out.println();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



    public void CSVWriter(String UserId,int Difficulty, int day,int weather,double rep,double money,double cones,double sugar,double vanilla,double milk){

        try{
            //TODO fix the excel sheet and fix the double


            String[] newData = {UserId, String.valueOf(Difficulty), String.valueOf(day), String.valueOf(weather),rep + "",money + "",cones + "",sugar + "",vanilla + "",milk + ""};


            if(!records.isEmpty()){
                // change this value!!!!!
                String [] lastrecord = new String[10];

                for(int i = 0; i < newData.length; i ++){
                    lastrecord[i] = newData[i];
                }
                records.set(records.size()-1,lastrecord);
            }
            CSVWriter writer = new CSVWriter(new FileWriter(fileName,true), ',', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
            writer.writeNext(records.get(records.size()-1));
            writer.close();



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }


    public String[] returnLastDay(){
        String[] lastDayRecord;
        lastDayRecord = records.get(records.size()-1);

        return lastDayRecord;

    }



}