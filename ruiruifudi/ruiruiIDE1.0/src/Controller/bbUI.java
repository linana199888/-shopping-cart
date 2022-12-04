package Controller;

import java.awt.EventQueue;

//時間
import java.text.SimpleDateFormat;
import java.util.Date;

//列印
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.bling;

import java.awt.CardLayout;
import javax.swing.SpringLayout;
import javax.swing.Timer;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Dao.implBling;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class bbUI extends JFrame {

	private JPanel contentPane;
	private JTextField cl;
	private JTextField ac;
	private JTextField pe;
	private JTextArea output1 = new JTextArea();
	private JTextField total;
	private JTextField pay;
	private JTextArea o = new JTextArea();
	private ButtonGroup G1; 
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bbUI frame = new bbUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public bbUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(15, 0, 831, 54);
		panel.setBackground(new Color(255, 249, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("小福袋");
		lblNewLabel.setBounds(358, 20, 85, 21);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		
		//時間
		JLabel Date = new JLabel("日期");
		Date.setBounds(678, 24, 143, 15);
		panel.add(Date);
		
		JButton dan = new JButton("回登入");
		dan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new lodding().setVisible(true); //符合會開啟pos視窗
				 dispose(); //關閉login視窗
			}
		});
		dan.setBounds(10, 5, 85, 23);
		panel.add(dan);
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon(bbUI.class.getResource("/Controller/icon/Gift-icon.png")));
		lblNewLabel_16.setBounds(425, 5, 46, 49);
		panel.add(lblNewLabel_16);
		
		Timer timeAction = new Timer(100, e -> {
            long timemillis = System.currentTimeMillis();
            
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date.setText(df.format(new Date(timemillis)));
        });
        timeAction.start();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(15, 59, 372, 33);
		panel_1.setBackground(new Color(255, 249, 255));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton yes = new JRadioButton("會員姓名");
		yes.setBounds(6, 6, 76, 23);
		panel_1.add(yes);
		
		JRadioButton not = new JRadioButton("不是會員");
		not.setBounds(245, 6, 107, 23);
		panel_1.add(not);
		
		G1 = new ButtonGroup(); 
		G1.add(yes);
		G1.add(not);
		
		JTextArea name = new JTextArea();
		name.setBackground(new Color(228, 228, 228));
		name.setBounds(88, 4, 136, 25);
		panel_1.add(name);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(15, 102, 372, 403);
		contentPane.add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JPanel panel_3 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_3, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_3, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_3, 393, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_3, 362, SpringLayout.WEST, panel_2);
		panel_3.setBackground(new Color(255, 247, 251));
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("今日份幸福");
		lblNewLabel_1.setBounds(10, 10, 81, 15);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("購買數量");
		lblNewLabel_2.setBounds(184, 34, 91, 15);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("服裝");
		lblNewLabel_3.setBounds(116, 78, 46, 15);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("飾品");
		lblNewLabel_4.setBounds(116, 172, 46, 15);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("香水");
		lblNewLabel_5.setBounds(116, 268, 46, 15);
		panel_3.add(lblNewLabel_5);
		
		cl = new JTextField();
		cl.setText("0");
		cl.setBounds(159, 75, 96, 21);
		panel_3.add(cl);
		cl.setColumns(10);
		
		ac = new JTextField();
		ac.setText("0");
		ac.setBounds(159, 169, 96, 21);
		panel_3.add(ac);
		ac.setColumns(10);
		
		pe = new JTextField();
		pe.setText("0");
		pe.setBounds(159, 265, 96, 21);
		panel_3.add(pe);
		pe.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("套");
		lblNewLabel_6.setBounds(265, 78, 46, 15);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("件");
		lblNewLabel_7.setBounds(265, 172, 46, 15);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("支");
		lblNewLabel_8.setBounds(265, 258, 46, 34);
		panel_3.add(lblNewLabel_8);
		
		

		JButton ok = new JButton("確定");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name=name.getText();
		        String Cl=cl.getText();
		        String Ac=ac.getText();
		        String Pe=pe.getText();
		        
		        boolean Not=not.isSelected();

		        int C=Integer.parseInt(Cl);
		        int A=Integer.parseInt(Ac);
		        int P=Integer.parseInt(Pe);

		        bling b =new bling(Name,C,A,P,Not);
		        o.setText(b.show());
		        //output.setText(b.show());
		        total.setText(b.show3());
		        
			}
		});
		ok.setBounds(116, 350, 87, 23);
		panel_3.add(ok);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(bbUI.class.getResource("/Controller/icon/bikini-icon PNG.png")));
		lblNewLabel_13.setBounds(41, 35, 75, 81);
		panel_3.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(bbUI.class.getResource("/Controller/icon/EarringsEAR-icon PNG.png")));
		lblNewLabel_14.setBounds(41, 126, 102, 93);
		panel_3.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon(bbUI.class.getResource("/Controller/icon/perfume-icon PNG.png")));
		lblNewLabel_15.setBounds(51, 229, 75, 81);
		panel_3.add(lblNewLabel_15);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setBounds(397, 64, 457, 441);
		contentPane.add(panel_4);
		SpringLayout sl_panel_4 = new SpringLayout();
		panel_4.setLayout(sl_panel_4);
		
		JPanel panel_5 = new JPanel();
		sl_panel_4.putConstraint(SpringLayout.NORTH, panel_5, 10, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.WEST, panel_5, 10, SpringLayout.WEST, panel_4);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, panel_5, 431, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.EAST, panel_5, 447, SpringLayout.WEST, panel_4);
		panel_5.setBackground(new Color(255, 247, 251));
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		o.setEditable(false);
		o.setBounds(10, 10, 417, 90);
		panel_5.add(o);
		
		JLabel lblNewLabel_9 = new JLabel("輸入應付金額");
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_9.setBounds(53, 120, 78, 16);
		panel_5.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("輸入實收金額");
		lblNewLabel_10.setBounds(53, 173, 78, 16);
		panel_5.add(lblNewLabel_10);
		
		total = new JTextField();
		total.setBounds(141, 116, 148, 26);
		panel_5.add(total);
		total.setColumns(10);
		
		pay = new JTextField();
		pay.setBounds(141, 169, 148, 26);
		panel_5.add(pay);
		pay.setColumns(10);
		
		JButton ok1 = new JButton("確認結帳");
		ok1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 	String Name=name.getText();
			        int CL=Integer.parseInt(cl.getText());
			        int AC=Integer.parseInt(ac.getText());
			        int PE=Integer.parseInt(pe.getText());
			        boolean NOT=not.isSelected();
			    
				new implBling().add(Name, CL, AC, PE, NOT);
				
			}
		});
		ok1.setBounds(315, 167, 96, 29);
		ok1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				 	String t =total .getText();
			        String p =pay.getText();
			        double  r1 = Double.valueOf(t);
			        double  r2 = Double.valueOf(p);
			        double r3=r2-r1;
			       
					output1.setText("1000$\t"+(r3-r3%1000)/1000+"張"+
			            "\n500$\t"+(r3%1000-r3%500)/500+"張"+
			            "\n100$\t"+(r3%500-r3%100)/100+"張"+
			                    "\n================================="+
			            "\n50$\t"+(r3%100-r3%100%50)/50+"個"+
			            "\n10$\t"+(r3%100%50-r3%100%50%10)/10+"個"+
			            "\n5$\t"+(r3%100%50%10-r3%100%50%10%5)/5+"個"+
			            "\n1$\t"+(r3%500%100%50%10%5%1)+"個"
			        );
			}
			
			
		});
		panel_5.add(ok1);
		
		
		
		JLabel lblNewLabel_11 = new JLabel("找零");
		lblNewLabel_11.setBounds(10, 199, 26, 16);
		panel_5.add(lblNewLabel_11);
		
		JButton print = new JButton("列印明細");
		print.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//列印
		        try{
		            o.print();
		        }catch(PrinterException ex){
		        Logger.getLogger(bbUI.class.getName()).log(Level.SEVERE,null,ex);
		        }
			}
		});
		print.setBounds(331, 351, 96, 29);
		panel_5.add(print);
		
		JButton leave = new JButton("離開");
		leave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		leave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);//離開
			}
		});
		leave.setBounds(331, 388, 96, 29);
		panel_5.add(leave);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setBounds(1, 375, 46, 42);
		panel_5.add(lblNewLabel_12);
		lblNewLabel_12.setIcon(new ImageIcon(bbUI.class.getResource("/Controller/icon/EVE-icon.png")));
		
		JButton revise = new JButton("修改訂單");
		revise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		revise.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
		     new reviseUI().setVisible(true); //符合會開啟pos視窗
		     dispose(); //關閉login視窗	
		       
			}
		});
		revise.setBounds(57, 391, 85, 23);
		panel_5.add(revise);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 225, 417, 116);
		panel_5.add(scrollPane);
		output1.setEditable(false);
		scrollPane.setViewportView(output1);
		
		JButton bling = new JButton("清空");
		bling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText(null);
		        cl.setText(null);
		        ac.setText(null);
		        pe.setText(null);
		        o.setText(null);
		        total.setText(null);
		        pay.setText(null);
		        output1.setText(null);
			}
		});
		bling.setBounds(234, 388, 85, 29);
		panel_5.add(bling);
		
		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setIcon(new ImageIcon(bbUI.class.getResource("/Controller/icon/coins-in-hand-icon.png")));
		lblNewLabel_17.setBounds(10, 157, 46, 32);
		panel_5.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setIcon(new ImageIcon(bbUI.class.getResource("/Controller/icon/coins-icon.png")));
		lblNewLabel_18.setBounds(10, 107, 46, 42);
		panel_5.add(lblNewLabel_18);

	}
}


