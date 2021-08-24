package com.bean.annotation.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "question")
public class QuestionBean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	int questionId;
	
	
	@Column(name = "qstn", length = 50, nullable = false, unique = true)
	String question;
	
	
	@OneToMany(targetEntity=AnswerBean.class,cascade=CascadeType.ALL)
	List<AnswerBean> answers;
	
	
	public List<AnswerBean> getAnswers() {
		return answers;
	}
	public void setAnswers(List<AnswerBean> answers) {
		this.answers = answers;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
}
