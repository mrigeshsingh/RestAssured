package ResponsePojo.ExecutiveDashboard;

import java.util.Map;



public class EDMetricsResponseDTO {
    private Map<String , EDMetricsInfo>  data;
    private Object meta;

    public Map<String, EDMetricsInfo> getData() {
        return data;
    }

    public void setData(Map<String, EDMetricsInfo> data) {
        this.data = data;
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }
}




