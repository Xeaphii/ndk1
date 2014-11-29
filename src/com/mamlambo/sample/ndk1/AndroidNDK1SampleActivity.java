package com.mamlambo.sample.ndk1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AndroidNDK1SampleActivity extends Activity implements
		OnClickListener {

	Button Click;
	EditText t1, t2;

	private native void helloLog(String logThis);

	private native String getString(int value1, int value2);

	static {
		System.loadLibrary("ndk1");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_android_ndk1_sample);
		Click = (Button) findViewById(R.id.click);
		t1 = (EditText) findViewById(R.id.t1);
		t2 = (EditText) findViewById(R.id.t2);
		Click.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		helloLog("This will log to LogCat via the native call.");
		String result = getString(Integer.parseInt(t1.getText().toString()),
				Integer.parseInt(t2.getText().toString()));
		Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG)
				.show();
	}

}
