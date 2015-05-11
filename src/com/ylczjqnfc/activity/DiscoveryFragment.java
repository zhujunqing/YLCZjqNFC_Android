package com.ylczjqnfc.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylczjqnfc.R;

public class DiscoveryFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View discoveryLayout = inflater.inflate(R.layout.discovery_main, container, false);
		return discoveryLayout;
	}
}
