package base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

public class Base64Test {

	public static void main(String[] args) {
		
		try {
			//Encode using basic encoder
			String base64EncodedString = Base64.getEncoder().encodeToString("TestBase64?Java8".getBytes("utf-8"));
			System.out.println("Base64 Encoded String(Basic): "+base64EncodedString);

			//Decode
			byte[] base64DecodedByte = Base64.getDecoder().decode(base64EncodedString);
			System.out.println("Original String: "+ new String(base64DecodedByte,"utf-8"));
			
			//Encode using URL encoder
			String base64EncodedUrl = Base64.getUrlEncoder().encodeToString("TestBase64?Java8".getBytes("utf-8"));
			System.out.println("Base64 Encoded String(URL): "+base64EncodedUrl);
			
			//Decode
			System.out.println("Original String: "+ new String(Base64.getUrlDecoder().decode(base64EncodedUrl),"utf-8"));
			
			//Encode using Mime encoder
			StringBuilder stringBuilder = new StringBuilder();
			for(int i=0; i<10;i++) {
				stringBuilder.append(UUID.randomUUID().toString());
			}
			
			byte[] mimeBytes = stringBuilder.toString().getBytes();
			String mimeEncoding = Base64.getMimeEncoder().encodeToString(mimeBytes);
			System.out.println("Base64 Encoded String(MIME): "+mimeEncoding);
			
			//decode
			System.out.println("Original String: "+ new String(Base64.getMimeDecoder().decode(mimeEncoding),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
