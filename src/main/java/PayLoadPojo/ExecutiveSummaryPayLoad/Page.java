package PayLoadPojo.ExecutiveSummaryPayLoad;

public class Page
{
    private String size;

    private String offset;

    public String getSize ()
    {
        return size;
    }

    public void setSize (String size)
    {
        this.size = size;
    }

    public String getOffset ()
    {
        return offset;
    }

    public void setOffset (String offset)
    {
        this.offset = offset;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [size = "+size+", offset = "+offset+"]";
    }
}
