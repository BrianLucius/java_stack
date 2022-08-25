package net.brianlucius.feelz.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.brianlucius.feelz.models.Feelz;

@Repository
public interface FeelzRepository extends CrudRepository<Feelz, Long> {

	
	@Query(value="SELECT emotion, count(1) AS count FROM feelz WHERE create_date >= NOW() - INTERVAL 1 DAY GROUP BY emotion", nativeQuery=true)
	List<Map<String, Integer>> trendingEmotions();
	
	List<BrowserLocation> findDistinctByBrowserLocationNotNull();
		
}
