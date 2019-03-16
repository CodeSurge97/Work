
import java.util.ArrayList;

public class AppointmentBook 
{

    ArrayList<Appointment> appointments;

    public AppointmentBook() 
    {

        appointments = new ArrayList<>();

    }
    
    /**
     * add appointment to appointment book
     * @param a 
     */
    public void addAppointment(Appointment a) 
    {

        appointments.add(a);

    }
    
    /**
     * show all the appointments in the appointment book
     */
    public void showAll() 
    {

        for (Appointment a : appointments) 
        {
            System.out.println(a.toString());
        }

    }
    
    /**
     * show all the appointments that occur on a specific date
     * @param d
     * @param m
     * @param y 
     */
    public void show(int d, int m, int y) 
    {

        for (Appointment a : appointments) 
        {
           
            if (a.occursOn(d, m, y)) 
            {
                System.out.println(a.toString());
            }
        }

    }

}
