package courses.epam;

import java.util.Date;

public class Note {
    private int id;
    private String header = "Default";
    private String noteRecord = "";
    private Date creationTime;

    public Note(int id) {
        this.id = id;
        creationTime = new Date();
    }

    public Note(String noteRecord, int id) {
        this.noteRecord = noteRecord;
        this.id = id;
        creationTime = new Date();
    }

    public Note(int id, String header, String noteRecord) {
        this.id = id;
        this.header = header;
        this.noteRecord = noteRecord;
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
        return  header + '\n' +
                noteRecord + '\'' +
                "Date of creation:" + creationTime;
    }


    public void showCreationTime() {
        System.out.println(creationTime);
    }
}
