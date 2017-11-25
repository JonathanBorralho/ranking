package com.ranking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranking.model.Posto;

public interface PostoRepository extends JpaRepository<Posto, Long> {
	public List<Posto> findAllByOrderByPrecoGasolinaAsc();
}
