package su.kotindustries.kdecryptor;
import android.os.*;
import java.io.*;

public class DictionatyFile
{
	private String pFileName;
	public DictionatyFile(String sFileName){
		pFileName = sFileName;
	}
	public void foreachAllLines(WordFinder iter){
		String sFilePath = Environment.getExternalStorageDirectory().getAbsolutePath();
		String sFileName = sFilePath + "/dictionaries/" + pFileName;
		File fDictionary = new File(sFileName);
		if (fDictionary.exists()){
			try {
				FileInputStream fis = new FileInputStream(fDictionary);
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));
				try{
					String line;
					while((line = br.readLine()) != null)
						iter.Iterate(line);
				} catch (IOException e){
					e.printStackTrace();
				}
			} catch (FileNotFoundException e){
				e.printStackTrace();
			}
		}
	}
}
