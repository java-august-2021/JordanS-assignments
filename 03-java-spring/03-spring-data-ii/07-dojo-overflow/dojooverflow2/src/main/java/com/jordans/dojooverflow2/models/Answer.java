package com.jordans.dojooverflow2.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="answers")
	public class Answer {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotNull
		@Size(min=2)
		private String body;
		
		@Column(updatable=false)
		@DateTimeFormat(pattern="dd-mm-yyyy")
		private Date createdAt;
		
		@DateTimeFormat(pattern = "dd-mm-yyyy")
		private Date updatedAt;
		
		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}
		
		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}
		
		@ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="question_id")
		private Question question;
		
		//INIT CONSTRUCTORS
			public Answer() {
			}
			
			public Answer(String body) {
				this.body = body;
			}
			
			
			//GETTERS AND SETTERS
			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public String getBody() {
				return body;
			}

			public void setBody(String body) {
				this.body = body;
			}

			public Date getCreatedAt() {
				return createdAt;
			}

			public void setCreatedAt(Date createdAt) {
				this.createdAt = createdAt;
			}

			public Date getUpdatedAt() {
				return updatedAt;
			}

			public void setUpdatedAt(Date updatedAt) {
				this.updatedAt = updatedAt;
			}

			public Question getQuestion() {
				return question;
			}

			public void setQuestion(Question question) {
				this.question = question;
			}
	}
