package com.execute.my;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.VoteInfoDAO;


public class Execute_ResultVote implements Execute_Impl{

	public void Execute(HttpServletRequest request, 
	          HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		VoteInfoDAO tidao = null;
		String img_name = request.getParameter("img_name");
		String result = request.getParameter("result");
		tidao = new VoteInfoDAO();
		tidao.resultUpdate(img_name, result);////////////
	}
}
