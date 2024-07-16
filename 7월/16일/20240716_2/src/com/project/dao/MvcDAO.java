package com.project.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.project.dto.MvcDTO;

public class MvcDAO {

	 private static MvcDAO instance = new MvcDAO();
	    
	    private MvcDAO() {}

	    public static MvcDAO getInstance() {
	        return instance;
	    }

		public ArrayList<MvcDTO> selectAll(SqlSession mapper) {
			
			return (ArrayList<MvcDTO>)mapper.selectList("selectAll");
		}
}
