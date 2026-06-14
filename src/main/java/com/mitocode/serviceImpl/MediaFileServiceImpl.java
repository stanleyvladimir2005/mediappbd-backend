package com.mitocode.serviceImpl;

import com.mitocode.repo.IGenericRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mitocode.model.MediaFile;
import com.mitocode.repo.IMediaFileRepo;
import com.mitocode.service.IMediaFileService;

@Service
public class MediaFileServiceImpl extends CRUDImpl<MediaFile, Integer> implements IMediaFileService {

	@Autowired
	private IMediaFileRepo repo;

	@Override
	protected IGenericRepo<MediaFile, Integer> getRepo(){	return repo;}
}