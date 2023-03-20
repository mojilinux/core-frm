package com.core.framework.common.jasperReport;

import java.util.Vector;

public class ReportParameterList {
    private Vector<ReportParameter> params = new Vector<>();

    public ReportParameterList() {
    }

    public void addParameter(ReportParameter param) {
        this.params.add(param);
    }

    public void addParameter(String paramName, Object paramValue) {
        ReportParameter param = new ReportParameter(paramName, paramValue);
        this.params.add(param);
    }

    public Vector<ReportParameter> getParameters() {
        return this.params;
    }

    public int getParamsCount() {
        return this.params.size();
    }
}
