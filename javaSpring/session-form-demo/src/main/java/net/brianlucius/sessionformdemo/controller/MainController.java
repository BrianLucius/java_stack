package net.brianlucius.sessionformdemo.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
				@RequestParam("reviewer") String reviewer,
				HttpSession session,
				RedirectAttributes redirectAttributes) {
		// Process the review
		if(rating < 0 || rating > 5) {
			redirectAttributes.addFlashAttribute("error", "Rating must be between 1 and 5!");
			return "redirect:/reviewForm";
		}
		session.setAttribute("product", product);
		session.setAttribute("comment", comment);
		session.setAttribute("rating", rating);
		session.setAttribute("reviewer", reviewer);
		
		return "redirect:/displayReviewForm";
	}
	
	@GetMapping("/displayReviewForm")
	public String displayReviewForm() {
		return "reviewform/reviewformdisplay.jsp";
	}
	
	// ---- Reservations Form -----
	// Render form
	@GetMapping("/reserve")
	public String renderReserveForm() {
		return "/reservationform/reservationform.jsp";
	}
	
	// Process form
	@PostMapping("/processReservation")
	public String processReservation(@RequestParam("name") String name,
				@RequestParam("numOfPeople") Integer numOfPeople,
				@RequestParam("reservationDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date resDate,
				@RequestParam("reservationTime") @DateTimeFormat(pattern="HH:mm") Date resTime,
				HttpSession session) {
					session.setAttribute("name", name);
					session.setAttribute("numOfPeople", numOfPeople);
					session.setAttribute("reservationDate", resDate);
					session.setAttribute("reservationTime", resTime);
				
		return "redirect:/reserveResult";
	}
	//Display form
	@GetMapping("/reserveResult")
	public String displayReserveResult() {
		return "/reservationform/reservationdisplay.jsp";
	}
}
