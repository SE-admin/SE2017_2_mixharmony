package se.smu;

public class TodoDTO {
	private String itemname;
	private String deadline;
	private String rdeadline;
	private String importance;
	private String comment;
	
	
	public String getItemname() {
		return itemname;
	}


	public void setItemname(String itemname) {
		this.itemname = itemname;
	}


	public String getDeadline() {
		return deadline;
	}


	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}


	public String getRdeadline() {
		return rdeadline;
	}


	public void setRdeadline(String rdeadline) {
		this.rdeadline = rdeadline;
	}


	public String getImportance() {
		return importance;
	}


	public void setImportance(String importance) {
		this.importance = importance;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public String toString(){
		return "TodoDTO [itemname=" + itemname + ", deadline=" + deadline + ", rdeadline=" + rdeadline
                + ", importance=" + importance + ", comment=" + comment + "]";
	}
	
	
}