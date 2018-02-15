import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;

public class IntergrationCoeTest {

	public static void main(String[] args) throws Exception {

		IntergrationCoeTest codeTest = new IntergrationCoeTest();
		// Sample data set to test with
		JsonNode rootNode = JSONReader.getFileContents("people.json");

		// you can expect the following as headers
		String[] header = { "firstName", "lastName", "email", "phone", "postalCode" };
		
		for (int i = 0; i < header.length; i++) {
			System.out.print(header[i] + ",");
		}
		System.out.println("");

		int num = 0;
		Iterator<JsonNode> iterator = rootNode.iterator();
		while (iterator.hasNext()) {
			if (rootNode.get(num).get("firstName").asText().equals("")
					|| rootNode.get(num).get("lastName").asText().equals("")
					|| rootNode.get(num).get("email").asText().equals("")) {
				iterator.next();
				num++;
			} else {
				System.out.print(
						rootNode.get(num).get("firstName").asText() + "," + rootNode.get(num).get("lastName").asText()
								+ "," + rootNode.get(num).get("email").asText() + ",");

				String str = rootNode.get(num).get("phone").asText();
				Boolean flag = checkEmptySpace(str);
				if (flag) {
					System.out.print(rootNode.get(num).get("phone").asText() + ",");
				}

				String str1 = rootNode.get(num).get("postalCode").asText();
				Boolean flag1 = checkUpperCase(str1);
				if (flag1) {
					System.out.print(rootNode.get(num).get("postalCode").asText());
				}

			iterator.next();
			num++;
			System.out.println("");
			}
		}
	}

	private static Boolean checkEmptySpace(String str) {
		for (char ch : str.toCharArray()) {
			if (ch == ' ') {
				return false;
			}
		}
		return true;
	}

	private static Boolean checkUpperCase(String str) {
		char[] ch = str.toCharArray();
		if(ch.length != 7){
			return false;
		}
		if(!(ch[3] == ' ')){
			return false;
		}
		if(Character.isLetter(ch[0]) && Character.isLowerCase(ch[0])
				&& Character.isLetter(ch[2]) && Character.isLowerCase(ch[2])
				&& Character.isLetter(ch[5]) && Character.isLowerCase(ch[5])) {
	           return false;
	        }

		if(Character.isDigit(ch[1]) 
				&&  Character.isDigit(ch[4])
				&&  Character.isDigit(ch[6])) {          
	        }else{
	        	return false;
	        }
		
		return true;
	}

}