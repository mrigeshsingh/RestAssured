package PayLoadPojo.Indv301Payload;

public class Sort
{
    private String field;

    private String order;

    public String getField ()
    {
        return field;
    }

    public void setField (String field)
    {
        this.field = field;
    }

    public String getOrder ()
    {
        return order;
    }

    public void setOrder (String order)
    {
        this.order = order;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [field = "+field+", order = "+order+"]";
    }
}
