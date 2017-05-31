package se.smu;

public class Todo_Dto {
	private String itemname;
	private String deadline;
	private String rdeadline;
	private String importance;
	private String complete;
	private String subject;
	
	
	
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
	
	public String getcomplete() {
		return complete;
	}


	public void setcomplete(String complete) {
		this.complete = complete;
	}

	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String toString(){
		return "TodoDTO [itemname=" + itemname + ", deadline=" + deadline + ", rdeadline=" + rdeadline
                + ", importance=" + importance + ", subject=" + subject + "]";
	}
	
	
}