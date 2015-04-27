package backdoor_;

public class TESTING{

	public static void main(String[] arg) throws Exception{
		String temp = "";
		int[] searchSettings = new int[7];
		for(int i = 0; i<7; i++){
			searchSettings[i] = i;
		}
		
		for (int i : searchSettings) {
			temp += i;
		}
		int result = Integer.parseInt(temp);
		System.out.println(result);
	}
	}