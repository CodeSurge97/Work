
class BaseFormatter implements NumberFormatter 
{

    int base;

    public BaseFormatter(int b) 
    {

        base = b;

        if (base < 2 || base > 36) //if values out of range 2-36 inclusive are given, set default to 2
        {
            base = 2;
        }
    }

    @Override
    public String format(int n) 
    {
        return Integer.toString(n, base);
    }

    int getBase() 
    {
        return base;

    }

}
