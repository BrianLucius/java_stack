package net.brianlucius.student_roster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import net.brianlucius.student_roster.models.Dorm;
import net.brianlucius.student_roster.models.Student;
import net.brianlucius.student_roster.services.DormService;
import net.brianlucius.student_roster.services.StudentService;

@Controller
public class MainController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private DormService dormService;
	
	// ----- Dashboard -----
	@GetMapping(value={"/","/dorms"})
	public String index(Model model) {
		List<Dorm> dormsList = dormService.allDorms();
		model.addAttribute("dormsList", dormsList);
		return "index.jsp";
	}
	
	// ----- New Dorm Render and Process -----
	@GetMapping("/dorms/new")
	public String renderNewDorm(@ModelAttribute("dorm") Dorm dorm, Model model) {
		List<Dorm> dormsList = dormService.allDorms();
		model.addAttribute("dormsList", dormsList);
		return "new_dorm.jsp";
	}
	
	@PostMapping("/dorms/new")
	public String processNewDorm(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
		if(result.hasErrors()) {
			return "new_dorm.jsp";
		}
		dormService.saveDorm(dorm);
		return "redirect:/";
	}
	
	// ----- New Student Render and Process -----
	@GetMapping("/students/new")
	public String renderNewStudent(@ModelAttribute("student") Student Student, Model model) {
		List<Dorm> dormsList = dormService.allDorms();
		model.addAttribute("dormsList", dormsList);
		return "new_student.jsp";
	}
	
	@PostMapping("/students/new")
	public String processNewStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dorm> dormsList = dormService.allDorms();
			model.addAttribute("dormsList", dormsList);
			return "new_student.jsp";
		}
		studentService.saveStudent(student);
		return "redirect:/";
	}
	
	// ---- Render Dorm details -----
	@GetMapping("/dorms/{id}")
	public String showDorm(@PathVariable("id") Long id, Model model, @ModelAttribute("student") Student student) {
		List<Student> studentsList = studentService.allStudents();
		model.addAttribute("studentsList", studentsList);
		
		Dorm dormsList = dormService.getDormById(id);
		model.addAttribute("dormsList", dormsList);
		return "show_dorm.jsp";
	}
	
	// ----- Add student to Dorm -----
	@PutMapping("/students/update/{dorm_id}")
	public String addStudentToDorm(@PathVariable("dorm_id") Long dorm_id, @ModelAttribute("student") Student student) {
		Student updateStudent = studentService.getOne(student.getId());
		updateStudent.setDorm(dormService.getDormById(dorm_id));
		studentService.saveStudent(updateStudent);
		return "redirect:/dorms/"+dorm_id;
	}
	
	// ----- Remove student from Dorm -----
	@PutMapping("/students/{dorm_id}/{id}")
	public String removeStudentFromDorm(@PathVariable("dorm_id") Long dorm_id, @PathVariable("id") Long id) {
		Student updateStudent = studentService.getOne(id);
		updateStudent.setDorm(null);
		studentService.saveStudent(updateStudent);
		return "redirect:/dorms/"+dorm_id;
	}

}
