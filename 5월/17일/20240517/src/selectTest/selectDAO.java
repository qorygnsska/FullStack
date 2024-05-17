package selectTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class selectDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	// 1. job 테이블 모든 정보 조회
	public void select1() {
		System.out.println("select1");
		con = DBUtil.getConnection();
		try {
			String sql = "select * from job";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("직업 번호 : " + rs.getString("JOB_CODE"));
				System.out.println("직함 : " + rs.getString("JOB_Name"));
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 2. job 테이블의 직급 이름 조회
	public void select2() {
		System.out.println("select2");
		con = DBUtil.getConnection();
		try {
			String sql = "select job_name from job";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("직함 : " + rs.getString("job_name"));
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 3. department 테이블 모든 정보 조회
	public void select3() {
		System.out.println("select3");
		con = DBUtil.getConnection();
		try {
			String sql = "select * from department";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("부서 id : " + rs.getString("dept_id"));
				System.out.println("부서명 : " + rs.getString("dept_title"));
				System.out.println("부서위치 : " + rs.getString("location_id"));
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 4. employee 테이블의 직원명, 이메일, 전화번호, 고용일 조회
	public void select4() {
		System.out.println("select4");
		con = DBUtil.getConnection();
		try {
			String sql = "select emp_name, email, phone, hire_date from employee";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("직원명 : " + rs.getString("emp_name"));
				System.out.println("이메일 : " + rs.getString("email"));
				System.out.println("핸드폰 : " + rs.getString("phone"));
				System.out.println("고용일 : " + rs.getDate("hire_date"));
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 5. EMPLOYEE테이블의 고용일, 사원 이름, 월급 조회
	public void select5() {
		System.out.println("select5");
		con = DBUtil.getConnection();
		try {
			String sql = "select hire_date, emp_name, salary from employee";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("고용일 : " + rs.getDate("hire_date"));
				System.out.println("직원명 : " + rs.getString("emp_name"));
				System.out.println("월급 : " + rs.getInt("salary"));
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 6. EMPLOYEE테이블에서 이름, 연봉, 총수령액(보너스포함),
	// 실수령액(총수령액 - (연봉*세금 3%)) 조회
	public void select6() {
		System.out.println("select6");
		con = DBUtil.getConnection();
		try {
			String sql = "select emp_name, salary * 12 as 연봉, nvl((salary + salary * bonus) * 12, salary * 12) as 총수령액, nvl((salary + salary * bonus) * 12 - (salary * 12 * 0.03), salary * 12 - (salary * 12 * 0.03)) as 실수령액 from employee";

			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("직원명 : " + rs.getString("emp_name"));
				System.out.println("연봉 : " + rs.getInt("연봉") + "원");
				System.out.println("총수령액 : " + rs.getInt("총수령액") + "원");
				System.out.println("실수령액 : " + rs.getInt("실수령액") + "원");
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 7. EMPLOYEE테이블에서 SAL_LEVEL이 S1인 사원의 이름,
	//    월급, 고용일, 연락처 조회

	public void select7() {
		System.out.println("select7");
		con = DBUtil.getConnection();
		try {
			String sql = "select emp_name, salary, hire_date, phone from employee where sal_level = 'S1'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("직원명 : " + rs.getString("emp_name"));
				System.out.println("월급 : " + rs.getInt("salary") + "원");
				System.out.println("고용일 : " + rs.getDate("hire_date"));
				System.out.println("핸드폰 : " + rs.getString("phone"));
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	// 8. EMPLOYEE테이블에서 실수령액(6번 참고)이 5천만원 이상인 사원의 
	// 이름, 월급, 실수령액, 고용일 조회
	public void select8() {
		System.out.println("select8");
		con = DBUtil.getConnection();
		try {
			String sql = "select emp_name, salary, nvl((salary + salary * bonus) * 12 - (salary * 12 * 0.03), salary * 12 - (salary * 12 * 0.03)) as 실수령액, hire_date from employee where nvl((salary + salary * bonus) * 12 - (salary * 12 * 0.03), salary * 12 - (salary * 12 * 0.03)) > 50000000";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("직원명 : " + rs.getString("emp_name"));
				System.out.println("월급 : " + rs.getInt("salary") + "원");
				System.out.println("실수령액 : " + rs.getInt("실수령액") + "원");
				System.out.println("고용일 : " + rs.getDate("hire_date"));
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	// 9. EMPLOYEE테이블에 월급이 4000000이상이고 JOB_CODE가 J2인 사원의 전체 내용 조회
	public void select9() {
		System.out.println("select9");
		con = DBUtil.getConnection();
		try {
			String sql = "select * from employee where salary >= 4000000 and job_code = 'J2' ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("직원명 : " + rs.getString("emp_name"));
				System.out.println("월급 : " + rs.getInt("salary") + "원");
				System.out.println("실수령액 : " + rs.getInt("실수령액") + "원");
				System.out.println("고용일 : " + rs.getDate("hire_date"));
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	// 17.EMPLOYEE테이블에서 사원명, 입사일-오늘, 오늘-입사일 조회
	//   (단,각 별칭은 근무일수1, 근무일수2가 되도록 하고 모두 정수(내림), 양수가 되도록 처리)
	public void select17() {
		String sql = "select emp_name, floor(abs(hire_date - sysdate)) 근무일수1, floor(abs(sysdate - hire_date)) 근무일수2 from employee";
	}
	
	
	
	
	
	
	
	
	
	

}
