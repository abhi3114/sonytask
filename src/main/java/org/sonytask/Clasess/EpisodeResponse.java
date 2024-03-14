package org.sonytask.Clasess;

import org.sonytask.Entity.Episode;

import java.util.Optional;

public class EpisodeResponse {

    private Optional<Episode>  episode;
    private String message;

    public EpisodeResponse(Optional<Episode> episode, String message) {
        this.episode = episode;
        this.message = message;
    }

    public Optional<Episode> getEpisode() {
        return episode;
    }

    public void setEpisode(Optional<Episode> episode) {
        this.episode = episode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
