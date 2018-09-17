package com.bianlitransf.biz.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.bianlitransf.biz.dao.AttachmentDao;
import com.bianlitransf.biz.entity.Attachment;
import com.bianlitransf.biz.service.IAttachmentService;
import com.qiuxs.cuteframework.core.persistent.database.modal.BaseField;
import com.qiuxs.cuteframework.core.persistent.database.modal.PropertyWrapper;
import com.qiuxs.cuteframework.core.persistent.database.service.AbstractDataPropertyService;
import com.qiuxs.cuteframework.core.persistent.database.service.filter.IServiceFilter;
import com.qiuxs.cuteframework.core.persistent.database.service.filter.impl.IdGenerateFilter;

/**
 * 附件表服务类
 *
 * @author qiuxs
 *
 */
@Service
public class AttachmentService extends AbstractDataPropertyService<Long, Attachment, AttachmentDao>
		implements IAttachmentService {

	private static final String TABLE_NAME = "attachment";

	public AttachmentService() {
		super(Long.class, Attachment.class, TABLE_NAME);
	}

	@Value("${env.attachment.path}")
	private String attachmentPath;

	@Resource
	private AttachmentDao attachmentDao;

	@Override
	protected AttachmentDao getDao() {
		return this.attachmentDao;
	}

	@Override
	@Transactional
	public String saveFileMap(Map<String, MultipartFile> fileMap) throws IllegalStateException, IOException {
		StringBuilder ids = new StringBuilder();
		for (Iterator<Map.Entry<String, MultipartFile>> iter = fileMap.entrySet().iterator(); iter.hasNext();) {
			Map.Entry<String, MultipartFile> entry = iter.next();
			MultipartFile file = entry.getValue();
			String fileName = file.getOriginalFilename();
			Attachment attachment = new Attachment();
			attachment.setName(file.getOriginalFilename());
			this.setId(attachment);
			String path = this.getPath(attachment.getId(), fileName);
			attachment.setPath(path);
			// 保存文件
			file.transferTo(new File(path));
			// 追加ID
			ids.append(attachment.getId()).append(",");
			this.create(attachment);
		}
		if (ids.length() > 0) {
			ids.setLength(ids.length() - 1);
		}
		return ids.toString();
	}

	private String getPath(Long id, String fileName) {
		File dir = new File(this.attachmentPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		StringBuilder sb = new StringBuilder();
		sb.append(this.attachmentPath).append(File.separator).append(id).append("-")
				.append(fileName);
		return sb.toString();
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter<Long, Attachment>> serviceFilters) {
		serviceFilters.add(new IdGenerateFilter<>(TABLE_NAME));
	}

	@Override
	protected void initProps(List<PropertyWrapper<?>> props) {
		PropertyWrapper<?> prop = null;

		prop = new PropertyWrapper<Long>(new BaseField("id", "id", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("path", "存储路径", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("name", "文件名", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("createdBy", "创建人", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Date>(new BaseField("createdTime", "创建时间", Date.class), null);
		props.add(prop);

	}

}
