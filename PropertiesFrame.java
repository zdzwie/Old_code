package Classes;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;
import java.util.Properties;

import javax.swing.*;

public class PropertiesFrame extends JFrame {
	
	private static final int D_W = 300;
	private static final int D_H = 200;
	
	private File propertiesFile;
	private Properties settings;
	
	public PropertiesFrame() {
		
		String userDir = System.getProperty("user.home");
		File propertiesDier = new File(userDir,".corejava");
		
		if(!propertiesDier.exists()) propertiesDier.mkdir();
		
		this.propertiesFile = new File(propertiesDier,"program.properties");
		
		Properties defaultSettings = new Properties();
		defaultSettings.put("left","0" );
		defaultSettings.put("top","0" );
		defaultSettings.put("width",""+this.D_W );
		defaultSettings.put("height",""+this.D_H );
		defaultSettings.put("title","");
		
		this.settings = new Properties(defaultSettings);
		
		if(this.propertiesFile.exists()) {
			
			try(InputStream in = new FileInputStream(propertiesFile)){this.settings.load(in);}
			catch(IOException ex) {ex.printStackTrace();}
			}
		int left = Integer.parseInt(this.settings.getProperty("left"));
		int top = Integer.parseInt(this.settings.getProperty("top"));
		int width = Integer.parseInt(this.settings.getProperty("width"));
		int height = Integer.parseInt(this.settings.getProperty("height"));
		
		setBounds(left,top, width, height);
		
		String title = settings.getProperty("title");
		
		if(title.equals("")) title = JOptionPane.showInputDialog("Wpisz tytu³ ramki:");
		if(title==null)title = "";
		setTitle(title);
		
		addWindowListener(new WindowAdapter(){
			
			public void WindowClosing(WindowEvent event) {
				
				settings.put("left", ""+getX());
				settings.put("top", ""+getY());
				settings.put("width", ""+getWidth());
				settings.put("height", ""+getHeight());
				settings.put("title", getTitle());
			
			try(OutputStream out = new FileOutputStream(propertiesFile))
			{
				settings.store(out, "Program Properties");
			}
			catch(IOException ex) {ex.printStackTrace();}
		System.exit(0);
			}
	});
		
		
		
	}

}
