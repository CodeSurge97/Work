/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Surge
 */
class PrimeGenerator 
{
    int count;
    public PrimeGenerator()
    {
        count = 2;
    }
    public static boolean isPrime(int number) 
    {
        for(int check = 2; check < number; ++check) 
        {
            if(number % check == 0) 
            {
                return false;
            }
        }
        return true;
        
       
    }
  public int nextPrime()
   {
    count++;
    while(!isPrime(count))

       {

         count++;

       }

      return count;
        
  }  
    

}
