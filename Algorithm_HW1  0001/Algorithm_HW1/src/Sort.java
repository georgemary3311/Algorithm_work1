import java.util.Scanner;

public class Sort {

	public void Sort(float[] data) {

		System.out.println("�п�J�j�M��k 1�O�ɤO�k 2�OMaximum-subarray�t��k :");
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
				System.out.println("�ϥ�MS�j�M�k:");
				System.out.println("��" + ans[0] + "�馬�L�R�i��" + ans[1] + "�馬�L��X�̰���Q��"
						+ (data[(int) ans[1]] - data[(int) ans[0]]) + "��!");
				break;
			}
		} catch (Exception e) {

		}
	}

	private float[] MSSort(float[] data, int low, int high) {
		if (high == low) {
			float ans[] = { low, high, data[low] };
//			System.out.println("���ѳ̰򥻤���:"+data[low]);
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
		System.out.println("!!!���̤jindex" + maxleft + "	�k�̤jindex" + maxright + "		�`�M" + (leftsum + rightsum));
		return ans;

	}

	private void BruteSort(float[] data) {
		long time1 = System.currentTimeMillis();// �����ɤO�j�M�k�}�l���ɶ�
		int max = 0;// �O���b�ɤO�j�M�k���b�̤j�Ƚ�X�骺�Ʀr
		int min = 0;// �O���b�ɤO�j�M�k���b�̤j�ȮɶR�J�骺�Ʀr
		float total = 0; // �O����U�̤j�Ȫ��Ʀr
		for (int i = 0; i < data.length - 1; i++) { // �]�R�J��

			for (int j = i + 1; j < data.length; j++) {// �]��X��

				if (data[j] - data[i] > total) {// �p�G�j��̤j��
					total = data[j] - data[i];// �N�̤j�Ȭ����ç�s�R���
					min = i;
					max = j;
				}

			}
		}
		long time2 = System.currentTimeMillis();// �����ɤO�j�M�k�������ɶ�
		System.out.println("�ϥμɤO�j�M�k:");
		System.out.println("��" + min + "�馬�L�R�i��" + max + "�馬�L��X�̰���Q��" + total + "��!");
		System.out.println("�ӶO�G" + (time2 - time1) + "�@��");
	}

}
