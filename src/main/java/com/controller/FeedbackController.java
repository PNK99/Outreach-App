package com.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.Event;
import com.bean.Feedback;
import com.dao.EventDao;
import com.service.FeedbackService;

@Controller
public class FeedbackController {

	@Autowired
	private FeedbackService feedback;

	@Autowired
	private EventDao eventDao;

	@GetMapping("/feedback")
	public String feed(@ModelAttribute("feedback") Feedback f, Integer eventId, Model map) {
		map.addAttribute("eventId", eventId);
		return "volunteerfeedback";
	}

	@PostMapping("/feedbackSave")
	public String feedback(@ModelAttribute("feedback") Feedback f, BindingResult br, Model m, Integer eventId) {
		feedback.savefeedback(f);
		System.out.println(eventId);
		Event event = eventDao.findById(eventId).get();
		event.getFeedbacks().add(f);

		eventDao.save(event);
		return "redirect:home";
	}

	@GetMapping("/generateFeedbackReport")
	public void generateFeedbackReport(HttpServletResponse response, Integer eventId) throws Exception {
		String filename = "C:\\Users\\839834\\Downloads\\feedback-report.csv";

		feedback.writeCSV(filename, eventId);
		feedback.downloadCSV(response, filename);

	}
	
	
	
	
}
