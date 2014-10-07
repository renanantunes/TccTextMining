package gui;

import javax.swing.JFileChooser;

public class FileChooserDirectory {

	public static String initialize() {
		
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setCurrentDirectory(new java.io.File(""));
		
	
		if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
			return chooser.getSelectedFile().toString();
		}else{
			return null;
		}	
	}

}
