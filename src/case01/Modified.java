package case01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Modified
 */
@WebServlet("/modi")
public class Modified extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		try{
			  Class.forName("com.mysql.jdbc.Driver");
//			  out.print("驱动加载成功");   
			  String url = "jdbc:mysql://localhost:3306/mydata";
			  String user = "root";
			  String pw = "root";
			  Connection conn = DriverManager.getConnection(url,user,pw);
			  //修改数据项
//			  out.print("hello");
			  int id=Integer.parseInt(request.getParameter("id"));
			  
//			  System.out.println("hello");
			  String stuId =request.getParameter("stuId");
			  String name =request.getParameter("name");
			  String sex =request.getParameter("sex");
			  Double score=Double.parseDouble(request.getParameter("score"));
			  //更新数据
			  String sql="update student01 set stuId=?,name=?,sex=?,score=?where id=?";
//			  out.println("hello");
//			  String sql="insert into student01(stuId,name,sex,score)values(?,?,?,?)";
			  
			  PreparedStatement prep =conn.prepareStatement(sql);
			  prep.setString(1,stuId);
			  prep.setString(2, name);
			  prep.setString(3, sex);
			  prep.setDouble(4,score);
			  prep.setInt(5, id);
			  out.print("hello");
			  prep.executeUpdate();
//			  out.print("修改成功");
			  response.sendRedirect("liststu");//重定位
			  
		}catch(Exception e){
			e.printStackTrace();
			out.print("修改失败");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
