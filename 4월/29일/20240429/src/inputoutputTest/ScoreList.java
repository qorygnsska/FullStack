package inputoutputTest;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

// 여러 학생의 성적(Score)를 기억하는 클래스 
public class ScoreList {
	
	private ArrayList<Score> scoreList
		= new ArrayList<Score>();

	public ArrayList<Score> getScoreList() {
		return scoreList;
	}

	public void setScoreList(ArrayList<Score> scoreList) {
		this.scoreList = scoreList;
	}
	// 성적 데이터 추가하는 메서드!
	public void addScore(Score score) {
		scoreList.add(score);
		// 파일에 추가하기 위해서는 파일의 이름
		// 입력받기!
		
		save("scorelist2");
	}
	
	// 파일에 추가하는 메서드 !
	public void save(String fileName) {
		
		// 1. 파일이름과 경로를 작성해야된다.
		String filePath = fileName+".txt";
		System.out.println(filePath);
		// try-with-resources구문
		// finally 작성 안해도 됨
		try (PrintWriter pw = new PrintWriter(filePath)){
			
			for(int i = 0; i < scoreList.size();
							i++) {
				// PrintWriter 사용하는 가장 큰 
				// 이유는  스트림을 사용하게 되면 
				// 각각 데이터를 래퍼클래스를 이용해서
				// 변경해야된다. printWriter는
				// 이미 print(),println() 오버로딩
				// 으로 구현이 되어있어서 편하게 데이터만
				// 넣으면 알아서 변경해서 문자로 저장한다.
				
				Score temp = scoreList.get(i);
				pw.print(temp.getIdx() + "/");
				pw.print(temp.getName() + "/");
				pw.print(temp.getKor() + "/");
				pw.print(temp.getEng() + "/");
				pw.print(temp.getMath());
				pw.println();
			}			
			
			System.out.println("정상 저장 되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}

	public void readScore() {
		// 프로그램이 동작 중에 새로운 데이터를 
		// 저장을 하고 출력을 눌렀을 떄 
		// 파일을 불러오다 보니 ArrayList가 
		// 비어있지 않아서 중복적인 데이터가
		// 보일 수 있다.
		
		// 리스트 비우기!
		scoreList.clear();
		
		Scanner scan = null;
		
		try {
			scan = new Scanner(
				   new File("scorelist2.txt"));
			
			while(scan.hasNextLine()) {
				// 텍스트 한 줄을 읽어 드린다.
				String str = scan
						 .nextLine().trim();
				System.out.println(str);
				
				// 한줄로 되어있는 문장을 잘라서 
				// score객체에 저장한다. 
				Score score = new Score();
				String[] temp = str.split("/");
				
				// 문자 -> 숫자 변경 
				score.setIdx(Integer
							.parseInt(temp[0]));
				score.setName(temp[1]);
				score.setKor(Integer
							.parseInt(temp[2]));
				score.setEng(Integer
							.parseInt(temp[3]));
				score.setMath(Integer
							.parseInt(temp[4]));
				
				// arraylist에 추가 
				scoreList.add(score);
			
			}
				
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		
		
		
	}	
}