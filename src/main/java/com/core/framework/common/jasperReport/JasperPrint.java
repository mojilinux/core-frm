package com.core.framework.common.jasperReport;

import java.sql.ResultSet;
import java.util.List;

public class JasperPrint {
	private ResultSet           resultSet;
	private String              JrxmlPath;
	private ReportParameterList parameterList;
	private List                resultList;

	public JasperPrint(ResultSet resultSet, String jrxmlPath, ReportParameterList parameterList) {
		this.resultSet = resultSet;
		this.JrxmlPath = jrxmlPath;
		this.parameterList = parameterList;
	}

	public JasperPrint(List resultList, String jrxmlPath, ReportParameterList parameterList) {
		this.setResultList(resultList);
		this.JrxmlPath = jrxmlPath;
		this.parameterList = parameterList;
	}

	public JasperPrint(String jrxmlPath, ReportParameterList parameterList) {
		this.JrxmlPath = jrxmlPath;
		this.parameterList = parameterList;
	}

	public ResultSet getResultSet() {
		return this.resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public String getJrxmlPath() {
		return this.JrxmlPath;
	}

	public void setJrxmlPath(String jrxmlPath) {
		this.JrxmlPath = jrxmlPath;
	}

	public ReportParameterList getParameterList() {
		return this.parameterList;
	}

	public void setParameterList(ReportParameterList parameterList) {
		this.parameterList = parameterList;
	}

	public List getResultList() {
		return this.resultList;
	}

	public void setResultList(List resultList) {
		this.resultList = resultList;
	}
}