package com.uglyboys.canavalapp.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;

import com.uglyboys.canavalapp.CarnavalAppActivity;

public class FileUtil {

	public void copyAssets(Context context) {
		AssetManager assetManager = context.getAssets();
		String[] files            = null;

		try {
			files = assetManager.list("");

			//Prepare output folder
			File directory = new File(CarnavalAppActivity.EXTERNAL_PATH);
			
			Log.i("TabletTest", "directory: " + directory.getPath());

			//If directory already exists exit.
			if(directory.exists()) return;

			//Prepare output folder	
			directory.mkdir();

			Log.i("TabletTest", "Main"+" - Directory created. ");

		} catch (IOException e) {
			e.printStackTrace();
		}

		for(int i=0; i<files.length; i++) {
			InputStream in   = null;
			OutputStream out = null;

			try {

				in  = assetManager.open(files[i]);
				Log.i("TabletTest", "Main"+" - File opened: "+ files[i]);
				out = new FileOutputStream( CarnavalAppActivity.EXTERNAL_PATH + files[i]);

				this.copyFile(in, out);
				Log.i("TabletTest", "Main"+" - File: "+ files[i]);
				//Close Streams
				in.close();
				out.flush();
				out.close();

				//Free pointers
				in  = null;
				out = null;
			} catch(Exception e) {
				Log.e("TabletTest", e.getMessage());
				e.printStackTrace();
			}       
		}
	}

	private void copyFile(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[1024];
		int read;
		while((read = in.read(buffer)) != -1){
			out.write(buffer, 0, read);
		}
	}

	public String getExternalStorage(){
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
			return Environment.getExternalStorageDirectory() + "";
		}
		return "";
	}

}
