package PayLoadPojo.ExecutiveSummaryPayLoad;

import java.util.Map;

public class Filters
{
    private Map businessLevels;

    private AnalysisPeriod analysisPeriod;

    private String[] columnFilters;

    public Map getBusinessLevels ()
    {
        return businessLevels;
    }

    public void setBusinessLevels (Map businessLevels)
    {
        this.businessLevels = businessLevels;
    }

    public AnalysisPeriod getAnalysisPeriod ()
    {
        return analysisPeriod;
    }

    public void setAnalysisPeriod (AnalysisPeriod analysisPeriod)
    {
        this.analysisPeriod = analysisPeriod;
    }

    public String[] getColumnFilters ()
    {
        return columnFilters;
    }

    public void setColumnFilters (String[] columnFilters)
    {
        this.columnFilters = columnFilters;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [businessLevels = "+businessLevels+", analysisPeriod = "+analysisPeriod+", columnFilters = "+columnFilters+"]";
    }
}
