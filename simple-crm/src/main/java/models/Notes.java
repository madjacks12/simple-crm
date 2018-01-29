package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Notes{

    private String writtenBy;
    private String content;
    private long createdAt;
    private int id;
    private int clientId;

    public Notes(String writtenBy, String content, String createdAt, int clientId) {
        this.writtenBy = writtenBy;
        this.content = content;
        this.createdAt = System.currentTimeMillis();
        this.clientId = clientId;
    }

    public String getWrittenBy() {
        return writtenBy;
    }

    public String getContent() {
        return content;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }

    public String getFormattedCreatedAt(){
        Date date = new Date(createdAt);
        String datePatternToUse = "MM/dd/yyyy @ K:mm a"; //see https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
        SimpleDateFormat sdf = new SimpleDateFormat(datePatternToUse);
        return sdf.format(date);
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = System.currentTimeMillis();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Notes notes = (Notes) o;

        if (createdAt != notes.createdAt) return false;
        if (id != notes.id) return false;
        if (clientId != notes.clientId) return false;
        if (!writtenBy.equals(notes.writtenBy)) return false;
        return content.equals(notes.content);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + writtenBy.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + (int) (createdAt ^ (createdAt >>> 32));
        result = 31 * result + id;
        result = 31 * result + clientId;
        return result;
    }

    public void setId(int id) {
        this.id = id;
    }
}
