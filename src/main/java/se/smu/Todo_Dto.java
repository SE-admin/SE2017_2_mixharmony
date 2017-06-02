package se.smu;

public class Todo_Dto {
	private String itemname;
	//private String deadline;
	private String deadlinem;
	private String deadlined;
	private String deadlinet;
	//private String rdeadline;
	private String rdeadlinem;
	private String rdeadlined;
	private String rdeadlinet;
	private String importance;
	private String complete;
	private String subject;
	
	
	
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

	
	public String getRdeadlinem() {
		return rdeadlinem;
	}


	public void setRdeadlinem(String rdeadlinem) {
		this.rdeadlinem = rdeadlinem;
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
		return "TodoDTO [itemname=" + itemname
				+ ", deadlinem=" + deadlinem + ", deadlined=" + deadlined + ", deadlinet=" + deadlinet
				+ ", rdeadlinem=" + rdeadlinem + ", rdeadlined=" + rdeadlined + ", rdeadlinet=" + rdeadlinet
                + ", importance=" + importance + ", subject=" + subject + "]";
	}
	
	
}