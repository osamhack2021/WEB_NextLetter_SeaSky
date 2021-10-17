package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.MessageDTO;
import poly.persistance.mapper.MessageMapper;
import poly.service.IMessageService;

@Service("MessageService")
public class MessageService implements IMessageService {

	@Resource(name = "MessageMapper")
	private MessageMapper messageMapper;
	
	@Override
	public int insertMessage(MessageDTO mDTO) throws Exception{
		return messageMapper.insertMessage(mDTO);
	}
	
	@Override
	public List<MessageDTO> getMessage(String user_no) throws Exception{
		return messageMapper.getMessage(user_no);
	}
	
	@Override
	public String getSendedMessage(MessageDTO mDTO) throws Exception{
		return messageMapper.getSendedMessage(mDTO);
	}
}
