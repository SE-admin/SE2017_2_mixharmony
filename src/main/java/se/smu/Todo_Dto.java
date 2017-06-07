package se.smu;

public class Todo_Dto {
	private String itemname;
	private String deadliney;//년도
	private String deadlinem;//월
	private String deadlined;//일
	private String deadline_ampm;//오전오후
	private String deadlinet;//시
	private String rdeadliney;
	private String rdeadlinem;
	private String rdeadlined;
	private String rdeadline_ampm;
	private String rdeadlinet;
	private String importance;//중요도
	private String comment;
	private String subject;
	private String complete;//완료여부
	
	private String deadline;//마감일
	private String rdeadline;//실제 마감일
	
	private String star;//중요도 별
	
	
	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	
	public String getDeadliney() {
		return deadliney;
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
	

	public String getRdeadliney() {
		return rdeadliney;
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
		return comment;
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
	
	//마감일
	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadliney, String deadlinem, String deadlined, String deadline_ampm, String deadlinet) {
		String deadline = deadliney+"년 "+deadlinem+"월 "+deadlined+"일 " + deadline_ampm+" " + deadlinet + "시";
		this.deadline = deadline;
	}
	
	//실제 마감일
	public String getRdeadline() {
		return rdeadline;
	}

	public void setRdeadline(String rdeadliney, String rdeadlinem, String rdeadlined, String rdeadline_ampm, String rdeadlinet) {
		String rdeadline = rdeadliney+"년 "+ rdeadlinem+"월 "+ rdeadlined+"일 " + rdeadline_ampm+" " + rdeadlinet + "시";
        if (rdeadliney == "" || rdeadlinem == "" || rdeadlined == "" || rdeadline_ampm =="" || rdeadlinet =="")
        {
        	rdeadline  = rdeadliney+rdeadlinem+rdeadlined+rdeadline_ampm+rdeadlinet;
        }
		this.rdeadline = rdeadline;
	}
	
	public String getStar(){
		return star;
	}
	
	public void setStar(String importance){
		if(Integer.parseInt(importance)==0){//중요도 입력 안 했을 시 3으로 출력
			this.star = "★★★";
		}else if(Integer.parseInt(importance)==1){
			this.star = "★";
		}else if(Integer.parseInt(importance)==2){
			this.star = "★★";
		}else if(Integer.parseInt(importance)==3){
			this.star = "★★★";
		}else if(Integer.parseInt(importance)==4){
			this.star = "★★★★";
		}else{
			this.star = "★★★★★";
		}
	}
	

	
	public String toString(){
		return "TodoDTO [itemname=" + itemname
				+ ", deadline=" + deadline + ", rdeadline=" + rdeadline
                + ", importance=" + importance + ", subject=" + subject + ", complete=" + complete + "]";
		/*
		return "TodoDTO [itemname=" + itemname
				+ ", deadliney=" + deadliney + ", deadlinem=" + deadlinem + ", deadlined=" + deadlined
				+ "deadline_ampm=" + deadline_ampm + ", deadlinet=" + deadlinet
				+ ", rdeadliney=" + rdeadliney + ", rdeadlinem=" + rdeadlinem + ", rdeadlined=" + rdeadlined
				+ "rdeadline_ampm=" + rdeadline_ampm + ", rdeadlinet=" + rdeadlinet
                + ", importance=" + importance + ", subject=" + subject + ", complete=" + complete + "]";
        */
	}
	
	
}