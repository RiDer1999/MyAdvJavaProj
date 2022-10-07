package com.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.mysql.jdbc.ResultSet;

public class EmpDao {
	
	
	public static Connection getConnection() {
		Connection con1=null;
		try {
			Class.forName("com.mysql.jc.jdbc.Driver");
			con1=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
			
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		return con1;
	}
	
	public static int save(emp e1) {
		int status=0;
		try {
			Connection con1=EmpDao.getConnection();
			PreparedStatement ps1=(PreparedStatement) con1.prepareStatement("insert into employee (id,uname,email,PASSWORD,country) values (?,?,?,?,?)");
			ps1.setInt(1, e1.getId());
			ps1.setString(2, e1.getUname());
			ps1.setString(3,e1.getEmail());
			ps1.setString(4, e1.getPASSWORD());
			ps1.setString(5, e1.getCountry());
			
			status=ps1.executeUpdate();
			con1.close();
			
		}
		catch(Exception ex1)
		
		{
			ex1.printStackTrace();
		}
		return status;
	}


public static ArrayList<emp> getAllEmployee() throws SQLException
{
	 
	 Connection con1=EmpDao.getConnection();  
	 PreparedStatement ps1=(PreparedStatement) con1.prepareStatement("select * from employee");
	 ArrayList <emp>list1= new ArrayList<emp>();
	 
	 ResultSet rs = (ResultSet) ps1.executeQuery();
	 while(rs.next())
	 {
		 emp e1 = new emp();
		 
		 e1.setId(rs.getInt(1));
		 e1.setUname(rs.getString(2));
		 e1.setEmail(rs.getString(3));
		 e1.setPASSWORD(rs.getString(4));
		 e1.setCountry(rs.getString(5));
		 
		 list1.add(e1);
		 
	 }
	 con1.close();
	  
	 
	 return list1;
}

public static emp getEmployeeById(int id){  

	emp e=new emp();  

   try{  
       Connection con1 =EmpDao.getConnection();  
       PreparedStatement ps=(PreparedStatement) con1.prepareStatement("select * from employee where id=?");  
       ps.setInt(1,id);  
       ResultSet rs=(ResultSet) ps.executeQuery();  
       if(rs.next()){  
           e.setId(rs.getInt(1));  
           e.setUname(rs.getString(2));  
           e.setEmail(rs.getString(3));  
           e.setPASSWORD(rs.getString(4));  
           e.setCountry(rs.getString(5));  
       }  
       con1.close();  
   }catch(Exception ex){ex.printStackTrace();}  
     
   return e;  
}  

public static int update(emp e){  
    int status=0;  
    try{  
        Connection con=EmpDao.getConnection();  
        PreparedStatement ps=(PreparedStatement) con.prepareStatement("update employee set uname=?,PASSWORD=?,email=?,country=? where id=?");  
          
        ps.setString(1,e.getUname());  
        ps.setString(2,e.getPASSWORD());  
        ps.setString(3,e.getEmail()); 
        ps.setString(4,e.getCountry()); 
        
        ps.setInt(5,e.getId());  
          
        status=ps.executeUpdate();  
          
        con.close();  
    }catch(Exception ex){ex.printStackTrace();}  
      
    return status;  
}  
public static int delete(int id){  
    int status=0;  
    try{  
        Connection con=EmpDao.getConnection();  
        PreparedStatement ps=(PreparedStatement) con.prepareStatement("delete from employee where id=?");  
        ps.setInt(1,id);  
        status=ps.executeUpdate();  
          
        con.close();  
    }catch(Exception e){e.printStackTrace();}  
      
    return status;  
}  


}

