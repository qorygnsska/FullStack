package select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class selectMain1 {

	public static void main(String[] args) {

		/*
		 * select - 데이터를 조회한 결과를 ResultSet 이라고 하는데 select 구문에 의해 반환된 행들의 집합 - ResultSet은
		 * 0개 이상의 행이 포함될 수 있고 특정한 기준에 의해서 정렬 가능
		 */

		try {
//			Connection con;
//			PreparedStatement ps;
//			ResultSet rs;
//
//			System.out.println("select1");
//
//			ArrayList<Employee> list = new ArrayList<Employee>();
//
//			con = DBUtil.getConnection();
//			String sql = "select emp_id, emp_name, salary from employee";
//
//			ps = con.prepareStatement(sql);
//
//			rs = ps.executeQuery();
//
//			while (rs.next()) {
//
//				Employee temp = new Employee();
//
//				temp.setEMP_ID(rs.getString("EMP_ID"));
//				temp.setEMP_NAME(rs.getString("EMP_NAME"));
//				temp.setSALARY(rs.getInt("SALARY"));
//
//				list.add(temp);
//			}
			//select1(list);

// ------------------------------------------------------------------
			// 직원 전부의 연봉 출력
			// 직원의 이름, 월급, 연봉
//			sql = "select emp_name as 이름, salary as 월급, salary * 12 as 연봉 from employee";
//			ps = con.prepareStatement(sql);
//
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				System.out.println("이름 : " + rs.getString("이름"));
//				System.out.println("월급 : " + rs.getInt("월급"));
//				System.out.println("연봉 : " + rs.getInt("연봉"));
//				System.out.println();
//			}
			
			//select2();
			
			//select3();
			
			select4();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 핸드폰 앞 네자리중 첫번째 번호가 7인 직원 이름과 전화번호 조회
	public static void select4() {
		System.out.println("select4");
		
		Connection con = DBUtil.getConnection();
		try {
			String sql = "select emp_name, phone from employee where phone like '___7%'";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("이름 : " + rs.getString("emp_name"));
				System.out.println("핸드폰 : " + rs.getString("phone"));
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// '전'씨 성을 가진 직원의 이름과 급여 조회
	// 키보드로 입력받은 성으로 시작하는 직원 출력
	public static void select3() {
		System.out.println("select3");
		Scanner sc = new Scanner(System.in);
		System.out.print("성 입력 : ");
		String name = sc.nextLine();
		
		Connection con = DBUtil.getConnection();
		try {
			String sql = "select emp_name, salary from employee where emp_name like '"+ name +"%'";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("이름 : " + rs.getString("emp_name"));
				System.out.println("급여 : " + rs.getInt("salary"));
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 부서코드가 D6이고 급여가 200만원보다 많은
	// 직원 이름, 부서 코드, 급여 조회
	public static void select2() {
		Connection con = DBUtil.getConnection();
		try {
			String sql = "select emp_name, dept_code, salary from employee where dept_code = 'D6' and salary > 2000000";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("이름 : " + rs.getString("emp_name"));
				System.out.println("부서코드 : " + rs.getString("dept_code"));
				System.out.println("급여 : " + rs.getInt("salary"));
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 사번, 이름, 월급을 조회하는 메서드
	public static void select1(ArrayList<Employee> list) {
		// list에서 하나씩 employee 타입으로 꺼내서 temp에 저장하고 출력
		for (Employee temp : list) {
			System.out.println("id : " + temp.getEMP_ID());
			System.out.println("name : " + temp.getEMP_NAME());
			System.out.println("salary : " + temp.getSALARY());
			System.out.println();
		}

	}

}
