package com.coding.excercise.service;

import com.coding.excercise.bo.AnswerBo;
import com.coding.excercise.bo.QuestionarieBo;
import com.coding.excercise.bo.ResponseBo;

public interface QuestionarieService {
	QuestionarieBo getQuestion(String userId);
	ResponseBo verifyAnswer(AnswerBo answerBo, String userId);
}
