package poly.mail;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import poly.dto.MessageDTO;
import poly.dto.SoldierDTO;

public class AirForceLibrary {
	public static void main(String[] args) {
		SoldierDTO sDTO = new SoldierDTO();
		
		sDTO.setName("오승완");
		sDTO.setBirth("20030124");
		sDTO.setEnterDate("20210906");
		
		MessageDTO mDTO = new MessageDTO();
		
		mDTO.setTitle("더캠프 테스트");
		mDTO.setContent("더캠프 테스트 중입니다.");
		mDTO.setRelation("더캠프");
		mDTO.setPw("1234");
		
		
		String msg = "";
		
		try {
			msg = sendMsg(sDTO, mDTO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(msg);
	}
	
	public static Map<String, String> getInfo(SoldierDTO sDTO) throws IOException {
		Map<String, String> result = new HashMap<>();
		
		//String URL = "http://www.airforce.mil.kr/user/emailPicViewSameMembers.action?siteId=last2&searchName=" + sDTO.getName() + "&searchBirth=" + sDTO.getBirth();
		String URL = "http://www.airforce.mil.kr/user/emailPicViewSameMembers.action?siteId=tong-new&searchName=" + sDTO.getName() + "&searchBirth=" + sDTO.getBirth();
		Connection conn = Jsoup.connect(URL);
		
		Document document = conn.get();
		
		Elements parsingList = document.getElementsByClass("SameResultList").select("li");
		
		result.put("status", "fail");
		result.put("msg", "훈련병 정보가 존재하지 않습니다.");
		
//		for(Element ele : parsingList) {
//			String[] sodea = ele.select("dd").get(0).text().split(" ");
//			String enter_dt = ele.select("dd").get(1).text().replace(": ", "").replace("-", "");
//			
//			String sodeaVal = sodea[3].replace("중대", "") + sodea[4].replace("소대", "") + sodea[6].replace("번", "");
//			String memberSeqVal = ele.select("input").attr("onclick").split("'")[1];
//			
//			if(enter_dt.equals(sDTO.getEnterDate())) {
//				result.put("status", "success");
//				result.put("msg", "훈련병 정보가 존재하지 않습니다.");
//				result.put("sodaeVal", sodeaVal);
//				result.put("enter_dt", enter_dt);
//				result.put("memberSeqVal", memberSeqVal);
//			}
//		}
		
		result.put("status", "success");
		result.put("msg", "훈련병 정보가 존재하지 않습니다.");
		result.put("sodaeVal", "병 830기");
		result.put("memberSeqVal", "282436763");
		
		return result;
		
	}
	
	
	public static String sendMsg(SoldierDTO sDTO, MessageDTO mDTO) throws IOException, UnirestException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		String msg = "";
		
		Map<String, String> soliderMap = getInfo(sDTO);
		
		if(soliderMap.get("status").equals("fail")){
			msg = soliderMap.get("msg");
		}else {
			msg = "인터넷 편지 발송을 실패했습니다.";
//			SSLContext sslcontext = SSLContexts.custom()
//                    .loadTrustMaterial(null, new TrustSelfSignedStrategy())
//                    .build();
//
//			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext);
//			CloseableHttpClient httpclient = HttpClients.custom()
//			                             .setSSLSocketFactory(sslsf)
//			                             .build();
//			Unirest.setHttpClient(httpclient);

			HttpResponse<String> msg_response = Unirest.post("http://www.airforce.mil.kr/user/emailPicSaveEmail.action")
					  .header("content-type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW")
					  //.body("------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"siteId\"\r\n\r\nlast2\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"command2\"\r\n\r\nwriteEmail\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"memberSeqVal\"\r\n\r\n" + soliderMap.get("memberSeqVal") + "\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"sodaeVal\"\r\n\r\n" + soliderMap.get("sodaeVal") + "\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"senderName\"\r\n\r\n" + mDTO.getSender() + "\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"relationship\"\r\n\r\n" + mDTO.getRelation() + "\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"title\"\r\n\r\n" + mDTO.getTitle() + "\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"contents\"\r\n\r\n" + mDTO.getContent() + "\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"password\"\r\n\r\n" + mDTO.getPw() + "\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW--")
					  .body("------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"siteId\"\r\n\r\ntong-new\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"command2\"\r\n\r\nwriteEmail\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"memberSeqVal\"\r\n\r\n" + soliderMap.get("memberSeqVal") + "\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"sodaeVal\"\r\n\r\n" + soliderMap.get("sodaeVal") + "\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"senderName\"\r\n\r\n" + mDTO.getSender() + "\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"relationship\"\r\n\r\n" + mDTO.getRelation() + "\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"title\"\r\n\r\n" + mDTO.getTitle() + "\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"contents\"\r\n\r\n" + mDTO.getContent() + "\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"password\"\r\n\r\n" + mDTO.getPw() + "\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW--")
					  .asString();
			/*System.out.println(msg_response.getBody().toString());*/
			//TODO 302 뜨는 현상 수정 필요
			if(msg_response.getStatus() == 200 || msg_response.getStatus() == 302) {
				msg = "success";
			}
		}
		
		
		return msg;
	}
}
