/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Surge
 */
public class TestNumberFormatter 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int numbers[] = {-82, 55500, 1000000, 45, 7};

        DefaultFormatter defFmt = new DefaultFormatter();

        DecimalSepratorFormatter deciFmt = new DecimalSepratorFormatter();

        AccountingFormatter accFmt = new AccountingFormatter();

        BaseFormatter baseFmt = new BaseFormatter(16); //base 16

        String s;

        System.out.println("\tDefault \t Decimal \tAccounting \t Base(" + baseFmt.getBase() + ")");

        for (int i = 0; i < numbers.length; i++) {

            print(numbers[i], defFmt);

            print(numbers[i], deciFmt);

            print(numbers[i], accFmt);

            print(numbers[i], baseFmt);

            System.out.println();//new line

        }

    }
    
    /**
     * Prints the integer in the specified format
     * @param n
     * @param formatter
     */
    public static void print(int n, NumberFormatter formatter) 
    {

        String s = String.format("%15s", formatter.format(n));

        System.out.print(s);

    }
}
