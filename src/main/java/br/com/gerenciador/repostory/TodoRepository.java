package br.com.gerenciador.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.gerenciador.domain.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{

	@Query("SELECT obj FROM Todo obj WHERE obj.finalizado = false ORDER BY obj.dataParaFinalizar ASC")
	List<Todo> findAllOpen();

	@Query("SELECT obj FROM Todo obj WHERE obj.finalizado = true ORDER BY obj.dataParaFinalizar ASC")
	List<Todo> findAllClose();

}