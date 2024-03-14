package org.sonytask.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class ComplianceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "episode_id")
    @JsonBackReference
    private Episode episode;

    @Column(name = "timecode_in")
    @NotBlank(message = "Timecode-IN  is required")
    @Pattern(regexp = "\\d{2}:\\d{2}:\\d{2}", message = "Timecode in must be in the format HH:mm:ss")
    private String timecodeIn;
    @Column(name = "timecode_out")
    @NotBlank(message = "Timecode out is required")
    @Pattern(regexp = "\\d{2}:\\d{2}:\\d{2}", message = "Timecode out must be in the format HH:mm:ss")
    private String timecodeOut;

    @Column(name = "comment")
    private String comment;

    @Column(name = "category_name")
    //@NotBlank(message = "Category name is required")
    private String categoryName;

    //Constructor
    public ComplianceItem() {
    }

    public ComplianceItem(Long id, Episode episode, String timecodeIn, String timecodeOut, String comment, String categoryName) {
        super();
        this.id = id;
        this.episode = episode;
        this.timecodeIn = timecodeIn;
        this.timecodeOut = timecodeOut;
        this.comment = comment;
        this.categoryName = categoryName;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    public String getTimecodeIn() {
        return timecodeIn;
    }

    public void setTimecodeIn(String timecodeIn) {
        this.timecodeIn = timecodeIn;
    }

    public String getTimecodeOut() {
        return timecodeOut;
    }

    public void setTimecodeOut(String timecodeOut) {
        this.timecodeOut = timecodeOut;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ComplianceItem{" + "id=" + id + ", episode=" + episode + ", timecodeIn='" + timecodeIn + '\'' + ", timecodeOut='" + timecodeOut + '\'' + ", comment='" + comment + '\'' + ", categoryName='" + categoryName + '\'' + '}';
    }
}

