package forms;

public class MainWindowForm {
	private String keyWords;
	private String saveType;
	private boolean isOneFilePerRecord = false;
	private boolean isAllRecordsInOneFile = false;
	private String path;
	private String fetchType;
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public String getSaveType() {
		return saveType;
	}
	public void setSaveType(String saveType) {
		this.saveType = saveType;
	}
	public boolean isOneFilePerRecord() {
		return isOneFilePerRecord;
	}
	public void setOneFilePerRecord(boolean isOneFilePerRecord) {
		this.isOneFilePerRecord = isOneFilePerRecord;
	}
	public boolean isAllRecordsInOneFile() {
		return isAllRecordsInOneFile;
	}
	public void setAllRecordsInOneFile(boolean isAllRecordsInOneFile) {
		this.isAllRecordsInOneFile = isAllRecordsInOneFile;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFetchType() {
		return fetchType;
	}
	public void setFetchType(String fetchType) {
		this.fetchType = fetchType;
	}

	
}

