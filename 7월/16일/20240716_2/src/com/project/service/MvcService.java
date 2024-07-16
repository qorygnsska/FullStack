package com.project.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.project.dao.MvcDAO;
import com.project.dto.MvcDTO;
import com.project.mybatis.MySqlSession;

public class MvcService {
	
	private static MvcService instance = new MvcService();

    private MvcService() {}

    public static MvcService getInstance() {
        return instance;
    }
    
    private MvcDAO dao = MvcDAO.getInstance();

	public ArrayList<MvcDTO> selectAll() {
		
		SqlSession mapper = MySqlSession.getSqlSession();
		
		return dao.selectAll(mapper);
		
	}
}
