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
 * Servlet implementation class AddDataTable
 */
@WebServlet("/add")
public class AddDataTable extends HttpServlet {
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
			  String stuId =request.getParameter("stuId");
			  String name =request.getParameter("name");
			  String sex =request.getParameter("sex");
			  Double score=Double.parseDouble(request.getParameter("score"));
			  String sql="insert into student01(stuId,name,sex,score)values(?,?,?,?)";
			  PreparedStatement prep =conn.prepareStatement(sql);
			  prep.setString(1,stuId);
			  prep.setString(2, name);
			  prep.setString(3, sex);
			  prep.setDouble(4,score);
			  prep.executeUpdate();
			  out.print("添加成功");
			  
		}catch(Exception e){
			e.printStackTrace();
			out.print("添加失败");
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
