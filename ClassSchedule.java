public class ClassSchedule {
    private final Schedule schedule;
    private final Days days;
    private final Time startTime;
    private final Time endTime;


    void checkSkedOverlap(Section other){
        if (this.shcedule.getDays(.equals(otther.shcedule.getDays()))&&
        (this.schedule).getStartTime().isBefore(other.schedule.getEndTime())||
                this.schedule.getEndTime().isAfter(
                        other.schedule.getStartTime()))){
                        thrownewRuntimeException(...error message...);
        }
    }
}
