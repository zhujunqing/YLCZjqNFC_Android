package com.ylczjqnfc.activity;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ylczjqnfc.R;
import com.ylczjqnfc.adapter.MyFragmentPagerAdapter;
import com.ylczjqnfc.utils.viewTools.SlidingMenu;

/**
 * 软件框架的界面
 * 
 * @author 朱俊清
 * 
 */
public class MainActivity extends FragmentBaseActivity implements
		OnClickListener {

	private SlidingMenu mMenu;// 侧滑菜单
	// 用于展示"充值"页面的Fragment
	private RechargeFragment rechargeFragment;
	// 用于展示"查询"页面的Fragment
	private QueryFragment queryFragment;
	// 用于展示"发现"页面的Fragment
	private DiscoveryFragment discoveryFragment;
	// 用于展示"我"页面的Fragment
	private AccountFragment accountFragment;

	// 充值
	private View recharge_layout;
	// 查询
	private View query_layout;
	// 发现
	private View discovery_layout;
	// 我
	private View account_layout;

	/**
	 * 充值的图片和文字
	 */
	private ImageView recharge_image;
	private TextView recharge_text;
	/**
	 * 查询的图片和文字
	 */
	private ImageView query_image;
	private TextView query_text;
	/**
	 * 发现的图片和文字
	 */
	private ImageView discovery_image;
	private TextView discovery_text;
	/**
	 * 我的图片和文字
	 */
	private ImageView account_image;
	private TextView account_text;
	
	private FragmentManager fragmentManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		//初始化布局元素
		initViews();
		//获取fragmentManager
		fragmentManager = getSupportFragmentManager();
        // 第一次启动时选中第0个tab  
        setTabSelection(0);
		List<Fragment> fragList = new ArrayList<Fragment>();// 用于存放“充值”、“查询”、“发现”、“我”
		fragList.add(rechargeFragment);
		fragList.add(queryFragment);
		fragList.add(discoveryFragment);
		fragList.add(accountFragment);

		MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(
				getSupportFragmentManager(), fragList);

	}

	public void initViews() {
		mMenu = (SlidingMenu) findViewById(R.id.id_menu);
		rechargeFragment = new RechargeFragment();
		queryFragment = new QueryFragment();
		discoveryFragment = new DiscoveryFragment();
		accountFragment = new AccountFragment();
		recharge_layout = findViewById(R.id.recharge_layout);// 充值
		recharge_layout.setOnClickListener(this);
		query_layout = findViewById(R.id.query_layout);// 查询
		query_layout.setOnClickListener(this);
		discovery_layout = findViewById(R.id.discovery_layout);// 发现
		discovery_layout.setOnClickListener(this);
		account_layout = findViewById(R.id.account_layout);// 我
		account_layout.setOnClickListener(this);
		// 充值
		recharge_image = (ImageView) findViewById(R.id.recharge_image);
		recharge_text = (TextView) findViewById(R.id.recharge_text);
		// 查询
		query_image = (ImageView) findViewById(R.id.query_image);
		query_text = (TextView) findViewById(R.id.query_text);
		// 发现
		discovery_image = (ImageView) findViewById(R.id.discovery_image);
		discovery_text = (TextView) findViewById(R.id.discovery_text);
		// 我
		account_image = (ImageView) findViewById(R.id.account_image);
		account_text = (TextView) findViewById(R.id.account_text);
	}

	// 点击菜单按钮，会侧滑出菜单
	public void toggleMenu(View view) {
		mMenu.toggle();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.recharge_layout:
			// 当点击了消息tab时，选中第1个tab
			setTabSelection(0);
			Toast.makeText(MainActivity.this, "recharge", 1).show();
			break;
		case R.id.query_layout:
			// 当点击了消息tab时，选中第2个tab
			setTabSelection(1);
			Toast.makeText(MainActivity.this, "query", 1).show();
			break;
		case R.id.discovery_layout:
			// 当点击了消息tab时，选中第3个tab
			setTabSelection(2);
			Toast.makeText(MainActivity.this, "discovery", 1).show();
			break;
		case R.id.account_layout:
			// 当点击了消息tab时，选中第4个tab
			setTabSelection(3);
			Toast.makeText(MainActivity.this, "account", 1).show();
			break;
		default:
			break;
		}
	}

	/**
	 * 根据传入的index参数来设置选中的tab页。 （非NFC手机）
	 * 
	 * @param index
	 *            每个tab页对应的下标。0表示充值，1表示查询，2表示发现，3表示我。
	 */
	private void setTabSelection(int index) {  
		// 每次选中之前先清楚掉上次的选中状态  
        clearSelection();  
        // 开启一个Fragment事务  
        FragmentTransaction transaction = fragmentManager.beginTransaction();  
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况  
        hideFragments(transaction);  
        switch (index) {
        //充值
		case 0:
			// 当点击了消息tab时，改变控件的图片和文字颜色  
			recharge_image.setImageResource(R.drawable.ico_paychecked);
			recharge_text.setTextColor(Color.WHITE);
			// 如果rechargeFragment为空，则创建一个并添加到界面上 
			if(rechargeFragment==null){
				rechargeFragment = new RechargeFragment();
				transaction.add(R.id.content, rechargeFragment);
			}else{
				transaction.show(rechargeFragment);
			}
			break;
		//查询
		case 1:
			// 当点击了消息tab时，改变控件的图片和文字颜色 
			query_image.setImageResource(R.drawable.tab_query_selected);
			query_text.setTextColor(Color.WHITE);
			// 如果queryFragment为空，则创建一个并添加到界面上 
			if(queryFragment==null){
				queryFragment = new QueryFragment();
				transaction.add(R.id.content, queryFragment);
			}else{
				transaction.show(queryFragment);
			}
			break;
		//发现
		case 2:
			// 当点击了消息tab时，改变控件的图片和文字颜色 
			discovery_image.setImageResource(R.drawable.finding_selected);
			discovery_text.setTextColor(Color.WHITE);
			// 如果discoveryFragment为空，则创建一个并添加到界面上 
			if(discoveryFragment==null){
				discoveryFragment = new DiscoveryFragment();
				transaction.add(R.id.content, discoveryFragment);
			}else{
				transaction.show(discoveryFragment);
			}
			break;
		//我
		case 3:
		default:
			// 当点击了消息tab时，改变控件的图片和文字颜色 
			account_image.setImageResource(R.drawable.ico_safechecked);
			account_text.setTextColor(Color.WHITE);
			// 如果accountFragment为空，则创建一个并添加到界面上 
			if(accountFragment==null){
				accountFragment = new AccountFragment();
				transaction.add(R.id.content, accountFragment);
			}else{
				transaction.show(accountFragment);
			}
			break;
		}
        transaction.commit();  
	}
	
	/** 
     * 清除掉所有的选中状态。 
     */  
    private void clearSelection() {  
    	recharge_image.setImageResource(R.drawable.ico_payunchecked);  
    	recharge_text.setTextColor(Color.parseColor("#82858b"));  
    	query_image.setImageResource(R.drawable.tab_query);  
    	query_text.setTextColor(Color.parseColor("#82858b"));  
        discovery_image.setImageResource(R.drawable.finding_normal);  
        discovery_text.setTextColor(Color.parseColor("#82858b"));  
        account_image.setImageResource(R.drawable.ico_safeunchecked);  
        account_text.setTextColor(Color.parseColor("#82858b"));  
    }  
    /** 
     * 将所有的Fragment都置为隐藏状态。 
     *  
     * @param transaction 
     *            用于对Fragment执行操作的事务 
     */  
    private void hideFragments(FragmentTransaction transaction) {  
        if (rechargeFragment != null) {  
            transaction.hide(rechargeFragment);  
        }  
        if (accountFragment != null) {  
            transaction.hide(accountFragment);  
        }  
        if (queryFragment != null) {  
            transaction.hide(queryFragment);  
        }  
        if (discoveryFragment != null) {  
            transaction.hide(discoveryFragment);  
        }  
    }  
}
