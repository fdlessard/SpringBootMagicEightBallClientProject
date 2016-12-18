package io.fdlessard.codebites.magiceightball.client.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by fdlessard on 16-12-05.
 */
public class MagicEightBallAnswer implements Serializable {

    private String id;

    private String message;

    private String color;

    public MagicEightBallAnswer() {
        // Needed by Jackson
    }

    public MagicEightBallAnswer(String id, String message, String color) {
        this.id = id;
        this.message = message;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("message", message)
                .append("color", color)
                .toString();
    }
}
