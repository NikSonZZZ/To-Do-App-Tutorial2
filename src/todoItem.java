public class todoItem {
    private String description;
    private boolean isDone;

    public todoItem(String description){
        this.description = description;
        this.isDone = false;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public boolean GetisDone(){
        return isDone;

    }
    public void setDone(boolean isDone){
        this.isDone = isDone;
    }
}
