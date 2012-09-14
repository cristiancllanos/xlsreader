package gl;

import java.util.Map;

/**
 * Clase para configurar el proceso de mapeo de objeto con el xls.
 * 
 * @author Cristian Ceferino Llanos <cristian.llanos@globallogic.com>
 */
public class SourceMappingXLSFile {

	private String spreadsheet;


	private String xlsUrlSource;
	private Class bean;
	private Map<String, String> settingMapping;

	public SourceMappingXLSFile(String xlsUrlSource, Class bean,
			Map<String, String> settingMapping) {
		this.xlsUrlSource = "https://spreadsheets.google.com/feeds/worksheets/0Ap9dpq9vAeVtdEZZc0lyNV9fQk5kVlpyaFI3dXM4Mnc/private/full";
		this.bean = bean;
		this.settingMapping = settingMapping;
	}

	public String getXlsUrlSource() {
		return xlsUrlSource;
	}

	public void setXlsUrlSource(String xlsUrlSource) {
		this.xlsUrlSource = xlsUrlSource;
	}

	public Class getBean() {
		return bean;
	}

	public void setBean(Class bean) {
		this.bean = bean;
	}

	public Map<String, String> getSettingMapping() {
		return settingMapping;
	}

	public void setSettingMapping(Map<String, String> settingMapping) {
		this.settingMapping = settingMapping;
	}

	public String getSpreadsheet() {
		return spreadsheet;
	}
	
	public void setSpreadsheet(String spreadsheet) {
		this.spreadsheet = spreadsheet;
	}
}
