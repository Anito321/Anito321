import java.util.Collection;
import java.util.Collections;

public class Room {

    private final String name;
    private final int capacity;
    private final Collection<Section> sections = new hashSet<>();

    Room(String name) {this (name, capacity, Collections.emptyList()); }

    Room(String name, int capacity, Collections<Section> sections){
        notBlank (name, "name cannot be blank or null");
        isTrue(isAlphanumeric(name),"sectionID must be alphanumeric, was +" + name);
        isTrue(capacity > 0, "capacity must be greater than 0, was: " + capacity);
        this.name = name;
        this.capacity = capacity;
        this.sections = addAll(sections);
        this.sections.remove(null);
    }

    void reserve(Section newSection){
        sections.forEach(currSection) -> {
            if (currSection.hasScheduleConflict(newSection)){
                throw new ScheduleConflictException("New section" + newSection +
                        " has a schedule conflict with current section" +currSection + " for room " + this);
            }
        }
        sections.add(newSection);
    }

    void checkCapacity(int occupancy) {
        if (occupancy >= capacity){
            throw new SectionCapacityException(
                    "occupancy of " + occupancy + " is at or exceeds capacity of " + capacity);

        }
    }
}
