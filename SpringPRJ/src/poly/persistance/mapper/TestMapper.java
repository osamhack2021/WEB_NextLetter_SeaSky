package poly.persistance.mapper;



import config.Mapper;


@Mapper("TestMapper")
public interface TestMapper {
	//public retun형 함수명(parm형 parm명) throws Exception;
	public String testMethod() throws Exception;
}
