import org.apache.commons.lang3.*;
import static org.apache.commons.lang3.Validate.*;
import static org.apache.commons.lang3.StringUtils.*;
public class Section {
    private final String sectionId;

    Section(String sectionId){
        isBlank(sectionId);
        isTrue(isAlphanumeric(sectionId),
                "sectionID must be alphanumeric, was: " + sectionId);

        this.sectionId = sectionId;
    }
    void enlist(SectionnewSection){
        ...other validation...
        currentSections.forEach(currSection ->{
            if(currSection.getSchedule().getDays().equals(
                    newSection.getSchedule().getDays())&&
                    (currSection.getSchedule().getStartTime().isBefore(
                            newSection.getSchedule().getEndTime())||
                            currSection.getSchedule().getEndTime().isAfter(
                                    newSection.getSchedule().getStartTime()))){thrownewRuntimeException(...error message...);
            }
        });
        ...main body...
    }

    @Override
    public String toString () {
        return sectionId;
    }

    @Override
    public boolean equals (Object o){

    }

}
