package courses.epam;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Note n = new Note(1);
        NoteBook nb = new NoteBook();
//        for (int i = 0; i < 10; i++) {
//            nb.addNote("Number: " + i);
//        }
//
//        for (int i = 9; i > 5; i--) {
//            nb.deleteNote(i);
//        }

//        nb.deleteNote(3);
        nb.addNote("asd");
        nb.deleteNote(23);
        System.out.println(nb.getSize());
        nb.showAllNote();

    }
}
