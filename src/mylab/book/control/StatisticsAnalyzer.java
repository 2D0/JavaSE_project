package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {

	// 타입별 평균 가격: 타입마다 가격 합계와 권수를 모은 뒤 나눈다
	public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
		Map<String, Integer> totalPrice = new HashMap<>();
		Map<String, Integer> count = new HashMap<>();
		for (Publication pub : publications) {
			String type = getPublicationType(pub);
			totalPrice.put(type, totalPrice.getOrDefault(type, 0) + pub.getPrice());
			count.put(type, count.getOrDefault(type, 0) + 1);
		}

		Map<String, Double> average = new HashMap<>();
		for (String type : totalPrice.keySet()) {
			average.put(type, (double) totalPrice.get(type) / count.get(type));
		}
		return average;
	}

	// 타입별 비율(%): 타입별 권수 / 전체 권수 * 100
	public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
		Map<String, Integer> count = new HashMap<>();
		for (Publication pub : publications) {
			String type = getPublicationType(pub);
			count.put(type, count.getOrDefault(type, 0) + 1);
		}

		Map<String, Double> distribution = new HashMap<>();
		for (String type : count.keySet()) {
			distribution.put(type, count.get(type) * 100.0 / publications.length);
		}
		return distribution;
	}

	// 출판일 앞 4자리(연도)가 year와 같은 출판물의 비율(%)
	public double calculatePublicationRatioByYear(Publication[] publications, String year) {
		int matched = 0;
		for (Publication pub : publications) {
			if (pub.getPublishDate().substring(0, 4).equals(year)) {
				matched++;
			}
		}
		return matched * 100.0 / publications.length;
	}

	private String getPublicationType(Publication pub) {
		if (pub instanceof Novel) {
			return "소설";
		} else if (pub instanceof Magazine) {
			return "잡지";
		} else if (pub instanceof ReferenceBook) {
			return "참고서";
		}
		return "기타";
	}

	public void printStatistics(Publication[] publications) {
		DecimalFormat df = new DecimalFormat("#,###.##");

		System.out.println("===== 출판물 통계 분석 =====");
		System.out.println("1. 타입별 평균 가격:");
		for (Map.Entry<String, Double> entry : calculateAveragePriceByType(publications).entrySet()) {
			System.out.println("   - " + entry.getKey() + ": " + df.format(entry.getValue()) + "원");
		}

		System.out.println("2. 출판물 유형 분포:");
		for (Map.Entry<String, Double> entry : calculatePublicationDistribution(publications).entrySet()) {
			System.out.println("   - " + entry.getKey() + ": " + df.format(entry.getValue()) + "%");
		}

		System.out.println("3. 2007년에 출판된 출판물 비율: "
				+ df.format(calculatePublicationRatioByYear(publications, "2007")) + "%");
	}
}
