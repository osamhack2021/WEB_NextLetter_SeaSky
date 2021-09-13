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
		public retun형 함수명(parm형 parm명) throws Exception {
			return testMapper.함수명(parm명);
		}
	*/

}
