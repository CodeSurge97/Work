/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author Surge
 */
public class TheaterSeating 
{
   static Scanner in = new Scanner(System.in);
   
   
   /**
    * This method prints the seating chart and takes the seating array as a parameter
    * @param seatingChart
    */
   
   public static void print_Seats(int[][] seatingChart)
    {
      // Double for loop to go through the bidimensional array
      for(int i = 0; i < seatingChart.length; i++)
       {
         for(int j = 0; j < seatingChart[i].length; j++)
           {
              if(j >= 0)
              {
                System.out.print("\t"); 
                System.out.print(seatingChart[i][j]);  //print the seating chart
              }
        
           }
          System.out.println();
       }
    }
    
    /**
     * This methods takes the a seating chart array parameter and it allows the user
     * to purchase a seat by price
     * @param seatingChart 
     */
     public static void sellSeatByPrice(int seatingChart[][])
     {
        System.out.print("Please enter a price for the seat you would like: ");
        int price = in.nextInt();
        //double fro loop for to go through the bidimensional array
   out: for (int i = 0; i < seatingChart.length; i++) 
        {
           for (int j = 0; j < seatingChart[i].length; j++)
            {
              if (seatingChart[i][j] == price) // If a seat is found at the given price
               { 
                   seatingChart[i][j]=0; break out; // Sell seat(price = 0) Exits the loop after seat is found
               } 
            }
        }
        print_Seats(seatingChart); // print the seating chart
     
  
    }
     
     /**
      * This method allows the user to purchase a seat by selecting the row and number(column) of the seat.
      * It takes the seating chart array parameter
      * @param seatingChart 
      */
     public static void sellSeatByNumber(int seatingChart[][])
     {
       System.out.println("Enter a row, then enter a seat number.");
       System.out.print("What row would you like to sit on?:");
       int row = in.nextInt();
      
       System.out.print("What seat of that row would you like to sit in?:");
       int col = in.nextInt();
       
       if (seatingChart[row][col]!= 0) // If the selected seat is available
       {
           seatingChart[row][col] = 0; // Sell the seat(set price to 0)
           print_Seats(seatingChart); // Print the seats 
           System.out.println("Your seat has been reserved and reflected with a 0 on the chart now.");
       }
       else 
       { 
           System.out.println("Sorry, that seat is already taken."); 
       }
   }

}