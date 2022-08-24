package com.uce.edu.demo.service.funcional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class MainInterfacesFuncionales {
	private static Logger LOG = LogManager.getLogger(MainInterfacesFuncionales.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConsumoMetodosHighOrder metodosHo=new ConsumoMetodosHighOrder();
		
		
		//SUPPLIER
		// Clases
		
		IPersonaSupplier<String>supplier=new PersonaSupplierImpl();
		LOG.info("Supplier Clase: "+supplier.getNombre());
		
		IPersonaSupplier<String>supplierTE=new PersonaSupplierTEImpl();
		LOG.info("Supplier ClaseTE: "+supplierTE.getNombre());
		// Lambdas
		IPersonaSupplier<String>supplierLambda=()->"Antony 2";
		LOG.info("Supplier Lambda: "+supplierLambda.getNombre());
		
		IPersonaSupplier<String>supplierTE2=()->"Antony TE 2";
		LOG.info("Supplier ClaseTE: "+supplierTE2.getNombre());
		//Metodos HO
		String valor=metodosHo.consumirSuplier(()->"Hola Mundo");
		LOG.info("HO supplier: "+valor);
		
		String valorHo=metodosHo.consumirSuplier(()->{
			String val="";
			return val;
		});
		LOG.info("HO supplier: "+valor);
		// CONSUMER
		// Clases
		IPersonaConsumer<String>consumerPersona=new PersonaConsumerImpl();
		consumerPersona.accept("Antony Consumer");
		
		IPersonaConsumer<String>consumerLambda=cadena->System.out.println("cadena");
		consumerLambda.accept("Antony Consumer Lambda");
		// Lambdas
//Metodos HigORder
		metodosHo.consumirConsumer(cadena->System.out.println(cadena), 2);
		
		// PREDICATE
		// Clases
		// Lambdas
		IPersonaPredicate<String>predicateLambda=cadena->cadena.contains("z");
		LOG.info("Predicate Lamda: "+predicateLambda.evaluar("Manxz"));
//MetodosHO
		boolean respuesta=metodosHo.consumirPredicate(cadena->cadena.contains("z"), "zzebasz");
		LOG.info("HOpredicate "+respuesta);
		
		// FUNCTION
		// Clases
		// Lambdas
		IPersonaFunction<Integer, String>funcLambda=cadena->{
			Integer aval=Integer.parseInt(cadena);
			Integer valorFinal=aval-2;
			return valorFinal;
		};
		LOG.info("Function lambda; "+funcLambda.aplicar("9"));
//HOMetodos
		String avalFn=metodosHo.consumirFunction(aval->{
			String rer=aval.toString()+"A";
			return rer;
		}, 1);
		LOG.info("HO function "+avalFn);
		// UNARY OPERATOR (FUNCTION
		// Clases
		// Lambdas
IPersonaFunctionUnaryOperator<String> unaryLambda=cadena->{
	String valorFinal=cadena.concat("sufijo");
	return valorFinal;
};
LOG.info("Predicate Lambdas: "+unaryLambda.aplicar("Antony"));
	}

}
