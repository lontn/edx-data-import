package com.fcu.gtml.edx.service;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.print.attribute.standard.RequestingUserName;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fcu.gtml.edx.domain.YoutuBe;
import com.fcu.gtml.edx.utils.Arithmetic;
import com.fcu.gtml.edx.utils.Configuration;

@Service
public class YoutubeAPIServiceImpl implements YoutubeAPIService {
    private static final Logger L = LogManager.getLogger();
    private ObjectMapper mapper = new ObjectMapper();
    private Client client = ClientBuilder.newClient();
    private static final String pattern = "^P(?:(\\d{1,2})D)?T(?:(\\d{1,2})H)?(?:(\\d{1,2})M)?(?:(\\d{1,2})S)?";

    @Override
    public YoutuBe getYoutubeAPI(String videoCode) {
        int retry = 0;
        String apiUrl = Configuration.YoutubeAPI.getURL() + "id=" + videoCode + "&key=" + Configuration.YoutubeAPI.getPrivateKey() + "&part=" + Configuration.YoutubeAPI.getPart();
        boolean isSuccess = true;
        YoutuBe youtuBe = new YoutuBe();
        while (isSuccess) {
            String resultAPI = getYoutubeResult(apiUrl);
            if (resultAPI != null) {
                try {
                    JsonNode nodes = mapper.readTree(resultAPI);
                    JsonNode nodeItems = nodes.get("items");
                    for (JsonNode itemNode : nodeItems) {
                        String code = itemNode.get("id").asText();
                        youtuBe.setViedoCode(code);
                        String title = itemNode.get("snippet").get("title").asText();
                        youtuBe.setVideoTitle(title);
                        String description = itemNode.get("snippet").get("description").asText();
                        youtuBe.setVidoeDescription(description);
                        String channelTitle = itemNode.get("snippet").get("channelTitle").asText();
                        youtuBe.setChannelTitle(channelTitle);
                        String liveBroadcastContent = itemNode.get("snippet").get("liveBroadcastContent").asText();
                        youtuBe.setLiveBroadcastContent(liveBroadcastContent);
                        String duration = itemNode.get("contentDetails").get("duration").asText();
                        youtuBe.setVideoTime(calculateVedioTime(duration));
                        String dimension = itemNode.get("contentDetails").get("dimension").asText();
                        youtuBe.setDimension(dimension);
                        String definition = itemNode.get("contentDetails").get("definition").asText();
                        youtuBe.setDefinition(definition);
                        boolean caption = itemNode.get("contentDetails").get("caption").asBoolean();
                        youtuBe.setCaption(caption);
                        boolean licensedContent = itemNode.get("contentDetails").get("licensedContent").asBoolean();
                        youtuBe.setLicensedContent(licensedContent);
                        String projection = itemNode.get("contentDetails").get("projection").asText();
                        youtuBe.setProjection(projection);
                        int viewCount = itemNode.get("statistics").get("viewCount").asInt();
                        youtuBe.setViewCount(viewCount);
                        int likeCount = itemNode.get("statistics").get("likeCount").asInt();
                        youtuBe.setLikeCount(likeCount);
                        int dislikeCount = itemNode.get("statistics").get("dislikeCount").asInt();
                        youtuBe.setDislikeCount(dislikeCount);
                        int commentCount = itemNode.get("statistics").get("commentCount").asInt();
                        youtuBe.setCommentCount(commentCount);
                    }
                    return youtuBe;
                } catch (IOException e) {
                    L.error("getYoutubeAPI IOException:{}", e);
                }
            }
            if (retry >= 2) {
                L.error("videoCode:{}, apiUrl:{}", videoCode, apiUrl);
                isSuccess = false;
            }
            retry++;
        }
        return null;
    }

    private int calculateVedioTime(String duration) {
        int time = 0;
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(duration);
        Arithmetic timeSum = new Arithmetic(time);
        Arithmetic timeDay = new Arithmetic(time);
        Arithmetic timeHour = new Arithmetic(time);
        Arithmetic timeMin = new Arithmetic(time);
        Arithmetic timeSec = new Arithmetic(time);
        if (m.find()) {
            if (m.group(1) != null) {
                int day = Integer.valueOf(m.group(1));
                timeDay.add(day).mul(24).mul(60).mul(60);
            }
            if (m.group(2) != null) {
                int hour = Integer.valueOf(m.group(2));
                timeHour.add(hour).mul(60).mul(60);
            }
            if (m.group(3) != null) {
                int min = Integer.valueOf(m.group(3));
                timeMin.add(min).mul(60);
            }
            if (m.group(4) != null) {
                int sec = Integer.valueOf(m.group(4));
                timeSec.add(sec);
            }
            timeSum.add(timeDay.intValue()).add(timeHour.intValue()).add(timeMin.intValue()).add(timeSec.intValue());
            return timeSum.intValue();
        } else {
            L.info("NO MATCH duration");
        }
        return time;
    }

    private String getYoutubeResult(String apiUrl) {
        String result = null;
        try {
            WebTarget target = client.target(apiUrl);
            Response response = target.request().get();
            result = response.readEntity(String.class).trim();
        } catch (Exception e) {
            result = null;
            L.error("getYoutubeResult:{}", e);
        }
        return result; 
    }
}
