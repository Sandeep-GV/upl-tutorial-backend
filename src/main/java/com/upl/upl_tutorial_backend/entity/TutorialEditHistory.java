package com.upl.upl_tutorial_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tutorial_edit_history")
public class TutorialEditHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Long historyId;

    @Column(name = "tutorial_id")
    private Long tutorialId;

    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "old_title")
    private String oldTitle;

    @Column(name = "new_title")
    private String newTitle;

    @Column(name = "old_content", columnDefinition = "TEXT")
    private String oldContent;

    @Column(name = "new_content", columnDefinition = "TEXT")
    private String newContent;

    @Column(name = "old_youtube_link")
    private String oldYoutubeLink;

    @Column(name = "new_youtube_link")
    private String newYoutubeLink;

    @Column(name = "changed_by")
    private Integer changedBy;

    @Column(name = "changed_at")
    private LocalDateTime changedAt;

    public TutorialEditHistory() {
    }

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public Long getTutorialId() {
        return tutorialId;
    }

    public void setTutorialId(Long tutorialId) {
        this.tutorialId = tutorialId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getOldTitle() {
        return oldTitle;
    }

    public void setOldTitle(String oldTitle) {
        this.oldTitle = oldTitle;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getOldContent() {
        return oldContent;
    }

    public void setOldContent(String oldContent) {
        this.oldContent = oldContent;
    }

    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent;
    }

    public String getOldYoutubeLink() {
        return oldYoutubeLink;
    }

    public void setOldYoutubeLink(String oldYoutubeLink) {
        this.oldYoutubeLink = oldYoutubeLink;
    }

    public String getNewYoutubeLink() {
        return newYoutubeLink;
    }

    public void setNewYoutubeLink(String newYoutubeLink) {
        this.newYoutubeLink = newYoutubeLink;
    }

    public Integer getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(Integer changedBy) {
        this.changedBy = changedBy;
    }

    public LocalDateTime getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(LocalDateTime changedAt) {
        this.changedAt = changedAt;
    }

    @PrePersist
    public void prePersist() {
        this.changedAt = LocalDateTime.now();
    }
}