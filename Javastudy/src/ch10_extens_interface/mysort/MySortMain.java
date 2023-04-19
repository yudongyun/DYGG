package ch10_extens_interface.mysort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ch09_class.school.Student;

public class MySortMain {

	public static void main(String[] args) {
		
		ArrayList<Student> stuList = new ArrayList<>();
		
		stuList.add(new Student("준호", 40, 91, 91));
		stuList.add(new Student("동욱", 20, 93, 27));
		stuList.add(new Student("유정", 10, 45, 37));
		stuList.add(new Student("혜라", 50, 55, 57));
		stuList.add(new Student("현진", 66, 75, 67));
		stuList.add(new Student("민경", 80, 85, 87));
		
		// 이런게 바로 콜백함수임 (아래)
		// 인터페이스 ( Comparetor )의 추상메소드를
		// 미리 다른 메소드 ( sort ) 에서 사용하고,
		// 추상메소드 (compare) 의 구현은 해당 메소드 ( sort )를
		// 실행하는 쪽에서 구현한다.
		
		
		Collections.sort(stuList, new Comparator<Student>() {
			@Override
			public int compare(Student stuA, Student stuB) {
				double diff = stuA.getAvg() - stuB.getAvg();
				return (diff > 0) ? -1 : 1;
			}
		});
		
		// 람다식
		Collections.sort(stuList, (stuA, stuB) -> (stuA.getAvg() - stuB.getAvg() > 0) ? -1 : 1);
		
		for(int i = 0; i < stuList.size(); i++) {
			System.out.println((i+1) + "등. " + stuList.get(i));
		}
		
		MyCollections.mySort(stuList, new MyComparator<Student>() {
			@Override
			public boolean mycompare(Student stuA, Student stuB) {
				return stuA.getAvg() < stuB.getAvg();
			}
		
		});
		
		// 람다식
		MyCollections.mySort(stuList, (stuA, stuB) -> stuA.getAvg() < stuB.getAvg());
		
		for(int i = 0; i < stuList.size(); i++) {
			System.out.println((i+1) + "등. " + stuList.get(i));
		}
		
		
		
		
		
		
		
	}

}
