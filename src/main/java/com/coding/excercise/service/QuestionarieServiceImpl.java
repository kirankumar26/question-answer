package com.coding.excercise.service;

import com.coding.excercise.bo.AnswerBo;
import com.coding.excercise.bo.QuestionarieBo;
import com.coding.excercise.bo.ResponseBo;
import com.coding.excercise.exception.ExcerciseException;
import com.coding.excercise.service.QuestionarieService;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class QuestionarieServiceImpl implements QuestionarieService {
  private static final Logger logger = LoggerFactory.getLogger(com.coding.excercise.service.QuestionarieServiceImpl.class);
  
  @Autowired
  CacheManager cacheManager;
  
  @CachePut(value = {"questionarie"}, key = "#userId")
  public QuestionarieBo getQuestion(String userId) {
    QuestionarieBo questionarieBo = new QuestionarieBo();
    questionarieBo.setQuestion("Please sum the numbers " + getRandomNumber() + "," + getRandomNumber());
    return questionarieBo;
  }
  
  public ResponseBo verifyAnswer(AnswerBo answerBo, String userId) {
    if (null == answerBo.getQuestion() || null == answerBo.getAnswer())
      throw new ExcerciseException("Question/Answer can't be empty.", HttpStatus.BAD_REQUEST); 
    if (!validateQuestionCorrectness(answerBo.getQuestion(), userId))
      throw new ExcerciseException("Thatwrong. Please try again.", HttpStatus.BAD_REQUEST); 
    if (answerBo.getAnswer().contains(String.valueOf(sumOfNumbers(answerBo.getQuestion())))) {
      ResponseBo responseBo = new ResponseBo();
      responseBo.setMessage("Thatgreat");
      return responseBo;
    } 
    throw new ExcerciseException("Thatwrong. Please try again.", HttpStatus.BAD_REQUEST);
  }
  
  public int sumOfNumbers(String question) {
    Pattern pattern = Pattern.compile("\\d+");
    Matcher matcher = pattern.matcher(question);
    int sum = 0;
    while (matcher.find())
      sum += Integer.parseInt(matcher.group(0)); 
    return sum;
  }
  
  private int getRandomNumber() {
    Random random = new Random();
    return random.nextInt(100);
  }
  
  private boolean validateQuestionCorrectness(String question, String userId) {
    Cache cache = this.cacheManager.getCache("questionarie");
    QuestionarieBo questionarie = (QuestionarieBo)cache.get(userId).get();
    logger.info("Previous question : " + questionarie.getQuestion());
    logger.info("Answer question : " + question);
    if (null != questionarie && questionarie.getQuestion().equals(question))
      return true; 
    return false;
  }
}

