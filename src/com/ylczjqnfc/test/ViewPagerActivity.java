package com.ylczjqnfc.test;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylczjqnfc.R;

public class ViewPagerActivity extends Activity{

	ViewPager viewpager;
	View view1,view2,view3;
	List<View> viewList;//视图列表
	
	private List<String> titleList;//标题列表数组
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_pager_test);
		viewpager = (ViewPager)findViewById(R.id.viewpager);
		LayoutInflater inflater = getLayoutInflater();
		view1 = inflater.inflate(R.layout.layout1, null);
		view2 = inflater.inflate(R.layout.layout2, null);
		view3 = inflater.inflate(R.layout.layout3, null);
		viewList = new ArrayList<View>();
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);
		
		titleList = new ArrayList<String>();
		
		titleList.add("充值");// 1
		titleList.add("发现");// 2
		titleList.add("查询");// 3
		
		PagerAdapter pagerAdapter = new PagerAdapter() {
			
			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0 == arg1;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return viewList.size();
			}
			
			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				// TODO Auto-generated method stub
				container.addView(viewList.get(position));
				return viewList.get(position);
			}
			
			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				// TODO Auto-generated method stub
				container.removeView(viewList.get(position));
			}
			
			@Override
			public CharSequence getPageTitle(int position) {
				// TODO Auto-generated method stub
				return titleList.get(position);
			}
		};
		
		viewpager.setAdapter(pagerAdapter);
	}
}
