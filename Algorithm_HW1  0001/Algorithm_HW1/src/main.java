import java.util.Scanner;

public class main {
	static Openfile Opf = new Openfile();

	public static void main(String[] args) {
		while (true) {
			System.out.println("請輸入測資檔案的名稱 不含 .TXT 如要結束 請輸入 \"END\"");
			Scanner scn = new Scanner(System.in);
			String filename = scn.nextLine(); // 輸入檔案名稱
			if(filename.equals("END")||filename.equals("end"))
				break;
			float data[] = null;
			try {
				data = Opf.OpenTxt(filename);// 呼叫方法並回傳TXT中的資料
			} catch (Exception e) {
				e.printStackTrace();
			}
			Sort sort = new Sort(); // 建立Sort物件
			sort.Sort(data);// 呼叫方法
		}

	}

}
