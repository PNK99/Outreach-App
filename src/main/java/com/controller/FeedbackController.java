package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.Feedback;
import com.service.FeedbackService;


@Controller
public class FeedbackController {

	@Autowired
	private FeedbackService feedback;
	
	@GetMapping("/feedback")
	public String feed(@ModelAttribute("feedback")Feedback f) {
		return "volunteerfeedback";
	}
	
	@PostMapping("/feedbackSave")
	public String feedback(@ModelAttribute("feedback")Feedback f,BindingResult br,Model m ) {
		feedback.savefeedback(f);
		return "Thankyou";
	}
	
	
	
	
}
