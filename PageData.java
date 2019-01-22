package pageData;

import java.awt.event.*;
import java.awt.*;
import java.net.*;
import java.io.*;
import javax.swing.*;

import javax.swing.JFrame;

public class PageData extends JFrame implements Runnable, ActionListener {

	Thread runner;
	String[] headers = {"Contnet-Length","Content-Type","Date","Public", "Expires","Last-Modified","Server"};
	
	URL page;
	JTextField url;
	
	JLabel[] headerLabel = new JLabel[7];
	JTextField[] header = new JTextField[7];
	JButton readPage,clearPage,quitLoading;
	JLabel status;
	
	public PageData() {
		
		super("Dane strony");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel;
		setLayout(new GridLayout(10,1));
		
		JPanel first = new JPanel();
		first.setLayout(new FlowLayout(FlowLayout.RIGHT));
	
		JLabel urlLabel = new JLabel("URL:");
		this.url = new JTextField(22);
		urlLabel.setLabelFor(this.url);
		
		first.add(urlLabel);
		first.add(url);
		
		JPanel second = new JPanel();
		second.setLayout(new FlowLayout());
		
		this.readPage = new JButton("Odczytaj stronê");
		this.clearPage = new JButton("Wyczyœæ pola");
		this.quitLoading = new JButton("Zakoñcz odczytywanie");
		
		this.readPage.setMnemonic('o');
		this.clearPage.setMnemonic('w');
		this.quitLoading.setMnemonic('z');
		
		this.readPage.setToolTipText("Rozpocznij wczytywanie strony");
		this.clearPage.setToolTipText("Wyczyœæ wszystkie pola nag³ówków");
		this.quitLoading.setToolTipText("Zakoñcz wczytywanie strony");
		
		this.readPage.setEnabled(true);
		this.clearPage.setEnabled(false);
		this.quitLoading.setEnabled(false);
		
		this.readPage.addActionListener(this);
		this.clearPage.addActionListener(this);
		this.quitLoading.addActionListener(this);
		
		second.add(this.readPage);
		second.add(this.clearPage);
		second.add(this.quitLoading);
		add(second);
		
		JPanel[] row = new JPanel[7];
		for(int i =0;i<7;i++) {
			
			row[i] = new JPanel();
			row[i].setLayout(new FlowLayout(FlowLayout.RIGHT));
			
			this.headerLabel[i] = new JLabel(headers[i]+":");
			this.header[i] = new JTextField(22);
			this.headerLabel[i].setLabelFor(this.header[i]);
			
			row[i].add(this.headerLabel[i]);
			row[i].add(this.header[i]);
			add(row[i]);
		}
		
		JPanel last = new JPanel();
		last.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.status = new JLabel("Wpisz adres URL do sprawdzenia.");
		last.add(status);
		add(last);
		pack();
		setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
