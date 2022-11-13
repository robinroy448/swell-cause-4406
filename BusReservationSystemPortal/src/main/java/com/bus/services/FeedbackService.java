package com.bus.services;

import java.util.List;

import com.bus.bean.Feedback;
import com.bus.exceptions.BusException;
import com.bus.exceptions.FeedBackException;
import com.bus.exceptions.UserException;


public interface FeedbackService {
	
	
	public Feedback addFeedBack(Feedback feedBack,Integer busId,String key) throws BusException, UserException;
	
	public Feedback updateFeedBack(Feedback feedback,String key) throws FeedBackException, UserException;
	
	public Feedback deleteFeedBack(Integer feedbackId, String key)throws FeedBackException, UserException;

	public Feedback viewFeedback(Integer id) throws FeedBackException;

	public List<Feedback> viewFeedbackAll() throws FeedBackException;
	
}
