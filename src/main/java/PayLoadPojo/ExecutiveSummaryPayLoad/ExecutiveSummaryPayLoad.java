package PayLoadPojo.ExecutiveSummaryPayLoad;

import java.util.Map;

public class ExecutiveSummaryPayLoad
{
    private String[] columns;

    private String[] sort;

    private Filters filters;

    private Page page;

    private Map norm;

    public String[] getColumns ()
    {
        return columns;
    }

    public void setColumns (String[] columns)
    {
        this.columns = columns;
    }

    public String[] getSort ()
    {
        return sort;
    }

    public void setSort (String[] sort)
    {
        this.sort = sort;
    }

    public Filters getFilters ()
    {
        return filters;
    }

    public void setFilters (Filters filters)
    {
        this.filters = filters;
    }

    public Page getPage ()
    {
        return page;
    }

    public void setPage (Page page)
    {
        this.page = page;
    }

    public Map getNorm ()
    {
        return norm;
    }

    public void setNorm (Map norm)
    {
        this.norm = norm;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [columns = "+columns+", sort = "+sort+", filters = "+filters+", page = "+page+", norm = "+norm+"]";
    }
}