/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testooad;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Imran Kamil
 */
public class TestOOAD {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        
        
        String path = "\"D:\\Downloads\\OOAD\\Project\\properties.csv\"";
        String line = "";
        int rows = 0;
        
        // String ilan = "200";
        // int i = Integer.parseInt(ilan);  example change string to int
        // System.out.println(i + 100);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            
            List<String[]> lines = new ArrayList<String[]>();
            while((line = br.readLine()) != null) {
                lines.add(line.split(","));
                rows++;
            }
            
            String[][] array = new String[lines.size()][0];
            lines.toArray(array);
            br.close();
            
            int change;
            int brchange;
            
            String propType = "Semi-D";
            int minprice = 5000;
            int maxprice = 10000;
            String furn = "Fully furnished";
            int bedroom = 4;
            
            int propcount = 0;
            int pricecount = 0;
            int furncount = 0;
            
            List<Integer> aftprop = new ArrayList<>();
            List<Integer> aftprice = new ArrayList<>();
            List<Integer> aftfurn = new ArrayList<>();
            
            // Residential type
            for(int i=0;i<rows;i++){
                if (array[i][0].equals(propType)){
                    System.out.println(propType + " in row " + (i+1));
                    propcount++;
                    aftprop.add(i);
                }
            }
            
            // Price Range
            for(int i=0;i<propcount;i++){
                int row = aftprop.get(i);
                change = Integer.parseInt(array[row][1]);
                if ((change >= minprice) && (change <= maxprice)){
                    System.out.println("Got this price at row " + (row+1));
                    pricecount++;
                    aftprice.add(row);
                    }
            }
            
            // Furniture
            for(int i=0;i<pricecount;i++){
                int row = aftprice.get(i);
                if (array[row][2].equals(furn)){
                    System.out.println("Row " + (row+1) + " is Unfurnished");
                    furncount++;
                    aftfurn.add(row);
                }
            }
            
            // Bedrooms
            for(int i=0;i<furncount;i++){
                int row = aftfurn.get(i);
                brchange = Integer.parseInt(array[row][3]);
                if (brchange >= bedroom){
                    System.out.println("Bedrooms Sepcification in row " + (row+1));
                }
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestOOAD.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
        
      
        
    }
    
    public void testImage(){
        testimage home = new testimage();
        home.show();
    }
    
}
