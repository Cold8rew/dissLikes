package com.controller.my;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.execute.my.Execute_Impl;
import com.execute.my.Execute_ResultVote;
import com.execute.my.Execute_getVote;
import com.execute.my.Execute_Survey;
import com.execute.my.Execute_getLastVote;

import DAO.InprogressDAO;
import DAO.MemberDAO;
import DAO.TelInfoDAO;
import VO.CustomInfoVO;
import VO.InprogressVO;
import VO.MemberVO;



/**
 * Servlet implementation class Votecontroller
 */
@WebServlet("*.do")
@MultipartConfig(fileSizeThreshold = 1024*1024, maxFileSize = 1024*1024*50, maxRequestSize = 1024*1024*50*5)
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	String vt_id = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controller() {
        super();
        // TODO Auto-generated constructor stub
    }
  //포워드 메소드
  	protected void forward(HttpServletRequest request, HttpServletResponse response, String url)
  			throws ServletException, IOException {
  		RequestDispatcher rd = request.getRequestDispatcher(url);
  		rd.forward(request, response); 	
  	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println(request.getRequestURI());	
		System.out.println(request.getContextPath());
		
		String c =request.getRequestURI().substring
                     (request.getContextPath().length());
		System.out.println(c);
		
		String str = null;  
		Execute_Impl e1 = null;
		//호준.
		switch(c) {
		//jh
		case "/Sign-In.do":
			str = "Login/Sign-In.jsp";
			break;
			
		case "/password-find1.do":
			str = "Login/password-find1.jsp";
			break;
			
		case "/Sign-Up.do":
			str = "Login/Sign-Up.jsp";
			break;
			
		case "/like.do":
	    	str = "After_Click/Main.jsp";
	    	break;
	    	
	    case "/disslike.do":
	    	str = "After_Click/Main.jsp";
	    	break;
	    	
	    case "/Main.do":
			e1 = new Execute_getVote();
			try {  
				e1.Execute(request, response); 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			str = "Main/Main.jsp";
			
			e1 = new Execute_getLastVote();
            try {  
               e1.Execute(request, response); 
            } catch (Exception e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
            str = "Main/Main.jsp";
            break;
            
		    case "/Result.do":
				e1 = new Execute_ResultVote();
				try {  
					e1.Execute(request, response); 
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String img_name = request.getParameter("img_name");
				request.setAttribute("img_name", img_name);
				
				str = "/After_Click/InProgress_Survey.jsp";
				break;
				
			//수진.
		    case "/Search_vt_id.do":
		    	e1 = new Execute_Survey();
				try {  
					e1.Execute(request, response); 
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				str = "/After_Click/InProgress_Survey.jsp";
				break;
				
		    case "/Close_One.do" :
		    	Execute_Impl surveyImpl= new Execute_Survey();
				try {
					surveyImpl.Execute(request, response);
				} catch (Exception e) {
					// TODO Auto-generated  catch block
					e.printStackTrace();
				}
				
				str = "/Closed_Survey/html/closed_survey.jsp";
				
				break;
				
			//혜연.
		    case "/allList.do" :	
				TelInfoDAO tidao1 = null;
				
				try {
					tidao1 = new TelInfoDAO();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				
				ArrayList<InprogressVO> alist1 = null;	
				
				try {
					alist1 = tidao1.getAllList();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				int count = alist1.size();
				request.setAttribute("alist1", alist1);
				request.setAttribute("count", count);
				request.setAttribute("ing", 1);
				
				str = "/Vote_List/list_main.jsp";
				break;
				
		    case "/getAllCloseList.do" :	
				TelInfoDAO tidao2 = null;
				
				try {
					tidao2 = new TelInfoDAO();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				
				ArrayList<InprogressVO> alist2 = null;	
				
				try {
					alist2 = tidao2.getAllCloseList();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				int count2 = alist2.size();

				request.setAttribute("alist1", alist2);
				request.setAttribute("count", count2);
				request.setAttribute("ing", 0);
				
				str = "/Vote_List/list_main.jsp";
				break;
				
			//성락
			case "/new-Vote.do":
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		        Calendar c1 = Calendar.getInstance();
		        request.setAttribute("st_date", sdf.format(c1.getTime()));
		        
				str = "/New_Vote/new-Vote.jsp";
				break;
			}
		
	RequestDispatcher rd1 = request.getRequestDispatcher(str);
	rd1.forward(request, response);	//요청,응답을 가져감
	}// do-get-end
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      request.setCharacterEncoding("UTF-8");//POST 방식의 한글처리
	      response.setCharacterEncoding("UTF-8");
	      HttpSession session = request.getSession();

	      MemberDAO dao = null;
	      TelInfoDAO dao1 = null;
	      try {
	         dao = new MemberDAO();
	      } catch (ClassNotFoundException | SQLException e) {
	         e.printStackTrace();
	      }
	      String cp = request.getContextPath();
	      String uri = request.getRequestURI();
	      MemberVO mv = null;
	      String url;
	      //------------------------업로드---------------------------
	      if(uri.indexOf("/new-vote-upload.do")!=-1){
	         UploadUtil uploadUtil = UploadUtil.create(request.getServletContext());
	         Part part = request.getPart("vt_img_name"); //List<Part> parts = (List<Part>)
	         request.getParts();
	         String fileName = uploadUtil.saveFiles(part, "", uploadUtil.createFilePath());
	         
	         try {
	            dao1 = new TelInfoDAO();
	         } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	         String vt_id = (String) session.getAttribute("nick"); //
	         String vt_name = request.getParameter("vt_name"); // 투표이름
	         String vt_img_name = fileName; // 이미지이름
	         String vt_img_path = "Img_Data/" + fileName;
	         String vt_stdate = request.getParameter("vt_stdate"); // 시작일
	         String vt_enddate = request.getParameter("vt_enddate"); //종료일
	         String vt_type = request.getParameter("vt_type");// 카테고리
	         String vt_dtype = request.getParameter("vt_dtype");// 세부카테고리
	         dao1.insertDB(vt_id, vt_name, vt_img_name, vt_img_path, vt_stdate, vt_enddate, vt_type, vt_dtype);
	         System.out.println("업로드 확인용2");
	         url = cp + "/Main/Main.jsp";
	         response.sendRedirect(url);
	      }
	      //회원가입시----------------------------------------------------
	      if(uri.indexOf("Sign-Up.do")!=-1){
	         
	         //회원가입에 성공하면 MemberInsert(mv)메서드 실행..
	         String email = request.getParameter("email");
	         String password = request.getParameter("password");
	         String password2 = request.getParameter("password2");
	         String reg_pwd = "^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$";
	         Matcher matcher = Pattern.compile(reg_pwd).matcher(password); // 비밀번호확인.
	         System.out.println("비밀번호 유효성검사 : " + matcher.matches());
	         
	         mv = dao.getReadData(email);
	         
	         // 아이디 형식 확인바랍니다.   
	         if(email.indexOf("@") == -1 || email.indexOf(".com") == -1){ // 이메일의 값에서 @를 찾을수 없거나 .com을 찾을수 없다면 
	            url = "/disslikes/Sign-Up.do";
	            response.setContentType("text/html; charset=UTF-8");
	            PrintWriter writer = response.getWriter();
	            writer.println("<script>alert('아이디 형식 확인바랍니다.'); location.href='" + url + "';</script>");
	            writer.close();
	            System.out.println("아이디 형식 확인바랍니다.");
	            return;//로그인 실패시 더이상의 소스코드가 실행되지 않도록 return작성
	            
	         //비밀번호가 6자리보다 작다면.
	         }else if(!(password.length() >= 6)){ 
	            url = "/disslikes/Sign-Up.do";
	            response.setContentType("text/html; charset=UTF-8");
	            PrintWriter writer = response.getWriter();
	            writer.println("<script>alert('비밀번호가 6자리 미만입니다.'); location.href='" + url + "';</script>");
	            writer.close();
	            System.out.println("비밀번호서로다름.");
	            return;//로그인 실패시 더이상의 소스코드가 실행되지 않도록 return작성
	            
	         //비밀번호가 숫자+영문 조합이 아니라면
	         }else if(!matcher.matches()){ 
	            System.out.println("여기로 들어왔나 확인"); // 여기로 들어오지않으면 삭제하면됨.
	            url = "/disslikes/Sign-Up.do";
	            response.setContentType("text/html; charset=UTF-8");
	            PrintWriter writer = response.getWriter();
	            writer.println("<script>alert('비밀번호는 숫자+영문 6자리.'); location.href='" + url + "';</script>");
	            writer.close();
	            System.out.println("비밀번호형식");
	            return;//로그인 실패시 더이상의 소스코드가 실행되지 않도록 return작성
	         
	         // 비밀번호가 서로 다릅니다.확인바랍니다.
	         }else if(!password.equals(password2)){ //비밀번호와 비밀번호가 not equals 라면 .. 
	            url = "/disslikes/Sign-Up.do";
	            response.setContentType("text/html; charset=UTF-8");
	            PrintWriter writer = response.getWriter();
	            writer.println("<script>alert('비밀번호가 서로 다릅니다.'); location.href='" + url+ "';</script>");
	            writer.close();
	            System.out.println("비밀번호서로다름.");
	            return;//로그인 실패시 더이상의 소스코드가 실행되지 않도록 return작성
	         
	         //아이디 중복시 가입안됨. 중복된아이디 mv.getEmail() 의 값이 널값이면 비교할수없다.
	         }else if(mv.getEmail().equals(email)){ // 받은정보와 세션과 비교.
	            url = "/disslikes/Sign-Up.do";
	            response.setContentType("text/html; charset=UTF-8");
	            PrintWriter writer = response.getWriter();
	            writer.println("<script>alert('중복된 아이디'); location.href='" + url + "';</script>");
	            writer.close();
	            return;//로그인 실패시 더이상의 소스코드가 실행되지 않도록 return작성
	         }
	         //회원가입이 완료되면 인덱스페이지로 이동
	         dao.MemberInsert(email, password);
	         url = "/Login/Sign-UpOK.jsp";
	         forward(request, response, url);
	         // 로그인 시..
	      }else if(uri.indexOf("Sign-InOK.do")!=-1){ 
	         System.out.println("여기까진ok");
	         String email = request.getParameter("email");
	         String password = request.getParameter("password");
	         
	         mv = dao.getReadData(email);
	         System.out.println("로그인시 mv의 값 : " + mv.getEmail());
	         // 로그인 할때------------------------------------------------
	         //mv==null일 경우 아이디가 없음
	         //세션에 있는 pwd가 DB의 pwd와 일치하지 않는 경우
	         if(mv.getEmail().equals("아이디중복아님") ||!mv.getPassword().equals(password)){ // 받은정보와 세션과 비교.
	            url = "/disslikes/Sign-In.do";
	            response.setContentType("text/html; charset=UTF-8");
	            System.out.println("여기로 들어오는거 확인.");
	            PrintWriter writer = response.getWriter();
	            writer.println("<script>alert('이메일없거나 비밀번호 틀림.'); location.href='" + url +"';</script>");
	            writer.close();
	            System.out.println("비밀번호틀림");
	            return;//로그인 실패시 더이상의 소스코드가 실행되지 않도록 return작성
	         }
	         CustomInfoVO info = new CustomInfoVO();
	         info.setEmail(mv.getEmail());
	         System.out.println("info : " + info.getEmail());
	         
	         //자바 클래스에서는 html과는 달리 세션이 없으므로 객체를 달라고 요청을 해야함
	         session = request.getSession();
	         String nickname = info.getEmail().substring(0, info.getEmail().indexOf("@"));
	         session.setAttribute("nick", nickname);
	         System.out.println(session.getAttribute("nick"));

	         url = cp + "/Main/Main.jsp";
	         response.sendRedirect(url);
	         //비밀번호 찾기
	      }else if(uri.indexOf("passwordfind.do")!=-1){ 

	         String findemail = request.getParameter("findemail");
	         mv = dao.getReadData(findemail);

	         //mv==null일 경우 아이디가 없음 
	         if(mv.getEmail().equals("아이디중복아님")){ // mv로 받은정보가 null 값인지검사..
	            url = "/disslikes/password-find1.do";
	            response.setContentType("text/html; charset=UTF-8");
	            PrintWriter writer = response.getWriter();
	            writer.println("<script>alert('이메일 주소 확인해주세요.'); location.href='" + url + "';</script>");
	            writer.close();
	            return;//로그인 실패시 더이상의 소스코드가 실행되지 않도록 return작성
	         } //아래부턴 검색해본결과 일치할때. ------------------------------------수정필요---------------------------------
	         CustomInfoVO info = new CustomInfoVO();
	         info.setPassword(mv.getPassword()); //가져온정보를 info에 담고
	         System.out.println("info : " + info.getPassword()); // 맞는지확인.
	         session = request.getSession();
	         session.setAttribute("findpassword", info.getPassword());
	         System.out.println(session.getAttribute("nick"));

	         url = "/Login/password-find2.jsp"; // 패스워드 찾은곳으로 이동.
	         forward(request, response, url);
	      }
	   }
	}