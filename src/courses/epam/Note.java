package courses.epam;

import java.util.Date;

public class Note {
    private int id;
    private final String DEFAULT_HEADER = "Default";
    private final String DEFAULT_NOTE_RECORD = "";
    private String header;
    private String noteRecord;
    private Date creationTime;

    public Note(int id) {
        this.id = id;
        creationTime = new Date();
    }

    public Note(String noteRecord, int id) {
        this(id);
        this.noteRecord = noteRecord;
    }

    public Note(int id, String header, String noteRecord) {
        this(noteRecord, id);
        this.header = header;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setNoteRecord(String noteRecord) {
        this.noteRecord = noteRecord;
    }

    public String getNoteRecord() {
        return noteRecord;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(header);
        result.append('\n');
        result.append(noteRecord);
        result.append('\n');
        result.append("Date of creation:");
        result.append(creationTime);
        return  result.toString();
    }


    public void showCreationTime() {
        System.out.println(creationTime);
    }
}
