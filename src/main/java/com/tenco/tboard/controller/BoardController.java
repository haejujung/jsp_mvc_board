package com.tenco.tboard.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
    }
    
    @Override
    public void init() throws ServletException {
    	// BoardRepository 추가 예정
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		// TODO 인증 처리 추후 추가
		
		switch (action) {
		case "/create":
			//게시글 생성 페이지 이동 처리
			
			break;
		case "/list":
			handleListBoards(request, response);
			break;

		default:
			break;
		}
	}
	/**
	 * 페이징 처리 하기
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	
	private void handleListBoards(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("게시글 리스트 보이니?");
		
		
		// 게시글 목록 조회 기능
		int page = 1; // 기본 페이지 번호
		int pageSize = 3; // 한 페이지당 보여질 게시글에 수
	
		try {
			String pageStr = request.getParameter("page");
			if(pageStr != null) {
				page = Integer.parseInt(pageStr);
			}
		} catch (Exception e) {
			// TODO: handle exception
			page = 1;
		}
		// pageSize --> 3이다
		// page 1, page 2, page 
		
		int offset = (page - 1) * pageSize;
		
		System.out.println("page : " + page);
		System.out.println("offset : " + offset);
		
		
		
		request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
