package com.core.framework.service.reportService;

import com.core.framework.common.jasperReport.JasperPrint;
import net.sf.jasperreports.engine.JRException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface IReportService {
	void exportJasperPrintList(HttpServletResponse response, String reportName, List<JasperPrint> jasperPrintList, ReportService.FileExtension fileExtension) throws IOException, JRException;

	void exportJasperPrintList(HttpServletResponse response, String reportName, JasperPrint jasperPrint, ReportService.FileExtension fileExtension) throws IOException, JRException;

	void exportPdfJasperPrintList(HttpServletResponse response, String reportName, List<JasperPrint> jasperPrintList) throws IOException, JRException;

	void exportPdfJasperPrintList(HttpServletResponse response, String reportName, JasperPrint jasperPrint) throws IOException, JRException;

	void exportWordJasperPrintList(HttpServletResponse response, String reportName, List<JasperPrint> jasperPrintList) throws IOException, JRException;

	void exportWordJasperPrintList(HttpServletResponse response, String reportName, JasperPrint jasperPrint) throws IOException, JRException;

	void exportXlsJasperPrintList(HttpServletResponse response, String reportName, List<JasperPrint> jasperPrintList) throws IOException, JRException;

	void exportXlsJasperPrintList(HttpServletResponse response, String reportName, JasperPrint jasperPrint) throws IOException, JRException;

	void exportXlsxJasperPrintList(HttpServletResponse response, String reportName, List<JasperPrint> jasperPrintList) throws IOException, JRException;

	void exportXlsxJasperPrintList(HttpServletResponse response, String reportName, JasperPrint jasperPrint) throws IOException, JRException;
}
