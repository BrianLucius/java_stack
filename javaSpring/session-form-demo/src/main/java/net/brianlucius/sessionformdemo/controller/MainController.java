package net.brianlucius.sessionformdemo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	// ----- Sessions -----
	@GetMapping(value={"/","/home"})
	public String index(HttpSession session) {
		// check if count is in the session
		if(session.getAttribute("count") == null) {
			// If not, create count as 1
			session.setAttribute("count", 1);
		}
		//Increment the count in the session
		Integer tempCount = (Integer) session.getAttribute("count");
		session.setAttribute("count", ++tempCount);
			
		return "counthome.jsp";
	}
	
	@GetMapping("/getcount")
	public String getCount() {
		return "countget.jsp";
	}
	
	// ------ Forms ------
	@GetMapping("/searchForm")
	public String searcFrom() {
		return "searchForm/searchform.jsp";
	}
	
	@GetMapping("/search")
	public String displayForm(@RequestParam("keyword") String keyword,
				Model model) {
		model.addAttribute("keyword", keyword);
		return "searchForm/displayform.jsp";
	}
	
	// ------ Forms post method ------
	@GetMapping("/reviewForm")
	public String reviewForm() {
		return "reviewform/reviewform.jsp";
	}
	
	@PostMapping("/process")
	public String processForm(@RequestParam("product") String product,
				@RequestParam("comment") String comment,
				@RequestParam("rating") Integer rating,
				HttpSession session) {
		// Process the review
		session.setAttribute("product", product);
		session.setAttribute("comment", comment);
		session.setAttribute("rating", rating);
		
		return "redirect:/displayReviewForm";
	}
	
	@GetMapping("/displayReviewForm")
	public String displayReviewForm() {
		return "reviewform/reviewformdisplay.jsp";
	}
	
}
