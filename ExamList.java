package 객체.ex1.캡슐화;

import java.util.Scanner;

public class ExamList {
	Exam[] exams;   // Exam타입의 exams 배열참조변수 선언( Exam클래스를 이용할 참조배열변수)
	int current;        
	
	  	static void printList(ExamList list) {
			printList(list, list.current); //함수 공통기능 집중화
		}
		
		//함수 오버로딩
		 static void printList(ExamList list, int size) {
				System.out.println("┌──────────────────┐");
				System.out.println("│     성적 출력            │");
				System.out.println("└──────────────────┘");
				System.out.println();
				
				//int size = list.current;
				Exam[] exams = list.exams;
				
				for(int i=0; i<size; i++) {
				Exam exam = exams[i];
				int kor = exam.kor;
				int eng = exam.eng;
				int math = exam.math;
				
				int total = exam.kor+exam.eng+exam.math;
				float avg = total/3.0f;
				
				System.out.printf("국어 %d\n", kor);
				System.out.printf("영어 %d\n", eng);
				System.out.printf("수학 %d\n", math);
			
				System.out.printf("총점 : %3d\n", total);
				System.out.printf("평균 : %6.2f\n", avg);
				System.out.println("────────────────────────");
				}
		}

		 static void inputList(ExamList list) {
			Scanner scan = new Scanner(System.in);
			System.out.println("┌──────────────────┐");
			System.out.println("│     성적 입력            │");
			System.out.println("└──────────────────┘");
			System.out.println();
			
			
			int kor, eng, math;
			
			do 
			{
				System.out.printf("국어: ");
				kor = scan.nextInt();
				
				if(kor < 0 || 100 < kor)
				{
					System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");
				}
			}while(kor<0 || 100 < kor);
			
			do 
			{
				System.out.printf("영어: ");
				eng = scan.nextInt();
				
				if(eng < 0 || 100 < eng)
				{
					System.out.println("영어성적은 0~100까지의 범위만 입력이 가능합니다.");
				}
			}while(eng<0 || 100 < eng);
			
			do 
			{
				System.out.printf("수학: ");
				math = scan.nextInt();
				
				if(math < 0 || 100 < math)
				{
					System.out.println("수학성적은 0~100까지의 범위만 입력이 가능합니다.");
				}
			}while(math<0 || 100 < math);
			
			Exam exam = new Exam(); //지역적인 exam클래스 변수 선언후에 국,영,수 성적 집어넣기
			exam.kor = kor;
			exam.eng = eng;
			exam.math = math;
			
			Exam[] exams = list.exams;
			int size = list.current;
			
			if(exams.length == size) {
				// 1. 크기가 5개 정도 더 큰 새로운 배열을 생성하시오
				Exam[] temp = new Exam[size + 5];
				// 2. 값을 이주시키기
				for(int i=0; i<size; i++)
					temp[i] = exams[i];
				// 3. list.exams가 새로 만든 temp 배열을 참조하도록 한다.
				list.exams  = temp;
				
			}
			
			list.exams[list.current] = exam; // list.current = 0 이므로 list.exams[0] = exam
			list.current++;  //current의 값이 증가해서 1메뉴를 반복할수록 list.exams 배열에 성적이 쌓임
									 // 하지만 list.exams의 방이 3개밖에 없어서 list.exams[3]부터 오류
			
		}

		 public static void init(ExamList list) {  // 변수값 초기화 함수
			list.exams = new Exam[3];         // Exam클래스의 변수 3개 참조하면 사용가능.
			list.current = 0;
		}
}
