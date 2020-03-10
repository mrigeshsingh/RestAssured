package ResponsePojo.Individual301;

import java.util.List;
import java.util.Map;

public class Indv301ResponseMetricsDTO {

    private List<Indv301MetricsInfo> data;
    private Map<String,Object> meta;

    public List<Indv301MetricsInfo> getData() {
        return data;
    }

    public void setData(List<Indv301MetricsInfo> data) {
        this.data = data;
    }

    public Map<String, Object> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }


}
