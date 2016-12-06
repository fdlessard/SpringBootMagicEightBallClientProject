package io.fdlessard.codebites.magiceightball.client.domain;

import java.io.Serializable;

/**
 * Created by fdlessard on 16-12-05.
 */
public class MagicEightBallAnswer implements Serializable {

    private String id;

    private String message;

    public MagicEightBallAnswer() {
        //
    }

    public MagicEightBallAnswer(String id, String message) {
        this.id = id;
        this.message = message;
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

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("message", message)
                .toString();
    }
}
