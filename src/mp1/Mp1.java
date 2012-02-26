/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mp1;

import domain.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Brian T. Bailey
 */
public class Mp1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declare String to hold Data File Path
        String dataFilePath = "data/Catalog.txt";
        
        // Read and Process Data File into an ArrayList
        ArrayList data = readDataFileToArrayList(dataFilePath);
        
        // Process Data into ContinentEarthquakeRecord Objects Based on Continent
        ArrayList continentEarthquakeData = processRecordsByContinent(data);
        
        // Get ContinentEarthquakeData Arrays from continentEarthquakeData ArrayList
        EarthquakeRecord[] africaEarthquakeData = (EarthquakeRecord[]) continentEarthquakeData.get(0);
        EarthquakeRecord[] asiaEarthquakeData = (EarthquakeRecord[]) continentEarthquakeData.get(1);
        EarthquakeRecord[] australiaEarthquakeData = (EarthquakeRecord[]) continentEarthquakeData.get(2);
        EarthquakeRecord[] eurasiaEarthquakeData = (EarthquakeRecord[]) continentEarthquakeData.get(3);
        EarthquakeRecord[] indiaEarthquakeData = (EarthquakeRecord[]) continentEarthquakeData.get(4);
        EarthquakeRecord[] northAmericaEarthquakeData = (EarthquakeRecord[]) continentEarthquakeData.get(5);
        EarthquakeRecord[] southAmericaEarthquakeData = (EarthquakeRecord[]) continentEarthquakeData.get(6);
        
      
        //Print Results To Screen
        displayOutputHeader(System.out);
        displayTectonicAssocTable(System.out, africaEarthquakeData, asiaEarthquakeData, australiaEarthquakeData, eurasiaEarthquakeData, indiaEarthquakeData, northAmericaEarthquakeData, southAmericaEarthquakeData);
        displayMinMaxEarthquakeTable(System.out, africaEarthquakeData, asiaEarthquakeData, australiaEarthquakeData, eurasiaEarthquakeData, indiaEarthquakeData, northAmericaEarthquakeData, southAmericaEarthquakeData);
        displayOldestNewestByContinent(System.out, africaEarthquakeData, asiaEarthquakeData, australiaEarthquakeData, eurasiaEarthquakeData, indiaEarthquakeData, northAmericaEarthquakeData, southAmericaEarthquakeData);
        displayAllRecordsByContinent(System.out, africaEarthquakeData, asiaEarthquakeData, australiaEarthquakeData, eurasiaEarthquakeData, indiaEarthquakeData, northAmericaEarthquakeData, southAmericaEarthquakeData);

        
        //Print Results to File
        PrintWriter pr = null;
        try {
            pr = new PrintWriter(new FileWriter("data/mp1_out.txt"), true);
            printOutputHeader(pr);
            printTectonicAssocTable(pr, africaEarthquakeData, asiaEarthquakeData, australiaEarthquakeData, eurasiaEarthquakeData, indiaEarthquakeData, northAmericaEarthquakeData, southAmericaEarthquakeData);
            printMinMaxEarthquakeTable(pr, africaEarthquakeData, asiaEarthquakeData, australiaEarthquakeData, eurasiaEarthquakeData, indiaEarthquakeData, northAmericaEarthquakeData, southAmericaEarthquakeData);
            printOldestNewestByContinent(pr, africaEarthquakeData, asiaEarthquakeData, australiaEarthquakeData, eurasiaEarthquakeData, indiaEarthquakeData, northAmericaEarthquakeData, southAmericaEarthquakeData);
            printAllRecordsByContinent(pr, africaEarthquakeData, asiaEarthquakeData, australiaEarthquakeData, eurasiaEarthquakeData, indiaEarthquakeData, northAmericaEarthquakeData, southAmericaEarthquakeData);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (pr != null) {
                pr.close();
            }
        }
 
    }
    
    
    
    // This method is used to read the raw data file provided by the USGS.
    // The data file was found to contain extra newline characters that caused
    // some records to be split between two lines. This method parses through
    // the file and removes the erroneous newline characters and returns an 
    // ArrayList of Strings. Each item in the list is one complete tab
    // deliminated data record. 
    private static ArrayList readDataFileToArrayList(String path) {
        // Declare ArrayList, StringBuilder, BufferedReader...
        ArrayList al = new ArrayList();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        
        try {
            // Create BufferReader FileReader Stream...
            br = new BufferedReader(new FileReader(path));
            String line;
            
            // While there are more lines in the file loop through and read
            // one line at a time. Append the line and a newline character to the 
            // StringBuilder Object. This is done to get the entire file with all
            // the newline characters into a string. The readLine() method strips
            // the newline character off when it reads a line.
            while ((line = br.readLine()) != null) {
                 sb.append(line);
                 sb.append("\n");
            }
                       
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    // Close the BufferedReader
                    br.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                }
            }
        }
        
        // Declare String to hold raw data and fill using the StringBuilder toString
        String dataString = sb.toString();
        
        // Replace all "space newline" character patterns with a "space"
        // This eliminates extra newline characters only after spaces in data
        // Data analysis showed the erroneous newlines always follow spaces
        String processedDataString = dataString.replaceAll(" \n", " ");
        
        // Declare and create new Scanner Object using the processedDataString
        // Set scanner delimiter so that spaces are not used
        Scanner scan = new Scanner(processedDataString);
        scan.useDelimiter("[\t\r\n\f]");
        
        // Loop through lines in processedDataString reading to tmp String
        // If the tmp String is not empty add it to the ArrayList
        // This asssures we are not adding blank lines to the ArrayList
        while (scan.hasNextLine()) {
            String tmp = scan.nextLine();
            if (!tmp.equals("")) {
                al.add(tmp);
            }
        }
        // Close the scanner
        scan.close();
        
        // Return the resulting ArrayList
        return al;
    }

    
    
    // This method is used to process the data file that was read in by
    // the readDataFileToArrayList() method. The method reads an ArrayList of
    // tab deliminated Strings representing one record each. The method
    // returns an ArrayList containing 7 EarthquakeRecord Arrays, one for each
    // continent. The EarthquakeRecord Arrays are stored in the following order:
    // Africa, Asia, Australia, Eurasia, India, North America, South America.
    private static ArrayList processRecordsByContinent(ArrayList rawData) {
        // Declare Scanner and String to hold current data record
        Scanner scan = null;
        String dataRecord;
        
        // Declare and create ArrayLists for each continents records
        ArrayList africaEarthquakeRecords = new ArrayList();
        ArrayList asiaEarthquakeRecords = new ArrayList();
        ArrayList australiaEarthquakeRecords = new ArrayList();
        ArrayList eurasiaEarthquakeRecords = new ArrayList();
        ArrayList indiaEarthquakeRecords = new ArrayList();
        ArrayList northAmericaEarthquakeRecords = new ArrayList();
        ArrayList southAmericaEarthquakeRecords = new ArrayList();
        
        // Loop through each Object in the rawData ArrayList
        // Each Object is a String representing one tab deliminated data record
        for (Object o : rawData) {
            // Store string value of record in dataRecord variable
            dataRecord = o.toString();
            
            // Declare and Create new Scanner Object and set delimiter
            // Set the delimiter so that spaces do not seperate fields
            scan = new Scanner(dataRecord);
            scan.useDelimiter("[\t\r\n\f]");

            // Create String array to temporarily hold the 36 data fields
            String[] record = new String[36];
            for (int i = 0; i < record.length; i++) {
                if (scan.hasNext()) {
                    // If there is a token available store it in the array
                    record[i] = scan.next();
                } else {
                    // If there is no token available store "NO VALUE" in the array
                    // Some records do not have the last two fields, 35 and 36
                    record[i] = "NO VALUE";
                }
            }
            
            // Create Appropriate ContinentEarthquakeRecord object and add to the relative ArrayList
            if (record[5].contains("AF")) {
                // Create New AfricaEarthquakeRecord Object and Add to AF ArrayList
                africaEarthquakeRecords.add(new AfricaEarthquakeRecord(record[0], record[1], record[2], record[3], record[4], record[5], record[6], record[7], record[8], record[9], record[10], record[11], record[12], record[13], record[14], record[15], record[16], record[17], record[18], record[19], record[20], record[21], record[22], record[23], record[24], record[25], record[26], record[27], record[28], record[29], record[30], record[31], record[32], record[33], record[34], record[35]));
            } else if (record[5].contains("AS")) {
                // Create New AsiaEarthquakeRecord Object and Add to AS ArrayList
                asiaEarthquakeRecords.add(new AsiaEarthquakeRecord(record[0], record[1], record[2], record[3], record[4], record[5], record[6], record[7], record[8], record[9], record[10], record[11], record[12], record[13], record[14], record[15], record[16], record[17], record[18], record[19], record[20], record[21], record[22], record[23], record[24], record[25], record[26], record[27], record[28], record[29], record[30], record[31], record[32], record[33], record[34], record[35]));
            }  else if (record[5].contains("AU")) {
                // Create New AustraliaEarthquakeRecord Object and Add to AU ArrayList
                australiaEarthquakeRecords.add(new AustraliaEarthquakeRecord(record[0], record[1], record[2], record[3], record[4], record[5], record[6], record[7], record[8], record[9], record[10], record[11], record[12], record[13], record[14], record[15], record[16], record[17], record[18], record[19], record[20], record[21], record[22], record[23], record[24], record[25], record[26], record[27], record[28], record[29], record[30], record[31], record[32], record[33], record[34], record[35]));
            } else if (record[5].contains("EU")) {
                // Create New EurasiaEarthquakeRecord Object and Add to EU ArrayList
                eurasiaEarthquakeRecords.add(new EurasiaEarthquakeRecord(record[0], record[1], record[2], record[3], record[4], record[5], record[6], record[7], record[8], record[9], record[10], record[11], record[12], record[13], record[14], record[15], record[16], record[17], record[18], record[19], record[20], record[21], record[22], record[23], record[24], record[25], record[26], record[27], record[28], record[29], record[30], record[31], record[32], record[33], record[34], record[35]));
            } else if (record[5].contains("IN")) {
                // Create New IndiaEarthquakeRecord Object and Add to IN ArrayList
                indiaEarthquakeRecords.add(new IndiaEarthquakeRecord(record[0], record[1], record[2], record[3], record[4], record[5], record[6], record[7], record[8], record[9], record[10], record[11], record[12], record[13], record[14], record[15], record[16], record[17], record[18], record[19], record[20], record[21], record[22], record[23], record[24], record[25], record[26], record[27], record[28], record[29], record[30], record[31], record[32], record[33], record[34], record[35]));
            } else if (record[5].contains("NA")) {
                // Create New NorthAmericaEarthquakeRecord Object and Add to NA ArrayList
                northAmericaEarthquakeRecords.add(new NorthAmericaEarthquakeRecord(record[0], record[1], record[2], record[3], record[4], record[5], record[6], record[7], record[8], record[9], record[10], record[11], record[12], record[13], record[14], record[15], record[16], record[17], record[18], record[19], record[20], record[21], record[22], record[23], record[24], record[25], record[26], record[27], record[28], record[29], record[30], record[31], record[32], record[33], record[34], record[35]));
            } else if (record[5].contains("SA")) {
                // Create New SouthAmericaEarthquakeRecord Object and Add to SA ArrayList
                southAmericaEarthquakeRecords.add(new SouthAmericaEarthquakeRecord(record[0], record[1], record[2], record[3], record[4], record[5], record[6], record[7], record[8], record[9], record[10], record[11], record[12], record[13], record[14], record[15], record[16], record[17], record[18], record[19], record[20], record[21], record[22], record[23], record[24], record[25], record[26], record[27], record[28], record[29], record[30], record[31], record[32], record[33], record[34], record[35]));
            }
            
        }
        // Close Scanner Object
        if (scan != null) {
            scan.close();
        }
        
        // Creat ArrayList to hold all 7 Continent EarthquakeRecord Arrays
        ArrayList continentEarthquakeRecords = new ArrayList();
        // Populate continentEarthquakeRecords ArrayList with EarthquakeRecord Arrays
        // Stored in Order: Africa, Asia, Australia, Eurasia, India, North America, South America
        continentEarthquakeRecords.add(africaEarthquakeRecords.toArray(new EarthquakeRecord[africaEarthquakeRecords.size()]));
        continentEarthquakeRecords.add(asiaEarthquakeRecords.toArray(new EarthquakeRecord[asiaEarthquakeRecords.size()]));
        continentEarthquakeRecords.add(australiaEarthquakeRecords.toArray(new EarthquakeRecord[australiaEarthquakeRecords.size()]));
        continentEarthquakeRecords.add(eurasiaEarthquakeRecords.toArray(new EarthquakeRecord[eurasiaEarthquakeRecords.size()]));
        continentEarthquakeRecords.add(indiaEarthquakeRecords.toArray(new EarthquakeRecord[indiaEarthquakeRecords.size()]));
        continentEarthquakeRecords.add(northAmericaEarthquakeRecords.toArray(new EarthquakeRecord[northAmericaEarthquakeRecords.size()]));
        continentEarthquakeRecords.add(southAmericaEarthquakeRecords.toArray(new EarthquakeRecord[southAmericaEarthquakeRecords.size()]));
        
        // Return continentEarthquakeRecords ArrayList containing the 7 EarthquakeRecord Arrays
        return continentEarthquakeRecords;
    }

    
    
    private static void printOutputHeader(PrintWriter out) {
        out.println("Project: MP1");
        out.println("Course: ITM-411");
        out.println("Author: Brian T. Bailey");
        out.println("----------------------------------------------------------------------");
        out.format("%n%n");     
    }

    
    
    private static void displayOutputHeader(PrintStream out) {
        out.println("Project: MP1");
        out.println("Course: ITM-411");
        out.println("Author: Brian T. Bailey");
        out.println("----------------------------------------------------------------------");
        out.format("%n%n");     
    }

    
    
    private static void displayTectonicAssocTable(PrintStream out, EarthquakeRecord[] africa, EarthquakeRecord[] asia, EarthquakeRecord[] australia, EarthquakeRecord[] eurasia, EarthquakeRecord[] india, EarthquakeRecord[] northAmerica, EarthquakeRecord[] southAmerica) {
        // Declare String Array to hold Continent Names
        // Create Array of continentEarthquakeData Arrays passed in as parameters
        String[] continents = {"Africa", "Asia", "Australia", "Eurasia", "India", "North America", "South America"};
        EarthquakeRecord[][] continentData = {africa, asia, australia, eurasia, india, northAmerica, southAmerica};
        
        // Print out table and column headers
        out.println("Tetonic Associations by Continent");
        out.println("----------------------------------------------------------------------");
        out.format("%-16s  %5s  %5s  %10s  %8s  %6s  %8s%n","", "", "", "Non-Rifted", "Possible", "", "Possible");
        out.format("%-16s  %5s  %5s  %10s  %8s  %6s  %8s%n","", "Rifts", "RCM*", "Crust", "Rifts", "Europe", "RCM*");
        out.println("----------------------------------------------------------------------");
        
        // Start table Loop... Print table rows...
        for (int i = 0; i < continentData.length; i++) {
            ArrayList r = new ArrayList();
            ArrayList pm = new ArrayList();
            ArrayList not = new ArrayList();
            ArrayList pr = new ArrayList();
            ArrayList e = new ArrayList();
            ArrayList ppm = new ArrayList();
            for (int j = 0; j < continentData[i].length; j++) {
                if (continentData[i][j].getTectonicAssoc().contentEquals("r")) {
                    r.add(continentData[i][j]);
                } else if (continentData[i][j].getTectonicAssoc().contentEquals("pm")) {
                    pm.add(continentData[i][j]);
                } else if (continentData[i][j].getTectonicAssoc().contentEquals("not")) {
                    not.add(continentData[i][j]);
                } else if (continentData[i][j].getTectonicAssoc().contentEquals("pr")) {
                    pr.add(continentData[i][j]);
                } else if (continentData[i][j].getTectonicAssoc().contentEquals("e")) {
                    e.add(continentData[i][j]);
                } else if (continentData[i][j].getTectonicAssoc().contentEquals("ppm")) {
                    ppm.add(continentData[i][j]);
                }
            }
            out.format("%-16s  %5s  %5s  %10s  %8s  %6s  %8s%n", continents[i], r.size(), pm.size(), not.size(), pr.size(), e.size(), ppm.size());
        }
        
        // Output Table Footer
        out.println("----------------------------------------------------------------------");
        out.println("* Rifted Continental Margins (Passive Margins)");
        out.println("----------------------------------------------------------------------");
        // Output blank lines
        out.format("%n%n");
    }

    
    
    private static void printTectonicAssocTable(PrintWriter out, EarthquakeRecord[] africa, EarthquakeRecord[] asia, EarthquakeRecord[] australia, EarthquakeRecord[] eurasia, EarthquakeRecord[] india, EarthquakeRecord[] northAmerica, EarthquakeRecord[] southAmerica) {
        // Declare String Array to hold Continent Names
        // Create Array of continentEarthquakeData Arrays passed in as parameters
        String[] continents = {"Africa", "Asia", "Australia", "Eurasia", "India", "North America", "South America"};
        EarthquakeRecord[][] continentData = {africa, asia, australia, eurasia, india, northAmerica, southAmerica};
        
        // Print out table and column headers
        out.println("Tetonic Associations by Continent");
        out.println("----------------------------------------------------------------------");
        out.format("%-16s  %5s  %5s  %10s  %8s  %6s  %8s%n","", "", "", "Non-Rifted", "Possible", "", "Possible");
        out.format("%-16s  %5s  %5s  %10s  %8s  %6s  %8s%n","", "Rifts", "RCM*", "Crust", "Rifts", "Europe", "RCM*");
        out.println("----------------------------------------------------------------------");
        
        // Start table Loop... Print table rows...
        for (int i = 0; i < continentData.length; i++) {
            ArrayList r = new ArrayList();
            ArrayList pm = new ArrayList();
            ArrayList not = new ArrayList();
            ArrayList pr = new ArrayList();
            ArrayList e = new ArrayList();
            ArrayList ppm = new ArrayList();
            for (int j = 0; j < continentData[i].length; j++) {
                if (continentData[i][j].getTectonicAssoc().contentEquals("r")) {
                    r.add(continentData[i][j]);
                } else if (continentData[i][j].getTectonicAssoc().contentEquals("pm")) {
                    pm.add(continentData[i][j]);
                } else if (continentData[i][j].getTectonicAssoc().contentEquals("not")) {
                    not.add(continentData[i][j]);
                } else if (continentData[i][j].getTectonicAssoc().contentEquals("pr")) {
                    pr.add(continentData[i][j]);
                } else if (continentData[i][j].getTectonicAssoc().contentEquals("e")) {
                    e.add(continentData[i][j]);
                } else if (continentData[i][j].getTectonicAssoc().contentEquals("ppm")) {
                    ppm.add(continentData[i][j]);
                }
            }
            out.format("%-16s  %5s  %5s  %10s  %8s  %6s  %8s%n", continents[i], r.size(), pm.size(), not.size(), pr.size(), e.size(), ppm.size());
        }
        
        // Output Table Footer
        out.println("----------------------------------------------------------------------");
        out.println("* Rifted Continental Margins (Passive Margins)");
        out.println("----------------------------------------------------------------------");
        // Output Blank Lines
        out.format("%n%n");
    }

    
    
    private static void displayMinMaxEarthquakeTable(PrintStream out, EarthquakeRecord[] africa, EarthquakeRecord[] asia, EarthquakeRecord[] australia, EarthquakeRecord[] eurasia, EarthquakeRecord[] india, EarthquakeRecord[] northAmerica, EarthquakeRecord[] southAmerica) {
        // Declare String Array to hold Continent Names
        // Create Array of continentEarthquakeData Arrays passed in as parameters
        String[] continents = {"Africa", "Asia", "Australia", "Eurasia", "India", "North America", "South America"};
        EarthquakeRecord[][] continentData = {africa, asia, australia, eurasia, india, northAmerica, southAmerica};
        
        // Print out table and column headers
        out.println("Minimum and Maximum Number of");
        out.println("Earthquakes by Continent");
        out.println("--------------------------------");
        out.format("%-14s %8s %8s%n","", "Minimum", "Maximum");
        out.println("--------------------------------");
        
        // Create er to run methods
        AfricaEarthquakeRecord er = new AfricaEarthquakeRecord();
        
        // Start Table Loop... Print Table Rows...
        for (int i = 0; i < continentData.length; i++) {
            // Print Row
            out.format("%-14s %8s %8s%n", continents[i], er.findMinEarthquakesPerContinent(continentData[i]), er.findMaxEarthquakesPerContinent(continentData[i]));
        }
        out.println("--------------------------------");
        int totalEq = 0;
        for (int i = 0; i < continentData.length; i++) {
            totalEq += new Integer(er.findMaxEarthquakesPerContinent(continentData[i]));
        }
        out.format("%-14s %8s %8s%n", "Total", "", totalEq);
        out.println("--------------------------------");
        
        // Output Blank Lines
        out.format("%n%n"); 
    }

    
    
    private static void printMinMaxEarthquakeTable(PrintWriter out, EarthquakeRecord[] africa, EarthquakeRecord[] asia, EarthquakeRecord[] australia, EarthquakeRecord[] eurasia, EarthquakeRecord[] india, EarthquakeRecord[] northAmerica, EarthquakeRecord[] southAmerica) {
        // Declare String Array to hold Continent Names
        // Create Array of continentEarthquakeData Arrays passed in as parameters
        String[] continents = {"Africa", "Asia", "Australia", "Eurasia", "India", "North America", "South America"};
        EarthquakeRecord[][] continentData = {africa, asia, australia, eurasia, india, northAmerica, southAmerica};
        
        // Print out table and column headers
        out.println("Minimum and Maximum Number of");
        out.println("Earthquakes by Continent");
        out.println("--------------------------------");
        out.format("%-14s %8s %8s%n","", "Minimum", "Maximum");
        out.println("--------------------------------");
        
        // Create er to run methods
        AfricaEarthquakeRecord er = new AfricaEarthquakeRecord();
        
        // Start Table Loop... Print Table Rows...
        for (int i = 0; i < continentData.length; i++) {
            // Print Row
            out.format("%-14s %8s %8s%n", continents[i], er.findMinEarthquakesPerContinent(continentData[i]), er.findMaxEarthquakesPerContinent(continentData[i]));
        }
        out.println("--------------------------------");
        int totalEq = 0;
        for (int i = 0; i < continentData.length; i++) {
            totalEq += new Integer(er.findMaxEarthquakesPerContinent(continentData[i]));
        }
        out.format("%-14s %8s %8s%n", "Total", "", totalEq);
        out.println("--------------------------------");
        
        // Output Blank Lines
        out.format("%n%n");
    }

    
    
    private static void displayOldestNewestByContinent(PrintStream out, EarthquakeRecord[] africa, EarthquakeRecord[] asia, EarthquakeRecord[] australia, EarthquakeRecord[] eurasia, EarthquakeRecord[] india, EarthquakeRecord[] northAmerica, EarthquakeRecord[] southAmerica) {
        // Declare String Array to hold Continent Names
        // Create Array of continentEarthquakeData Arrays passed in as parameters
        String[] continents = {"Africa", "Asia", "Australia", "Eurasia", "India", "North America", "South America"};
        EarthquakeRecord[][] continentData = {africa, asia, australia, eurasia, india, northAmerica, southAmerica};
        
        // Print Out Section Headers
        out.println("Oldest and Newest Earthquake Records per Continent");
        out.println("----------------------------------------------------------------------");
        out.println("");
        
        // Create EarthquakeRecord object to use in loop
        EarthquakeRecord er = new AfricaEarthquakeRecord();
        // Print out data
        for (int i = 0; i < continentData.length; i++) {
            out.format("%s  -----------------------------------------%n%n", continents[i]);
            out.format("Oldest %s Record:%n", continents[i]);
            out.format("%s%n%n", er.findOldestEarthquakePerContinent(continentData[i]));
            out.format("Newest %s Record:%n", continents[i]);
            out.format("%s%n%n%n", er.findNewestEarthquakePerContinent(continentData[i]));
        }
        out.println("----------------------------------------------------------------------");
        // Print Blank Lines...
        out.format("%n%n");
    }

    
    
    private static void printOldestNewestByContinent(PrintWriter out, EarthquakeRecord[] africa, EarthquakeRecord[] asia, EarthquakeRecord[] australia, EarthquakeRecord[] eurasia, EarthquakeRecord[] india, EarthquakeRecord[] northAmerica, EarthquakeRecord[] southAmerica) {
        // Declare String Array to hold Continent Names
        // Create Array of continentEarthquakeData Arrays passed in as parameters
        String[] continents = {"Africa", "Asia", "Australia", "Eurasia", "India", "North America", "South America"};
        EarthquakeRecord[][] continentData = {africa, asia, australia, eurasia, india, northAmerica, southAmerica};
        
        // Print Out Section Headers
        out.println("Oldest and Newest Earthquake Records per Continent");
        out.println("----------------------------------------------------------------------");
        out.println("");
        
        // Create EarthquakeRecord object to use in loop
        EarthquakeRecord er = new AfricaEarthquakeRecord();
        // Print out data
        for (int i = 0; i < continentData.length; i++) {
            out.format("%s  -----------------------------------------%n%n", continents[i]);
            out.format("Oldest %s Record:%n", continents[i]);
            out.format("%s%n%n", er.findOldestEarthquakePerContinent(continentData[i]));
            out.format("Newest %s Record:%n", continents[i]);
            out.format("%s%n%n%n", er.findNewestEarthquakePerContinent(continentData[i]));
        }
        out.println("----------------------------------------------------------------------");
        // Print Blank Lines...
        out.format("%n%n");
    }

    
    
    private static void displayAllRecordsByContinent(PrintStream out, EarthquakeRecord[] africa, EarthquakeRecord[] asia, EarthquakeRecord[] australia, EarthquakeRecord[] eurasia, EarthquakeRecord[] india, EarthquakeRecord[] northAmerica, EarthquakeRecord[] southAmerica) {
        // Declare String Array to hold Continent Names
        // Create Array of continentEarthquakeData Arrays passed in as parameters
        String[] continents = {"Africa", "Asia", "Australia", "Eurasia", "India", "North America", "South America"};
        EarthquakeRecord[][] continentData = {africa, asia, australia, eurasia, india, northAmerica, southAmerica};
        
        // Print Out Section Headers
        out.println("All Earthquake Records per Continent");
        out.println("----------------------------------------------------------------------");
        
        // Loop through the arrays and print out each record
        for (int i = 0; i < continentData.length; i++) {
            out.format("%n%s  ----------------------------------------------%n%n", continents[i]);
            for (int j = 0; j < continentData[i].length; j++){
                out.format("%s%n", continentData[i][j]);
            }
            out.println("");
        }
        out.println("----------------------------------------------------------------------");
        // Print Blank Lines...
        out.format("%n%n");
    }

    
    
    private static void printAllRecordsByContinent(PrintWriter out, EarthquakeRecord[] africa, EarthquakeRecord[] asia, EarthquakeRecord[] australia, EarthquakeRecord[] eurasia, EarthquakeRecord[] india, EarthquakeRecord[] northAmerica, EarthquakeRecord[] southAmerica) {
        // Declare String Array to hold Continent Names
        // Create Array of continentEarthquakeData Arrays passed in as parameters
        String[] continents = {"Africa", "Asia", "Australia", "Eurasia", "India", "North America", "South America"};
        EarthquakeRecord[][] continentData = {africa, asia, australia, eurasia, india, northAmerica, southAmerica};
        
        // Print Out Section Headers
        out.println("All Earthquake Records per Continent");
        out.println("----------------------------------------------------------------------");
        
        // Loop through the arrays and print out each record
        for (int i = 0; i < continentData.length; i++) {
            out.format("%n%s  ----------------------------------------------%n%n", continents[i]);
            for (int j = 0; j < continentData[i].length; j++){
                out.format("%s%n", continentData[i][j]);
            }
            out.println("");
        }
        out.println("----------------------------------------------------------------------");
        // Print Blank Lines...
        out.format("%n%n");
    }
    
    
}