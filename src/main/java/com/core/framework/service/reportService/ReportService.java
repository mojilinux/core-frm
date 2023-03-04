package com.core.framework.service.reportService;

import com.core.framework.common.jasperReport.JasperPrint;
import com.core.framework.common.jasperReport.ReportParameter;
import com.core.framework.common.jasperReport.ReportParameterList;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportService implements IReportService {
	@Autowired
	@Qualifier("dataSource")
	private DataSource datasource;

	public ReportService() {
	}

	public void exportJasperPrintList(HttpServletResponse response, String reportName, List<JasperPrint> jasperPrintList, FileExtension fileExtension) throws IOException, JRException {
		switch (fileExtension) {
		case PDF:
			this.exportPdfJasperPrintList(response, reportName, jasperPrintList);
			break;
		case DOC:
		case DOCX:
			this.exportWordJasperPrintList(response, reportName, jasperPrintList);
			break;
		case XLS:
			this.exportXlsJasperPrintList(response, reportName, jasperPrintList);
			break;
		case XLSX:
			this.exportXlsxJasperPrintList(response, reportName, jasperPrintList);
		}

	}

	public void exportJasperPrintList(HttpServletResponse response, String reportName, JasperPrint jasperPrint, FileExtension fileExtension) throws IOException, JRException {
		List<JasperPrint> printList = new ArrayList();
		printList.add(jasperPrint);
		this.exportJasperPrintList(response, reportName, (List) printList, fileExtension);
	}

	public void exportPdfJasperPrintList(HttpServletResponse response, String reportName, List<JasperPrint> jasperPrintList) throws IOException, JRException {
		String uniqueReportName = uniqName(reportName);
		prepairResponseExport(response, uniqueReportName, FileExtension.PDF);
		List<net.sf.jasperreports.engine.JasperPrint> jasperPrints = (List) jasperPrintList.stream().map((p) -> {
			return p.getResultSet() != null ? this.jasperConnect(p.getResultSet(), (List) null, p.getJrxmlPath(), p.getParameterList()) : this.jasperConnect((ResultSet) null, p.getResultList(), p.getJrxmlPath(), p.getParameterList());
		}).collect(Collectors.toList());
		JRPdfExporter exporter = new JRPdfExporter();
		SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
		exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrints));
		configuration.setCreatingBatchModeBookmarks(true);
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
		exporter.setConfiguration(configuration);
		exporter.exportReport();
	}

	public void exportPdfJasperPrintList(HttpServletResponse response, String reportName, JasperPrint jasperPrint) throws IOException, JRException {
		List<JasperPrint> printList = new ArrayList();
		printList.add(jasperPrint);
		this.exportPdfJasperPrintList(response, reportName, (List) printList);
	}

	public void exportWordJasperPrintList(HttpServletResponse response, String reportName, List<JasperPrint> jasperPrintList) throws IOException, JRException {
		String uniqueReportName = uniqName(reportName);
		prepairResponseExport(response, uniqueReportName, FileExtension.DOCX);
		List<net.sf.jasperreports.engine.JasperPrint> jasperPrints = (List) jasperPrintList.stream().map((p) -> {
			return p.getResultSet() != null ? this.jasperConnect(p.getResultSet(), (List) null, p.getJrxmlPath(), p.getParameterList()) : this.jasperConnect((ResultSet) null, p.getResultList(), p.getJrxmlPath(), p.getParameterList());
		}).collect(Collectors.toList());
		JRDocxExporter exporter = new JRDocxExporter();
		exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrints));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
		exporter.exportReport();
	}

	public void exportWordJasperPrintList(HttpServletResponse response, String reportName, JasperPrint jasperPrint) throws IOException, JRException {
		List<JasperPrint> printList = new ArrayList();
		printList.add(jasperPrint);
		this.exportWordJasperPrintList(response, reportName, (List) printList);
	}

	public void exportXlsJasperPrintList(HttpServletResponse response, String reportName, List<JasperPrint> jasperPrintList) throws IOException, JRException {
		String uniqueReportName = uniqName(reportName);
		prepairResponseExport(response, uniqueReportName, FileExtension.XLS);
		List<net.sf.jasperreports.engine.JasperPrint> jasperPrints = (List) jasperPrintList.stream().map((p) -> {
			return p.getResultSet() != null ? this.jasperConnect(p.getResultSet(), (List) null, p.getJrxmlPath(), p.getParameterList()) : this.jasperConnect((ResultSet) null, p.getResultList(), p.getJrxmlPath(), p.getParameterList());
		}).collect(Collectors.toList());
		JRXlsExporter exporterXls = new JRXlsExporter();
		exporterXls.setExporterInput(SimpleExporterInput.getInstance(jasperPrints));
		exporterXls.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
		SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
		configuration.setIgnorePageMargins(false);
		configuration.setWhitePageBackground(false);
		configuration.setRemoveEmptySpaceBetweenColumns(true);
		configuration.setRemoveEmptySpaceBetweenRows(true);
		configuration.setDetectCellType(true);
		exporterXls.setConfiguration(configuration);
		exporterXls.exportReport();
	}

	public void exportXlsJasperPrintList(HttpServletResponse response, String reportName, JasperPrint jasperPrint) throws IOException, JRException {
		List<JasperPrint> printList = new ArrayList();
		printList.add(jasperPrint);
		this.exportXlsJasperPrintList(response, reportName, (List) printList);
	}

	public void exportXlsxJasperPrintList(HttpServletResponse response, String reportName, List<JasperPrint> jasperPrintList) throws IOException, JRException {
		String uniqueReportName = uniqName(reportName);
		prepairResponseExport(response, uniqueReportName, FileExtension.XLSX);
		List<net.sf.jasperreports.engine.JasperPrint> jasperPrints = (List) jasperPrintList.stream().map((p) -> {
			return p.getResultSet() != null ? this.jasperConnect(p.getResultSet(), (List) null, p.getJrxmlPath(), p.getParameterList()) : this.jasperConnect((ResultSet) null, p.getResultList(), p.getJrxmlPath(), p.getParameterList());
		}).collect(Collectors.toList());
		JRXlsxExporter exporterXlsx = new JRXlsxExporter();
		exporterXlsx.setExporterInput(SimpleExporterInput.getInstance(jasperPrints));
		SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
		configuration.setIgnorePageMargins(false);
		configuration.setWhitePageBackground(false);
		configuration.setRemoveEmptySpaceBetweenColumns(true);
		configuration.setRemoveEmptySpaceBetweenRows(true);
		configuration.setDetectCellType(true);
		exporterXlsx.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
		exporterXlsx.setConfiguration(configuration);
		exporterXlsx.exportReport();
	}

	public void exportXlsxJasperPrintList(HttpServletResponse response, String reportName, JasperPrint jasperPrint) throws IOException, JRException {
		List<JasperPrint> printList = new ArrayList();
		printList.add(jasperPrint);
		this.exportXlsxJasperPrintList(response, reportName, (List) printList);
	}

	private net.sf.jasperreports.engine.JasperPrint jasperConnect(ResultSet resultSet, List resultList, String jrxmlPath, ReportParameterList parameterList) {
		try {
			Connection connection = this.datasource.getConnection();
			Throwable var6 = null;

			net.sf.jasperreports.engine.JasperPrint var11;
			try {
				JasperDesign design = JRXmlLoader.load(this.getClass().getResourceAsStream("/report" + jrxmlPath));
				JasperReport jReport = JasperCompileManager.compileReport(design);
				Map<String, Object> params = new HashMap();
				params.put("REPORT_CONNECTION", connection);
				if (parameterList != null) {
					for (int i = 0; i < parameterList.getParamsCount(); ++i) {
						params.put(((ReportParameter) parameterList.getParameters().get(i)).getParamName(), ((ReportParameter) parameterList.getParameters().get(i)).getParamValue());
					}
				}

				if (resultList == null) {
					if (resultSet != null) {
						JRDataSource resultSetDataSource = new JRResultSetDataSource(resultSet);
						var11 = JasperFillManager.fillReport(jReport, params, resultSetDataSource);
						return var11;
					}

					net.sf.jasperreports.engine.JasperPrint var27 = JasperFillManager.fillReport(jReport, params, connection);
					return var27;
				}

				JRDataSource jrDataSource = new JRBeanCollectionDataSource(resultList);
				var11 = JasperFillManager.fillReport(jReport, params, jrDataSource);
			}
			catch (Throwable var23) {
				var6 = var23;
				throw var23;
			}
			finally {
				if (connection != null) {
					if (var6 != null) {
						try {
							connection.close();
						}
						catch (Throwable var22) {
							var6.addSuppressed(var22);
						}
					}
					else {
						connection.close();
					}
				}

			}

			return var11;
		}
		catch (Exception var25) {
			var25.printStackTrace();
			throw new RuntimeException(var25);
		}
	}

	private static void prepairResponseExport(HttpServletResponse response, String reportName, FileExtension fileExtension) {
		switch (fileExtension) {
		case PDF:
			response.setContentType("Application/pdf");
			break;
		case DOC:
		case DOCX:
			response.setContentType("Application/msword");
			break;
		case XLS:
			response.setContentType("Application/x-msexcel");
			break;
		case XLSX:
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			break;
		case HTM:
		case HTML:
		case TXT:
		case INI:
		case XML:
		case LOG:
			response.setContentType("text/plain");
			break;
		case PPT:
		case PPS:
			response.setContentType("Application/vnd.ms-powerpoint");
			break;
		case ZIP:
		case RAR:
			response.setContentType("application/x-zip-compressed");
			break;
		default:
			response.setContentType("application/x-zip-compressed");
		}

		response.setHeader("Content-disposition", String.format(" attachment; filename*=UTF-8''%s", reportName + "." + fileExtension));
	}

	private static String uniqName(String reportName) {
		DateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

		try {
			return URLEncoder.encode(reportName, "UTF-8") + "_" + df.format(new Date());
		}
		catch (UnsupportedEncodingException var3) {
			var3.printStackTrace();
			return "_" + df.format(new Date());
		}
	}

	private Map<String, String> getReportParamsAsMap(List<JasperPrint> jasperPrintList) {
		Map<String, String> reportParams = new HashMap();
		jasperPrintList.stream().forEach((printList) -> {
			printList.getParameterList().getParameters().stream().forEach((param) -> {
				reportParams.put(param.getParamName(), String.valueOf(param.getParamValue()));
			});
		});
		return reportParams;
	}

	static {
		DefaultJasperReportsContext reportsContext = DefaultJasperReportsContext.getInstance();
		JRPropertiesUtil.getInstance(reportsContext).setProperty("net.sf.jasperreports.query.executer.factory.plsql", "net.sf.jasperreports.engine.query.PlSqlQueryExecuterFactory");
	}

	public static enum FileExtension {
		HTM, HTML, XML, TXT, INI, LOG, DOC, DOCX, XLS, XLSX, PDF, PPT, PPS, ZIP, RAR;

		private FileExtension() {
		}
	}
}
