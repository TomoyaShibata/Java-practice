package main;

import java.lang.System;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main (String[] args) {
		getDayDiff();
	}

	private static void getDayDiff () {
		TimeZone.setDefault(TimeZone.getTimeZone("JST"));

		// システム現在日の0時0分0秒を取得
		Calendar nowCal    = Calendar.getInstance();
		int nowYear        = nowCal.get(Calendar.YEAR);
		int nowMonth       = nowCal.get(Calendar.MONTH);
		int nowDay         = nowCal.get(Calendar.DATE);

		Calendar midNowCal = Calendar.getInstance();
		midNowCal.set(nowYear, nowMonth, nowDay, 0, 0, 0);

		// システム現在日の前日の0時0分0秒を取得
		Calendar yesCal = Calendar.getInstance();
		int billedDateYear  = yesCal.get(Calendar.YEAR);
		int billedDateMonth = yesCal.get(Calendar.MONTH);
		int billedDateDay   = yesCal.get(Calendar.DATE) - 1;

		Calendar midYesCal = Calendar.getInstance();
		midYesCal.set(billedDateYear, billedDateMonth, billedDateDay, 0, 0, 0);

		System.out.println("nowCal     :" + nowCal.getTime());
		System.out.println("midNowCal  :" + midNowCal.getTime());
		System.out.println("yesCaleCal :" + yesCal.getTime());
		System.out.println("midYesCal  :" + midYesCal.getTime());

		// 2つの日付間の日数を計算するため、long値(ミリ秒）に変換
		long timeYesCal = midYesCal.getTimeInMillis();
		long timeNowCal = midNowCal.getTimeInMillis();

		// 演算を行い、結果をミリ秒 → 秒へ変換
		long timeDiff   = timeNowCal - timeYesCal;
		long dayDiff = TimeUnit.MILLISECONDS.toDays(timeDiff);
		
		System.out.println("timeDiff:" + timeDiff);
		System.out.println("dayDiff :" + (int)dayDiff);
		System.out.println("result  :" + (dayDiff >= 1 ? true : false));
	}
}
