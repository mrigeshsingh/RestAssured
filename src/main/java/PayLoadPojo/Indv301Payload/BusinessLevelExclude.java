package PayLoadPojo.Indv301Payload;

public class BusinessLevelExclude {
    private String[] exclude;

    public String[] getExclude ()
    {
        return exclude;
    }

    public void setExclude (String[] exclude)
    {
        this.exclude = exclude;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [exclude = "+exclude+"]";
    }
}
