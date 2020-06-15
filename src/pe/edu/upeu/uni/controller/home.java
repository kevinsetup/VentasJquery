package pe.edu.upeu.uni.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.uni.dao.AlumnoDao;
import pe.edu.upeu.uni.dao.EscuelaDao;
import pe.edu.upeu.uni.daoImp.AlumnoDaoImp;
import pe.edu.upeu.uni.daoImp.EscuelaDaoImp;
import pe.edu.upeu.uni.entity.Alumno;
import pe.edu.upeu.uni.entity.Escuela;



/**
 * Servlet implementation class home
 */
@WebServlet("/home")
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlumnoDao alu = new AlumnoDaoImp();
	private EscuelaDao esc = new EscuelaDaoImp();
	private Gson g = new Gson();   	
	int idAlumno,idEscuela; String apelnombres,correo,telefono;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int op = Integer.parseInt(request.getParameter("opc"));
		switch(op) {
		case 1: //listar escuelas
				out.println(g.toJson(esc.ReadAll()));
				break;
		case 2: //Listar alumno
				out.println(g.toJson(alu.readAll()));
			    break;
		case 3: //registrar alumno
			
				alu.create(new Alumno(0,
				Integer.parseInt(request.getParameter("esc")),
				request.getParameter("apell"),
				request.getParameter("correo"),
				request.getParameter("tele")));
		        out.println(g.toJson("Registro guardado correctamente"));  
		    break;         
		case 4:
			out.println(g.toJson(alu.read(Integer.parseInt(request.getParameter("id")))));		
		break;
		case 5:
			int x = alu.delete(Integer.parseInt(request.getParameter("id")));
			out.println(g.toJson(x));
			
			break; 
		case 6:
			idAlumno = Integer.parseInt(request.getParameter("idp"));
			idEscuela = Integer.parseInt(request.getParameter("idEscuela"));
			apelnombres = request.getParameter("apell");
			correo = request.getParameter("correo");				
			telefono = request.getParameter("tele");				
			out.println(g.toJson(alu.update(new Alumno(idAlumno, idEscuela, apelnombres, correo, telefono))));	
			break;
	
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
