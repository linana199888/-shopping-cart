package Controller;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implBling;
import Dao.implMember;
import Model.bling;

import javax.swing.SpringLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class reviseUI extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField cl;
	private JTextField ac;
	private JTextField pe;
	private JTextField id1;
	private JTextField amount;
	private JTextField average;
	private JTextArea show1=new JTextArea();
	
	
	/**
     *  時間序號
     * */
	private static String getTimeNumber() {
        String pattern = "yyyyMMddHHmmssSSS";
        SimpleDateFormat d = new SimpleDateFormat(pattern);
        return d.format(new Date());
	}
        
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reviseUI frame = new reviseUI();
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
	public reviseUI() {
		setTitle("修改訂單revise");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, -5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 491, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 762, SpringLayout.WEST, contentPane);
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -229, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, -538, SpringLayout.EAST, panel);
		panel_1.setBackground(new Color(255, 247, 251));
		panel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JLabel lblNewLabel = new JLabel("訂單ID");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		panel_1.add(lblNewLabel);

		id = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.WEST, id, 70, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel, -6, SpringLayout.WEST, id);
		sl_panel_1.putConstraint(SpringLayout.EAST, id, -35, SpringLayout.EAST, panel_1);
		panel_1.add(id);
		id.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("服裝");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		panel_1.add(lblNewLabel_2);

		JLabel label = new JLabel("飾品");
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -16, SpringLayout.NORTH, label);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, label);
		sl_panel_1.putConstraint(SpringLayout.WEST, label, 10, SpringLayout.WEST, panel_1);
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel_1.add(label);

		cl = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, cl, 2, SpringLayout.NORTH, lblNewLabel_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, cl, 0, SpringLayout.WEST, id);
		panel_1.add(cl);
		cl.setColumns(10);

		ac = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, ac, 2, SpringLayout.NORTH, label);
		sl_panel_1.putConstraint(SpringLayout.WEST, ac, 0, SpringLayout.WEST, id);
		panel_1.add(ac);
		ac.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("香水");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 170, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_3, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, label, -13, SpringLayout.NORTH, lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		panel_1.add(lblNewLabel_3);

		pe = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, pe, 2, SpringLayout.NORTH, lblNewLabel_3);
		sl_panel_1.putConstraint(SpringLayout.EAST, pe, 0, SpringLayout.EAST, cl);
		panel_1.add(pe);
		pe.setColumns(10);
		
		show1.setEditable(false);
		show1.setBounds(10, 43, 496, 342);
		
		JPanel panel_2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 12, SpringLayout.EAST, panel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, -48, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, -10, SpringLayout.EAST, panel);
		panel_2.setBackground(new Color(255, 247, 251));
		panel.add(panel_2);
		panel_2.setLayout(null);
		panel_2.add(show1);
		
		JButton Update = new JButton("確定修改");
		Update.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				// 先轉型
				int CL = Integer.parseInt(cl.getText());
				int AC = Integer.parseInt(ac.getText());
				int PE = Integer.parseInt(pe.getText());
				int ID = Integer.parseInt(id.getText());
				/*
				 * if(name!=null && name!="" && chi!=null && chi!="") { student s=new
				 * implStudent().queryId(ID); s.setName(Name); s.setChi(CHI); s.setEng(ENG);
				 * s.setMath(MATH);
				 * 
				 * new implStudent().update(s); }
				 */
				bling b = new implBling().queryId(ID);
				
				b.setCl(CL);
				b.setAc(AC);
				b.setPe(PE);
				
				new implBling().Update(b);
				show1.setText(new implBling().query1());

			}
		});
		Update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		sl_panel_1.putConstraint(SpringLayout.SOUTH, Update, -10, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, Update, -67, SpringLayout.EAST, panel_1);
		panel_1.add(Update);

		JButton query1 = new JButton("查詢");
		query1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<bling> l=new implBling().query2();
				bling[] s=l.toArray(new bling[l.size()]);
		        amount.setText(""+s.length);//""+為整數
		        int sum=0;
		        for(int i=0;i<s.length;i++)
		        {sum=sum+s[i].getSum();}
		        average.setText(""+sum);
		        show1.setText(new implBling().query1());
		        
			}
		});
		query1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				show1.setText(new implBling().query1());
				
			}
		});
		query1.setBounds(10, 10, 87, 23);
		sl_panel.putConstraint(SpringLayout.NORTH, query1, 46, SpringLayout.NORTH, panel_2);
		sl_panel.putConstraint(SpringLayout.WEST, query1, 10, SpringLayout.WEST, panel_2);
		panel_2.add(query1);
		
		

		

		JPanel panel_3 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_3, 14, SpringLayout.SOUTH, panel_1);
		sl_panel.putConstraint(SpringLayout.WEST, panel_3, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_3, 0, SpringLayout.SOUTH, panel_2);

		JLabel lblNewLabel_6 = new JLabel("人數");
		lblNewLabel_6.setBounds(234, 14, 45, 15);
		panel_2.add(lblNewLabel_6);

		amount = new JTextField();
		amount.setBounds(269, 11, 96, 21);
		panel_2.add(amount);
		amount.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("總額");
		lblNewLabel_7.setBounds(375, 14, 46, 15);
		panel_2.add(lblNewLabel_7);

		average = new JTextField();
		average.setBounds(410, 11, 96, 21);
		panel_2.add(average);
		average.setColumns(10);
		
		JButton poi = new JButton("匯出");
		poi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new implMember().exportToExcel("工作表區");
			}
		});
		poi.setBounds(12, 395, 77, 23);
		panel_2.add(poi);
		
		JButton byebye = new JButton("離開");
		byebye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		byebye.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);//離開
			}
		});
		byebye.setBounds(429, 395, 77, 23);
		panel_2.add(byebye);
		
		JButton returnn = new JButton("上一頁");
		returnn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 new bbUI().setVisible(true); //符合會開啟pos視窗
				 dispose(); //關閉login視窗
			}
		});
		returnn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		returnn.setBounds(335, 395, 77, 23);
		panel_2.add(returnn);
		sl_panel.putConstraint(SpringLayout.EAST, panel_3, 0, SpringLayout.EAST, panel_1);

		JPanel panel_4 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, id, 16, SpringLayout.SOUTH, panel_4);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_4, -222, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel, 14, SpringLayout.SOUTH, panel_4);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_4, -10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_4, 0, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_4, 219, SpringLayout.WEST, panel_1);
		panel_4.setBackground(new Color(255, 206, 231));
		panel_4.setForeground(new Color(255, 128, 0));
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("修改");
		lblNewLabel_5.setFont(new Font("新細明體", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(89, 10, 46, 25);
		panel_4.add(lblNewLabel_5);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 12, SpringLayout.SOUTH, lblNewLabel_3);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_5, -19, SpringLayout.WEST, Update);
		panel_3.setBackground(new Color(255, 249, 255));
		panel_3.setForeground(new Color(254, 240, 255));
		panel.add(panel_3);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);

		JLabel lblNewLabel_4 = new JLabel("ID");
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel_4, -194, SpringLayout.EAST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -77, SpringLayout.SOUTH, panel_3);
		lblNewLabel_4.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_4);

		id1 = new JTextField();
		sl_panel_3.putConstraint(SpringLayout.WEST, id1, 69, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel_4, -2, SpringLayout.NORTH, id1);
		sl_panel_3.putConstraint(SpringLayout.EAST, lblNewLabel_4, -18, SpringLayout.WEST, id1);
		panel_3.add(id1);
		id1.setColumns(10);

		JButton delete = new JButton("確認刪除");
		sl_panel_3.putConstraint(SpringLayout.NORTH, delete, 25, SpringLayout.SOUTH, id1);
		sl_panel_3.putConstraint(SpringLayout.WEST, delete, 0, SpringLayout.WEST, id1);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ID1=Integer.parseInt(id1.getText());
		        new implBling().delete(ID1);
		        
			}
		});
		panel_3.add(delete);

		JPanel panel_5 = new JPanel();
		sl_panel_3.putConstraint(SpringLayout.NORTH, id1, 35, SpringLayout.SOUTH, panel_5);
		sl_panel_3.putConstraint(SpringLayout.NORTH, panel_5, 0, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, panel_5, 0, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, panel_5, -133, SpringLayout.SOUTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, panel_5, 219, SpringLayout.WEST, panel_3);
		panel_5.setBackground(new Color(255, 206, 231));
		panel_3.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("刪除");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(91, 0, 52, 41);
		panel_5.add(lblNewLabel_1);
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 4, SpringLayout.NORTH, delete);
	}
}
