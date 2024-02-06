package myProjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Data {
    String datatxtPath = System.getProperty("user.dir") + "/src/myProjects/data.txt";

    public Data() throws IOException {
    }

    public void FoodArr(int index, double newPrice)throws IOException{
       File myObj = new File(datatxtPath);
       Scanner myReader = new Scanner(myObj);
       String FirstLine = myReader.nextLine();
       int i =1;
       String newString = "";
       for (String prices : FirstLine.split(",")){
           if(i == 1){
               if(index == i){
                   newString += newPrice;
               }else {
                   newString += prices;
               }
           }else {
               if (index == i) {
                   newString += "," + newPrice;
               }else {
                   newString += "," + prices;
               }
           }


           i++;
       }
        FileWriter myWriter = new FileWriter(datatxtPath);
        myWriter.write(newString);
        myWriter.close();
        System.out.println("prices Changed");

    }
    public String FoodReturn() throws FileNotFoundException{
        File myObj = new File(datatxtPath);
        Scanner myReadet = new Scanner(myObj);
        String FirsLine = myReadet.nextLine();
        return FirsLine;
    }

}


