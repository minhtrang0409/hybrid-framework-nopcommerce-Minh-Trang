package javaOOP;

import java.util.Scanner;

public class Topic_01_Class_Object_Student {
	private int studentID;
	private String studentname;
	private float knowledgePoint;
	private float practicePoint;
	
	//nhập dữ liệu từ bàn phím
	Scanner scanner = new Scanner(System.in);
	
	private int getStudentID() {
		return studentID;
	}

	private void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	private String getStudentname() {
		return studentname;
	}

	private void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	private float getKnowledgePoint() {
		return knowledgePoint;
	}

	private void setKnowledgePoint(float knowledgePoint) {
		this.knowledgePoint = knowledgePoint;
	}

	private float getPracticePoint() {
		return practicePoint;
	}

	private void setPracticePoint(float practicePoint) {
		this.practicePoint = practicePoint;
	}

	private float getAveragePoint() {
		return (this.knowledgePoint + this.practicePoint *2)/3;
	}
	
	private void showStudentInfor() {
		System.out.println("********************");
		System.out.println("Student ID = "+ getStudentID() );
		System.out.println("Student name = "+ getStudentname() );
		System.out.println("Student knowledgePoint = "+ getKnowledgePoint() );
		System.out.println("Student practice Point = "+ getPracticePoint() );
		System.out.println("Student everage Point = "+ getAveragePoint() );
		System.out.println("********************");
	}
	
	public static void main(String[] args) {
		Topic_01_Class_Object_Student firstStudent = new Topic_01_Class_Object_Student();
		firstStudent.setStudentID(456465);
		firstStudent.setStudentname("Minh Trang");
		firstStudent.setKnowledgePoint(8.0f);
		firstStudent.setPracticePoint(4.5f);
		firstStudent.showStudentInfor();
		

	}

}
