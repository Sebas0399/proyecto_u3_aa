package com.uce.edu.demo.service.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainInterfacesFuncionales {
	private static Logger LOG = LogManager.getLogger(MainInterfacesFuncionales.class.getName());
	public static boolean prueba() {
		return true;
	}
	public static void impresion(String cadena) {
		LOG.info("Impresion: "+cadena);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConsumoMetodosHighOrder metodosHo = new ConsumoMetodosHighOrder();

		// SUPPLIER
		// Clases

		IPersonaSupplier<Integer> supplier = new PersonaSupplierImpl();
		LOG.info("Supplier Clase: " + supplier.getEdad());
		// Lambdas
		IPersonaSupplier<Integer> supplierLambda = () -> 23;
		LOG.info("Supplier Lambda: " + supplierLambda.getEdad());

		// HO
		Integer valor = metodosHo.consumirSuplier(() -> 23);
		LOG.info("HO supplier: " + valor);
		//JAVA
		///Supplier<T>l;
		System.out.println("JAVA FUNCION");
		Stream<String> test=Stream.generate(()->"Antony").limit(5);
		test.forEach(cadena->System.out.println(cadena));
		
		// CONSUMER
		// Clases
		IPersonaConsumer<Integer> consumerPersona = new PersonaConsumerImpl();
		consumerPersona.accept(23);

		
		// Lambdas
		IPersonaConsumer<Integer>comsummerLambda=(y)->System.out.println("Edad: "+y);
		comsummerLambda.accept(23);
		// Metodos HigORder
		metodosHo.consumirConsumer(e -> System.out.println("Edad: "+e), 23);
		//JAVA
		System.out.println("JAVA CONSUMER");
		List<Integer>listaNumeros=Arrays.asList(1,2,3,4,5);
		listaNumeros.forEach((arg)->System.out.println(arg));
		
		
		// PREDICATE
		// Clases
		IPersonaPredicate<Integer>predicateClse=new PersonaPredicateImpl();
		LOG.info("Predicate Clase: "+predicateClse.evaluar(11));
		// Lambdas
		IPersonaPredicate<Integer> predicateLambda = cadena -> {
			if(cadena<10) {
				return true;
			}
			else {
				return false;
			}
		};
		LOG.info("Predicate Lamda: " + predicateLambda.evaluar(20));
		// MetodosHO
		boolean respuesta = metodosHo.consumirPredicate(cadena -> cadena<10,40);
		LOG.info("HOpredicate " + respuesta);
		//JAVA
		System.out.println("JAVA PREDICATE");
		Stream<Integer>nuevaLista=listaNumeros.stream().filter(numero->numero>=3);
		nuevaLista.forEach(numero->System.out.println(numero));
		// FUNCTION
		// Clases
		IPersonaFunction<Integer, String>personaFun=new PersonaFuncionImpl();
		LOG.info("Edad: "+personaFun.aplicar("19"));
		// Lambdas
		IPersonaFunction<String, Integer> funcLambda = cadena -> {
			Integer aval = (cadena);
			Integer valorFinal = aval - 2;
			return "Edad hace dos años: "+valorFinal;
		};
		LOG.info("Function lambda; " + funcLambda.aplicar(40));
		// HOMetodos
		String avalFn = metodosHo.consumirFunction(aval -> {
			String rer = "Edad actual: "+aval.toString();
			return rer;
		}, 1);
		LOG.info("HO function " + avalFn);
		//JAVA FUNCTION
		LOG.info("JAVA FUNCION");
		Stream <String>listaCambiada=listaNumeros.stream().map(numeroLista->{
			Integer value=numeroLista+1;
			String cadena="num: "+value.toString();
		return cadena;
		});
		listaCambiada.forEach(val->impresion(val));
		// UNARY OPERATOR (FUNCTION
		IPersonaFunctionUnaryOperator<String>personaFunUO=new PersonaFuncionUOImpl();
		LOG.info("Edad: "+personaFunUO.aplicar("19"));
		// Clases
		IPersonaFunctionUnaryOperator<String>unaryClass=new PersonaFuncionUOImpl();
		LOG.info("FuncionUO class Edad: "+unaryClass.aplicar("40"));
		
		// Lambdas
		IPersonaFunctionUnaryOperator<Integer> unaryLambda = cadena -> {
			Integer valorFinal = cadena-1;
			
			return valorFinal;
		};
		LOG.info("FuncionUO Lambdas: " + unaryLambda.aplicar(20));

	}

}
