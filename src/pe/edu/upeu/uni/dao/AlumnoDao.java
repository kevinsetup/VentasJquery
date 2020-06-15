package pe.edu.upeu.uni.dao;

import java.util.Map;

import java.util.List;
import pe.edu.upeu.uni.entity.Alumno;

public interface AlumnoDao {

	public int create(Alumno u);
	public int update(Alumno u);
	public int delete(int id);
	public List<Map<String,Object>> read(int id);
	public List<Map<String,Object>> readAll();

	
}
