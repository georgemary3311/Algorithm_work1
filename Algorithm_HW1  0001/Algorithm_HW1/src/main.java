import java.util.Scanner;

public class main {
	static Openfile Opf = new Openfile();

	public static void main(String[] args) {
		while (true) {
			System.out.println("�п�J�����ɮת��W�� ���t .TXT �p�n���� �п�J \"END\"");
			Scanner scn = new Scanner(System.in);
			String filename = scn.nextLine(); // ��J�ɮצW��
			if(filename.equals("END")||filename.equals("end"))
				break;
			float data[] = null;
			try {
				data = Opf.OpenTxt(filename);// �I�s��k�æ^��TXT�������
			} catch (Exception e) {
				e.printStackTrace();
			}
			Sort sort = new Sort(); // �إ�Sort����
			sort.Sort(data);// �I�s��k
		}

	}

}
