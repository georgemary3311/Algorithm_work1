import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Openfile {
	static int num=0;//�ΨӽT�{����`��  �]�� �èS���^�Ǹ���`�� �b��ư}�C��
	public float[] OpenTxt(String filename) throws IOException {
		FileReader fr = null;
		int count = 0;//�����O���O�Ĥ@��  �p�G�O �Ĥ@�欰��ƶq
		float data[] = null;
		try {
			System.out.println("�}���ɮצW��     -->"+filename);
			fr = new FileReader(filename+".txt");//�}���ɮ�
			BufferedReader br = new BufferedReader(fr);//�}�Ҧ�y
			while (br.ready()) {
				if(count==0){//�N��O�Ĥ@�檺���  ����ƶq
					num=Integer.parseInt(br.readLine());
					data = new float[num];//�ǥѰʺA�}�C �إߨ��x�s
				}
				count++;//
				data[count-1]=Float.parseFloat(br.readLine());//������� ���ഫ��float �]����ƥi��a���p���I
//				System.out.println(data[count-1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			fr.close();//�}�n�������O�n�ߺD
		}
		System.out.println("�����ɮצW��     -->"+filename);
		return data;
	}
	public int getNum(){
		return num;//�쥻�Q���|�Ψ� ���G����data.length()  ���٬O���
	}
}
