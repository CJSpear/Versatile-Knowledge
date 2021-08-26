/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.File;
import java.util.Date;

/**
 *
 * @author sarahaverill
 */
public class Article {
    private Integer articleId;
    private String  title;
    private String articleAbstract;
    private File file;
    private String keywords;
    private Date author;
    private Boolean verified;
    private Boolean publsihed;
    private Integer citedCount;
    private String contributedBy;
    private String verifiedBy;
    private Integer timesFlagged;

    public Article() {
    }

    public Article(Integer articleId, String title, String articleAbstract, File file, String keywords, Date author, Boolean verified, Boolean publsihed, Integer citedCount, String contributedBy, String verifiedBy, Integer timesFlagged) {
        this.articleId = articleId;
        this.title = title;
        this.articleAbstract = articleAbstract;
        this.file = file;
        this.keywords = keywords;
        this.author = author;
        this.verified = verified;
        this.publsihed = publsihed;
        this.citedCount = citedCount;
        this.contributedBy = contributedBy;
        this.verifiedBy = verifiedBy;
        this.timesFlagged = timesFlagged;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Date getAuthor() {
        return author;
    }

    public void setAuthor(Date author) {
        this.author = author;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Boolean getPublsihed() {
        return publsihed;
    }

    public void setPublsihed(Boolean publsihed) {
        this.publsihed = publsihed;
    }

    public Integer getCitedCount() {
        return citedCount;
    }

    public void setCitedCount(Integer citedCount) {
        this.citedCount = citedCount;
    }

    public String getContributedBy() {
        return contributedBy;
    }

    public void setContributedBy(String contributedBy) {
        this.contributedBy = contributedBy;
    }

    public String getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public Integer getTimesFlagged() {
        return timesFlagged;
    }

    public void setTimesFlagged(Integer timesFlagged) {
        this.timesFlagged = timesFlagged;
    }

    @Override
    public String toString() {
        return "Article{" + "articleId=" + articleId + ", title=" + title + ", articleAbstract=" + articleAbstract + ", file=" + file + ", keywords=" + keywords + ", author=" + author + ", verified=" + verified + ", publsihed=" + publsihed + ", citedCount=" + citedCount + ", contributedBy=" + contributedBy + ", verifiedBy=" + verifiedBy + ", timesFlagged=" + timesFlagged + '}';
    }
    
     
    
    
    
    
}
