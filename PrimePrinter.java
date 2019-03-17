/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author Surge
 */
public class PrimePrinter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
         Scanner in = new Scanner(System.in);

      System.out.print("Enter a Number: ");

      int maxInt = in.nextInt();

      PrimeGenerator Generator = new PrimeGenerator();

      int i = 2;

      int prime;

      System.out.println("Prime numbers are:");

      while(i  <= maxInt)
    {

      if(i == 2)

         System.out.println(i+" ");

      else
      {
        prime = Generator.nextPrime();
        if(prime <= maxInt)
        {

          System.out.println(prime + " ");

        }
      }

      i++;

    }

  }
    
    
}
