/**
 * Title: Polynomial
 * Semester: COP3337 – Summer 2017
 *
 * @author Serge Metellus
 *
 * I affirm that this program is entirely my own work and none of it is the work
 * of any other person.
 *
 * This program creates a polynomial as a linked list of terms. A term contains 
 * the coefficient and the power of x. It manipulates the polynomials by adding, multiplying, and printing them. 
 */

import java.util.LinkedList;
import java.util.ListIterator;
/**
 * A class to represent a polynomial.
 */
public class Polynomial 
{
    private LinkedList<Term> termList = new LinkedList<>();
    
    /**
     * Constructs an empty polynomial
     */
    public Polynomial()
    {
        termList = new LinkedList <>();
    }
    
    /**
     * Constructs a new polynomial with the given term
     * @param t the term to initialize the polynomial with
     */
    public Polynomial(Term t)
    {
        termList.add(t);
    }
    
    /**
     * Adds the polynomial such that the terms are in sorted order
     * from highest power to lowest
     * @param p the polynomial to add
     */
    public void add(Polynomial p)
    {
        //Declares a term object and sets it equal to the first Term of the polynomial passed as a parameter
        Term myTerm = p.termList.getFirst();
        boolean added = false;
        //If the linked list is empty
        if(termList.isEmpty())
        {
            //add the term
            termList.addLast(myTerm);
            added = true;
        }
        //loop through the Polynomial to add the term correctly and in the correct order
        for(int i = 0; i < termList.size() && !added; i++)
        {
            Term nextTerm = termList.get(i);
            if(nextTerm.getPower() == myTerm.getPower())
            {
                nextTerm.addIfSamePower(myTerm);
                added = true;
                
            }
            if(nextTerm.getPower() < myTerm.getPower())
            {
                termList.add(i, myTerm);
                added = true;
            }
        }
       // If the term still hasn't been added to the list then it is samller then all the other 
       // terms so add at the end of the list
       if(!added)
        {
           termList.addLast(myTerm);
        }
    }
    
    /**
     * Multiplies the given polynomial with this one and returns the result
     * @param p the polynomial to multiply
     * @return result
     */
    public Polynomial multiply(Polynomial p)
    {
        Polynomial result = new Polynomial();
        // Iterator for "this" object
        ListIterator <Term> itr;
        // Iterator for p object
        ListIterator <Term> itr2 = p.termList.listIterator();
        //Term object declarations
        Term myTerm;
        Term li2Term;
        //While there are terms in the p object and "this object, multiply the terms and set the result equal to a new term,create
        //a new polynomial, add the term to the polynomial and add that polynomial to the result polynomial
        while (itr2.hasNext())
        {
            li2Term = (Term) itr2.next();
            itr = termList.listIterator();
            while (itr.hasNext())
            {
                myTerm = (Term) itr.next();
                Term term1 = myTerm.multiply(li2Term);
                Polynomial newresult = new Polynomial();
                newresult.termList.add(term1);
                result.add(newresult);
            }
        }
        return result;
    }
    
    /**
     * Prints the polynomial "nicely" so that it reads
     * from highest term to lowest and doesn't have a
     * leading "+" if the first term is positive.
     */
    public void print()
    {
        ListIterator <Term> itr = termList.listIterator();
        Term myTerm;
        String result = "";
        boolean firstTime = true;
         //correctly handles the cases when the exponent
        //is 0 or 1 and the
        //coefficient is 0, 1, or -1
        while (itr.hasNext())
        {
            myTerm = itr.next();
            if ((myTerm.getCoefficient() > 0) && !firstTime) 
            {
                result += " + ";
            }
            firstTime = false;
            if (myTerm.getCoefficient() == 0) 
            {
                result += "";
            }
            else if (myTerm.getCoefficient() <= -1) 
            {
                result += " - " + myTerm.toString() + " ";
            } 
            else 
            {
                result += myTerm.toString();
            }
        }
        System.out.println(result);
    }
}