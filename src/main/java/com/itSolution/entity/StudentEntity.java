package com.itSolution.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="STUDENT_DTLS")
public class StudentEntity {
	
	@Id
	@GeneratedValue
	private Integer sid;
	private String name;
	private String email;
	private String gender;
	private String course;
	private String timings;
}
