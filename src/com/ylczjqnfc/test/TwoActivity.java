package com.ylczjqnfc.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ylczjqnfc.R;

public class TwoActivity extends Activity{

	EditText editText2;
	Button commit2;
	TextView textView2;
	private static final int RESULTCODE=2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);
		editText2 = (EditText)findViewById(R.id.editText2);
		commit2 = (Button)findViewById(R.id.commit2);
		textView2 = (TextView)findViewById(R.id.textView2);
		
		final Intent intent = getIntent();
		final Bundle bundle = intent.getExtras();
		String oneStr = bundle.getString("edittext");
		textView2.setText(oneStr);
		commit2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				String twoStr = editText2.getText().toString();
				intent.putExtra("edittext2", twoStr);
				setResult(2, intent);
				finish();
			}
		});
	}
}
