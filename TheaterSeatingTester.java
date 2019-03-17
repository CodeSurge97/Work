
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Surge
 */
public class TheaterSeatingTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
         Scanner in = new Scanner(System.in);
         int[][] seatingChart =
         {
         {10,  10,  10,  10,  10,  10,  10,  10,  10,  10,  10,  10},
         {10,  10,  10,  10,  10,  10,  10,  10,  10,  10,  10,  10},
         {10,  10,  20,  20,  20,  20,  20,  20,  20,  20,  10,  10}, 
         {10,  10,  20,  20,  20,  20,  20,  20,  20,  20,  10,  10}, 
         {20,  20,  30,  30,  40,  40,  40,  40,  30,  30,  20,  20}, 
         {20,  20,  30,  30,  40,  40,  40,  40,  30,  30,  20,  20}, 
         {20,  30,  30,  40,  40,  40,  40,  40,  40,  30,  30,  20}, 
         {20,  30,  30,  40,  40,  40,  40,  40,  40,  30,  30,  20}, 
         {30,  30,  40,  40,  50,  50,  50,  50,  40,  40,  30,  30}, 
         {30,  40,  50,  50,  50,  50,  50,  50,  50,  50,  40,  30},
    };
         System.out.println("Welcome to the Apex Theater Seating System");
         System.out.println("Please note that seats are arranged such that");
         System.out.println("Row 0, Column 0, is the top front row.");
         System.out.println("Also, a zero denotes the seat is already sold.");
         
         TheaterSeating.print_Seats(seatingChart); // Print seating chart
         char response = 'Y';
         while ((response == 'Y') || (response == 'y'))
          {
            System.out.print("Pick by Seat <s>, Price <p>, or Quit <q>: ");
            char choice = in.next().charAt(0);
             switch (choice)
              {
               case'S':case's':
               { TheaterSeating.sellSeatByNumber(seatingChart); // If the user enters "s" sell seat by its number
                   break; }
               case'P':case'p':
               { TheaterSeating.sellSeatByPrice(seatingChart); // If the user enters "p" sell seat by price
                   break; }
               case'Q':case'q':                                // If user enters "q" print farewell messay and end program
               { System.out.print("Thank you, come again!");
                   System.exit(0); }
               default:
               { System.out.println("Error: Invalid choice."); }
              }
           System.out.print("Would you like to reserve another seat (Y/N)?: ");
           response = in.next().charAt(0);
       }
       System.out.println("Thank you, come again!");
    }
         
    
}    

       