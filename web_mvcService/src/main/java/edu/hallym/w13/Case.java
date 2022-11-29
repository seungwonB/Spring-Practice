package edu.hallym.w13;

public class Case {
	private String case_day;
	private String case_court;
	private String case_name;
	private String case_order;
	private String case_main;
	private int seq;

	public String getCase_day() {
		return case_day;
	} 

	public void setCase_day(String case_day) {
		this.case_day = case_day;
	}

	public String getCase_court() {
		return case_court;
	}

	public void setCase_court(String case_court) {
		this.case_court = case_court;
	}

	public String getCase_name() {
		return case_name;
	}

	public void setCase_name(String case_name) {
		this.case_name = case_name;
	}

	public String getCase_order() {
		return case_order;
	}

	public void setCase_order(String case_order) {
		this.case_order = case_order;
	}

	public String getCase_main() {
		return case_main;
	}

	public void setCase_main(String case_main) {
		this.case_main = case_main;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	@Override
	public String toString() {
		return "Case [case_day=" + case_day + ", case_court=" + case_court + ", case_name=" + case_name
				+ ", case_order=" + case_order + ", case_main=" + case_main + ", seq=" + seq + "]";
	}
}
