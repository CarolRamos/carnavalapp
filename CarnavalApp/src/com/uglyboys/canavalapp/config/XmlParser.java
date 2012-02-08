package com.uglyboys.canavalapp.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.util.Log;

import com.uglyboys.canavalapp.util.FileUtil;

public class XmlParser  {

	private static final long serialVersionUID = 1L;

	private String filePath = new FileUtil().getExternalStorage() +"programacao.xml";
	private Document doc;

	/**
	 * 
	 * @param filePath The configuration's file path
	 */
	public void loadConfiguration(String filePath) {
		try {
			File file = new File(filePath);

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db;
			db = dbf.newDocumentBuilder();
			this.doc = db.parse(file);
			this.doc.getDocumentElement().normalize();

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Boolean verifyIfXMLExists(String filePath) {
		File file = new File(filePath);
		Log.d("TabletTest", "XmlParser - FilePath: "+ filePath);
		return file.exists();
	}	


	public ProgramacaoConfig getProgramacao(String xml)throws FileNotFoundException {
		Log.i("xmlparser", "xml: " + xml);
		List<Circuito> circuitos = new ArrayList<Circuito>();
		List<CircuitoDia> diasDoCircuito = new ArrayList<CircuitoDia>();
		List<Atracao> atracoes = new ArrayList<Atracao>();
		
		Log.i("xmlparser", "1");
		FileUtil fileUtil = new FileUtil();
		
		Log.i("xmlparser", "2");
		if(!this.verifyIfXMLExists(xml)) throw new FileNotFoundException();

		Log.i("xmlparser", "3");
		if (this.doc == null) this.loadConfiguration(xml);
		if (this.doc == null) return null;

		Log.i("xmlparser", "4");
		ProgramacaoConfig programacaoConfig = new ProgramacaoConfig();
		Node nodeProgramacao = doc.getElementsByTagName("programacao").item(0);
		Log.i("xmlparser", "5");

		NodeList nodesCircuito = doc.getElementsByTagName("circuito");
		Log.i("xmlparser", "nodesCircuito.getLength(): " + nodesCircuito.getLength());

		for (int i = 0; i < nodesCircuito.getLength(); i++){
			Log.i("XMLPARSER", "i: " + i);
			Node nodeCircuito = nodesCircuito.item(i);
			Log.i("XMLPARSER", "nodesCircuito.getNodeValue(): " + nodeCircuito.getNodeValue());
			Log.i("XMLPARSER", "nodesCircuito.getNodeName(): " + nodeCircuito.getNodeName());
			
			NodeList nodesDia = doc.getElementsByTagName("dia");
			Log.i("xmlparser", "nodesDia.getLength(): " + nodesDia.getLength());
			for (int j = 0; j < nodesDia.getLength(); j++){
				Node nodeDia = nodesDia.item(i);
				Log.i("XMLPARSER", "nodeDia.getNodeValue(): " + nodeDia.getNodeValue());
				Log.i("XMLPARSER", "nodeDia.getNodeName(): " + nodeDia.getNodeName());
				
				NodeList nodesAtracoes = doc.getElementsByTagName("atracao");
				Log.i("xmlparser", "nodesAtracoes.getLength(): " + nodesAtracoes.getLength());
				for (int k = 0; k < nodesDia.getLength(); k++){
					Node nodeAtracao = nodesAtracoes.item(i);
					Log.i("XMLPARSER", "node.getNodeValue(): " + nodeAtracao.getNodeValue());
					Log.i("XMLPARSER", "node.getNodeName(): " + nodeAtracao.getNodeName());
				}
				
			}
			
		}
		programacaoConfig.setCircuitos(circuitos);
		return programacaoConfig;
	}
}
