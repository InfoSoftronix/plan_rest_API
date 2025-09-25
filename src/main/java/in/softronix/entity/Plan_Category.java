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
public class Plan_Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PLAN_CATEGORY_ID")
	private Integer plan_category_id;
	
	@Column(name="PLAN_CATEGORY_NAME")
	private String plan_category_name;
	
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
