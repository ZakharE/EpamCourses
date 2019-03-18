package courses.epam;

import java.util.Arrays;

public class NoteBook {
    private final int DEFAULT_NOTES_ARRAY_SIZE = 10;
    private Note[] notes;
    private int lastAvailableNoteId = -1;

    public NoteBook() {
        notes = new Note[DEFAULT_NOTES_ARRAY_SIZE];
    }


    public void addNote(String noteRecord) {
        if (lastAvailableNoteId == notes.length - 1) {
            notes = changeArraySize( true);
        }
        ++lastAvailableNoteId;
        notes[lastAvailableNoteId] = new Note(noteRecord, lastAvailableNoteId);
    }
    public int getNoteBookCapacity() {
        return notes.length;
    }
    public void deleteNote(int id) {
        if (!isValidID(id)) {
            return;
        }

        for (int i = id; i < lastAvailableNoteId; i++) {
            notes[i] = notes[i + 1];
            notes[i].setId(i);
        }

        --lastAvailableNoteId;

        if (lastAvailableNoteId <= notes.length / 4 && lastAvailableNoteId > DEFAULT_NOTES_ARRAY_SIZE) {
            notes = changeArraySize(false);
        }


    }

    public void editHeader(int id, String newHeader) {
        if (!isValidID(id)) {
            return;
        }
        notes[id].setHeader(newHeader);
    }

    public void editNoteRecord(int id, String newRecord) {
        if (!isValidID(id)) {
            return;
        }
        notes[id].setNoteRecord(newRecord);
    }

    public void editHeaderAndNoteRecord(int id, String newHeader, String newRecord) {
        if (!isValidID(id)) {
            return;
        }
        notes[id].setHeader(newHeader);
        notes[id].setNoteRecord(newRecord);
    }

    public void addToNote(int id, String addition) {
        if (!isValidID(id)) {
            return;
        }
        String newRecord = notes[id].getNoteRecord() + " " + addition;
        notes[id].setNoteRecord(newRecord);
    }

    public void removeFromNote(int id, String remove) {
        if (!isValidID(id)) {
            return;
        }
        String record = notes[id].getNoteRecord();
        record = record.replaceAll("\\b" + remove + "\\b", "");
        notes[id].setNoteRecord(record);
    }

    public int getSize() {
        return lastAvailableNoteId + 1;
    }

    public void showAllNote() {
        if(lastAvailableNoteId < 0) {
            System.out.println("Sorry. Nothing to show :(");
            return;
        }
        for (int i = 0; i <= lastAvailableNoteId; i++) {
            System.out.println(notes[i]);
        }

    }

    private Note[] changeArraySize(boolean isIncreasing) {
        Note[] newNotes;

        if (isIncreasing) {
            newNotes = Arrays.copyOf(notes, notes.length * 2);
        } else {
            newNotes = Arrays.copyOf(notes, notes.length / 2);
        }
        return newNotes;
    }

    private boolean isValidID(int id) {
        if (id < 0 || id > lastAvailableNoteId) {
            System.out.println("This ID not found");
            return false;
        }
        return true;
    }
}
