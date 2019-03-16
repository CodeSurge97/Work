/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playerroster;
import java.util.Scanner;



/**
 *
 * @author Surge
 */
public class PlayerRoster {

    static Scanner sc = new Scanner(System.in);
  
   public static void main(String[] args) {
       char option;
       String text, phraseToFind;

       //Reading text from user
       System.out.println("Enter a sample text:");
       text = sc.nextLine();

       //Printing text
       System.out.println("\nYou entered: " + text);

       //Loop till user wants to quit
       while(true)
       {
           //Printing menu
           option = printMenu();

           //Calling functions based on option selected by user
           switch(option)
           {
               //User wants to quit
               case 'q':
               case 'Q': System.exit(0);

               //Counting non-white space characters
               case 'c':
               case 'C': System.out.println("\n\nNumber of non-whitespace characters: " + GetNumOfNonWSCharacters(text) );
break;

               //Counting number of words
               case 'w':
               case 'W': System.out.println("\n\nNumber of words: " + GetNumOfWords(text) );
                               break;

               //Counting number of occurrences phrase in given string
               case 'f':
               case 'F': sc.nextLine(); 
               System.out.println("Enter a word or phrase to find: ");
                           phraseToFind = sc.nextLine();
  
                           System.out.println("\"" + phraseToFind + "\" instances: " + FindText(text, phraseToFind) );
                           break;

               //Replacing ! with .
               case 'r':
               case 'R': text = ReplaceExclamation(text); System.out.println("\n\nEdited text: " + text);
break;

               //Replacing multiple spaces with single space
               case 's':
               case 'S': text = ShortenSpace(text); System.out.println("\n\nEdited text: " + text );
break;

               default: System.out.println("\n\nInvalid Choice.... Try Again"); break;
           }
       }
   }
  
   public static char printMenu()
   {
       char ch;
      
       //Printing menu
       System.out.println("\nMENU");
       System.out.println("c - Number of non-whitespace characters\nw - Number of words\nf - Find text\nr - Replace all !'s\ns - Shorten spaces\nq - Quit");
       System.out.print("\nChoose an option:\n");

       //Reading user choice
       ch = sc.next().charAt(0);

       return ch;
   }
  
   //Method that count number of non space characters
   public static int GetNumOfNonWSCharacters(String textIp)
   {
       int cnt = 0, i;
       int len = textIp.length();
      
       char text[] = textIp.toCharArray();

       //Looping over given text
       for(i=0; i<len; i++)
       {
           //Counting spaces
           if(!Character.isWhitespace(text[i]))
               cnt++;
       }

       return cnt;
   }
  
   //Method that count number of words in the string
   public static int GetNumOfWords(String textIp)
   {
       int words = 0, i;
       int len = textIp.length();
  
       char text[] = textIp.toCharArray();
      
       //Looping over text
       for(i=0; i<len;)
       {
           //Checking for space
           if(Character.isWhitespace(text[i]))
           {
               //Handling multiple spaces
               while(Character.isWhitespace(text[i]))
                   i++;

               //Incrementing words
               words++;
           }
           else
           {
               i++;
           }
       }

       //Handling last word
       words = words + 1;

       return words;
   }
  
   //Method that counts the occurrences of given phrase in a given text
   public static int FindText(String text, String phrase)
   {
       int count = 0;
       int it;
       
       while ((it = text.indexOf(phrase)) != -1) 
       {
          text = text.substring(it+phrase.length());
          count += 1;
       }
       return count;
   }
  
  
   //Function that replaces ! with .
   public static String ReplaceExclamation(String textIp)
   {
       int i, len = textIp.length();
  
       char text[] = textIp.toCharArray();
       char newText[] = textIp.toCharArray();
      
       //Looping over string
       for(i=0; i<len; i++)
       {
           //Replacing ! with .
           if(text[i] == '!')
               newText[i] = '.';
       }
      
       String textOp = new String(newText);
      
       return textOp;
   }
  
   //Function that replaces Multiple spaces with single space
   public static String ShortenSpace(String textIp)
   {
      String textOp = textIp.trim().replaceAll(" +", " ");
      return textOp;
   }

}