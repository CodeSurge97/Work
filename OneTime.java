
/**
 * A onetime appointment.
 */
public class OneTime extends Appointment {

    /**
     * Initializes appointment for a given date.
     *
     * @param year the year
     * @param month the month
     * @param day the day
     * @param description the text description of the appointment
     */
    public OneTime(int day, int month, int year, String description) 
    {
        super(day, month, year, description);
    }
    
    public String toString() 
    {

        return "[OneTime] " + super.toString() + " on " + month + "/" + day + "/" + year ;

    }
}

