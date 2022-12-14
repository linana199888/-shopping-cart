package Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implMember;
import Model.member;

import javax.swing.SpringLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addmemberUI extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addmemberUI frame = new addmemberUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public addmemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 453);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 238, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 205, 181));
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 52, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 495, SpringLayout.WEST, contentPane);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JLabel lblNewLabel = new JLabel("??????");
		lblNewLabel.setFont(new Font("????????????", Font.PLAIN, 24));
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 212, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -10, SpringLayout.SOUTH, panel);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("??????");
		lblNewLabel_1.setFont(new Font("????????????", Font.PLAIN, 18));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 32, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 130, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);

		name = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, name, 2, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, name, 19, SpringLayout.EAST, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, name, 143, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(name);
		name.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("??????");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 39, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1_1, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel_1_1.setFont(new Font("????????????", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("??????");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1, 40, SpringLayout.SOUTH, lblNewLabel_1_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_1, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel_1_1_1.setFont(new Font("????????????", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1_1_1);

		username = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, username, 0, SpringLayout.NORTH, lblNewLabel_1_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, username, 19, SpringLayout.EAST, lblNewLabel_1_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, username, 0, SpringLayout.EAST, name);
		username.setColumns(10);
		contentPane.add(username);

		password = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, password, 2, SpringLayout.NORTH, lblNewLabel_1_1_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, password, 19, SpringLayout.EAST, lblNewLabel_1_1_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, password, 0, SpringLayout.EAST, name);
		contentPane.add(password);

		JButton ok = new JButton("??????");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.get-->username 2.?????????????????? 3.query(??????)-->true-->??????-->??????
				 * 4.false-->get-->????????????--->new member-->add()-->????????????-->????????? 
				 */
				String Username = username.getText();
				if (name.getText().length() != 0 && username.getText().length() != 0 && password.getText().length() != 0) // ??????
				{

					if (new implMember().query(Username)) {
						JFrame jFrame = new JFrame();
						JOptionPane.showMessageDialog(jFrame, "????????????,????????????");
					} else {
						String Name = name.getText();
						String Password = password.getText();

						member m = new member(Name, Username, Password);
						new implMember().add(m);

						JFrame jFrame = new JFrame();
						JOptionPane.showMessageDialog(jFrame, "????????????,????????????");
						
						new lodding().setVisible(true);
						dispose();
					}
				}
				else
				{
					JFrame jFrame = new JFrame();
					JOptionPane.showMessageDialog(jFrame, "????????????");
				}
				
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, ok, 70, SpringLayout.SOUTH, password);
		sl_contentPane.putConstraint(SpringLayout.WEST, ok, 196, SpringLayout.WEST, contentPane);
		contentPane.add(ok);

		JButton returnn = new JButton("??????");
		returnn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new lodding().setVisible(true); // ???????????????pos??????
				dispose(); // ??????login??????
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, returnn, 7, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, returnn, 0, SpringLayout.WEST, panel);
		contentPane.add(returnn);
	}
}
