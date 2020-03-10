package PayLoadPojo.ExecutiveSummaryPayLoad;

public class AnalysisPeriod
{
    private String[] args;

    private String period;

    private String periodOverPeriod;

    private String type;

    public String[] getArgs ()
    {
        return args;
    }

    public void setArgs (String[] args)
    {
        this.args = args;
    }

    public String getPeriod ()
    {
        return period;
    }

    public void setPeriod (String period)
    {
        this.period = period;
    }

    public String getPeriodOverPeriod ()
    {
        return periodOverPeriod;
    }

    public void setPeriodOverPeriod (String periodOverPeriod)
    {
        this.periodOverPeriod = periodOverPeriod;
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
        return "ClassPojo [args = "+args+", period = "+period+", periodOverPeriod = "+periodOverPeriod+", type = "+type+"]";
    }
}