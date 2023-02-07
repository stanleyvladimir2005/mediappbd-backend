package com.mitocode.serviceImpl;

import com.mitocode.model.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mitocode.repo.IExamRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IExamService;

@Service
public class ExamServiceImpl extends CRUDImpl<Exam, Integer> implements IExamService {

	@Autowired
	private IExamRepo repo;

	@Override
	protected IGenericRepo<Exam, Integer> getRepo() {
		return repo;
	}
}