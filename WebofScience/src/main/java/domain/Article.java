/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.Date;

/**
 *
 * @author sarahaverill
 */
public class Article {

    private Integer articleId;
    private String title;
    private String articleAbstract;
    //private byte[] filee;
    //private String filee;
    private String keywords;
    private String author;
    private Boolean verified;
    private Boolean publsihed;
    private Integer citedCount;
    private String contributedBy;
    private String verifiedBy;
    private Integer timesFlagged;
    private Date date;
    private byte[] data;
    //private String mediaType;
    

    public Article() {
    }

    public Article(Integer articleId, String title, String articleAbstract, byte[] data, String keywords, String author, Boolean verified, Boolean publsihed, Integer citedCount, String contributedBy, String verifiedBy, Integer timesFlagged, Date date) {
        this.articleId = articleId;
        this.title = title;
        this.articleAbstract = articleAbstract;
//        this.data = data;
        this.keywords = keywords;
        this.author = author;
        this.verified = verified;
        this.publsihed = publsihed;
        this.citedCount = citedCount;
        this.contributedBy = contributedBy;
        this.verifiedBy = verifiedBy;
        this.timesFlagged = timesFlagged;
        this.date = date;
        //this.filee = filee;
//        
//        this.mediaType = mediaType;
        //loadFile(filee);
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

//    public String getFile() {
//        return filee;
//    }
//
//    public void setFile(String filee) {
//        this.filee = filee;
//    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
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

    public Date getDate() {
        return date;
    }
    /*
    * sets the date variable to the parameter
    *
    *@param date is the current date
    */
    public void setDate(Date date) {
        this.date = date;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

//    public String getMediaType() {
//        return mediaType;
//    }
//
//    public void setMediaType(String mediaType) {
//        this.mediaType = mediaType;
//    }
    

    @Override
    public String toString() {
        return "Article{" + "articleId=" + articleId + ", title=" + title + ", articleAbstract=" + articleAbstract +/* ", filee=" + filee +*/ ", keywords=" + keywords + ", author=" + author + ", verified=" + verified + ", publsihed=" + publsihed + ", citedCount=" + citedCount + ", contributedBy=" + contributedBy + ", verifiedBy=" + verifiedBy + ", timesFlagged=" + timesFlagged + ", date=" + date +  ", data=" + data + '}';
    }

    public Article getArticleId(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public void loadFile(String path) {
//        try {
//            File file = new File(path);
//            this.data  = Files.readAllBytes(file.toPath());
//                    
////            Long fileLength = file.length();
////            ByteBuffer buff = ByteBuffer.allocate(fileLength.intValue());
////            try (
////                     RandomAccessFile raf = new RandomAccessFile(file, "r");  FileChannel channel = raf.getChannel();) {
////                channel.read(buff);
////                buff.flip();
//                this.mediaType = URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(this.data));
//              //  this.data = buff.array();
//           // }
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }

}
