package PayLoadPojo;

public class ExecutiveDashbordPayload {
    String metrics;
    public String getExecutiveDashbordPayload(String division,String AnalyzeBy, String AnalysisPeriod)
    {
        if(division == "kpi")
        {metrics = getKPIMetrics();}
        else if (division == "costandutils")
        {metrics =getCostAndUtilsMetrics();}
        else if (division == "risk")
        {metrics =getRiskMetrics();}
        else if (division == "clinicaloutcome")
        {metrics =getClinicalOutcomeMetrics();}
        else if (division == "qualitymeasures")
        {metrics =getQualityMeasuresMetrics();}

        String PayLoad = "{\n" +
                "   \"inputParameters\":{\n" +
                "      \"analysisPeriod\":{\n" +
                "         \"period\":\""+AnalyzeBy+"\",\n" +
                "         \"periodOverPeriod\":false,\n" +
                "         \"args\":[\n" +
                "\n" +
                "         ],\n" +
                "         \"type\":\""+AnalysisPeriod+"\"\n" +
                "      }\n" +
                "   },\n" +
                "   \"outputParameters\":{\n" +
                "      \"normType\":\"NATIONAL\",\n" +
                "       "+metrics+""+
                "   },\n" +
                "   \"population\":{\n" +
                "      \"filters\":{\n" +
                "         \"age\":{\n" +
                "            \"exclude\":[\n" +
                "\n" +
                "            ]\n" +
                "         },\n" +
                "         \"gender\":{\n" +
                "            \"exclude\":[\n" +
                "\n" +
                "            ]\n" +
                "         },\n" +
                "         \"relflag\":{\n" +
                "            \"exclude\":[\n" +
                "\n" +
                "            ]\n" +
                "         },\n" +
                "         \"region\":{\n" +
                "            \"exclude\":[\n" +
                "\n" +
                "            ]\n" +
                "         },\n" +
                "         \"state\":{\n" +
                "            \"exclude\":[\n" +
                "\n" +
                "            ]\n" +
                "         },\n" +
                "         \"claimType\":{\n" +
                "            \"include\":[\n" +
                "               \"MED\"\n" +
                "            ]\n" +
                "         }\n" +
                "      },\n" +
                "      \"businessLevels\":{\n" +
                "\n" +
                "      }\n" +
                "   }\n" +
                "}";
        return PayLoad;
    }


    public  String getKPIMetrics()
    {
        String KPIMetrics ="\"metrics\":[\n" +
                "         \"avgRisk_18\",\n" +
                "         \"membership\",\n" +
                "         \"avgRisk_55\",\n" +
                "         \"avgAge\"\n" +
                "      ]";

        return KPIMetrics;
    }

    public  String getCostAndUtilsMetrics()
    {
        String CostAndUtilsMetrics = "\"metrics\":[\n" +
                "         \"PMPM\",\n" +
                "         \"PAID_PER_ADMISSION\",\n" +
                "         \"TOTAL_PMPM_ADMISSION\"\n" +
                "      ]";

        return CostAndUtilsMetrics;
    }

    public  String getRiskMetrics()
    {
        String RiskMetrics = "\"metrics\":[\n" +
                "         \"riskScoreDistribution\",\n" +
                "         \"riskContribution\"\n" +
                "      ]";

        return  RiskMetrics;
    }
    public  String getQualityMeasuresMetrics()
    {
        String QualityMeasuresMetrics="\"metrics\":[\n" +
                "         \"QRM_12089\",\n" +
                "         \"QRM_12090\",\n" +
                "         \"QRM_12113\",\n" +
                "         \"QRM_12122\",\n" +
                "         \"QRM_12506\",\n" +
                "         \"QRM_12525\",\n" +
                "         \"QRM_113014\",\n" +
                "         \"QRM_13022\",\n" +
                "         \"QRM_12027\",\n" +
                "         \"QRM_12054\",\n" +
                "         \"QRM_12074\",\n" +
                "         \"QRM_113119\",\n" +
                "         \"QRM_13502\"\n" +
                "      ]";

        return  QualityMeasuresMetrics;
    }
    public  String getClinicalOutcomeMetrics()
    {
        String ClinicalOutcomeMetrics="\"metrics\":[\n" +
                "         \"opErVisitsPer1K\",\n" +
                "         \"acscReAdmissionsPer1K\",\n" +
                "         \"avoidableErVisitsPer1K\",\n" +
                "         \"admissionsPer1K\"\n" +
                "      ]";

        return ClinicalOutcomeMetrics;

    }
}
