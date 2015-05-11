package com.ylczjqnfc.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ylczjqnfc.R;

public class OneActivity extends Activity {

	EditText editText1;
	TextView textView1;
	Button commit1;
	private final static int REQUESTCODE=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.one);
		editText1 = (EditText)findViewById(R.id.editText1);
		textView1 = (TextView)findViewById(R.id.textView1);
		
		commit1 = (Button)findViewById(R.id.commit1);
		commit1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(OneActivity.this,TwoActivity.class);
				Bundle bundle = new Bundle();
				final String name = editText1.getText().toString();
				bundle.putString("edittext", name);
				intent.putExtras(bundle);
				startActivityForResult(intent, REQUESTCODE);
			}
		});
	}
	
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==2){
			if(requestCode==REQUESTCODE){
				String twoStr = data.getStringExtra("edittext2");
				textView1.setText(twoStr);
			}
		}
	}
}
