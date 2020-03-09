package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Feedback;
import com.dao.FeedbackDao;

@Service
public class FeedbackService  {
	
	
	
@Autowired	
private FeedbackDao feedbackdao;



public boolean savefeedback(Feedback feedback) {
	try {
		feedbackdao.save(feedback);
	}
	catch(Exception e){
		System.out.println(e.getMessage());
		return false;
	}
	return true;
	
}


}
