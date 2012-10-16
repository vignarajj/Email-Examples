package com.email.exampleone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Emailactivity extends Activity {
	EditText eed1,eed2,eed3;
	Button ebtn1,ebtn2;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        eed1=(EditText)findViewById(R.id.eme1);
        eed2=(EditText)findViewById(R.id.eme2);
        eed3=(EditText)findViewById(R.id.eme3);
        ebtn1=(Button)findViewById(R.id.ebt1);
        ebtn2=(Button)findViewById(R.id.ebt2);
        ebtn1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String a1=eed1.getText().toString();
				String a2=eed2.getText().toString();
				String a3=eed3.getText().toString();
				if(a1.length()==0)
				{
					Toast.makeText(Emailactivity.this,"Enter the mail ID",Toast.LENGTH_SHORT).show();
				}
				else
				{
				Intent email3 = new Intent(Intent.ACTION_SEND);
			      email3.setType("text/html");
			      email3.putExtra(Intent.EXTRA_EMAIL  ,new String[]{ eed1.getText().toString()});
			      email3.putExtra(Intent.EXTRA_SUBJECT,a2);
			      email3.putExtra(Intent.EXTRA_TEXT   ,a3);
			      try {
			         startActivity(Intent.createChooser(email3, "Send mail..."));
			      } catch (android.content.ActivityNotFoundException ex) {
			         Toast.makeText(Emailactivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
			      }   
				}
			}
		});
        ebtn2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				eed1.setText("");
				eed2.setText("");
				eed3.setText("");
			}
		});
	}
}
