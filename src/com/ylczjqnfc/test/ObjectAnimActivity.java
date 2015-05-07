package com.ylczjqnfc.test;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.ylczjqnfc.R;
import com.ylczjqnfc.controller.GlobalVar;
import com.ylczjqnfc.utils.LogUtil;

public class ObjectAnimActivity extends Activity {

	ImageView imageView1;
	//简单的多动画Together
	int mScreenWidth;
	int mScreenHeight;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		WindowManager wm = (WindowManager) this.getSystemService(
				Context.WINDOW_SERVICE);
		mScreenWidth = wm.getDefaultDisplay().getWidth();
		mScreenHeight = wm.getDefaultDisplay().getHeight();
		setContentView(R.layout.xml_for_anim2);
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		
	}

	public void rotateyAnimRun(final View view) {
		// ObjectAnimator.ofFloat(view, "rotationX", 0.0F,
		// 360.0F).setDuration(500).start(); //这是一个属性动画
		ObjectAnimator anim = ObjectAnimator.ofFloat(view, "zhy", 1.0F, 0.0F)
				.setDuration(500);
		anim.start();
		anim.addUpdateListener(new AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				float cVal = (Float) animation.getAnimatedValue();
				view.setAlpha(cVal); // 第一个属性
				view.setScaleX(cVal); // 第二个属性
				view.setScaleY(cVal); // 第三个属性
			}
		});
	}

	// 垂直加速成
	public void propertyValuesHolder(View view) {
		PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f,
				0f, 1f);
		PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f,
				0, 1f);
		PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f,
				0, 1f);
		ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY, pvhZ)
				.setDuration(1000).start();
	}

	/*
	 * public void verticalRun(View view) { ValueAnimator animator =
	 * ValueAnimator.ofFloat(0, mScreenHeight - mBlueBall.getHeight());
	 * animator.setTarget(mBlueBall); animator.setDuration(1000).start(); }
	 */

	

	/**
	 * 自由落体
	 * 
	 * @param view
	 */
	public void verticalRun(View view) {
		ValueAnimator animator = ValueAnimator.ofFloat(0, mScreenHeight
				- imageView1.getHeight());
		animator.setTarget(imageView1);
		animator.setDuration(1000).start();
		// animator.setInterpolator(value)
		animator.addUpdateListener(new AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				imageView1.setTranslationY((Float) animation.getAnimatedValue());
			}
		});
	}

	/**
	 * 抛物线
	 * 
	 * @param view
	 */
	public void paowuxian(View view) {

		ValueAnimator valueAnimator = new ValueAnimator();
		valueAnimator.setDuration(3000);
		valueAnimator.setObjectValues(new PointF(0, 0));
		valueAnimator.setInterpolator(new LinearInterpolator());
		valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
			// fraction = t / duration
			@Override
			public PointF evaluate(float fraction, PointF startValue,
					PointF endValue) {
				LogUtil.e(GlobalVar.TAG, fraction * 3 + "");
				// x方向200px/s ，则y方向0.5 * 10 * t
				PointF point = new PointF();
				point.x = 200 * fraction * 3;
				point.y = 0.5f * 200 * (fraction * 3) * (fraction * 3);
				return point;
			}
		});

		valueAnimator.start();
		valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				PointF point = (PointF) animation.getAnimatedValue();
				imageView1.setX(point.x);
				imageView1.setY(point.y);

			}
		});
	}
	
	/**
	 * 监听事件动画
	 */
    public void fadeOut(View view)  
    {  
        ObjectAnimator anim = ObjectAnimator.ofFloat(imageView1, "alpha", 0.5f);  
          
        anim.addListener(new AnimatorListener()  
        {  
  
            @Override  
            public void onAnimationStart(Animator animation)  
            {  
                Log.e(GlobalVar.TAG, "onAnimationStart");  
            }  
  
            @Override  
            public void onAnimationRepeat(Animator animation)  
            {  
                // TODO Auto-generated method stub  
                Log.e(GlobalVar.TAG, "onAnimationRepeat");  
            }  
  
            @Override  
            public void onAnimationEnd(Animator animation)  
            {  
                Log.e(GlobalVar.TAG, "onAnimationEnd");  
                ViewGroup parent = (ViewGroup) imageView1.getParent();  
                if (parent != null)  
                    parent.removeView(imageView1); //将图片删除 
            }  
  
            @Override  
            public void onAnimationCancel(Animator animation)  
            {  
                // TODO Auto-generated method stub  
                Log.e(GlobalVar.TAG, "onAnimationCancel");  
            }  
        });  
        anim.start();  
    }
    
    /**
     * 简单的多动画Together
     * @param view
     */
    public void togetherRun(View view)  
    {  
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(imageView1, "scaleX",  
                1.0f, 2f);  
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(imageView1, "scaleY",  
                1.0f, 2f);  
        AnimatorSet animSet = new AnimatorSet();  
        animSet.setDuration(2000);  
        animSet.setInterpolator(new LinearInterpolator());  
        //两个动画同时执行  
        animSet.playTogether(anim1, anim2);  
        animSet.start();  
    }  
  
    /**
     * 多动画按次序执行
     * @param view
     */
    public void playWithAfter(View view)  
    {  
        float cx = imageView1.getX();  
  
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(imageView1, "scaleX",  
                1.0f, 2f);  
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(imageView1, "scaleY",  
                1.0f, 2f);  
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(imageView1,  
                "x",  cx ,  0f);  
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(imageView1,  
                "x", cx);  
          
        /** 
         * anim1，anim2,anim3同时执行 
         * anim4接着执行 
         */  
        AnimatorSet animSet = new AnimatorSet();  
        animSet.play(anim1).with(anim2);  
        animSet.play(anim2).with(anim3);  
        animSet.play(anim4).after(anim3);  
        animSet.setDuration(1000);  
        animSet.start();  
    }  
}
