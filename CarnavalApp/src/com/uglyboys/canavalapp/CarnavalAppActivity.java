package com.uglyboys.canavalapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Button;

public class CarnavalAppActivity extends Activity {
	
	private Button btProg;
	private Button bt2;
	private Button bt3;
	private Button bt4;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Display display = ((WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        
        Log.i("carnaval", "width: " + width);
        Log.i("carnaval", "height: " + height);
        
        this.btProg = (Button) findViewById(R.bt.programacao);
        this.btProg.setText("programacao");
        this.btProg.setWidth(width / 2);
        this.btProg.setHeight(height / 2 - 5);
        
        this.bt2 = (Button) findViewById(R.bt.bt2);
        this.bt2.setText("bt2");
        this.bt2.setWidth(width / 2);
        this.bt2.setHeight(height / 2 - 5);
        
        this.bt3 = (Button) findViewById(R.bt.bt3);
        this.bt3.setText("bt3");
        this.bt3.setWidth(width / 2);
        this.bt3.setHeight(height / 2 - 5);
        
        this.bt4 = (Button) findViewById(R.bt.bt4);
        this.bt4.setText("bt4");
        this.bt4.setWidth(width / 2);
        this.bt4.setHeight(height / 2 - 5);
        
//        this.btProg.invalidate();
//        this.bt2.invalidate();
//        this.bt3.invalidate();
//        this.bt4.invalidate();

    }
}