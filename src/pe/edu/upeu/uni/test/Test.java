package pe.edu.upeu.uni.test;

import com.google.gson.Gson;

import pe.edu.upeu.uni.dao.AlumnoDao;
import pe.edu.upeu.uni.dao.EscuelaDao;
import pe.edu.upeu.uni.daoImp.AlumnoDaoImp;
import pe.edu.upeu.uni.daoImp.EscuelaDaoImp;
import pe.edu.upeu.uni.entity.Alumno;
import pe.edu.upeu.uni.util.Conexion;


public class Test {
	private static AlumnoDao pd = new AlumnoDaoImp();
	private static EscuelaDao es = new EscuelaDaoImp();
	private static Gson g = new Gson();
public static void main(String[] args) {
	conex();
	listarP();
	ListaC();
}

static void conex() {
	if(Conexion.getConexion() != null) {
		System.out.println("Conectado :D");
	}else {
		System.out.println("Desconectado");
	}
	
	
}

static void listarP() {
	  System.out.println(g.toJson(pd.readAll()));
}


static void ListaC() {
	 System.out.println(g.toJson(es.ReadAll()));
	
}


}
