package com.ylczjqnfc.test;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.ylczjqnfc.R;

public class ViewPagerActivity2 extends FragmentActivity {

	private ViewPager viewpager;
	private List<Fragment> fragmentList;
	@Override
	protected void onCreate(Bundle bundle) {
		// TODO Auto-generated method stub
		super.onCreate(bundle);
		setContentView(R.layout.view_pager_test2);
		viewpager = (ViewPager)findViewById(R.id.viewpager);
		fragmentList = new ArrayList<Fragment>();
		fragmentList.add(new Fragment1());
		fragmentList.add(new Fragment2());
		fragmentList.add(new Fragment3());
		
		FragAdapter adapter = new FragAdapter(getSupportFragmentManager(), fragmentList);
		viewpager.setAdapter(adapter);
	}
}
