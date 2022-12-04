package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.bling;


import Model.bling;




public class implBling implements RuiDao {


	public static void main(String[] args) {
		//new implBling().add("emmo", 50, 47, 60,true);
		//new implBling().query1();
		/*bling b=new implBling().queryId(1);
        b.setName("oo");
        b.setCl(70);
        
        new implBling().Update(b);*/

	}
	
	@Override
	public void add(String name,int cl,int ac,int pe,boolean not) {
		Connection conn=DbConnection.getDB();
        String sql="insert into bling(name,cl,ac,pe,sum) values(?,?,?,?,?)";//sql的欄位
        bling b=new bling(name,cl,ac,pe,not);//urse
        
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, b.getName());
            ps.setInt(2, b.getCl());
            ps.setInt(3, b.getAc());
            ps.setInt(4, b.getPe());
            ps.setInt(5, b.getSum());
            
            ps.executeUpdate();//收尾執行
        } catch (SQLException ex) {
            Logger.getLogger(implBling.class.getName()).log(Level.SEVERE, null, ex);
        }  
	}

	@Override
	public String query1() {
		String show="";
		Connection conn=DbConnection.getDB();
		String Sql="select * from bling";
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement(Sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				/*System.out.println("id:"+rs.getInt("id")+
                "\tname:"+rs.getString("name")+
                "\tcl:"+rs.getInt("cl")+
                "\tac:"+rs.getInt("ac")+
                "\tpe:"+rs.getInt("pe")+
                "\tsum:"+rs.getInt("sum"));測試*/
				show =show+"id:"+rs.getInt("id")+
                        "\tname:"+rs.getString("name")+
                        "\tcl:"+rs.getInt("cl")+
                        "\tac:"+rs.getInt("ac")+
                        "\tpe:"+rs.getInt("pe")+
                        "\tsum:"+rs.getInt("sum")+"\n";
			}
		} catch (SQLException e) {
			Logger.getLogger(implBling.class.getName()).log(Level.SEVERE, null, e);
		}
		return show;
	}
	
	@Override
	public List<bling> querySum2(int start, int end) {
		List<bling> l=new ArrayList();
	       Connection conn=DbConnection.getDB();
	       String sql="select * from bling where sum>=? and sum<=?";
	       
	        try {
	            PreparedStatement ps=conn.prepareStatement(sql);
	            ps.setInt(1, start);
	            ps.setInt(2, end);
	            ResultSet rs=ps.executeQuery();//database資料,rs--->student
	            while(rs.next())//每一筆
	            {
	            	bling b=new bling();//空白資料的 student
	            	b.setId(rs.getInt("id"));
	                b.setName(rs.getString("name"));
	                b.setCl(rs.getInt("cl"));
	                b.setAc(rs.getInt("ac"));
	                b.setPe(rs.getInt("pe"));
	                b.setSum(rs.getInt("sum"));

	            l.add(b);//新增student物件
	            }           
	        } catch (SQLException ex) {
	            Logger.getLogger(implBling.class.getName()).log(Level.SEVERE, null, ex);
	        } 
	       return l;
	}
	
	@Override
	public List<bling> query2() {
		List<bling> l=new ArrayList();
        Connection conn=DbConnection.getDB();
        String sql="select * from bling";
        
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
            	bling b=new bling();
                b.setId(rs.getInt("id"));
                b.setName(rs.getString("name"));
                b.setCl(rs.getInt("cl"));
                b.setAc(rs.getInt("ac"));
                b.setPe(rs.getInt("pe"));
                b.setSum(rs.getInt("sum"));

            l.add(b);
            //l.add(new student(rs.getString("name"),rs.getInt("chi"),rs.getInt("eng"),rs.getInt("math")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(implBling.class.getName()).log(Level.SEVERE, null, ex);
        }
       return l;
		
	}


	

	public bling queryId(int id) {
		bling b=null;
        Connection conn=DbConnection.getDB();
        String sql="select * from bling where id=?";
       try {
           PreparedStatement ps=conn.prepareStatement(sql);
           ps.setInt(1, id);
           
           ResultSet rs=ps.executeQuery();
           if(rs.next())
           {
               
        	   b=new bling();
               b.setId(rs.getInt("id"));
               b.setName(rs.getString("name"));
               b.setCl(rs.getInt("cl"));
               b.setAc(rs.getInt("ac"));
               b.setPe(rs.getInt("pe"));
               b.setSum(rs.getInt("sum"));
           }
       } catch (SQLException ex) {
           Logger.getLogger(implBling.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        return b;
		
	}

	public void Update(bling b) {
		Connection conn=DbConnection.getDB();
	       String sql="update bling set name=?,cl=?,ac=?,pe=?,sum=? where id=?";
	       
	        try {
	            PreparedStatement ps=conn.prepareStatement(sql);
	            ps.setString(1, b.getName());
	            ps.setInt(2, b.getCl());
	            ps.setInt(3, b.getAc());
	            ps.setInt(4, b.getPe());
	            ps.setInt(5, b.getSum());
	            ps.setInt(6, b.getId());
	            
	            ps.executeUpdate();
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(implBling.class.getName()).log(Level.SEVERE, null, ex);
	        }
		
	}

	@Override
	public void delete(int id) {
		Connection conn=DbConnection.getDB();
	      String sql="delete from liuruirui.bling where id=?";//sql先測試成功
	        try {
	            PreparedStatement ps=conn.prepareStatement(sql);
	            ps.setInt(1, id);
	            ps.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(implBling.class.getName()).log(Level.SEVERE, null, ex);
	        }
		
	}

	

	
	
		
	
	
	
}
