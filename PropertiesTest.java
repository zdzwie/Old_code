package Classes;

import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;
import java.util.Properties;

import javax.swing.*;

public class PropertiesTest {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(()->{
			PropertiesFrame frame = new PropertiesFrame();
			frame.setVisible(true);
		});

	}

}
