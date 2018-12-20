package com.zzu.StuManage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.zzu.StuManage.entity.Announcement;
import com.zzu.StuManage.util.DBUtil;

public class AnnoDao {
	
	/**		
	 * 返回公告列表
	 */
	public List<Announcement> AnnouncementsInfoUtil(){				
		List<Announcement> AnnouncementList = new ArrayList<Announcement>();
		QueryRunner qr = new QueryRunner(DBUtil.getDS());
		String sql = "select ano,atitle,adate from announcement";
		try {
			AnnouncementList = qr.query(sql,new ResultSetHandler<List<Announcement>>(){
				public List<Announcement> handle(ResultSet rs) throws SQLException{
					List<Announcement> AnnouncementList = new ArrayList<Announcement>();
					Announcement anno = null;
					while(rs.next()){
						anno = new Announcement();
						anno.setAno(rs.getString("ano"));
						anno.setAtitle(rs.getString("atitle"));
						anno.setAdate(rs.getString("adate"));
						AnnouncementList.add(anno);
					}
					return AnnouncementList;
				}
			});		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return AnnouncementList;
	}	
	
	/**
	 * 返回单个通知信息
	 */
	public Announcement AnnouncementInfo(String ano){				
		Announcement Announcement = new Announcement();
		QueryRunner qr = new QueryRunner(DBUtil.getDS());
		String sql = "select * from announcement where ano="+ano+"";
		try {
			Announcement = qr.query(sql,new ResultSetHandler<Announcement>(){
				public Announcement handle(ResultSet rs) throws SQLException{
					Announcement anno = null;
					if(rs.next()){
						anno = new Announcement();	
						anno.setAno(rs.getString("ano"));
						anno.setAtitle(rs.getString("atitle"));
						anno.setAdate(rs.getString("adate"));
						anno.setAmessage(rs.getString("amessage"));
					}
					return anno;
				}
			});	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return Announcement;
	}
	
	//添加公告
	public int addAnno(Object[] params)  {
		QueryRunner qr = new QueryRunner(DBUtil.getDS());
		int rows = 0;
		String sql = "insert into announcement(ano,atitle,adate,amessage)values(?,?,?,?)";
		try {
			rows = qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
	
	//删除公告
	public int deleteAnno(String ano)  {
		QueryRunner qr = new QueryRunner(DBUtil.getDS());
		int rows = 0;
		String sql = "delete from  announcement where ano = "+ano+"";
		try {
			rows = qr.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
	
	//修改公告
	public int updateAnno(Object[] params)  {
		QueryRunner qr = new QueryRunner(DBUtil.getDS());
		int rows = 0;
		String sql = "update announcement set atitle=?,amessage=? where ano=?";
		try {
			rows = qr.update(sql,params);
			System.out.println("rows="+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
	
}
