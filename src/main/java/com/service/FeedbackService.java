package com.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.bean.Event;
import com.bean.Feedback;
import com.bean.User;
import com.dao.EventDao;
import com.dao.FeedbackDao;
import com.dao.UserDao;

@Service
public class FeedbackService {

	@Autowired
	private FeedbackDao feedbackdao;

	@Autowired
	private EventDao eventDao;
	
	@Autowired
	private UserDao userDao;

	public boolean savefeedback(Feedback feedback) {
		try {
			feedbackdao.save(feedback);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;

	}

	public void downloadCSV(HttpServletResponse response, String filename) {
		File file = new File(filename);
		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		if (mimeType == null) {

			mimeType = "application/octet-stream";
		}

		String name = new Date().toString().substring(0, 10);

		response.setContentType(mimeType);

		response.setHeader("Content-Disposition",
				String.format("inline; filename=\"" + "feedback(" + name + ").csv" + "\""));

		response.setContentLength((int) file.length());

		InputStream inputStream;
		try {
			inputStream = new BufferedInputStream(new FileInputStream(file));
			FileCopyUtils.copy(inputStream, response.getOutputStream());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void writeCSV(String filename, Integer eventId) {
		FileWriter csvWriter;
		try {

			Event event = eventDao.findById(eventId).get();

			Set<Feedback> feedbacks = event.getFeedbacks();

			csvWriter = new FileWriter(filename);

			csvWriter.append("Enjoyed,Had fun,Would Recommend,Were coordinator helpful\n");

			for (Feedback feed : feedbacks) {
				csvWriter.append(feed.getEnjoy() + "," + feed.getFun() + "," + feed.getRecommend() + ","
						+ feed.getCo_ordinator() + "\n");
			}

			csvWriter.flush();
			csvWriter.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public Set<Event> getFeedbackNotification(Integer userId){
		User user =  userDao.findById(userId).get();
		return user.getEventFeedback();
	}

}
