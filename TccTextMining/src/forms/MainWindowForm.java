package forms;

public class MainWindowForm {
	private String keyWords;
	private String saveType;
	private boolean isOneFilePerRecord = false;
	private boolean isAllRecordsInOneFile = false;
	private String path;
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public String getSaveType() {
		return saveType;
	}
	public void setSaveTxt(String saveType) {
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

	
}

