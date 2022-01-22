package com.quan.myblog.pojo;

import org.springframework.stereotype.Component;

/**
 * @ClassName: Contents
 * @Description: 文章实体类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/22 15:25
 */

@Component
public class Contents {
    // 文章主键
    private Integer cid;

    // 文章标题
    private String title;

    // 文章封面图
    private String titlePic;

    // slug？内容缩略名
    private String slug;

    // 内容创建时的GMT unix时间戳
    private Integer created;

    // 内容生成时的GMT unix时间戳
    private Integer modified;

    // 文章主体内容
    private String test;

    // 文章作者id
    private Integer authorId;

    // 文章类型
    private String type;

    // 文章状态
    private String status;

    // 文章标签
    private String tags;

    // 文章类别
    private String categories;

    // 文章点击次数
    private Integer hits;

    // 文章评论数
    private Integer commentsNum;

    // 是否允许评论
    private Integer allowComment;

    // 是否允许ping
    private Integer allowPing;

    // 是否允许出现在聚合中
    private Integer allowFeed;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitlePic() {
        return titlePic;
    }

    public void setTitlePic(String titlePic) {
        this.titlePic = titlePic;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getModified() {
        return modified;
    }

    public void setModified(Integer modified) {
        this.modified = modified;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getCommentsNum() {
        return commentsNum;
    }

    public void setCommentsNum(Integer commentsNum) {
        this.commentsNum = commentsNum;
    }

    public Integer getAllowComment() {
        return allowComment;
    }

    public void setAllowComment(Integer allowComment) {
        this.allowComment = allowComment;
    }

    public Integer getAllowPing() {
        return allowPing;
    }

    public void setAllowPing(Integer allowPing) {
        this.allowPing = allowPing;
    }

    public Integer getAllowFeed() {
        return allowFeed;
    }

    public void setAllowFeed(Integer allowFeed) {
        this.allowFeed = allowFeed;
    }
}
