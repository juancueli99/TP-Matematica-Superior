package Test;

import static org.junit.Assert.fail;

import org.junit.Test;

import EDT.NumeroComplejo;
import OA.OperacionesAvanzadas;
import OB.Operacion;
import SF.Fasores;
import SF.SumaDeFasores;
import SF.TienenDistintoFrecuenciaException;
import junit.framework.Assert;

public class Tests {
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSuma(){
		
		NumeroComplejo numero1= new NumeroComplejo();
		NumeroComplejo numero2= new NumeroComplejo();
		Operacion operacionBasica= new Operacion();
		
		
		numero1.setParteImaginaria(1);
		numero1.setParteReal(1);
		numero1.setFase(numero1.obtenerFase());
		numero1.setModulo(numero1.obtenerModulo());

		
		numero2.setModulo(1);
		numero2.setParteImaginaria(0);
		numero2.setParteReal(1);
		numero2.setFase(numero2.obtenerFase());
		
		
		NumeroComplejo numeroResultado= operacionBasica.resta(numero1, numero2);
		
		Assert.assertEquals((0.0), numeroResultado.getParteReal(), 0.01);
		
		
		
		
	}
	
	
	@Test
	public void testExcepcionCuandoSumaFasoresDistintaFrecuencias() {
		
		Fasores fasor1= new Fasores();
		Fasores fasor2= new Fasores();
		SumaDeFasores sumadorFasores= new SumaDeFasores();
		
		fasor1.setEsCoseno(true);
		fasor1.setAmplitud(8);
		fasor1.setFrecuencia(2);
		fasor1.setFase(Math.PI);
		

		fasor2.setEsCoseno(true);
		fasor2.setAmplitud(8);
		fasor2.setFrecuencia(5);
		fasor2.setFase(2*(Math.PI));
		
		
		try {sumadorFasores.realizarOperacion(fasor1, fasor2); 
		}	catch(TienenDistintoFrecuenciaException e){ return;} fail();}
	
	
	@Test
	public void testDivision() {
		
		NumeroComplejo numero1= new NumeroComplejo();
		NumeroComplejo numero2= new NumeroComplejo();
		Operacion operacionBasica= new Operacion();
		
		
		numero1.setParteImaginaria(1);
		numero1.setParteReal(3);
		numero1.setFase(numero1.obtenerFase());
		numero1.setModulo(numero1.obtenerModulo());

		
		
		numero2.setParteImaginaria(-2);
		numero2.setParteReal(-2);
		numero2.setFase(numero2.obtenerFase());
		numero2.setModulo(numero2.obtenerModulo());

		
		NumeroComplejo numeroResultado= operacionBasica.cociente(numero1, numero2);

		Assert.assertEquals(-0.5, numeroResultado.getParteImaginaria(), 0.001);
		
	}
	
	
	@Test
	public void testMultiplicacion() {
		
		
		NumeroComplejo numero1= new NumeroComplejo();
		NumeroComplejo numero2= new NumeroComplejo();
		Operacion operacionBasica= new Operacion();
		
		
		numero1.setParteImaginaria(3);
		numero1.setParteReal(4);
		numero1.setFase(numero1.obtenerFase());
		numero1.setModulo(numero1.obtenerModulo());

		
		
		numero2.setParteImaginaria(-4);
		numero2.setParteReal(3);
		numero2.setFase(numero2.obtenerFase());
		numero2.setModulo(numero2.obtenerModulo());

		
		
		NumeroComplejo numeroResultado= operacionBasica.multiplicacion(numero1, numero2);

		Assert.assertEquals(24.0, numeroResultado.getParteReal(), 0.01);
		
	}
	
	

	@Test
	public void testSumaFasores() throws TienenDistintoFrecuenciaException {
		
		Fasores fasor1= new Fasores();
		Fasores fasor2= new Fasores();
		SumaDeFasores sumadorFasores= new SumaDeFasores();
		
		fasor1.setEsCoseno(true);
		fasor1.setAmplitud(4);
		fasor1.setFrecuencia(3);
		fasor1.setFase(((Math.PI)/4));
		

		fasor2.setEsCoseno(true);
		fasor2.setAmplitud(6);
		fasor2.setFrecuencia(3);
		fasor2.setFase((-(Math.PI)/3));
		
		Fasores fasorResultado= sumadorFasores.realizarOperacion(fasor1, fasor2);
		double resultado= (( fasorResultado.getAmplitud()));
		
		Assert.assertEquals(6.29 ,resultado ,0.01);
		
		
	}
	
	
	@Test
	public void testPasarPolarABinomica() {
		
		NumeroComplejo numero= new NumeroComplejo();
		
		numero.setFase((Math.PI)/4);
		numero.setModulo((float) (Math.sqrt(2.0)));
		numero.ObtenerParteImaginariayReal();
		
		
		Assert.assertEquals(1, numero.getParteReal(), 0.000001);
		
		
		
		
		
		
		
		
		
	}
	

	@Test
	public void testPotenciacion() {
		
		

		NumeroComplejo numero1= new NumeroComplejo();
		OperacionesAvanzadas operacionAvanzada= new OperacionesAvanzadas();
		
		
		numero1.setParteImaginaria(-1);
		numero1.setParteReal(3);
		numero1.setFase(numero1.obtenerFase());
		numero1.setModulo(numero1.obtenerModulo());

		
		float resultadoEsperado= (float) Math.sqrt(10.0);
		resultadoEsperado= (float) Math.pow(resultadoEsperado, 5);
		
		
		NumeroComplejo numeroResultado= operacionAvanzada.potenciacion(numero1, 5);

		Assert.assertEquals(resultadoEsperado, numeroResultado.getModulo(), 0.01);

		
		
	}
	
	
	@Test
	public void testRadicacion() {
		

		NumeroComplejo numero1= new NumeroComplejo();
		OperacionesAvanzadas operacionAvanzada= new OperacionesAvanzadas();
		
		
		numero1.setParteImaginaria(1);
		numero1.setParteReal(1);
		numero1.setFase(numero1.obtenerFase());
		numero1.setModulo(numero1.obtenerModulo());

		
		
		
		NumeroComplejo numeroResultado= operacionAvanzada.radicacion(numero1, 3);

		Assert.assertEquals(1.12246, numeroResultado.getModulo(),0.00001);	
		
		
		
	}
		
		
		
		
		
	
	
	
	
	
	
	

}
