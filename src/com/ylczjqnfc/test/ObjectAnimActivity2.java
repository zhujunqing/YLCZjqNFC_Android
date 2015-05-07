package com.ylczjqnfc.test;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ylczjqnfc.R;

public class ObjectAnimActivity2 extends Activity {

	ImageView imageView1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xml_for_anim3);
		imageView1 = (ImageView)findViewById(R.id.imageView1);
		
	}
	
	/**
	 * 横向拉伸
	 */
	public void horizontalStretch(View view){
		// 加载动画  
        Animator anim = AnimatorInflater.loadAnimator(this, R.anim.scalex);  
        imageView1.setPivotX(0);  
        imageView1.setPivotY(0);  
        //显示的调用invalidate  
        imageView1.invalidate();  
        anim.setTarget(imageView1);  
        anim.start();
	}
	
	/**
	 * 横竖向拉伸
	 */
	public void horizontalVerticalStretch(View view){
		// 加载动画  
        Animator anim = AnimatorInflater.loadAnimator(this, R.anim.scalexy);  
        imageView1.setPivotX(0);  
        imageView1.setPivotY(0);  
        //显示的调用invalidate  
        imageView1.invalidate();  
        anim.setTarget(imageView1);  
        anim.start();
	}
}
