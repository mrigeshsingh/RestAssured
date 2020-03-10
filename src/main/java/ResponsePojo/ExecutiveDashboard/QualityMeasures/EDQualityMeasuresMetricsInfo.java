package ResponsePojo.ExecutiveDashboard.QualityMeasures;

import java.util.List;

public class EDQualityMeasuresMetricsInfo {
    private List values;
    private String label;
    private String metrics;
    private String type;
    private String numeratorDescription;
    private String denominatorDescription;

    public List getValues() {
        return values;
    }

    public void setValues(List values) {
        this.values = values;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMetrics() {
        return metrics;
    }

    public void setMetrics(String metrics) {
        this.metrics = metrics;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumeratorDescription() {
        return numeratorDescription;
    }

    public void setNumeratorDescription(String numeratorDescription) {
        this.numeratorDescription = numeratorDescription;
    }

    public String getDenominatorDescription() {
        return denominatorDescription;
    }

    public void setDenominatorDescription(String denominatorDescription) {
        this.denominatorDescription = denominatorDescription;
    }
}
