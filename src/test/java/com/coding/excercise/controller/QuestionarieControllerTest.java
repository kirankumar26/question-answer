package com.coding.excercise.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.coding.excercise.bo.AnswerBo;
import com.coding.excercise.bo.QuestionarieBo;
import com.coding.excercise.bo.ResponseBo;
import com.coding.excercise.exception.ErrorResponse;
import com.coding.excercise.exception.ExcerciseException;
import com.coding.excercise.service.QuestionarieService;

public class QuestionarieControllerTest {
	@Mock
	QuestionarieService service;
	
	@InjectMocks
	QuestionarieController controller;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getQuestionTestForSuccess() {
	   String userId = "1";
	   QuestionarieBo questionarieBo = new QuestionarieBo();
	   questionarieBo.setQuestion("Please sum the numbers 40,93");
	   Mockito
			.when(service.getQuestion(userId))
			.thenReturn(questionarieBo);
	   ResponseEntity<QuestionarieBo> response = new ResponseEntity<>(questionarieBo, HttpStatus.OK);
	   Assert.assertSame(response.getBody().getQuestion(), controller.getQuestion(userId).getBody().getQuestion());
	}
	
	@Test
	public void postAnswerTestForSuccess() {
		String userId = "1";
		AnswerBo answerBo = new AnswerBo();
		answerBo.setQuestion("Please sum the numbers 40,93");
		answerBo.setAnswer("Answer is 133");
		ResponseBo responseBo = new ResponseBo();
		responseBo.setMessage("That’s great.");
		Mockito
			.when(service.verifyAnswer(answerBo, userId))
			.thenReturn(responseBo);
		ResponseEntity<ResponseBo> response = new ResponseEntity<>(responseBo, HttpStatus.OK);
		Assert.assertSame(response.getBody().getMessage(), controller.postAnswer(userId, answerBo).getBody().getMessage());
	}
	
	@Test(expected=ExcerciseException.class)
	public void postAnswerTestWithoutHeaderUserId() {
		AnswerBo answerBo = new AnswerBo();
		answerBo.setQuestion("Please sum the numbers 40,93");
		answerBo.setAnswer("Answer is 133");
		ErrorResponse responseBo = new ErrorResponse();
		responseBo.setMessage("Missing request header 'user-id' for method parameter of type String");
		Mockito
			.when(service.verifyAnswer(answerBo, null))
			.thenThrow(ExcerciseException.class);
		ResponseEntity<ErrorResponse> response = new ResponseEntity<>(responseBo, HttpStatus.BAD_REQUEST);
		Assert.assertSame(response.getBody().getMessage(), controller.postAnswer(null, answerBo).getBody().getMessage());
	}
	
	@Test(expected=ExcerciseException.class)
	public void postAnswerTestWithoutAnswerInRequestBody() {
		AnswerBo answerBo = new AnswerBo();
		answerBo.setQuestion("Please sum the numbers 40,93");
		ErrorResponse responseBo = new ErrorResponse();
		responseBo.setMessage("Question/Answer can't be empty.");
		Mockito
			.when(service.verifyAnswer(answerBo, null))
			.thenThrow(ExcerciseException.class);
		ResponseEntity<ErrorResponse> response = new ResponseEntity<>(responseBo, HttpStatus.BAD_REQUEST);
		Assert.assertSame(response.getBody().getMessage(), controller.postAnswer(null, answerBo).getBody().getMessage());
	}
	
	@Test(expected=ExcerciseException.class)
	public void postAnswerTestWithoutQuestionInRequestBody() {
		AnswerBo answerBo = new AnswerBo();
		answerBo.setAnswer("Answer is 133");
		ErrorResponse responseBo = new ErrorResponse();
		responseBo.setMessage("Question/Answer can't be empty.");
		Mockito
			.when(service.verifyAnswer(answerBo, null))
			.thenThrow(ExcerciseException.class);
		ResponseEntity<ErrorResponse> response = new ResponseEntity<>(responseBo, HttpStatus.BAD_REQUEST);
		Assert.assertSame(response.getBody().getMessage(), controller.postAnswer(null, answerBo).getBody().getMessage());
	}
	
	@Test(expected=ExcerciseException.class)
	public void postAnswerTestForWrongAnswer() {
		AnswerBo answerBo = new AnswerBo();
		answerBo.setQuestion("Please sum the numbers 40,93");
		answerBo.setAnswer("Answer is 113");
		ErrorResponse responseBo = new ErrorResponse();
		responseBo.setMessage("That’s wrong. Please try again.");
		Mockito
			.when(service.verifyAnswer(answerBo, null))
			.thenThrow(ExcerciseException.class);
		ResponseEntity<ErrorResponse> response = new ResponseEntity<>(responseBo, HttpStatus.BAD_REQUEST);
		Assert.assertSame(response.getBody().getMessage(), controller.postAnswer(null, answerBo).getBody().getMessage());
	}	
}
