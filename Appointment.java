/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Surge
 */
public class Appointment 
{
    protected String description;
    protected int year;
    protected int month;
    protected int day;

    /**
     * Initializes appointment for a given date.
     *
     * @param year the year
     * @param month the month
     * @param day the day
     * @param description the text description of the appointment
     */
    public Appointment(int day, int month, int year, String description) 
    {
        this.year = year;
        this.month = month;
        this.day = day;
        this.description = description;
    }

    /**
     * Returns the text description of the appointment.
     * @return the text description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Set the text description
     * @param description 
     */
    public void setDescription(String description) 
    {
        this.description = description;
    }

     /**
     * Returns the year of the appointment.
     * @return the year
     */
    public int getYear() 
    {
        return year;
    }
    
    /**
     * Set the year of the appointment
     * @param year 
     */
    public void setYear(int year) 
    {
        this.year = year;
    }
    
    /**
     * Returns the month of the appointment.
     * @return the month
     */
    public int getMonth() 
    {
        return month;
    }
    
    /**
     * Set the month of the appointment
     * @param month 
     */
    public void setMonth(int month) 
    {
        this.month = month;
    }
    
    /**
     * Returns the day of the appointment.
     * @return the day
     */
    public int getDay() 
    {
        return day;
    }
    
    /**
     * Set the day of the appointment
     * @param day 
     */
    public void setDay(int day) 
    {
        this.day = day;
    }
    
    /**
     * Determines if the appointment is on the date given.
     *
     * @param year the year to check
     * @param month the month to check
     * @param day the day to check
     * @return true if the appointment matches all three parameters
     */
    public boolean occursOn(int day, int month, int year) 
    {
        return (year == this.year) && (month == this.month) && (day == this.day);
    }

    /**
     * Converts appointment to string description.
     * @return 
     */
    
    @Override
    public String toString() 
    {
        return description;
    }

}
