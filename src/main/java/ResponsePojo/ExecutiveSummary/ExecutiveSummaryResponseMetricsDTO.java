package ResponsePojo.ExecutiveSummary;

import java.util.Map;

public class ExecutiveSummaryResponseMetricsDTO {


    public Data getData() {
        return Data;
    }

    public void setData(Data Data) {
        this.Data = Data;
    }

    public Map getMeta() {
        return meta;
    }

    public void setMeta(Map meta) {
        this.meta = meta;
    }

    private Data Data;
    private Map meta;
}
