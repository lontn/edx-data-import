package com.fcu.gtml.edx.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="modulestore")
public class Modulestore extends TheData {

    @Field("metadata") private Metadata metadata;

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
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
