package com.fcu.gtml.edx.domain;

/**
 * <table border=1>
 * <tr><th> 欄位  </th><th> 說明  </th></tr>
 * <tr><th>videoCode: </th><th>YouTube用來唯一標識視頻的ID。EX=>9H2KWHmbGA0 (id) </th></tr>
 * <tr><th>liveBroadcastContent: </th><th>指示視頻是即將進行的/正在進行的直播。或者如果視頻不是即將到來的/活動的現場直播，則是"無"。 </th></tr>
 * <tr><th>channelTitle: </th><th>頻道所屬頻道的頻道標題。 </th></tr>
 * <tr><th>videoTitle: </th><th>影片的標題。該屬性值的最大長度為100個字符 (title) </th></tr>
 * <tr><th>vidoeDescription: </th><th>影片的描述 (description) </th></tr>
 * <tr><th>videoTime: </th><th>影片長度 換算成秒 </th></tr>
 * <tr><th>duration: </th><th>影片長度 EX=> PT15M33S </th></tr>
 * <tr><th>dimension: </th><th>影片是2D還是3D EX=>2d,3d </th></tr>
 * <tr><th>definition: </th><th>指示影片是以高清（HD）還是僅在標準清晰度中可用。 EX=>hd,sd </th></tr>
 * <tr><th>caption: </th><th>影片是否有字幕 </th></tr>
 * <tr><th>licensedContent: </th><th>指示影片是否代表許可內容，這意味著內容已上傳到與YouTube內容合作夥伴相關聯的頻道，然後由該合作夥伴聲明。 </th></tr>
 * <tr><th>projection: </th><th>指定視頻的投影格式。 EX=>360, rectangular </th></tr>
 * <tr><th>viewCount: </th><th>影片已被查看的次數。 </th></tr>
 * <tr><th>likeCount: </th><th>已經表示喜歡該影片的用戶數量。 </th></tr>
 * <tr><th>dislikeCount: </th><th>表示不喜歡影片的用戶數量。 </th></tr>
 * <tr><th>commentCount: </th><th>影片的評論數量。 </th></tr>
 * </table>
 * @author lt22
 *
 */
public class YoutuBe extends Entity {

    private static final long serialVersionUID = 1L;
    /**common**/
    private String viedoCode;
    private String liveBroadcastContent;
    private String channelTitle;
    private String videoTitle;
    private String vidoeDescription;
    private int videoTime;
    
    /**contentDetails**/
    private String duration;
    private String dimension;
    private String definition;
    private boolean caption;
    private boolean licensedContent;
    private String projection;
    
    /****statistics***/
    private int viewCount;
    private int likeCount;
    private int dislikeCount;
    private int commentCount;

    public String getViedoCode() {
        return viedoCode;
    }
    public void setViedoCode(String viedoCode) {
        this.viedoCode = viedoCode;
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
    public String getVidoeDescription() {
        return vidoeDescription;
    }
    public void setVidoeDescription(String vidoeDescription) {
        this.vidoeDescription = vidoeDescription;
    }
    public int getVideoTime() {
        return videoTime;
    }
    public void setVideoTime(int videoTime) {
        this.videoTime = videoTime;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
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
