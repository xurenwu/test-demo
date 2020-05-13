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
 * Servlet implementation class DelList
 */
@WebServlet("/del")
public class DelList extends HttpServlet {
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
			  int id =Integer.parseInt(request.getParameter("id"));
			  String sql="delete from student01 where id=?";
			  PreparedStatement prep=conn.prepareStatement(sql);
			  prep.setInt(1, id);
			  prep.executeUpdate();
			  response.sendRedirect("liststu");//重定位
		}catch(Exception e) {
			e.printStackTrace();
			out.print("删除失败！");
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
