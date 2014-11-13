package com.shixi.jxctest;

import android.app.ActionBar;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddProviderInfo extends Activity {
	
	private EditText addname;
	private EditText addphone;
	private EditText addaddress;
	private EditText addpostcode;
	private EditText addpmail;
	
	private Button save;
	private Button cancel;
	
	ActionBar actionBar;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addprovider);
		
		actionBar=getActionBar();
		actionBar.show();
		
		addname = (EditText)findViewById(R.id.add_p_name);
		addphone = (EditText)findViewById(R.id.add_p_phone);
		addaddress = (EditText)findViewById(R.id.add_p_address);
		addpostcode = (EditText)findViewById(R.id.add_p_postcode);
		addpmail = (EditText)findViewById(R.id.add_p_mail);
		
		save = (Button)findViewById(R.id.finish_pinfo);
		cancel = (Button)findViewById(R.id.cancel_pinfo);
		
		save.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				android.database.sqlite.SQLiteDatabase db;
				db = SQLiteDatabase.openOrCreateDatabase("data/data/com.shixi.jxctest/databases/basicInfo.db", null);
				db.execSQL("insert into provider(name, phone, address, postcode, mail) values(?, ?, ?, ?, ?)",
						new Object[] {addname.getText().toString(), addphone.getText().toString(), addaddress.getText().toString(),
						addpostcode.getText().toString(), addpmail.getText().toString()});
				
				Toast.makeText(getApplicationContext(), "����ɹ���",
					     Toast.LENGTH_SHORT).show();
				
				finish();
			}});
		
		cancel.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();
			}});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.actionbar_nomenu, menu);
		actionBar.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.bg));
		return true;
	}
}
