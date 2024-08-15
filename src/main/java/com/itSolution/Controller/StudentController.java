package com.itSolution.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itSolution.bindings.Student;
import com.itSolution.entity.StudentEntity;
import com.itSolution.repo.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository repo;
	
	@GetMapping("/")
	public String loadForm(Model model) {
		
		loadFormData(model);
			
		return "index";
	}

	private void loadFormData(Model model) {
		List<String> coursesList=new ArrayList<>();
		coursesList.add("Java");
		coursesList.add("Devops");
		coursesList.add("AWS");
		coursesList.add("Python");
		
		List<String> timingList=new ArrayList<>();
		timingList.add("Morning");
		timingList.add("Afternoon");
		timingList.add("Evening");
		
		Student student=new Student();
		model.addAttribute("courses",coursesList);
		model.addAttribute("timings", timingList);
		model.addAttribute("student", student);
	}
	
	@PostMapping("/save")
	public String handleSubmitBtn(Student s,Model model) {
		
		
		StudentEntity entity=new StudentEntity();
		
		BeanUtils.copyProperties(s, entity);
		
		entity.setTimings(Arrays.toString(s.getTimings()));
		
		repo.save(entity);
		
		loadFormData(model);

		model.addAttribute("msg","Saved Successfully");
		
		return "index";
	}	
	
	@GetMapping("/viewStudents")
	public String getStudentsData(Model model) {
		
		
		List<StudentEntity> studentList = repo.findAll();
		
		model.addAttribute("students",studentList);
		
		
		return "data";
	}
	
	
	
	
	
	
	
	
	
	
}
