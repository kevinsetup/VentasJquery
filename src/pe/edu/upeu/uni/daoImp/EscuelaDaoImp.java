package pe.edu.upeu.uni.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;


import pe.edu.upeu.uni.dao.EscuelaDao;
import pe.edu.upeu.uni.entity.Escuela;
import pe.edu.upeu.uni.util.Conexion;

public class EscuelaDaoImp implements EscuelaDao {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	@Override
	public int create(Escuela u) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int update(Escuela u) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Escuela read(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List <Escuela> ReadAll() {
		
		List<Escuela> list = new ArrayList<>();
		String sql = "select * from escuela";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Escuela a = new Escuela();
				a.setIdescuela(rs.getInt("idescuela"));
				a.setNombrecat(rs.getString("nombrecat"));
				list.add(a);
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
		
	}
	
	
	
}
