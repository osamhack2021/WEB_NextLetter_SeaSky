package poly.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.persistance.mapper.TestMapper;
import poly.service.ITestService;

@Service("TestService")
public class TestService implements ITestService {

	@Resource(name = "TestMapper")
	private TestMapper testMapper;
	
	/*
		@Override
		public retun�� �Լ���(parm�� parm��) throws Exception {
			return testMapper.�Լ���(parm��);
		}
	*/

}
