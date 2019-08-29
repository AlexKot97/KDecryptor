package su.kotindustries.kdecryptor;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import java.io.*;
import android.content.*;
import android.*;
import java.util.*;

public class MainActivity extends Activity
{
	EditText edtIn;
	Button btnFind;
	EditText edtOut;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		edtIn = findViewById(R.id.edtIn);
		btnFind = findViewById(R.id.btnFind);
		edtOut = findViewById(R.id.edtOut);
    }
	
	public void onClick(View v){
		String sMask = edtIn.getText().toString();
		if (sMask != ""){
		
			new AsyncFinder().execute(sMask);
			// вынести в поток
			
			
			
			
			
			
			// todo edtOut.setText("Обнаружено совпадений: " + String.valueOf(iCount));
			
		}
	}
	
	class AsyncFinder extends AsyncTask<String, Integer, ArrayList<String>>
	{

		@Override
		protected ArrayList<String> doInBackground(String[] params)
		{
	 		WordFinder wfSingle = new WordFinder(params[0]);
			DictionatyFile dfDictionary = new DictionatyFile("rus.txt");
			dfDictionary.foreachAllLines(wfSingle);
			// Todo: int iCount = wfSingle.getCount();
			ArrayList<String> alsResult = wfSingle.getResult();
			return alsResult;
		}

		@Override
		protected void onPostExecute(ArrayList<String> alsResult)
		{
			super.onPostExecute(alsResult);
			for (String sLine : alsResult)
				edtOut.append("\n" + sLine);
		}
	}
}

