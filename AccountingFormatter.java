

/**
 *
 * @author Surge
 */
public class AccountingFormatter implements NumberFormatter 
{

    @Override
    public String format(int n) 
    {
        if (n < 0)
        {
            return String.format("("+Math.abs(n)+")");
        }
        return String.valueOf(n);
    
    }

}
