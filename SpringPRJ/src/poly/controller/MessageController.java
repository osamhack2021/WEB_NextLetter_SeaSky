package poly.controller;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.service.ITestService;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Resource(name = "MessageService")
	private IMessageService messageService;

	@RequestMapping(value = "/send")
	public String send(ServletRequest request ,Model model) throws Exception {
		//��ķ�� �α��� ����
    	UserDTO uDTO = new UserDTO();
        String thecamp_id = request.getParameter("id");
        uDTO.setThecamp_id(thecamp_id);
        String thecamp_pw="seasky1!";
        uDTO.setThecamp_pw(thecamp_pw);

        //�Դ��� ����
        SoldierDTO sDTO = new SoldierDTO();
        String name="�趯��";
        sDTO.setName(name);
        String birth="20010616";
        sDTO.setBirth(birth);
        String missSoldierClassCdNm="������/�Ʒú�";
        sDTO.setMissSoldierClassCdNm(missSoldierClassCdNm);
        String grpCdNm="����";
        sDTO.setGrpCdNm(grpCdNm);
        String trainUnitCdNm="�����Ʒü�";
        sDTO.setTrainUnitCdNm(trainUnitCdNm);
        String enterDate="20210913";
        sDTO.setEnterDate(enterDate);
        String missSoldierRelationship = "FRIEND";
        sDTO.setMissSoldierRelationship(missSoldierRelationship);

        
        //�߼��� �޽���
        String title = "��ķ�� ���̺귯�� �׽�Ʈ";
        String content = "��ķ�� ���̺귯�� �߼��� ���� �׽�Ʈ ���Դϴ�. �� ������ ��� �Ͻʽÿ�.\n This is TheCamp Test.";
        MessageDTO mDTO = new MessageDTO();
        mDTO.setTitle(title);
        mDTO.setContent(content);
        
        try {
			String soldier_code = getSoliderCode(uDTO, sDTO);
			String msg = sendMsg(uDTO, sDTO, soldier_code, mDTO);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg", "�߼ۿ� �����߽��ϴ�.");
		}

		model.addAttribute("url", "/test/MessageTest.do");
		return "/alert";
	}

