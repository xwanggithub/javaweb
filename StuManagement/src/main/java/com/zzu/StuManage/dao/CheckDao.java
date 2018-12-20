package com.zzu.StuManage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.zzu.StuManage.util.DBUtil;


public class CheckDao {
	//返回用户名
	public String checkUtil(String sql)  {
		QueryRunner qr =new QueryRunner(DBUtil.getDS());
		String userName = null;			
			try {
				userName = qr.query(sql, new ResultSetHandler<String>(){
					public String handle(ResultSet rs) throws SQLException{
						String userName = null;
						if(rs.next()){								
							userName = rs.getString("username");
						}
						return userName;
					}
				});
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return userName;
	}
	
	//检查用户
	public String checkUser(String userId,String password) {
		String sql = "select username from users where userid="+userId+"and password="+password+"";
		return this.checkUtil(sql);
	}
	//检查管理员
	public String checkAdmin(String userId,String password){
		String sql = "select username from admins where userid="+userId+"and password="+password+"";
		return this.checkUtil(sql);
	}
	//检查是否有该用户
	public String checkus(String userId) {
		String sql = "select username from users where userid="+userId+"";
		return this.checkUtil(sql);
	}

}
