package in.softronix.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.softronix.entity.Plan_Master;
import in.softronix.service.PlanService;

@RestController
public class PlanController {
	
	@Autowired
	PlanService service;
	
	@GetMapping("/category")
	public ResponseEntity<Map<Integer,String>>  planCategory()
	{
		Map<Integer, String> category = service.getPlanCategory();
		
		return new ResponseEntity<>(category,HttpStatus.OK);
	}

	
	@PostMapping("/plans")
	public ResponseEntity<String> planSaves(@RequestBody Plan_Master plan)
	{
		String responseMassage="";
		boolean isSave= service.savePlan(plan);
		
		if(isSave)
		{
			responseMassage="Plan Save Successfully";
		}
		else
		{
			responseMassage="Plan Save failuer";
		}
		
		return new ResponseEntity<>(responseMassage,HttpStatus.CREATED);
		
	}
	
	@GetMapping("allplans")
	public ResponseEntity<List<Plan_Master>> getAllPlans()
	{
		List<Plan_Master> allPlan = service.getAllPlan();
		
		return new ResponseEntity<>(allPlan,HttpStatus.OK);
		
	}
	
	@GetMapping("plan/{plan_id}")
	public ResponseEntity<Plan_Master> editPlan(@PathVariable Integer plan_id)
	{
		Plan_Master plan = service.getPlanById(plan_id);
		
		return new ResponseEntity<>(plan,HttpStatus.OK);
		
	}
	
	@PutMapping("plan")
	public ResponseEntity<String> updatePlan(Plan_Master plan)
	{
		 String responseMassage="";
		 
		 boolean isUpdate = service.updatePlan(plan);
		 if(isUpdate)
		 {
			 responseMassage="Update Successfully";
		 }
		 else
		 {
			 responseMassage="Update Failuer...";
		 }
		 
		 return new ResponseEntity<>(responseMassage,HttpStatus.OK);
		 
	}
	
	@GetMapping("delete/{plan_id}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer plan_id)
	{
	 boolean deletePlanById = service.deletePlanById(plan_id);
	 
	 String responseMassage="";
	 
	 if( deletePlanById )
	 {
		 responseMassage="Update Successfully";
	 }
	 else
	 {
		 responseMassage="Update Failuer...";
	 }
		return new ResponseEntity<>(responseMassage,HttpStatus.OK);
		
	}
	
	@GetMapping("status")
	public ResponseEntity<String> changeStatus(String status,Integer plan_id)
	{
	 boolean planStatus = service.planStatus(plan_id, status);
	 String responseMassage="";
	 if( planStatus )
	 {
		 responseMassage="Plan Status Change Successfully Successfully";
	 }
	 else
	 {
		 responseMassage="Plan Status Change Failuer...";
	 }
		return new ResponseEntity<>(responseMassage,HttpStatus.OK);
	}
}
