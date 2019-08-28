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
			WordFinder wfSingle = new WordFinder(sMask);
			DictionatyFile dfDictionary = new DictionatyFile("rus.txt");
			dfDictionary.foreachAllLines(wfSingle);
			edtOut.setText("Обнаружено совпадений: " + String.valueOf(wfSingle.getCount()));
			for (String sLine : wfSingle.getResult())
				edtOut.append("\n" + sLine);
		}
	}
}

