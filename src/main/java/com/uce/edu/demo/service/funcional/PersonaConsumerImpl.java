package com.uce.edu.demo.service.funcional;

public class PersonaConsumerImpl implements IPersonaConsumer<Integer> {

	@Override
	public void accept(Integer arg1) {
		// TODO Auto-generated method stub
		System.out.println("Edad: "+arg1);
	}

}
