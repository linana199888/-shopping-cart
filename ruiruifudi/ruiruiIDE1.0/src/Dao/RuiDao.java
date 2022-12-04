package Dao;

import java.util.List;
import Model.bling;



public interface RuiDao {
	//Create新增
	   void add(String name,int cl,int ac,int pe,boolean not); 

	//Read查詢   一個大data抓出來
	   String query1();
	   List<bling> query2();
	   List<bling> querySum2(int start,int end);
	   bling queryId(int id);
	   
	//Update修改
	   void Update(bling b);
	   
	//Delete刪除
	   void delete(int id);


	
}
