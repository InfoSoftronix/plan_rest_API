package in.softronix.service;

import java.util.List;
import java.util.Map;

import in.softronix.entity.Plan_Master;

public interface PlanService {
	
	public Map<Integer,String> getPlanCategory();
	
	public boolean savePlan(Plan_Master plan);
	
	public List<Plan_Master> getAllPlan();
	
	public Plan_Master getPlanById(Integer  plan_id);
	
	public boolean updatePlan(Plan_Master plan);
	
	public boolean deletePlanById(Integer  plan_id);
	
	public boolean planStatus(Integer plan_id,String status);
	
	
	

}
