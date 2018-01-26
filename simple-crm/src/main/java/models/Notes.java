package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Notes extends Client {

    private String writtenBy;
    private String content;
    private long createdAt;

    public Notes(String name, String phone, String email, int id) {
        super(name, phone, email, id);
        this.writtenBy = writtenBy;
        this.content = content;
        this.createdAt = System.currentTimeMillis();
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

    public String getFormattedCreatedAt(){
        Date date = new Date(createdAt);
        String datePatternToUse = "MM/dd/yyyy @ K:mm a"; //see https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
        SimpleDateFormat sdf = new SimpleDateFormat(datePatternToUse);
        return sdf.format(date);
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = System.currentTimeMillis();
    }
}
