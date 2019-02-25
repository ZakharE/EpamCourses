package courses.epam;

import java.util.Date;

public class Note {
    private String noteRecord = "";
    private int id;
    private Date creationTime;

    public Note(int id) {
        this.id = id;
        creationTime = new Date();
    }

    public void setId(int id) {
        this.id = id;
    }

    public Note(String noteRecord, int id) {
        this.noteRecord = noteRecord;
        this.id = id;
        creationTime = new Date();
    }

    @Override
    public String toString() {
        return noteRecord + '\'' +
                "Date of creation:" + creationTime;
    }


    public void showCreationTime() {
        System.out.println(creationTime);
    }
}
