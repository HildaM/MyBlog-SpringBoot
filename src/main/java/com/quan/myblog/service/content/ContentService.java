package com.quan.myblog.service.content;

import com.quan.myblog.pojo.Contents;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ContentService
 * @Description: 文章Serivce
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/22 15:55
 */

@Service
public interface ContentService {
    // 获取所有文章
    public List<Contents> getAllContents();
}
