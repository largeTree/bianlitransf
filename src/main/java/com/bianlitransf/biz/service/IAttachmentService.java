package com.bianlitransf.biz.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.bianlitransf.biz.dao.AttachmentDao;
import com.bianlitransf.biz.entity.Attachment;
import com.qiuxs.cuteframework.core.persistent.database.service.ifc.IDataPropertyService;

public interface IAttachmentService extends IDataPropertyService<Long, Attachment, AttachmentDao> {

	public String saveFileMap(Map<String, MultipartFile> fileMap) throws IllegalStateException, IOException ;

	
	
}
