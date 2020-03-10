package PayLoadPojo.Indv301Payload;

public class ColumnFilters
{
    private String[] args;

    private String col;

    private String op;

    private String type;

    public String[] getArgs ()
    {
        return args;
    }

    public void setArgs (String[] args)
    {
        this.args = args;
    }

    public String getCol ()
    {
        return col;
    }

    public void setCol (String col)
    {
        this.col = col;
    }

    public String getOp ()
    {
        return op;
    }

    public void setOp (String op)
    {
        this.op = op;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [args = "+args+", col = "+col+", op = "+op+", type = "+type+"]";
    }
}
