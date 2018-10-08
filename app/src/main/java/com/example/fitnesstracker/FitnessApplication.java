package com.example.fitnesstracker;

import android.app.Application;

import com.google.firebase.FirebaseApp;

public class FitnessApplication extends Application
{
	@Override
	public void onCreate()
	{
		super.onCreate();
		FirebaseApp.initializeApp(this);
//		FirebaseDatabase.getInstance().setPersistenceEnabled(true);
	}
}
