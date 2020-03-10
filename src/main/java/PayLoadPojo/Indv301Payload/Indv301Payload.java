package PayLoadPojo.Indv301Payload;



public class Indv301Payload
{
    private String applyFullCycle;

    private String[] qmEntries;

    private String[] columns;

    private Sort[] sort;

    private Filters filters;

    private Page page;

    public String getApplyFullCycle ()
    {
        return applyFullCycle;
    }

    public void setApplyFullCycle (String applyFullCycle)
    {
        this.applyFullCycle = applyFullCycle;
    }

    public String[] getQmEntries ()
    {
        return qmEntries;
    }

    public void setQmEntries (String[] qmEntries)
    {
        this.qmEntries = qmEntries;
    }

    public String[] getColumns ()
    {
        return columns;
    }

    public void setColumns (String[] columns)
    {
        this.columns = columns;
    }

    public Sort[] getSort ()
    {
        return sort;
    }

    public void setSort (Sort[] sort)
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

    @Override
    public String toString()
    {
        return "ClassPojo [applyFullCycle = "+applyFullCycle+", qmEntries = "+qmEntries+", columns = "+columns+", sort = "+sort+", filters = "+filters+", page = "+page+"]";
    }
}
