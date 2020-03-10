package ResponsePojo.ExecutiveDashboard.Risk;

import java.util.List;

public class EDRiskMetricsValue {

    private String interval;
    private Double norm;
    private List value;

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public Double getNorm() {
        return norm;
    }

    public void setNorm(Double norm) {
        this.norm = norm;
    }

    public List getValue() {
        return value;
    }

    public void setValue(List value) {
        this.value = value;
    }


}
