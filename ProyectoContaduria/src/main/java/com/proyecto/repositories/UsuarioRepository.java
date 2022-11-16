package com.proyecto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entity.Enlace;
import com.proyecto.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	//select* form tb_usuario where login='ana'
	@Query("select u from Usuario u where u.login=?1")
	public Usuario iniciarSesion(String vLoguin);
	
	//select e.idenlace,e.descripcion,e.ruta from tb_enlace e
	//join tb_rol_enlace re on re.idenlace=e.idenlace where re.idrol=2
	@Query("select e from RolEnlace re join re.enlace e where re.rol.codigo=?1")
	public List<Enlace> traerEnlacesDelUsuario(int codRol);
}
