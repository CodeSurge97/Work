
class DecimalSepratorFormatter implements NumberFormatter 
{

    @Override
    public String format(int n) 
    {

        return String.format("%,d", n); //formats the number by putting comma for 3 digits

    }

}
