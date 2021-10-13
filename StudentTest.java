import java.util.concurrent.CountDownLatch;

public class StudentTest {



    @Test
    void enlist_in_section_to_overcapacity(){
        Section section = new Section ("A", new Room("X", 1));
        Student student1 = new Student(1);
        Student student2 = new Student(2);

        student1.enlist(section);
        assertThrows(SectionCapacityExcepetion.class, () -> student2.enlist(section));
    }

    @Test
    void enlist_concurrent_almost_full_section() throws Exception{
        for (int i=0; i < 20; i++){
            Student student1= new Student(1);
            Student student2= new Student(2);
            Student student3= new Student(3);
            Student student4= new Student(4);
            Student student5= new Student(5);
            Section section = new Section("X", new Room("Y",1));

            CountDownLatch latch = new CountDownLatch(1);
            new EnlistmentThread(student1, section, latch).start();
            new EnlistmentThread(student2, section, latch).start();
            new EnlistmentThread(student3, section, latch).start();
            new EnlistmentThread(student4, section, latch).start();
            new EnlistmentThread(student5, section, latch).start();
            latch.countDown();
            Thread.sleep(100);
            assertEquals(1, section.getNumStudentsEnlisted());
        }
    }
}
