package com.ylczjqnfc.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * 用于菜单滑动的操作
 * @author Administrator
 *
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

	List<Fragment> fragList;
	public MyFragmentPagerAdapter(FragmentManager fm,List<Fragment> fragList) {
		super(fm);
		// TODO Auto-generated constructor stub
		this.fragList = fragList;
	}

	@Override
	public Fragment getItem(int positon) {
		// TODO Auto-generated method stub
		return fragList.get(positon);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fragList.size();
	}

}
