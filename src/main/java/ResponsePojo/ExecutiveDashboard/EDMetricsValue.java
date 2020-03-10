package ResponsePojo.ExecutiveDashboard;

public class EDMetricsValue {

    private String interval;
    private String period;
    private Double value;
    private Double norm;


    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }



    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getNorm() {
        return norm;
    }

    public void setNorm(Double norm) {
        this.norm = norm;
    }

}
