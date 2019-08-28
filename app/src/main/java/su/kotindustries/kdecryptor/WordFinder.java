package su.kotindustries.kdecryptor;

import java.util.*;

public class WordFinder{
	private String pMaskSignature;
	private ArrayList <String> lsResult;
	private int pCounter;
	public WordFinder(String sMask){
		pMaskSignature = getSignature(sMask);
		lsResult = new ArrayList<String>();
		pCounter = 0;
	}
	public void Iterate(String sWord){
		String sWordSignature = getSignature(sWord);
		if (sWordSignature.compareTo(pMaskSignature)==0){
			lsResult.add(sWord);
			this.pCounter++;
		}
	}
	public int getCount(){
		return this.pCounter;
	}
	public ArrayList<String> getResult(){
		return this.lsResult;
	}
	public String getSignature(String sWord){
		String sResult = "";
		for (int j = 0; j < sWord.length(); j++)
			sResult += sWord.indexOf(sWord.substring(j,j+1));
		return sResult;
	}
}


