import courses.epam.Note;
import courses.epam.NoteBook;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NoteBookTest {
    private NoteBook nb = new NoteBook();
    private int NBlen;
    private int initialArrayLength;

    @BeforeEach
    public void setNb() {
        nb.addNote("At before");
        nb.editHeader(0, "NEW HEADER");
        NBlen = nb.getNotesNumber();
        initialArrayLength = nb.getArraySize();
    }

    @Test
    public void addNoteLastAvailableIDShouldIncrease() {
        nb.addNote("asd");
        nb.showAllNote();
        assertEquals(1, nb.getNotesNumber());
    }

    @Test
    public void deleteNoteWithWrongIdShouldNotChangeNotesNumber(){
        nb.deleteNote(23);
        assertEquals(NBlen, nb.getNotesNumber());
    }

    @Test
    void deleteNoteWithValidIdShouldReturnLengthMinusOne() {
        nb.deleteNote(0);
        assertEquals(NBlen-1, nb.getNotesNumber());
    }

    @Test
    void arrayLengthOverflowShouldReturnDefaultLengthTimesTwo () {
        for (int i = 0; i < 10; i++) {
            nb.addNote("Number + " + i);
        }
        assertEquals(initialArrayLength*2, nb.getArraySize());

    }

    @Test
    void shrinkingArrayShouldReturnSmallerArraySize() {
        for (int i = 0; i < 15; i++) {
            nb.addNote("Number + " + i);
        }
        int lenBefore = nb.getArraySize();

        for (int i = nb.getNotesNumber()-1; i > 4; i--) {
            nb.deleteNote(i);
        }
        int lenAfter = nb.getArraySize();
        assertTrue(lenAfter < lenBefore);
    }




}
