package com.koroliuk;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import ps.sony.Pro;

public class UI extends JFrame {

	private JLabel pic1Lbl = new JLabel();
	private JLabel pic2Lbl = new JLabel();
	private JLabel dotaLbl = new JLabel("DOTA 2");
	private JLabel methodLbl = new JLabel();
	private JLabel text1Lbl = new JLabel();
	private JLabel text2Lbl = new JLabel();
	private String name;

	public UI(String name) {
		super("Get Hero Name");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 600);
		getContentPane().setBackground(new Color(119, 136, 153));
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setLayout(null);

		ImageIcon pic1 = new ImageIcon(UI.class.getClassLoader().getResource("images/pic1.jpg"));
		pic1Lbl.setIcon(pic1);
		pic1Lbl.setBounds(20, 91, 356, 229);

		ImageIcon pic2 = new ImageIcon(UI.class.getClassLoader().getResource("images/pictures/pic2.jpg"));
		pic2Lbl.setIcon(pic2);
		pic2Lbl.setBounds(20, 331, 356, 229);

		dotaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		dotaLbl.setFont(new Font("Tahoma", Font.BOLD, 50));
		dotaLbl.setBounds(20, 29, 356, 51);

		text1Lbl.setBounds(399, 108, 274, 197);
		StringBuilder sbForText1 = new StringBuilder();
		try (InputStream is = UI.class.getClassLoader().getResourceAsStream("text/text1.txt");
				BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
			String str;
			while ((str = reader.readLine()) != null) {
				sbForText1.append(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		text1Lbl.setText(sbForText1.toString());
		text1Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		text1Lbl.setFont(new Font("Tahoma", Font.ITALIC, 10));

		text2Lbl.setBounds(399, 347, 274, 197);

		File fileText2 = new File("text/text2.txt");
		try {
			String str = new String(Files.readAllBytes(fileText2.toPath()));
			text2Lbl.setText(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		text2Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		text2Lbl.setFont(new Font("Tahoma", Font.ITALIC, 10));

		methodLbl.setBounds(399, 29, 274, 51);
		methodLbl.setText(createPro(name));
		methodLbl.setHorizontalAlignment(SwingConstants.CENTER);
		methodLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		methodLbl.setForeground(new Color(0, 100, 0));

		getContentPane().add(pic2Lbl);
		getContentPane().add(pic1Lbl);
		getContentPane().add(dotaLbl);
		getContentPane().add(methodLbl);
		getContentPane().add(text1Lbl);
		getContentPane().add(text2Lbl);

		setResizable(false);
		setLocationRelativeTo(null);

	}

	private String createPro(String name) {
		Pro pro = new Pro(name);
		return pro.getHeroName() + " сhose two characters";

	}

}