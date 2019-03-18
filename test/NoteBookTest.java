import courses.epam.NoteBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NoteBookTest {
    private NoteBook noteBook = new NoteBook();
    private int noteBookLength;
    private int initialArrayLength;

    @BeforeEach
    public void setNoteBook() {
        noteBook.addNote("At before");
        noteBook.editHeader(0, "NEW HEADER");
        noteBookLength = noteBook.getSize();
        initialArrayLength = noteBook.getNoteBookCapacity();
    }

    @Test
    public void addNoteLastAvailableIDShouldIncrease() {
        noteBook.addNote("asd");
        noteBook.showAllNote();
        assertEquals(2, noteBook.getSize());
    }

    @Test
    public void deleteNoteWithWrongIdShouldNotChangeNotesNumber(){
        noteBook.deleteNote(23);
        assertEquals(noteBookLength, noteBook.getSize());
    }

    @Test
    void deleteNoteWithValidIdShouldReturnLengthMinusOne() {
        noteBook.deleteNote(0);
        assertEquals(noteBookLength -1, noteBook.getSize());
    }

    @Test
    void arrayLengthOverflowShouldReturnDefaultLengthTimesTwo () {
        for (int i = 0; i < 10; i++) {
            noteBook.addNote("Number + " + i);
        }
        assertEquals(initialArrayLength*2, noteBook.getNoteBookCapacity());

    }

    @Test
    void shrinkingArrayShouldReturnSmallerArraySize() {
        for (int i = 0; i < 15; i++) {
            noteBook.addNote("Number + " + i);
        }
        int lenBefore = noteBook.getNoteBookCapacity();

        for (int i = noteBook.getSize()-1; i > 4; i--) {
            noteBook.deleteNote(i);
        }
        int lenAfter = noteBook.getNoteBookCapacity();
        assertTrue(lenAfter < lenBefore);
    }
}
