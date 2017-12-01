package com.fcu.gtml.edx.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="modulestore")
public class Modulestore extends TheData {

    @Field("_id") private CourseInfo courseInfo;
    @Field("metadata") private Metadata metadata;

    public CourseInfo getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(CourseInfo courseInfo) {
        this.courseInfo = courseInfo;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public static class CourseInfo extends TheData {
        @Field("tag") private String tag;
        @Field("org") private String org;
        @Field("course") private String course;
        @Field("category") private String category;
        @Field("name") private String name;
        @Field("revision") private String revision;
        
        public String getTag() {
            return tag;
        }
        public void setTag(String tag) {
            this.tag = tag;
        }
        public String getOrg() {
            return org;
        }
        public void setOrg(String org) {
            this.org = org;
        }
        public String getCourse() {
            return course;
        }
        public void setCourse(String course) {
            this.course = course;
        }
        public String getCategory() {
            return category;
        }
        public void setCategory(String category) {
            this.category = category;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getRevision() {
            return revision;
        }
        public void setRevision(String revision) {
            this.revision = revision;
        }
    }
    
    public static class Metadata extends TheData {
        @Field("display_name") private String displayName;
        @Field("youtube_id_1_0") private String youtubeCode;
        @Field("download_video") private boolean downloadVideo;

        public String getDisplayName() {
            return displayName;
        }
        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }
        public String getYoutubeCode() {
            return youtubeCode;
        }
        public void setYoutubeCode(String youtubeCode) {
            this.youtubeCode = youtubeCode;
        }
        public boolean isDownloadVideo() {
            return downloadVideo;
        }
        public void setDownloadVideo(boolean downloadVideo) {
            this.downloadVideo = downloadVideo;
        }
        
    }
}
