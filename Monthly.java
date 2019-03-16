
/**
 * Monthly appointment.
 */
public class Monthly extends Appointment {

    /**
     * Initializes appointment for a given date.
     *
     * @param year the year
     * @param month the month
     * @param day the day
     * @param description the text description of the appointment
     */
    public Monthly(int year, int month, int day, String description) 
    {
        super(year, month, day, description);
    }

    /**
     * Determines if the appointment occurs on the same day of the month.
     *
     * @param year the year
     * @param month the month
     * @param day the day
     * @return true if day matches the appointment date and is later than the
     * base appointment
     */
    @Override
    public boolean occursOn(int day, int month, int year) 
    {
        if (year < getYear()) 
        {
            return false;
        }
        if (month < getMonth() && year == getYear()) 
        {
            return false;
        }
        return day == getDay();
    }

    @Override
    public String toString() {
        return "[Monthly] " + description + " on day "+ day + " of the month";
    }
    
    
}
