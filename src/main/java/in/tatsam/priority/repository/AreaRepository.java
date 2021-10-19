package in.tatsam.priority.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.tatsam.priority.model.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
	List<Area> findAll();
}
