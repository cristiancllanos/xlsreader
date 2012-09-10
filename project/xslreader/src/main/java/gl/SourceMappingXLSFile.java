package gl;

/**
 * Clase para configurar el proceso de mapeo de objeto con el xls.
 * 
 * @author Cristian Ceferino Llanos <cristian.llanos@globallogic.com>
 */
public class SourceMappingXLSFile {

	private String xlsUrlSource;
	private Class bean;
	private String[][] settingMapping;

	public SourceMappingXLSFile(String xlsUrlSource, Class bean,
			String[][] settingMapping) {
		this.xlsUrlSource = xlsUrlSource;
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

	public String[][] getSettingMapping() {
		return settingMapping;
	}

	public void setSettingMapping(String[][] settingMapping) {
		this.settingMapping = settingMapping;
	}

}
