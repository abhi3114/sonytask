package org.sonytask.Clasess;

import org.sonytask.Entity.Episode;

import java.util.List;

public class ListEpisodeResponse {

    List<Episode> episodeList;
    String message;

    public ListEpisodeResponse(List<Episode> episodeList, String message) {
        this.episodeList = episodeList;
        this.message = message;
    }

    public List<Episode> getEpisodeList() {
        return episodeList;
    }


    public void setEpisodeList(List<Episode> episodeList) {
        this.episodeList = episodeList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
