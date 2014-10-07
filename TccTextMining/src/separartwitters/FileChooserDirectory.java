package separartwitters;

import java.io.File;

import javax.swing.JFileChooser;

public class FileChooserDirectory {

	public static File initialize() {
		
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setCurrentDirectory(new java.io.File(""));
		
	
		if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
			return chooser.getSelectedFile();
		}else{
			return null;
		}	
	}

}
