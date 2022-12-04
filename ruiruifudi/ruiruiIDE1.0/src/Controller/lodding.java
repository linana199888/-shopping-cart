package Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;

import Dao.implMember;

import javax.swing.event.AncestorEvent;

public class lodding extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JPasswordField nn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lodding frame = new lodding();
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
	public lodding() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 15, 457, 256);
		panel.setBackground(new Color(251, 226, 254));
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JLabel lblNewLabel = new JLabel("");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 59, SpringLayout.NORTH, panel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\icon\\12\\love-girl-icon.png"));
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("帳號");
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -32, SpringLayout.WEST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 70, SpringLayout.NORTH, panel);
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("密碼");
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel.add(lblNewLabel_2);

		id = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, id, 70, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, id, 254, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, -17, SpringLayout.WEST, id);
		sl_panel.putConstraint(SpringLayout.EAST, id, -85, SpringLayout.EAST, panel);
		panel.add(id);
		id.setColumns(10);

		nn = new JPasswordField();
		sl_panel.putConstraint(SpringLayout.WEST, nn, 17, SpringLayout.EAST, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.EAST, nn, -85, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, -2, SpringLayout.NORTH, nn);
		sl_panel.putConstraint(SpringLayout.NORTH, nn, 36, SpringLayout.SOUTH, id);
		sl_panel.putConstraint(SpringLayout.SOUTH, nn, -108, SpringLayout.SOUTH, panel);
		panel.add(nn);

		JLabel bye = new JLabel("");
		sl_panel.putConstraint(SpringLayout.NORTH, bye, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, bye, -10, SpringLayout.EAST, panel);
		bye.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 離開
				System.exit(0);
			}
		});
		bye.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\icon\\12\\close-icon.png"));
		panel.add(bye);

		JLabel sayonala = new JLabel("");
		sayonala.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);// 離開
			}
		});
		sayonala.setIcon(new ImageIcon(lodding.class.getResource("/Controller/icon/close-icon.png")));
		sl_panel.putConstraint(SpringLayout.NORTH, sayonala, 0, SpringLayout.NORTH, bye);
		sl_panel.putConstraint(SpringLayout.EAST, sayonala, -10, SpringLayout.EAST, panel);
		panel.add(sayonala);

		JButton btnNewButton = new JButton("註冊");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new addmemberUI().setVisible(true);
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, bye);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, panel);
		panel.add(btnNewButton);

		JButton ok = new JButton("確定");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String user = id.getText(); // 抓輸入的username
				String pass = nn.getText(); // 抓輸入的密碼
				
				if (id.getText().length() != 0 && nn.getText().length() != 0) {
					if (new implMember().query(user, pass)) {
						new bbUI().setVisible(true);
						dispose();
					} else {
						JFrame JFrame = new JFrame();
						JOptionPane.showMessageDialog(JFrame, "無此帳號,請先註冊");
					}
				} else {
					JFrame JFrame = new JFrame();
					JOptionPane.showMessageDialog(JFrame, "不可空白");
				}
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, ok, 31, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.WEST, ok, 68, SpringLayout.EAST, lblNewLabel);
		panel.add(ok);
	}
}
