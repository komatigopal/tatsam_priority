package in.tatsam.priority.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.tatsam.priority.model.Priority;
import in.tatsam.priority.model.PriorityId;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, PriorityId> {
}
