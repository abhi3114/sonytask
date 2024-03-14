package org.sonytask.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import javax.persistence.*;
import java.util.List;

@Entity
public class Episode {

    @Id
    @Column(name = "episode_number")
    @NotNull(message = "Episode number is required")
    private Long episodeNumber;

    @Column(name = "show")
    @NotBlank(message = "Show name is required")
    private String show;

    @Column(name = "channel")
    @NotBlank(message = "Channel name is required")
    private String channel;

    @Column(name = "review_date")
    @NotBlank(message = "Review date is required")
    @Pattern(regexp = "\\d{2}-\\w{3}-\\d{4} \\d{2}:\\d{2}:\\d{2}", message = "Review date must be in the format dd-MMM-yyyy HH:mm:ss")
    private String reviewDate;

    @Column(name = "status")
    @NotBlank(message = "Status is required")
    private String status;

    // @OneToMany(mappedBy = "episode", cascade = CascadeType.ALL)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "episode", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ComplianceItem> complianceItems;

    //Constructor
    public Episode() {
    }

    public Episode(Long episodeNumber, String show, String channel, String reviewDate, String status, List<ComplianceItem> complianceItems) {
        super();
        this.episodeNumber = episodeNumber;
        this.show = show;
        this.channel = channel;
        this.reviewDate = reviewDate;
        this.status = status;
        this.complianceItems = complianceItems;
    }

    // Getters and setters

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }


    public Long getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Long episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ComplianceItem> getComplianceItems() {
        return complianceItems;
    }

    public void setComplianceItems(List<ComplianceItem> complianceItems) {
        this.complianceItems = complianceItems;
    }

    @Override
    public String toString() {
        return "Episode{" + "episodeNumber=" + episodeNumber + ", show='" + show + '\'' + ", channel='" + channel + '\'' + ", reviewDate='" + reviewDate + '\'' + ", status='" + status + '\'' + ", complianceItems=" + complianceItems + '}';
    }
}
