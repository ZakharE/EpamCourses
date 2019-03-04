package courses.epam;

import java.util.Arrays;

public class NoteBook {
    private Note[] notes = new Note[10];
    private static int lastAvaliableNoteId = -1;


    public void addNote(String noteRecord) {
        if(lastAvaliableNoteId == notes.length - 1) {
            notes = changeArraySize(notes, true);
        }
        ++lastAvaliableNoteId;
        notes[lastAvaliableNoteId] = new Note(noteRecord, lastAvaliableNoteId);
    }

    public void deleteNote(int id) {
        if(isValidID(id)) {
            for (int i = id; i < lastAvaliableNoteId ; i++) {
                notes[i] = notes[i+1];
                notes[i].setId(i);
            }
            --lastAvaliableNoteId;
        } else
    {
        System.out.println("Not available ID");
    }
        if(lastAvaliableNoteId <= notes.length/4) {
            notes = changeArraySize(notes, false);
        }


    }

    public void editHeader(int id, String newHeader) {
        notes[id].setHeader(newHeader);
    }

    public void removeFromNote(int id, String remove) {
        String record = notes[id].getNoteRecord();
        record = record.replaceAll("\\b" + remove + "\\b","");
        notes[id].setNoteRecord(record);
    }

    public void addToNote(int id, String addition) {
        String newRecord = notes[id].getNoteRecord() + " " + addition;
        notes[id].setNoteRecord(newRecord);
    }

    public int getNotesNumber(){
        return lastAvaliableNoteId;
    }

    public void showAllNote() {
        for (int i = 0; i <= lastAvaliableNoteId ; i++) {
            System.out.println(notes[i].toString());
        }

    }

    private Note[] changeArraySize(Note[] notes, boolean isIncreasing) {
        Note[] newNote;

        if(isIncreasing) {
            newNote = Arrays.copyOf(notes, notes.length*2);
        } else {
            newNote = Arrays.copyOf(notes, notes.length / 2);
        }
        return newNote;
    }

    private boolean isValidID(int id) {
        if(id < 0 || id > lastAvaliableNoteId) {
            System.out.println("This ID not found");
            return false;
        }
        return true;
    }
}
