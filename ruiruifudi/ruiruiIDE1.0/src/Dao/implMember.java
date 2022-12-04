package Dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFCreationHelper;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.IOUtils;

import Model.member;

public class implMember implements memberDao{
	
	public static void main(String[] args) {
		new implMember().add(new member("aa","123","123"));
		//System.out.println(new implMember().query("123", "123"));
		//System.out.println(new implMember().query("aaa"));//測試帳號重複 有無這個帳號
	}
	@Override
	public void add(member m) {
		Connection conn=DbConnection.getDB();
		String sql="insert into member(name,username,password) values(?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,m.getName() );
			ps.setString(2,m.getUsername());
			ps.setString(3,m.getPassword());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public boolean query(String username, String password) {
		Connection conn=DbConnection.getDB();
		String sql="select *from member where username=? and password=?";
		boolean nono=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);//第一個問號
			ps.setString(2, password);//第二個問號
			ResultSet rs=ps.executeQuery();
			if(rs.next()) nono=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nono;
	}

	@Override
	public boolean query(String username) {
		Connection conn=DbConnection.getDB();
		String sql="select *from member where username=?";
		boolean nono=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);//第一個問號
			ResultSet rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nono;
	}
	
	public static void exportToExcel(String tableName) {
        Connection conn = DbConnection.getDB();
        String sql = "select * from bling";

        JFileChooser jf = new JFileChooser();
       
        jf.setFileSelectionMode(JFileChooser.SAVE_DIALOG | JFileChooser.DIRECTORIES_ONLY);
        jf.showSaveDialog(null);
        File fi = jf.getSelectedFile();// 擷取選擇file路徑
        String f = fi.getAbsolutePath() + "/bling.xls";// 選擇路徑+/fees.xls

        ResultSet resultSet = null;
        OutputStream os = null;

        //建立一個excel工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();

        //建立表 並設定sheet的名稱
        HSSFSheet sheet = workbook.createSheet(tableName);

        //建立標題行
        HSSFRow row = sheet.createRow(0);

        //日期格式化
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        HSSFCreationHelper creationHelper = workbook.getCreationHelper();
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));


        if (jf.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

            try {

                //通過傳進來的sql 查詢表中的資料
                PreparedStatement statement = conn.prepareStatement(sql);
                //獲取結果集
                resultSet = statement.executeQuery();
                //獲取元資料    用來獲取欄位名
                ResultSetMetaData metaData = resultSet.getMetaData();
                //每一行的列數
                int columnCount = metaData.getColumnCount();

                //動態根據欄位名設定列名 即標題
                for (int i = 0; i < columnCount; i++) {
                    String labelName = metaData.getColumnLabel(i + 1);
                    row.createCell(i).setCellValue(labelName);
                }

                int i = 1;

                //臨時行
                HSSFRow tempRow;
                //遍歷結果集  往excel中寫資料
                while (resultSet.next()) {
                    //建立臨時行  即當前行
                    tempRow = sheet.createRow(i);
                    for (int j = 0; j < columnCount; j++) {
                        //獲取當前單元格
                        HSSFCell tempCell = tempRow.createCell(j);
                        //獲取資料庫中與當前格對應的資料
                        Object temp = resultSet.getObject(j + 1);

                        //如果獲取到的資料為空則跳過該單元格
                        if (temp == null || "".equals(temp)) {
                            continue;
                        }

                        //如果獲取到的是時間  則格式化時間再寫到excel中
                        if (temp instanceof java.util.Date) {
                            //給日期設定樣式
                            tempCell.setCellStyle(cellStyle);
                            tempCell.setCellValue((java.util.Date) temp);
                        } else if (temp instanceof Boolean) {
                            tempCell.setCellValue((Boolean) temp);
                        } else if (temp instanceof Double) {
                            tempCell.setCellValue((Double) temp);
                        } else {
                            tempCell.setCellValue(temp.toString());
                        }
                    }
                    i++;
                }

                os = new BufferedOutputStream(new FileOutputStream(f));
                //將excel表格寫出到指定的路徑下
                workbook.write(os);

                JFrame jFrame = new JFrame();
                JOptionPane.showMessageDialog(jFrame, "匯出成功！");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //關閉資源
                IOUtils.closeQuietly(os);
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
        }

    }

	
}
