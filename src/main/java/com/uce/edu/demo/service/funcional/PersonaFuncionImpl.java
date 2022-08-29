package com.uce.edu.demo.service.funcional;

public class PersonaFuncionImpl implements IPersonaFunction<Integer,String>{

	@Override
	public Integer aplicar(String arg1) {
		// TODO Auto-generated method stub
		Integer edad=Integer.valueOf(arg1);
		return edad;
	}

}
