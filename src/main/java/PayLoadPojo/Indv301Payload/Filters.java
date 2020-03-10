package PayLoadPojo.Indv301Payload;

import java.util.List;
import java.util.Map;

public class Filters
{
    private BusinessLevels businessLevels;

    private AnalysisPeriod analysisPeriod;

    private ColumnFilters[] columnFilters;

    public BusinessLevels getBusinessLevels ()
    {
        return businessLevels;
    }

    public void setBusinessLevels (BusinessLevels businessLevels)
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

    public ColumnFilters[] getColumnFilters ()
    {
        return columnFilters;
    }

    public void setColumnFilters (ColumnFilters[] columnFilters)
    {
        this.columnFilters = columnFilters;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [businessLevels = "+businessLevels+", analysisPeriod = "+analysisPeriod+", columnFilters = "+columnFilters+"]";
    }
}