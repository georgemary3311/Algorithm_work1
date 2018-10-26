import java.util.Scanner;

public class Sort {

	public void Sort(float[] data) {

		System.out.println("請輸入搜尋方法 1是暴力法 2是Maximum-subarray演算法 :");
		Scanner scn = new Scanner(System.in);
		try {
			int type = scn.nextInt();
			switch (type) {
			case 1:
				BruteSort(data);
				break;
			case 2:
				float ans[] = MSSort(data, 0, data.length - 1);
				System.out.println(ans[0] + "     " + ans[1] + "     " + ans[2]);
				System.out.println("使用MS搜尋法:");
				System.out.println("第" + ans[0] + "日收盤買進第" + ans[1] + "日收盤賣出最高獲利為"
						+ (data[(int) ans[1]] - data[(int) ans[0]]) + "元!");
				break;
			}
		} catch (Exception e) {

		}
	}

	private float[] MSSort(float[] data, int low, int high) {
		if (high == low) {
			float ans[] = { low, high, data[low] };
//			System.out.println("分解最基本元素:"+data[low]);
			return ans;
		} else {
			int mid = (low + high) / 2;
			float leftarr[] = MSSort(data, low, mid);
			float rightarr[] = MSSort(data, mid + 1, high);
			float crossarr[] = MSSortCrossing(data, low, mid, high);
			System.out.println("low=:" + low + "	  high=" + high + " 	 MiddleM=" + mid);

			if (leftarr[2] > rightarr[2] && leftarr[2] > crossarr[2])
				return leftarr;
			else if (rightarr[2] > leftarr[2] && rightarr[2] > crossarr[2])
				return rightarr;
			else
				return crossarr;

		}

	}

	private float[] MSSortCrossing(float[] data, int low, int mid, int high) {
		float leftsum = 0, rightsum = 0;
		float sum = 0;
		float maxleft = 0, maxright = 0;
		for (int i = mid; i >= low; --i) {
			sum = sum + data[i];
			if (sum > leftsum) {
				leftsum = sum;
				maxleft = i;
			}
		}
		sum = 0;
		for (int i = mid + 1; i <= high; ++i) {
			sum = sum + data[i];
			if (sum > rightsum) {
				rightsum = sum;
				maxright = i;
			}
		}
		float ans[] = { maxleft, maxright, leftsum + rightsum };
		System.out.println("!!!左最大index" + maxleft + "	右最大index" + maxright + "		總和" + (leftsum + rightsum));
		return ans;

	}

	private void BruteSort(float[] data) {
		long time1 = System.currentTimeMillis();// 紀錄暴力搜尋法開始的時間
		int max = 0;// 記錄在暴力搜尋法中在最大值賣出日的數字
		int min = 0;// 記錄在暴力搜尋法中在最大值時買入日的數字
		float total = 0; // 記錄當下最大值的數字
		for (int i = 0; i < data.length - 1; i++) { // 跑買入日

			for (int j = i + 1; j < data.length; j++) {// 跑賣出日

				if (data[j] - data[i] > total) {// 如果大於最大值
					total = data[j] - data[i];// 將最大值紀錄並更新買賣日
					min = i;
					max = j;
				}

			}
		}
		long time2 = System.currentTimeMillis();// 紀錄暴力搜尋法結束的時間
		System.out.println("使用暴力搜尋法:");
		System.out.println("第" + min + "日收盤買進第" + max + "日收盤賣出最高獲利為" + total + "元!");
		System.out.println("耗費：" + (time2 - time1) + "毫秒");
	}

}
