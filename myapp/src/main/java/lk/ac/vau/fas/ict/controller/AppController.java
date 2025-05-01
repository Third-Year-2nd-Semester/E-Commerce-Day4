package lk.ac.vau.fas.ict.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.ict.model.Student;

@RestController
@RequestMapping("/app")
public class AppController {

	Student st1=new Student("IT01","Alice",25,"IT",3.8);
	Student st2=new Student("IT12","Kamal",24,"IT",3.2);
	Student st3=new Student("IT34","Raman",23,"IT",3.0);
	Student st4=new Student("AMA34","Sashi",24,"AMA",3.1);
	Student st5=new Student("CS54","Amal",23,"CS",2.9);
	Student st6=new Student("CS102","Rahul",25,"CS",3.1);
	
	private Map<String,Student> msstudent=new HashMap<String,Student>();
	
	@GetMapping("/addDetils")
	public void addobjects() {
		msstudent.put(st1.getRegNo(), st1);
		msstudent.put(st2.getRegNo(), st2);
		msstudent.put(st3.getRegNo(), st3);
		msstudent.put(st4.getRegNo(), st4);
		msstudent.put(st5.getRegNo(), st5);
		msstudent.put(st6.getRegNo(), st6);
	}
	
	@GetMapping("/details")
	public Map<String,Student> grtdetails(){
		return msstudent;
	}
	
	@PostMapping("/add")
	public String addstudent(@RequestBody Student student) {
		msstudent.put(student.getRegNo(), student);
		return "New Student added"; 
	}
	
	@PutMapping("/update/{id}")
	public String UpdateStudent(@PathVariable("id") String regNo,@RequestBody Student student) {
		if(msstudent.get(regNo)!=null)
		{
		msstudent.put(student.getRegNo(), student);
		return "new student added";
		}
		return "404 student not found";
	}
	
	@DeleteMapping("/students/{id}")
	public String DeleteStudent(@PathVariable("id") String regNo,@RequestBody Student student)
	{
	if(msstudent.get(regNo)!=null) {
		msstudent.remove(regNo);
		return "student delete successfully"; 
	}
	return "404 not found student";
	
	}
	
	
}
