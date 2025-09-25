package in.softronix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.softronix.entity.Plan_Master;

public interface PlanRepository extends JpaRepository<Plan_Master, Integer> {

}
