package Model;

public class bling {
	//個資
    private String name;
    private Integer id;
    
    //產品    
    private int cl;//clothing服裝
    private int ac;//accessories飾品
    private int pe;//perfume香水
    
    //金額
    private int sum;
  
    //沒有會員
    private  boolean not;
    
    //找零
    private int total;//應付
    private int pay;//實付
    //private int tototal=pay-total;//應付-實付
 
    
    public bling() {
		super();
	}

	//建構式
    public bling(String name, int cl, int ac, int pe,boolean not) 
        {
            this.name = name;
            this.cl = cl;
            this.ac = ac;
            this.pe = pe;
            this.not=not;
            //this.sum=cl+ac+pe;
            //this.sum1=(int) ((cl+ac+pe)*0.95);
            
        if(not)
            {
            sum=cl*590+ac*200+pe*650;  
            } 
        else 
            {
        	sum=cl*590+ac*200+pe*650;
            sum=(int) (sum*0.95);   
            }   
    }
    
    public int aaa()
    {
    	 if(not)
         {
         sum=cl*590+ac*200+pe*650;  
         } 
     else 
         {
     	sum=cl*590+ac*200+pe*650;
         sum=(int) (sum*0.95);   
         }   
        return sum;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCl() {
        return cl;
    }

    public void setCl(int cl) {
        this.cl = cl;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public int getPe() {
        return pe;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }

    public int getSum() {
    	
        return aaa();
    }
    
    public void setSum(Integer sum) {
        this.sum = sum;
    }
  

    public String show()
    {
    if(not)
    return "名字:"+getName()+
                "\n服飾:"+getCl()+"套*590"+
                "\n飾品:"+getAc()+"件*200"+
                "\n香水:"+getPe()+"支*650"+
                "\n總金額:"+getSum()+"台幣"+
                "\n========================="+"\n會員已享95折";
    else
    return "名字:"+getName()+
                "\n服飾:"+getCl()+"套*590"+
                "\n飾品:"+getAc()+"件*200"+
                "\n香水:"+getPe()+"支*650"+
                "\n總金額:"+getSum()+"台幣"+
                "\n=========================\n不是會員沒有優惠";
    }
     

    public String show1(int total,int pay){
        this.total=total;
        this.pay=pay;
 
           int tototal=pay-total;
           int t=total/1000;
           int fii=(total%1000)/500;
           int o=(total%500)/100;
           int fi=(total%100)/50;
           int ten=(total%50)/10;
           int five=(total%10)/5;
           int one=(total%5)/1;
        
        if(pay-total>=0)//總錢-應付>=0
            if (tototal>=0){
                return "一千元:\t"+t+"張"+
                   "\t五百元:"+fii+"張"+
                   "\t一百元"+o+"張"+
                   "\t五十元:"+fi+"個"+
                   "\t十元:"+ten+"個"+
                   "\t五元:"+five+"個"+
                   "\t一元:"+one+"個";}

            else{//總錢-應付<0
                 return "金額錯誤";}
        
        	else{
                 return "金額錯誤";}   
    }   
    
    public String show3()
     {
    	return ("\n"+getSum());
     } 
    
    
}

