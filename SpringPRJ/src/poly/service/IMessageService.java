package poly.service;

import java.util.List;

import poly.dto.MessageDTO;

public interface IMessageService {
	public int insertMessage(MessageDTO mDTO) throws Exception;
	public List<MessageDTO> getMessage(String user_no) throws Exception;
	public String getSendedMessage(MessageDTO mDTO) throws Exception;
}
