package com.uce.edu.demo.service.funcional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class MainInterfacesFuncionales {
	private static Logger LOG = LogManager.getLogger(MainInterfacesFuncionales.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		// CONSUMER
		// Clases
		IPersonaConsumer<String>consumerPersona=new PersonaConsumerImpl();
		consumerPersona.accept("Antony Consumer");
		
		IPersonaConsumer<String>consumerLambda=cadena->System.out.println("cadena");
		consumerLambda.accept("Antony Consumer Lambda");
		// Lambdas

		// PREDICATE
		// Clases
		// Lambdas

		// FUNCTION
		// Clases
		// Lambdas

		// UNARY OPERATOR (FUNCTION
		// Clases
		// Lambdas

	}

}
