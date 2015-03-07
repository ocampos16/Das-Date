/**
 * 
 */
package com.example.thebasics;

/**
 * @author Otto
 *
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHandler extends SQLiteOpenHelper{
	
	public dbHandler(Context ctx){
		
		super(ctx, "Mi Base", null, 1);
		
	}
	
	@Override
	public void onCreate(SQLiteDatabase db){
		
		String query = "SELECT * FROM User LIMIT 0 , 30 ";
		db.execSQL(query);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int version_ant, int version_nue){
		
		
	}
		
}//End public class dbHandler
