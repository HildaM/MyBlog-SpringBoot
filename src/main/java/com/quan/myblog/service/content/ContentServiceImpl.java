package com.quan.myblog.service.content;

import com.quan.myblog.dao.ContentDao;
import com.quan.myblog.pojo.Contents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ContentServiceImpl
 * @Description: 文章Service实现类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/22 15:56
 */

@Service
public class ContentServiceImpl implements ContentService{

    @Autowired
    private ContentDao contentDao;


    /**
     * @Author Hilda
     * @Description //TODO 获取所有文章
     * @Date 15:57 2022/1/22
     * @Param []
     * @returnValue List<Contents>
     **/
    @Override
    public List<Contents> getAllContents() {
        List<Contents> allContents = contentDao.getAllContents();

        return allContents;
    }
}
