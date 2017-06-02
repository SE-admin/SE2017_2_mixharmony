package se.smu;

public class Todo_Dto {
	private String itemname;
	//private String deadline;
	private String deadliney;
	private String deadlinem;
	private String deadlined;
	private String deadline_ampm;
	private String deadlinet;
	//private String rdeadline;
	private String rdeadliney;
	private String rdeadlinem;
	private String rdeadlined;
	private String rdeadline_ampm;
	private String rdeadlinet;
	private String importance;
	private String comment;
	private String subject;
	private String complete;
	
	
	public String getItemname() {
		return itemname;
	}


	public void setItemname(String itemname) {
		this.itemname = itemname;
	}


	//public String getDeadline() {
	//	return deadline;
	//}


	//public void setDeadline(String deadline) {
	//	this.deadline = deadline;
	//}

	public String getDeadliney() {
		return deadlinem;
	}


	public void setDeadliney(String deadliney) {
		this.deadliney = deadliney;
	}
	
	public String getDeadlinem() {
		return deadlinem;
	}


	public void setDeadlinem(String deadlinem) {
		this.deadlinem = deadlinem;
	}
	
	
	public String getDeadlined() {
		return deadlined;
	}


	public void setDeadlined(String deadlined) {
		this.deadlined = deadlined;
	}
	
	public String getDeadline_ampm() {
		return deadline_ampm;
	}


	public void setDeadline_ampm(String deadline_ampm) {
		this.deadline_ampm = deadline_ampm;
	}
	
	public String getDeadlinet() {
		return deadlinet;
	}


	public void setDeadlinet(String deadlinet) {
		this.deadlinet = deadlinet;
	}
	

	//public String getRdeadline() {
	//	return rdeadline;
	//}


	//public void setRdeadline(String rdeadline) {
	//	this.rdeadline = rdeadline;
	//}

	
	public String getRdeadliney() {
		return deadlinem;
	}


	public void setRdeadliney(String rdeadliney) {
		this.rdeadliney = rdeadliney;
	}
	
	
	public String getRdeadlinem() {
		return rdeadlinem;
	}


	public void setRdeadlinem(String rdeadlinem) {
		this.rdeadlinem = rdeadlinem;
	}
	
	public String getRdeadline_ampm() {
		return rdeadline_ampm;
	}


	public void setRdeadline_ampm(String rdeadline_ampm) {
		this.rdeadline_ampm = rdeadline_ampm;
	}
	
	public String getRdeadlined() {
		return rdeadlined;
	}


	public void setRdeadlined(String rdeadlined) {
		this.rdeadlined = rdeadlined;
	}
	
	public String getRdeadlinet() {
		return rdeadlinet;
	}


	public void setRdeadlinet(String rdeadlinet) {
		this.rdeadlinet = rdeadlinet;
	}

	
	public String getImportance() {
		return importance;
	}


	public void setImportance(String importance) {
		this.importance = importance;
	}
	

	public String getComment() {
		return itemname;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getComplete() {
		return complete;
	}


	public void setComplete(String complete) {
		this.complete = complete;
	}

	public String toString(){
		return "TodoDTO [itemname=" + itemname
				+ ", deadliney=" + deadliney + ", deadlinem=" + deadlinem + ", deadlined=" + deadlined
				+ "deadline_ampm=" + deadline_ampm + ", deadlinet=" + deadlinet
				+ ", rdeadliney=" + rdeadliney + ", rdeadlinem=" + rdeadlinem + ", rdeadlined=" + rdeadlined
				+ "rdeadline_ampm=" + rdeadline_ampm + ", rdeadlinet=" + rdeadlinet
                + ", importance=" + importance + ", subject=" + subject + ", complete=" + complete + "]";
	}
	
	
}