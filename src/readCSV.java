import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntPredicate;
import Model.ToyDAO;
import Model.ToyDTO;

public class readCSV {
	public static void main(String[] args) throws SQLException, FileNotFoundException{
		ArrayList<String[]> toyList = new ArrayList<String[]>();
		BufferedReader br = null;

		try {
			//csv 파일 읽어서 \n으로 나눠 리스트에 저장, 리스트는 ','구분해서 배열로 저장
			br = Files.newBufferedReader(Paths.get("C:\\Users\\SMT039\\Desktop\\장난감 데이터\\ToyList.csv"));
			// Charset.forName("UTF-8");
			String line = "";

			while ((line = br.readLine()) != null) {
				String[] temp = line.split(",");
				// System.out.println(Arrays.toString(temp));
				toyList.add(temp);
			
			}
			
	        
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
		ToyDAO dao = new ToyDAO();
		for (int i = 0; i < toyList.size(); i++) {
			
			String name = toyList.get(i)[0];
			String domain = toyList.get(i)[1];
			String develop = toyList.get(i)[2];
			String age = toyList.get(i)[3];
			String img = "./IMG/"+i+".jpg";
			int rent = 0;    
			
			int cnt = dao.toyInsert(new ToyDTO(name, domain, develop, age, rent, img));
			if(cnt==0) {
				System.out.println("실패!");
			}
			
			
		}

	}

}
