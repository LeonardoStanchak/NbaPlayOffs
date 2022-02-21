package br.com.Nba.Playoffs.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Nba.Playoffs.Model.NbaPlayOffsModel;

public interface NbaPlayOffsRepository extends JpaRepository<NbaPlayOffsModel, Long>{

	Page<NbaPlayOffsModel> findByNbatime(String nbatime, Pageable paginacao);

}
