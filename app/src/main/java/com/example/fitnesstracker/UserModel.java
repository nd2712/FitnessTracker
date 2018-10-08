package com.example.fitnesstracker;

public class UserModel
{
	String user_name,user_uid;

	public UserModel()
	{
	}

	public UserModel(String user_name, String user_uid)
	{
		this.user_name = user_name;
		this.user_uid = user_uid;
	}

	public String getUser_name()
	{
		return user_name;
	}

	public void setUser_name(String user_name)
	{
		this.user_name = user_name;
	}

	public String getUser_uid()
	{
		return user_uid;
	}

	public void setUser_uid(String user_uid)
	{
		this.user_uid = user_uid;
	}
}
