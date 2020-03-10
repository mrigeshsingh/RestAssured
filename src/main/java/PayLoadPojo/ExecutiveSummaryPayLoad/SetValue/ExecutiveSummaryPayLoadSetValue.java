package PayLoadPojo.ExecutiveSummaryPayLoad.SetValue;

import PayLoadPojo.ExecutiveSummaryPayLoad.AnalysisPeriod;
import PayLoadPojo.ExecutiveSummaryPayLoad.ExecutiveSummaryPayLoad;
import PayLoadPojo.ExecutiveSummaryPayLoad.Filters;
import PayLoadPojo.ExecutiveSummaryPayLoad.Page;

import java.util.Collections;

public class ExecutiveSummaryPayLoadSetValue {
    ExecutiveSummaryPayLoad executiveSummaryPayLoad=new ExecutiveSummaryPayLoad();
    Page page = new Page();
    Filters filters = new Filters();
    AnalysisPeriod analysisPeriod = new AnalysisPeriod();

    public ExecutiveSummaryPayLoad setValue(String AnalyzeBy,String AnalysisPeriod)
    {
        String emptyString[] ={};
        String columnList[] = {"demographics","cost_summary","quality_risk","warehouse_summary"};
        executiveSummaryPayLoad.setNorm(Collections.emptyMap());
        executiveSummaryPayLoad.setColumns(columnList);
        executiveSummaryPayLoad.setFilters(filters);
        executiveSummaryPayLoad.setPage(page);
        executiveSummaryPayLoad.setSort(emptyString);

        page.setSize("50");
        page.setOffset("1");

        filters.setColumnFilters(emptyString);
        filters.setBusinessLevels(Collections.emptyMap());
        filters.setAnalysisPeriod(analysisPeriod);

        analysisPeriod.setArgs(emptyString);
        analysisPeriod.setPeriodOverPeriod("false");
        analysisPeriod.setPeriod(AnalyzeBy);
        analysisPeriod.setType(AnalysisPeriod);

        return executiveSummaryPayLoad;
    }
}
