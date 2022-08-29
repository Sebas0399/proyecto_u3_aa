package com.uce.edu.demo.service.funcional;

public class ConsumoMetodosHighOrder {
public Integer consumirSuplier(IPersonaSupplier<Integer> funcion) {

	return funcion.getEdad();
}
public void consumirConsumer(IPersonaConsumer<Integer>funcion,Integer valor) {
	funcion.accept(valor);
}
public boolean consumirPredicate(IPersonaPredicate<Integer>funcion,Integer valor){
	return funcion.evaluar(valor);
	
}
public String consumirFunction(IPersonaFunction<String, Integer>funcion,Integer valor) {
	return funcion.aplicar(valor);
}


public String consumirFunctionUO(IPersonaFunctionUnaryOperator<String>funcion,String valor) {
	return funcion.aplicar(valor);
}
}
