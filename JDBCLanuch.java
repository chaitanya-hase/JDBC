package com.jdbcTrial;
import java.sql.*;
public class JDBCLanuch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//load and register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//establish connection
		String url="jdbc:mysql://localhost:3306/testdb";
		String user="root";
		String password="root123";
		Connection con=DriverManager.getConnection(url,user,password);
		
		//create statement
		Statement stm=con.createStatement();
		
		int count=stm.executeUpdate("insert into StudentInfo(id,sname,salary) values(4,'sita',10000000000)");
		
		//result processing
		System.out.println(count + " row inserted.");
		ResultSet rs=stm.executeQuery("Select * from Studentinfo");
		
		while(rs.next()) {
			System.out.println(rs.getInt("id")+" "+rs.getString("sname")+" "+rs.getDouble("salary"));
		}
		//close
		rs.close();
		stm.close();
		con.close();

	}

}
