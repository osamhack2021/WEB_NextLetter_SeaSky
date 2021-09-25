package poly.dto;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class SoldierDTO {
    /* SoldierClassName; // 성분
        '예비군인/훈련병' | '병사' | '장교' | '부사관' | '군무원' */
	private String missSoldierClassCdNm;
    
	/* SoldierClass; // 성분 코드 
        '예비군인/훈련병' = '0000490001',  '병사' = '0000490002',  '장교' = '0000490003',  '부사관' = '0000490004',  '군무원' = '0000490005',*/
    private String missSoldierClassCd;
    
    /* SoldierGroupName; // 군종 
        '육군' | '해군' | '공군' | '해병대' */
    private String grpCdNm;
    
    /* SoldierGroup; // 군종 코드
        '육군' = '0000010001',  '해군' = '0000010002',  '공군' = '0000010003',  '해병대' = '0000010004',*/
    private String grpCd;
    
    private String name;
    private String birth;
    private String enterDate;
    
    /* SoldierUnitName; // 입영부대
         '1사단' |  '2사단' |  '3사단' |  '5사단' |  '6사단' |  '7사단' |  '9사단' |  '11사단' |  '12사단' |  '15사단' |  '17사단' |  '20사단' |  '21사단' |  '22사단' |  '23사단' |  '25사단' |  '27사단' |  '28사단' |  '30사단' |  '31사단' |  '32사단' |  '35사단' |  '36사단' |  '37사단' |  '39사단' |  '50사단' |  '51사단' |  '53사단' |  '육군훈련소' |  '육군훈련소(23연대)' |  '육군훈련소(25연대)' |  '육군훈련소(26연대)' |  '육군훈련소(27연대)' |  '육군훈련소(28연대)' |  '육군훈련소(29연대)' |  '육군훈련소(30연대)'; */
    private String trainUnitCdNm;
    
    /* SoldierUnit; // 입영부대 코드
    '1사단' = '20121290100',  '2사단' = '20121490100',  '3사단' = '20121590100',  '5사단' = '20121690200',  '6사단' = '20121590200',  '7사단' = '20121390100',  '9사단' = '20121290200',  '11사단' = '20121790300',  '12사단' = '20121490200',  '15사단' = '20121390200',  '17사단' = '20121190100',  '20사단' = '20121790400',  '21사단' = '20121490300',  '22사단' = '20121890100',  '23사단' = '20121890200',  '25사단' = '20121290300',  '27사단' = '20121390300',  '28사단' = '20121690100',  '30사단' = '20121290400',  '31사단' = '20220280100',  '32사단' = '20220280200',  '35사단' = '20220280300',  '36사단' = '20120180100',  '37사단' = '20220280400',  '39사단' = '20220280500',  '50사단' = '20220280600',  '51사단' = '20121190200',  '53사단' = '20220280700',  '육군훈련소' = '20020191700',  '육군훈련소(23연대)' = '20020191800',  '육군훈련소(25연대)' = '20020191900',  '육군훈련소(26연대)' = '20020192000',  '육군훈련소(27연대)' = '20020192100',  '육군훈련소(28연대)' = '20020192200',  '육군훈련소(29연대)' = '20020192300',  '육군훈련소(30연대)' = '20020192400', */
    private String trainUnitCd;
    
    //관계 '부모' = 'PARENT', '배우자' = 'SPOUSE', '형제/자매' = 'SIBLING', '친구/지인' = 'FRIEND', '애인' = 'LOVER', '친척' = 'RELATIVE', '팬' = 'FAN'
    private String missSoldierRelationship;
    /* SoldierRelationship; // 관계 코드
    PARENT = '0000420001', // 부모  SPOUSE = '0000420003', // 배우자  SIBLING = '0000420002', // 형제/자매  FRIEND = '0000420006', // 친구/지인  LOVER = '0000420005', // 애인  RELATIVE = '0000420004', // 친척  FAN = '0000420007', // 팬*/
    private String missSoldierRelationshipCd;
    
    private String traineeMgrSeq;
	public String getMissSoldierClassCdNm() {
		return missSoldierClassCdNm;
	}
	public void setMissSoldierClassCdNm(String missSoldierClassCdNm) {
		this.missSoldierClassCdNm = missSoldierClassCdNm;
		
		if(missSoldierClassCdNm.equals("예비군인/훈련병")) {
			this.missSoldierClassCd = "0000490001";
		}else if(missSoldierClassCdNm.equals("병사")) {
			this.missSoldierClassCd = "0000490002";
		}else if(missSoldierClassCdNm.equals("장교")) {
			this.missSoldierClassCd = "0000490003";
		}else if(missSoldierClassCdNm.equals("부사관")) {
			this.missSoldierClassCd = "0000490004";
		}else if(missSoldierClassCdNm.equals("군무원")) {
			this.missSoldierClassCd = "0000490005";
		}
	}
	public String getMissSoldierClassCd() {
		return missSoldierClassCd;
	}
	public void setMissSoldierClassCd(String missSoldierClassCd) {
		this.missSoldierClassCd = missSoldierClassCd;
	}
	public String getGrpCdNm() {
		return grpCdNm;
	}
	public void setGrpCdNm(String grpCdNm) {
		this.grpCdNm = grpCdNm;
		
		if(grpCdNm.equals("육군")) {
			this.grpCd = "0000010001";
		}else if(grpCdNm.equals("해군")) {
			this.grpCd = "0000010002";
		}else if(grpCdNm.equals("공군")) {
			this.grpCd = "0000010003";
		}else if(grpCdNm.equals("해병대")) {
			this.grpCd = "0000010004";
		}
	}
	public String getGrpCd() {
		return grpCd;
	}
	public void setGrpCd(String grpCd) {
		this.grpCd = grpCd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getEnterDate() {
		return enterDate;
	}
	public void setEnterDate(String enterDate) {
		this.enterDate = enterDate;
	}
	public String getTrainUnitCdNm() {
		return trainUnitCdNm;
	}
	public void setTrainUnitCdNm(String trainUnitCdNm) {
		this.trainUnitCdNm = trainUnitCdNm;
		String unitCd = "'1사단':'20121290100', '2사단':'20121490100', '3사단':'20121590100', '5사단':'20121690200', '6사단':'20121590200', '7사단':'20121390100', '9사단':'20121290200', '11사단':'20121790300', '12사단':'20121490200', '15사단':'20121390200', '17사단':'20121190100', '20사단':'20121790400', '21사단':'20121490300', '22사단':'20121890100', '23사단':'20121890200', '25사단':'20121290300', '27사단':'20121390300', '28사단':'20121690100', '30사단':'20121290400', '31사단':'20220280100', '32사단':'20220280200', '35사단':'20220280300', '36사단':'20120180100', '37사단':'20220280400', '39사단':'20220280500', '50사단':'20220280600', '51사단':'20121190200', '53사단':'20220280700', '육군훈련소':'20020191700', '육군훈련소(23연대)':'20020191800', '육군훈련소(25연대)':'20020191900', '육군훈련소(26연대)':'20020192000', '육군훈련소(27연대)':'20020192100', '육군훈련소(28연대)':'20020192200', '육군훈련소(29연대)':'20020192300', '육군훈련소(30연대)':'20020192400'";
		JsonParser jsonParser = new JsonParser();
    	JsonObject jsonObj = jsonParser.parse(unitCd).getAsJsonObject();
    	
    	this.trainUnitCd = jsonObj.get(trainUnitCdNm).getAsString();
	}
	public String getTrainUnitCd() {
		return trainUnitCd;
	}
	public void setTrainUnitCd(String trainUnitCd) {
		this.trainUnitCd = trainUnitCd;
	}
	public String getMissSoldierRelationshipCd() {
		return missSoldierRelationshipCd;
	}
	public void setMissSoldierRelationshipCd(String missSoldierRelationshipCd) {
		this.missSoldierRelationshipCd = missSoldierRelationshipCd;
	}
	public String getTraineeMgrSeq() {
		return traineeMgrSeq;
	}
	public void setTraineeMgrSeq(String traineeMgrSeq) {
		this.traineeMgrSeq = traineeMgrSeq;
	}
	public String getMissSoldierRelationship() {
		return missSoldierRelationship;
	}
	public void setMissSoldierRelationship(String missSoldierRelationship) {
		this.missSoldierRelationship = missSoldierRelationship;
		
	    switch (missSoldierRelationship) {
		case "PARENT": this.missSoldierRelationshipCd = "0000420001";
			break;
		case "SPOUSE": this.missSoldierRelationshipCd = "0000420003";
				break;
		case "SIBLING": this.missSoldierRelationshipCd = "0000420002";
				break;
		case "FRIEND": this.missSoldierRelationshipCd = "0000420006";
				break;
		case "LOVER": this.missSoldierRelationshipCd = "0000420005";
				break;
		case "RELATIVE": this.missSoldierRelationshipCd = "0000420004";
				break;
		case "FAN": this.missSoldierRelationshipCd = "0000420007";
				break;
		}
	}

    
}
