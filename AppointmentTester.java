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
public class AppointmentTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        AppointmentBook book = new AppointmentBook();

        book.addAppointment(new Monthly(5, 1, 2017, "Pay electric bill"));

        book.addAppointment(new Daily(10, 2, 2017, "Meet Mr. John"));

        book.addAppointment(new OneTime(15, 2, 2017, "Meet dentist"));

        System.out.println("The appointments in the book are ");

        book.showAll();

        Scanner scanner = new Scanner(System.in);

        String answer;
        String description;
        int type;
        int day; 
        int month; 
        int year;

        Appointment app;

        while (true) 
        {

            System.out.println("Do you want to Add an appointment? Y/N: ");

            answer = scanner.next();

            if (!answer.equalsIgnoreCase("y")) 
            {
                break;
            } 
            else 
            {

                while (true) 
                {

                    System.out.println("1. One time");

                    System.out.println("2. Daily");

                    System.out.println("3. Monthly");

                    System.out.println("Choose appointment type: ");

                    type = scanner.nextInt();

                    if (type >= 1 && type <= 3) 
                    {
                        break;
                    }

                }

                scanner.nextLine(); //flush newline

                System.out.println("Enter description: ");

                description = scanner.nextLine();

                System.out.println("Enter day: ");

                day = scanner.nextInt();

                System.out.println("Enter month: ");

                month = scanner.nextInt();

                System.out.println("Enter year: ");

                year = scanner.nextInt();

                if (type == 1) 
                {
                    app = new OneTime(day, month, year, description);
                } 
                else if (type == 2) 
                {
                    app = new Daily(day, month, year, description);
                } 
                else 
                {
                    app = new Monthly(day, month, year, description);
                }

                book.addAppointment(app); // add appointment to appointment book

            }

        }

        System.out.println("\nThe appointments in the book are ");

        book.showAll();

        System.out.println("\nEnter date to show appointments for the date");

        System.out.println("Enter day: ");

        day = scanner.nextInt();

        System.out.println("Enter month: ");

        month = scanner.nextInt();

        System.out.println("Enter year: ");

        year = scanner.nextInt();

        book.show(day, month, year);

    }

}
