import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Openfile {
	static int num=0;//用來確認資料總數  因為 並沒有回傳資料總數 在資料陣列中
	public float[] OpenTxt(String filename) throws IOException {
		FileReader fr = null;
		int count = 0;//紀錄是不是第一行  如果是 第一行為資料量
		float data[] = null;
		try {
			System.out.println("開啟檔案名稱     -->"+filename);
			fr = new FileReader(filename+".txt");//開啟檔案
			BufferedReader br = new BufferedReader(fr);//開啟串流
			while (br.ready()) {
				if(count==0){//代表是第一行的資料  為資料量
					num=Integer.parseInt(br.readLine());
					data = new float[num];//藉由動態陣列 建立並儲存
				}
				count++;//
				data[count-1]=Float.parseFloat(br.readLine());//紀錄資料 並轉換成float 因為資料可能帶有小數點
//				System.out.println(data[count-1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			fr.close();//良好的關閉是好習慣
		}
		System.out.println("關閉檔案名稱     -->"+filename);
		return data;
	}
	public int getNum(){
		return num;//原本想說會用到 結果都用data.length()  但還是放著
	}
}
