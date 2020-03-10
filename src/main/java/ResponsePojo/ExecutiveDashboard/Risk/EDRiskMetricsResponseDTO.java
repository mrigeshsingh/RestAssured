package ResponsePojo.ExecutiveDashboard.Risk;

import java.util.Map;

public class EDRiskMetricsResponseDTO {

    public static class RiskMetricsResponse{
        public EDRiskMetricsInfo riskContribution;
        public EDRiskMetricsInfo riskScoreDistribution;
        public String description;
    }

    private RiskMetricsResponse data;
    private Map<String,Object> meta;


    public RiskMetricsResponse getData() {
        return data;
    }

    public void setData(RiskMetricsResponse data) {
        this.data = data;
    }

    public Map<String, Object> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }






}
