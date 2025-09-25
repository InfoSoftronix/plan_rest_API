package in.softronix.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Plan_Master {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PLAN_ID")
	private Integer plan_id;
	
	@Column(name="PLAN_NAME")
	private  String plan_name;
	
	@Column(name="PLAN_START_DATE")
	private LocalDate plan_start_date;
	
	@Column(name="PLAN_END_DATE")
	private LocalDate plan_end_date;
	
	@Column(name="PLAN_CATEGORY_ID")
	private Integer plan_category_id;
	
	@Column(name="ACTIVE_SW")
	private String active_switch;
	
	@Column(name="CREARED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@UpdateTimestamp
	@Column(name="UPDATE_DATE",insertable = false)
	private LocalDate update_date;
	
	@CreationTimestamp
	@Column(name="CREATE_DATE" , updatable = false)
	private LocalDate create_date;
	
	
	
	
	
	
	

}
