package com.uglyboys.canavalapp;

import java.io.File;
import java.io.FileNotFoundException;

import com.uglyboys.canavalapp.config.ProgramacaoConfig;
import com.uglyboys.canavalapp.config.XmlParser;
import com.uglyboys.canavalapp.util.FileUtil;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Button;

public class CarnavalAppActivity extends Activity {
	
	public static String XMLPATH = "";
	public static String DEFAULT_STORAGE = "";
	public static String EXTERNAL_PATH = "";
	
	private FileUtil fileUtil;
	
	private Button btProg;
	private Button bt2;
	private Button bt3;
	private Button bt4;
	
	private int width = 0;
	private int height = 0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Display display = ((WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        this.width = display.getWidth();
        this.height = display.getHeight();
        
        CarnavalAppActivity.DEFAULT_STORAGE = this.getDafaultStorage();
        Log.i("carnaval", "DEFAULTSTORAGE: " + CarnavalAppActivity.DEFAULT_STORAGE);
        
        if (CarnavalAppActivity.DEFAULT_STORAGE.equalsIgnoreCase("")){
        	//Exibir mensagem de erro e sair da aplicacao
        }
        
        EXTERNAL_PATH = DEFAULT_STORAGE + "/CarnavalApp/";
        
        CarnavalAppActivity.XMLPATH = CarnavalAppActivity.EXTERNAL_PATH + "programacao.xml";
        Log.i("carnaval", "XMLPATH: " + CarnavalAppActivity.XMLPATH);
        
        this.initButtons();
        
        this.fileUtil = new FileUtil();
        this.fileUtil.copyAssets(this);
        
        Log.i("carnaval", "width: " + this.width);
        Log.i("carnaval", "height: " + this.height);
        
        File file = new File(CarnavalAppActivity.XMLPATH);
        Log.i("carnaval", "filesssss: " + file.getPath());
        if (file.exists()){
        	Log.i("carnaval", "Arquivo existe");
        	this.getProgramacaoCarnaval();
        } else {
        	Log.i("carnaval", "Arquivo nao existe");
        }
    }

	private void initButtons(){
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
    }
	
	private void getProgramacaoCarnaval() {
		// TODO Auto-generated method stub
		
		ProgramacaoConfig programacaoConfig = new ProgramacaoConfig();
		
		XmlParser xmlParser = new XmlParser();
		try {
			programacaoConfig = xmlParser.getProgramacao(CarnavalAppActivity.XMLPATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getDafaultStorage() {
		// TODO Auto-generated method stub
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
			return Environment.getExternalStorageDirectory() + "";
		}
		return "";
	}
}