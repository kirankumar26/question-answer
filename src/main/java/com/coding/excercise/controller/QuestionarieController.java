package com.coding.excercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.excercise.bo.ResponseBo;
import com.coding.excercise.bo.AnswerBo;
import com.coding.excercise.bo.QuestionarieBo;
import com.coding.excercise.service.QuestionarieService;

@RestController
@RequestMapping("/")
public class QuestionarieController {
	
	@Autowired
	QuestionarieService questionarieService;
	
	/**
	  * Return the questionarie for the user by server.
	  * 
	  * @return QuestionarieBo contains the question.
	  * @throws ExcerciseException if any.
    */
	@GetMapping
	public ResponseEntity<QuestionarieBo> getQuestion(@RequestHeader(name="user-id", required=true) String userId) {
		return new ResponseEntity<>(questionarieService.getQuestion(userId), HttpStatus.OK);
	}
	
	/**
	  * Verify user answer for the question given by the server.
	  * 
	  * @param AnswerBo contains question and answer.
	  * @return Success message.
	  * @throws ExcerciseException if any.
    */
	@PostMapping
	public ResponseEntity<ResponseBo> postAnswer(@RequestHeader(name="user-id", required=true) String userId, @RequestBody AnswerBo answer) {
		return new ResponseEntity<>(questionarieService.verifyAnswer(answer, userId), HttpStatus.OK);
	}
}
