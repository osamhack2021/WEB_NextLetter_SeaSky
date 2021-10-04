package poly.persistance.mapper;



import java.util.List;

import config.Mapper;
import poly.dto.MessageDTO;


@Mapper("MessageMapper")
public interface MessageMapper {
	public MessageDTO insertMessage(MessageDTO mDTO) throws Exception;
	public List<MessageDTO> getMessage(String user_no) throws Exception;
}
