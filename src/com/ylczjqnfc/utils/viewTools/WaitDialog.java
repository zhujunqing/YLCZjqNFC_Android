package com.ylczjqnfc.utils.viewTools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.ylczjqnfc.R;

public class WaitDialog extends ProgressDialog {

	public WaitDialog(Context context, int theme) {
		super(context, theme);
	}
	public WaitDialog(Context context) {
		super(context);
	}
	private TextView text;
	private AnimationDrawable anim;
	private ImageView loading_img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog);
		loading_img = (ImageView)findViewById(R.id.loading_img);
		text = (TextView) WaitDialog.this.findViewById(R.id.text);
		anim = (AnimationDrawable) loading_img.getBackground();
		this.setCanceledOnTouchOutside(false);
		
		this.setOnShowListener(new OnShowListener() {
			@Override
			public void onShow(DialogInterface dialog) {
				/*ImageView image = (ImageView) WaitDialog.this
						.findViewById(R.id.loading_img);
				Animation anim = new RotateAnimation(0, 360,
						Animation.RELATIVE_TO_SELF, 0.5f,
						Animation.RELATIVE_TO_SELF, 0.5f);
				anim.setRepeatCount(Animation.INFINITE);
				anim.setDuration(1000);
				anim.setInterpolator(new LinearInterpolator());
				image.startAnimation(anim);//¹ýÈ¥µÄloading*/
				anim.start();
			}
		});

	}

	private boolean hide = true;

	public void setCanceled(boolean hide) {
		this.hide = hide;
		this.setCanceledOnTouchOutside(hide);
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (!hide) {
			if (keyCode == KeyEvent.KEYCODE_BACK) {

				return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}

	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if (!hide) {
			if (keyCode == KeyEvent.KEYCODE_BACK) {

			}
		}
		return super.onKeyUp(keyCode, event);
	}

	public void ShowMsg(String msg) {
		text.setText(msg);
	}

	private void setScreenBrightness() {
		Window window = getWindow();
		WindowManager.LayoutParams lp = window.getAttributes();
		lp.dimAmount = 0;
		window.setAttributes(lp);
	}

}
