package com.mitocode.repo;

import org.springframework.stereotype.Repository;
import com.mitocode.model.MediaFile;

@Repository
public interface IMediaFileRepo extends IGenericRepo<MediaFile, Integer> {
}