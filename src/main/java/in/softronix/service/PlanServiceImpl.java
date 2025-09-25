package in.softronix.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.softronix.entity.Plan_Category;
import in.softronix.entity.Plan_Master;
import in.softronix.repository.PlanCategoryRepository;
import in.softronix.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService {
	
	@Autowired
	PlanCategoryRepository pcr;
	
	@Autowired
	PlanRepository pr;
	

	@Override
	public Map<Integer, String> getPlanCategory() {
		
		List<Plan_Category> all = pcr.findAll(); // 1 Gold
		
		Map<Integer,String> m=new HashMap<>();//put(integer,String) {}
		
		all.forEach(category->{m.put(category.getPlan_category_id(),category.getPlan_category_name());});
		
		return m;
	}

	@Override
	public boolean savePlan(Plan_Master plan) {
		
		Plan_Master save = pr.save(plan);
		
		return save.getPlan_id()!=null; 
	}

	@Override
	public List<Plan_Master> getAllPlan() {
		
		
		return pr.findAll();
		
	}

	@Override
	public Plan_Master getPlanById(Integer plan_id) {
		
		Optional<Plan_Master> id = pr.findById(plan_id);
		
		if(id.isPresent())
		{
			return id.get();
		}
		else {
			return null;
		}
		
		
	}

	@Override
	public boolean updatePlan(Plan_Master plan) {
		
		return pr.save(plan)!=null;
	}

	@Override
	public boolean deletePlanById(Integer plan_id) {//101
		
		boolean status =false;
		try {
			pr.deleteById(plan_id);
			status=true;
			
		} catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public boolean planStatus(Integer plan_id, String status) {//101  , no
		
		Optional<Plan_Master> id = pr.findById(plan_id); //101 name  yes
		
		if(id.isPresent())
		{
			Plan_Master plan = id.get();
			plan.setActive_switch(status);
			pr.save(plan);
		}
			
		return false;
	}

}
