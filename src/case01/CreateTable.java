package case01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class CreateTable
 */
@WebServlet("/create")
public class CreateTable extends HttpServlet {
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
//			  out.print("�������سɹ�");   
			  String url = "jdbc:mysql://localhost:3306/mydata";
			  String user = "root";
			  String pw = "root";
			  Connection conn = DriverManager.getConnection(url,user,pw);
			  System.out.println("���ݿ����ӳɹ�!");
			  //����һ�ű�
			  Statement stmt = conn.createStatement();
			  String student1=request.getParameter("student1");
			  System.out.println("hello");
			  String sql = "create table "+student1+"(id int primary key auto_increment,"
			  		+ "stuId varchar(12),name varchar(8),sex varchar(2),score double)";
			  stmt.execute(sql);
			  out.println("�����ɹ���");
			}
		
		/*
		 * // catch(Exception e){ // e.printStackTrace(); // out.print("��������ʧ��"); // }*/
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print("����ʧ��");
//			System.out.println("���ݿ�����ʧ��!");
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
