package ResponsePojo.ExecutiveDashboard;

import java.util.List;

public class EDMetricsInfo {
    private String label;
    private List<EDMetricsValue> values;
    private String unit;
    private String description;
    private String subLabel;

    public String getSubLabel() {
        return subLabel;
    }

    public void setSubLabel(String subLabel) {
        this.subLabel = subLabel;
    }



    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<EDMetricsValue> getValues() {
        return values;
    }

    public void setValues(List<EDMetricsValue> values) {
        this.values = values;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
