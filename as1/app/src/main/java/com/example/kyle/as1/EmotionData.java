package com.example.kyle.as1;

import java.io.Serializable;
import java.util.Date;

// this class save the type of emotion
//the date saved
// and the comment associated with it
public class EmotionData implements Serializable {

        String emotion;
        Date savedTime;
        String comment;


    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public Date getSavedTime() {
        return savedTime;
    }

    public void setSavedTime(Date savedTime) {
        this.savedTime = savedTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
