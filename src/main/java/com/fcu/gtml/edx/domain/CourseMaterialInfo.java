package com.fcu.gtml.edx.domain;

import java.util.Date;

public class CourseMaterialInfo extends Entity {

    private static final long serialVersionUID = 1L;
    private String displayName;
    private String videoCode;
    private String liveBroadcastContent;
    private String channelTitle;
    private String videoTitle;
    private String videoDescript;
    private int videoTime;
    private Date startDate;
    private String endDate;
    private String courseId;
    private String org;
    private String dimension;
    private String definition;
    private boolean caption;
    private boolean licensedContent;
    private String projection;
    private int viewCount;
    private int likeCount;
    private int dislikeCount;
    private int commentCount;

    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public String getVideoCode() {
        return videoCode;
    }
    public void setVideoCode(String videoCode) {
        this.videoCode = videoCode;
    }
    public String getLiveBroadcastContent() {
        return liveBroadcastContent;
    }
    public void setLiveBroadcastContent(String liveBroadcastContent) {
        this.liveBroadcastContent = liveBroadcastContent;
    }
    public String getChannelTitle() {
        return channelTitle;
    }
    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }
    public String getVideoTitle() {
        return videoTitle;
    }
    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }
    public String getVideoDescript() {
        return videoDescript;
    }
    public void setVideoDescript(String videoDescript) {
        this.videoDescript = videoDescript;
    }
    public int getVideoTime() {
        return videoTime;
    }
    public void setVideoTime(int videoTime) {
        this.videoTime = videoTime;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public String getOrg() {
        return org;
    }
    public void setOrg(String org) {
        this.org = org;
    }
    public String getDimension() {
        return dimension;
    }
    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
    public String getDefinition() {
        return definition;
    }
    public void setDefinition(String definition) {
        this.definition = definition;
    }
    public boolean isCaption() {
        return caption;
    }
    public void setCaption(boolean caption) {
        this.caption = caption;
    }
    public boolean isLicensedContent() {
        return licensedContent;
    }
    public void setLicensedContent(boolean licensedContent) {
        this.licensedContent = licensedContent;
    }
    public String getProjection() {
        return projection;
    }
    public void setProjection(String projection) {
        this.projection = projection;
    }
    public int getViewCount() {
        return viewCount;
    }
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
    public int getLikeCount() {
        return likeCount;
    }
    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
    public int getDislikeCount() {
        return dislikeCount;
    }
    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }
    public int getCommentCount() {
        return commentCount;
    }
    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    
}
