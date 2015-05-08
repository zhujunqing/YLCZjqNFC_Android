package com.ylczjqnfc.test;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragAdapter extends FragmentPagerAdapter {

	List<Fragment> mfragments;
	public FragAdapter(FragmentManager fm,List<Fragment> fragments) {
		super(fm);
		// TODO Auto-generated constructor stub
		this.mfragments = fragments;
	}

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		return mfragments.get(position);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mfragments.size();
	}

}
