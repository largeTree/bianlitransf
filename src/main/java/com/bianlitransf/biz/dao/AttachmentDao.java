package com.bianlitransf.biz.dao;

import org.springframework.stereotype.Repository;

import com.qiuxs.cuteframework.core.persistent.database.dao.IBaseDao;
import com.bianlitransf.biz.entity.Attachment;

/**
 * 附件表Dao接口
 *
 * @author qiuxs
 *
 */
@Repository
public interface AttachmentDao extends IBaseDao<Long, Attachment> {

}
