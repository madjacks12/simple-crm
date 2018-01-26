package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Notes extends Client {

    private String writtenBy;
    private String content;
    private long createdAt;
    private int id;

    public Notes(String name, String phone, String email) {
        super(name, phone, email);
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

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
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
