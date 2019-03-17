package register;

/**
 *
 * Title: Register
 * Semester: COP3337 – Summer 2017
 * @author Serge Metellus
 *
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 *
 * This programs reads a file containing the transactions of a register
 * and analyzes those transaction to calculate what the final should be in the register. 
 * It uses the  IOException class to throw a FileNotFoundException(if necessary)
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Surge
 */
public class Register {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try 
        {
            doEverything();
        } 
        catch (FileNotFoundException e) 
        {
            System.err.println(e.getMessage());
        }
    }
    
    /**
     * Reads user input and the specified file, and analyzes the transactions
     * @throws FileNotFoundException If path doesn't exist
     */
    private static void doEverything() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> invoice = new ArrayList<Integer>();
        ArrayList<Double> cash = new ArrayList<Double>();
        ArrayList<String> PR = new ArrayList<String>();

        System.out.println("Enter the amount of cash you started with: ");
        double startingCash = in.nextDouble();
        System.out.println("Enter the amount of cash you ended with: ");
        double endingCash = in.nextDouble();

        System.out
                .println("Enter the address of the file you wish to read from: ");
        Scanner readFile = new Scanner(new File(in.next()));

        //Filling ArrayLists
        while (readFile.hasNext()) {
            invoice.add(readFile.nextInt());
            cash.add(readFile.nextDouble());
            PR.add(readFile.next());
        }

        //Determining whether to add or subtract from startingCash
        for (int i = 0; i < invoice.size(); i++) {
            if (PR.get(i).equals("P")) {
                startingCash -= cash.get(i);
            }
            if (PR.get(i).equals("R")) {
                startingCash += cash.get(i);
            }
        }

        //Determines whether the right amount is in the register,
        //prints results
        if (startingCash == endingCash
                || (double) Math.round(startingCash * 1000000000) / 1000000000 == endingCash) {
            System.out.println("There is the correct amount in the register.");

        } else {
            Double offBy = ((double) Math.round(startingCash * 100000) / 100000)
                    - endingCash;
            System.out.println("You are off by: " + offBy);
        }
        in.close();
        readFile.close();

    }
    
}
