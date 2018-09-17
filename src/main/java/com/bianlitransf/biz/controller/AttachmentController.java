package com.bianlitransf.biz.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.bianlitransf.biz.dao.AttachmentDao;
import com.bianlitransf.biz.entity.Attachment;
import com.bianlitransf.biz.service.IAttachmentService;
import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.annotation.Api;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;

/**
 * 附件表控制器
 *
 * @author qiuxs
 *
 */
@RestController
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX
		+ "/attachment", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class AttachmentController extends AbstractDataController<Long, Attachment, AttachmentDao, IAttachmentService> {

	@Resource
	private IAttachmentService attachmentService;

	@Api
	public String upload(HttpServletRequest request) throws IllegalStateException, IOException {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Map<String, MultipartFile> fileMap = multiRequest.getFileMap();
			return this.getService().saveFileMap(fileMap);
		}
		return null;
	}

	@RequestMapping("/getImg/{id}")
	public void getImg(@PathVariable("id") Long id, HttpServletResponse resp)
			throws FileNotFoundException, IOException {
		Attachment attch = this.getService().getById(id);
		IOUtils.copy(new BufferedInputStream(new FileInputStream(new File(attch.getPath()))),
				new BufferedOutputStream(resp.getOutputStream()));
	}

	@RequestMapping("/download/{id}")
	public void download(@PathVariable("id") Long id, HttpServletResponse resp)
			throws FileNotFoundException, IOException {
		Attachment attch = this.getService().getById(id);
		resp.setHeader("Content-Disposition", "attachment; filename=\"" + attch.getName() + "\"");
		File file = new File(attch.getPath());
		resp.setHeader("Content-Length", String.valueOf(file.length()));
		IOUtils.copy(new BufferedInputStream(new FileInputStream(file)),
				new BufferedOutputStream(resp.getOutputStream()));
	}

	@Override
	protected IAttachmentService getService() {
		return this.attachmentService;
	}

}
