package com.fcu.gtml.edx.domain;

public class CourseMaterialHistory extends Entity {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private int id;
    private int courseMaterialId;
    private int preViewCount;
    private int preLikeCount;
    private int preDislikeCount;
    private int preCommentCount;

    public CourseMaterialHistory() {
    }

    public CourseMaterialHistory(CourseMaterialInfo courseMaterialInfo) {
        this.courseMaterialId = courseMaterialInfo.getId();
        this.preViewCount = courseMaterialInfo.getViewCount();
        this.preLikeCount = courseMaterialInfo.getLikeCount();
        this.preDislikeCount = courseMaterialInfo.getDislikeCount();
        this.preCommentCount = courseMaterialInfo.getCommentCount();
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCourseMaterialId() {
        return courseMaterialId;
    }
    public void setCourseMaterialId(int courseMaterialId) {
        this.courseMaterialId = courseMaterialId;
    }
    public int getPreViewCount() {
        return preViewCount;
    }
    public void setPreViewCount(int preViewCount) {
        this.preViewCount = preViewCount;
    }
    public int getPreLikeCount() {
        return preLikeCount;
    }
    public void setPreLikeCount(int preLikeCount) {
        this.preLikeCount = preLikeCount;
    }
    public int getPreDislikeCount() {
        return preDislikeCount;
    }
    public void setPreDislikeCount(int preDislikeCount) {
        this.preDislikeCount = preDislikeCount;
    }
    public int getPreCommentCount() {
        return preCommentCount;
    }
    public void setPreCommentCount(int preCommentCount) {
        this.preCommentCount = preCommentCount;
    }


}
