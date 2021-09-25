package poly.dto;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class SoldierDTO {
    /* SoldierClassName; // ����
        '������/�Ʒú�' | '����' | '�屳' | '�λ��' | '������' */
	private String missSoldierClassCdNm;
    
	/* SoldierClass; // ���� �ڵ� 
        '������/�Ʒú�' = '0000490001',  '����' = '0000490002',  '�屳' = '0000490003',  '�λ��' = '0000490004',  '������' = '0000490005',*/
    private String missSoldierClassCd;
    
    /* SoldierGroupName; // ���� 
        '����' | '�ر�' | '����' | '�غ���' */
    private String grpCdNm;
    
    /* SoldierGroup; // ���� �ڵ�
        '����' = '0000010001',  '�ر�' = '0000010002',  '����' = '0000010003',  '�غ���' = '0000010004',*/
    private String grpCd;
    
    private String name;
    private String birth;
    private String enterDate;
    
    /* SoldierUnitName; // �Կ��δ�
         '1���' |  '2���' |  '3���' |  '5���' |  '6���' |  '7���' |  '9���' |  '11���' |  '12���' |  '15���' |  '17���' |  '20���' |  '21���' |  '22���' |  '23���' |  '25���' |  '27���' |  '28���' |  '30���' |  '31���' |  '32���' |  '35���' |  '36���' |  '37���' |  '39���' |  '50���' |  '51���' |  '53���' |  '�����Ʒü�' |  '�����Ʒü�(23����)' |  '�����Ʒü�(25����)' |  '�����Ʒü�(26����)' |  '�����Ʒü�(27����)' |  '�����Ʒü�(28����)' |  '�����Ʒü�(29����)' |  '�����Ʒü�(30����)'; */
    private String trainUnitCdNm;
    
    /* SoldierUnit; // �Կ��δ� �ڵ�
    '1���' = '20121290100',  '2���' = '20121490100',  '3���' = '20121590100',  '5���' = '20121690200',  '6���' = '20121590200',  '7���' = '20121390100',  '9���' = '20121290200',  '11���' = '20121790300',  '12���' = '20121490200',  '15���' = '20121390200',  '17���' = '20121190100',  '20���' = '20121790400',  '21���' = '20121490300',  '22���' = '20121890100',  '23���' = '20121890200',  '25���' = '20121290300',  '27���' = '20121390300',  '28���' = '20121690100',  '30���' = '20121290400',  '31���' = '20220280100',  '32���' = '20220280200',  '35���' = '20220280300',  '36���' = '20120180100',  '37���' = '20220280400',  '39���' = '20220280500',  '50���' = '20220280600',  '51���' = '20121190200',  '53���' = '20220280700',  '�����Ʒü�' = '20020191700',  '�����Ʒü�(23����)' = '20020191800',  '�����Ʒü�(25����)' = '20020191900',  '�����Ʒü�(26����)' = '20020192000',  '�����Ʒü�(27����)' = '20020192100',  '�����Ʒü�(28����)' = '20020192200',  '�����Ʒü�(29����)' = '20020192300',  '�����Ʒü�(30����)' = '20020192400', */
    private String trainUnitCd;
    
    //���� '�θ�' = 'PARENT', '�����' = 'SPOUSE', '����/�ڸ�' = 'SIBLING', 'ģ��/����' = 'FRIEND', '����' = 'LOVER', 'ģô' = 'RELATIVE', '��' = 'FAN'
    private String missSoldierRelationship;
    /* SoldierRelationship; // ���� �ڵ�
    PARENT = '0000420001', // �θ�  SPOUSE = '0000420003', // �����  SIBLING = '0000420002', // ����/�ڸ�  FRIEND = '0000420006', // ģ��/����  LOVER = '0000420005', // ����  RELATIVE = '0000420004', // ģô  FAN = '0000420007', // ��*/
    private String missSoldierRelationshipCd;
    
    private String traineeMgrSeq;
	public String getMissSoldierClassCdNm() {
		return missSoldierClassCdNm;
	}
	public void setMissSoldierClassCdNm(String missSoldierClassCdNm) {
		this.missSoldierClassCdNm = missSoldierClassCdNm;
		
		if(missSoldierClassCdNm.equals("������/�Ʒú�")) {
			this.missSoldierClassCd = "0000490001";
		}else if(missSoldierClassCdNm.equals("����")) {
			this.missSoldierClassCd = "0000490002";
		}else if(missSoldierClassCdNm.equals("�屳")) {
			this.missSoldierClassCd = "0000490003";
		}else if(missSoldierClassCdNm.equals("�λ��")) {
			this.missSoldierClassCd = "0000490004";
		}else if(missSoldierClassCdNm.equals("������")) {
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
		
		if(grpCdNm.equals("����")) {
			this.grpCd = "0000010001";
		}else if(grpCdNm.equals("�ر�")) {
			this.grpCd = "0000010002";
		}else if(grpCdNm.equals("����")) {
			this.grpCd = "0000010003";
		}else if(grpCdNm.equals("�غ���")) {
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
		String unitCd = "'1���':'20121290100', '2���':'20121490100', '3���':'20121590100', '5���':'20121690200', '6���':'20121590200', '7���':'20121390100', '9���':'20121290200', '11���':'20121790300', '12���':'20121490200', '15���':'20121390200', '17���':'20121190100', '20���':'20121790400', '21���':'20121490300', '22���':'20121890100', '23���':'20121890200', '25���':'20121290300', '27���':'20121390300', '28���':'20121690100', '30���':'20121290400', '31���':'20220280100', '32���':'20220280200', '35���':'20220280300', '36���':'20120180100', '37���':'20220280400', '39���':'20220280500', '50���':'20220280600', '51���':'20121190200', '53���':'20220280700', '�����Ʒü�':'20020191700', '�����Ʒü�(23����)':'20020191800', '�����Ʒü�(25����)':'20020191900', '�����Ʒü�(26����)':'20020192000', '�����Ʒü�(27����)':'20020192100', '�����Ʒü�(28����)':'20020192200', '�����Ʒü�(29����)':'20020192300', '�����Ʒü�(30����)':'20020192400'";
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
