package ResponsePojo.ExecutiveDashboard.QualityMeasures;

import java.util.List;
import java.util.Map;

public class EDQualityMeasuresMetricsResponseDTO {

    private List<EDQualityMeasuresMetricsInfo> data;
    private Map<String,Object> meta;

    public List<EDQualityMeasuresMetricsInfo> getData() {
        return data;
    }

    public void setData(List<EDQualityMeasuresMetricsInfo> data) {
        this.data = data;
    }

    public Map<String, Object> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }

}
