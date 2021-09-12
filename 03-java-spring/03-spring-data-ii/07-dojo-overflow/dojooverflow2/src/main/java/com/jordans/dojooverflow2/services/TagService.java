package com.jordans.dojooverflow2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jordans.dojooverflow2.models.Question;
import com.jordans.dojooverflow2.models.Tag;
import com.jordans.dojooverflow2.repositories.QuestionRepo;
import com.jordans.dojooverflow2.repositories.TagRepo;

@Service
public class TagService {
	private final TagRepo tagRepo;
	private final QuestionRepo questionRepo;
	
	public TagService(TagRepo tagRepo, QuestionRepo questionRepo) {
		this.tagRepo = tagRepo;
		this.questionRepo = questionRepo;
	}
	
	public List<Tag> allTags() {
		return (List<Tag>) tagRepo.findAll();
	}
	
	public Tag addTag(Tag tag) {
		return tagRepo.save(tag);
	}
	
	public Tag getOneTag(String subject) {
		return this.tagRepo.findBySubject(subject);
	}
	
	public ArrayList<Tag> splitTags(String tags) {
		ArrayList<Tag> tagsForQ = new ArrayList<Tag>();
		String[] tagsToProcess = tags.split(", ");
		for(String string : tagsToProcess) {
			if(this.tagRepo.existsBySubject(string)) {
				Tag tagToAdd = this.getOneTag(string);
				tagsForQ.add(tagToAdd);
			} else {
				Tag thisTag = new Tag();
				thisTag.setSubject(string);
				this.tagRepo.save(thisTag);
				tagsForQ.add(this.getOneTag(string));
			}
		}
		return tagsForQ;
	}
	
	public Question createQuestionWithTags(Question question) {
		question.setTags(this.splitTags(question.getTagQuery()));
		return this.questionRepo.save(question);
	}
}
