package case01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListStu
 */
@WebServlet("/liststu")
public class ListStu extends HttpServlet {
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
			  System.out.println("数据库连接成功!");
			 
			  String sql="select id,stuId,name,sex,score from student01";
			  PreparedStatement prep=conn.prepareStatement(sql);
			  ResultSet rst=prep.executeQuery();
			  out.print("<table border=1>");
			  out.print("<tr><td>id</td><td>stuId</td><td>name</td><td>sex</td><td>score</td><td>操作</td></tr>");
			  
			  while(rst.next()) {
				int id=rst.getInt(1);
				String stuId=rst.getString("stuId");
				String name=rst.getString("name");
				String sex=rst.getString("sex");
//				out.print("<p><a href='del?id=3'>del</p>");
//				out.print("hello");
//			  }
				Double score=rst.getDouble("score");
				out.print("<tr><form action='modi' method=post>"
						+"<td><input type='text' name='id' size='3' disable=false value='"+id+"'></td>"
						+"<td><input type='text' name='stuId' size='6' value='"+stuId+"'></td>" 
						+"<td><input type='text' name='name' size='3' value='"+name+"'></td>" 
						+"<td><input type='text' name='sex' size='1' value='"+sex+"'></td>" 
						+"<td><input type='text' name='score' size='3' value='"+score+"'></td>" 
						+"<td><input type='submit' value='修改' >&nbsp;"
						+"<a href='del?id="+id+"'>删除</a></td>"
						+"</form></tr>");
			  }
			  out.print("</table>");
		}
		catch(Exception e) {
			e.printStackTrace();
			out.println("访问失败");
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
