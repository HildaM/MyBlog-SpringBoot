package com.quan.myblog.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ClassName: Log
 * @Description: 日志记录实体类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/20 11:19
 */

@Component
public class Log implements Serializable {

    // 由于日志文件需要保存到本地，所以需要进行序列化操作
    private static final long serialVersionUID = 1L;

    // 主键
    private Integer id;
    // IP地址
    private String ip;
    // 操作者编号
    private Integer authorId;
    // 发生的事件
    private String action;
    // 产生的数据
    private String data;
    // 创建的时间
    private Integer created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }
}
