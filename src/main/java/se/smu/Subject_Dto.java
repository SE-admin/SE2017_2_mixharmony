package se.smu;

public class Subject_Dto {
	private String subject;
	private String professor;
	private String dayofweek;
	private String period;
	private String year;
	private String semester;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getDayofweek() {
		return dayofweek;
	}
	public void setDayofweek(String dayofweek) {
		this.dayofweek = dayofweek;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getDivclass() {
		return divclass;
	}
	public void setDivclass(String divclass) {
		this.divclass = divclass;
	}
	private String divclass;
	
	public String toString(){
		return "SubjectDTO [subject=" + subject + ", professor=" + professor + ", dayofweek=" + dayofweek
                + ", period=" + period + ", year=" + year + ", semester=" + semester
                + ", divclass=" + divclass + "]";
	}
	
	
}