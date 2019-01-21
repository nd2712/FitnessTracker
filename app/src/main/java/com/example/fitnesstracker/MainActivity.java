package com.example.fitnesstracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity
{
	FirebaseDatabase database = FirebaseDatabase.getInstance();
	DatabaseReference scanned_id_ref = database.getReference("scanned_id");
	DatabaseReference users_ref = database.getReference("users");

	FloatingActionButton cam_fab;

	String scanned_uid;

	TextView msg;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		msg = findViewById(R.id.hello_msg);

		cam_fab = findViewById(R.id.camera_icon);

		scanned_id_ref.addValueEventListener(new ValueEventListener()
		{
			@Override
			public void onDataChange(DataSnapshot dataSnapshot)
			{
				scanned_uid = dataSnapshot.getValue(String.class);
				users_ref.addValueEventListener(new ValueEventListener()
				{
					@Override
					public void onDataChange(DataSnapshot dataSnapshot)
					{
						boolean userFound = false;
						for(DataSnapshot userSnapshot: dataSnapshot.getChildren())
						{
							UserModel user = userSnapshot.getValue(UserModel.class);
							if(scanned_uid.equals(user.getUser_uid()))
							{
								userFound = true;
								String user_name = user.getUser_name();
								msg.setText("Welcome "+user_name);
							}
						}
						if(!userFound)
						{
							msg.setText("Hello");
						}
					}

					@Override
					public void onCancelled(DatabaseError databaseError)
					{

					}
				});
			}

			@Override
			public void onCancelled(DatabaseError databaseError)
			{

			}
		});

		cam_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view)
			{
				startActivity(new Intent(MainActivity.this,OcrActivity.class));
			}
		});


	}
}
