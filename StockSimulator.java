/**
 * Title: Stocks
 * Semester: COP3337 – Summer 2017
 *
 * @author Serge Metellus
 *
 * I affirm that this program is entirely my own work and none of it is the work
 * of any other person.
 *
 * This program calculates the gains(or losses) for arbitrary purchases and sales 
 * of shares in a single company
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
import java.util.TreeMap;
/**
   Class for simulating trading a single stock at varying prices.
*/
public class StockSimulator
{
   private Map<String, Queue<Block>> blocks;

   /**
      Constructor.
   */
   public StockSimulator()
   {
      blocks = new TreeMap<>();
   }

   /**
      Handle a user buying a given quantity of stock at a given price.
      @param symbol the stock to sell
      @param quantity how many to buy.
      @param price the price to buy.
   */
   public void buy(String symbol, int quantity, int price)
   {
       //If the stock exist
       if((blocks.get(symbol)) != null)
      {
          //Get the current queue 
          Queue newQueue = blocks.get(symbol);
          Block newBlock = new Block(quantity, price);
         // add a new block
          newQueue.add(newBlock);
      }
      //If the stock does not exist
      else
      {
         //Creates a new queue
          Queue<Block> newBlock = new LinkedList<>();
         //Adds a new block to the queue
          newBlock.add(new Block (quantity, price));
         //puts the new block and its association into the map
          blocks.put(symbol, newBlock);
      }
   }

   /**
      Handle a user selling a given quantity of stock at a given price.
      @param symbol the stock to sell
      @param quantity how many to sell.
      @param price the price to sell.
   */
   public void sell(String symbol, int quantity, int price)
   {
      int total = 0;
      Queue <Block> myQueue;
      if(blocks.containsKey(symbol) && quantity > 0 && price >= 0)
      {
          int qtySold;
          int accuGain = 0;
          int priceDiffer;
          myQueue = blocks.get(symbol);
          for(int i = 0; i < blocks.get(symbol).size(); i++)
          {
              Block newBlock = blocks.get(symbol).remove();
              total += newBlock.getQuantity();
              myQueue.add(newBlock);
          }
          //If the total amount of stocks is greater than or equal to the given quanity
          if(total >= quantity)
          {
              while(quantity > 0)
              {
                 // If the queue is not empty
                  if(!(myQueue.isEmpty()))
                  {
                      //The first block in the queue
                      Block firstIn = myQueue.peek();
                      //if the qunntity of stocks in the block is greater then the given quantity
                      if(firstIn.getQuantity() > quantity)
                      {
                           firstIn.sell(quantity);
                           qtySold = quantity;
                           // The difference in the prices
                           priceDiffer = price - firstIn.getPrice();
                      }
                      
                      else
                      {
                          qtySold = firstIn.getQuantity();
                          priceDiffer = price - firstIn.getPrice();
                          myQueue.remove();
                      }
                      //subtratcs the quantity sold from the avalable quantity
                      quantity -= qtySold;
                      //Calculates the amount gained or lost
                      accuGain += qtySold * priceDiffer;
                  }
              }
              
              for(int i = 0; i < myQueue.size(); i++)
              {
                  blocks.get(symbol).add(myQueue.remove());
              }
              //If the amount gained equals zero
              if(accuGain == 0)
              {
                  System.out.println("Did not make any profit");
              }
              else
              {
                 //If the amount gained is greater than zero 
                 if(accuGain > 0)
                 {
                    System.out.print("    Gain: $" + accuGain + ".00\n");
                      
                 }
                 else
                 {
                     System.out.print("    Loss: $" + Math.abs(accuGain) + ".00\n");
                 }
              }
          }
          else
          {
              System.out.println("There are not enough shares in stock \n");
          }
      }
      
      else
      {
          if(!(blocks.containsKey(symbol)))
          {
              System.out.println("The stock symbol is not in our records\n");
          }
          if(quantity < 0)
          {
              System.out.println("Quanity cannot be negative\n");
          }
          else
          {
              System.out.println("Nothing was sold\n");
          }
          if(price < 0)
          {
              System.out.println("Price cannot be negative");
          }
      }
   }
}