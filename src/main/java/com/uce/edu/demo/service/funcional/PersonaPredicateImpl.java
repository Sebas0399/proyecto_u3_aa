package com.uce.edu.demo.service.funcional;

public class PersonaPredicateImpl implements IPersonaPredicate<Integer>{

	@Override
	public boolean evaluar(Integer arg1) {
		// TODO Auto-generated method stub
		if(arg1<10) {
			return true;
		}
		return false;
	}

}
