import java.math.BigDecimal;
import java.util.Vector;

public class Inicio {
	
	public Inicio(){
		
//		CalculaLinhas cl = new CalculaLinhas();
//		
//		Linhas linhas0 = new Linhas( 6 );
//		linhas0.setBase( "X0" );
//		linhas0.setValor( 0 );
//		linhas0.setXValor( 0, 1 );
//		linhas0.setXValor( 1, -3 );
//		linhas0.setXValor( 2, -1.5 );
//		linhas0.setXValor( 3, -6 );
//		linhas0.setXValor( 4, 0 );
//		linhas0.setXValor( 5, 0 );
//		linhas0.setLinha( 0 );
//		linhas0.getLista();
//		cl.addLinhas( linhas0 );
//		 
//		System.out.println();
//		Linhas linhas1 = new Linhas( 6 );
//		linhas1.setBase( "X4" );
//		linhas1.setValor( 300000 );
//		linhas1.setXValor( 0, 0 );
//		linhas1.setXValor( 1, 30 );
//		linhas1.setXValor( 2, 3 );
//		linhas1.setXValor( 3, 15 );
//		linhas1.setXValor( 4, 1 );
//		linhas1.setXValor( 5, 0 );
//		linhas1.setLinha( 1 );
//		linhas1.getLista();
//		cl.addLinhas( linhas1 );
//		
//		System.out.println();
//		Linhas linhas2 = new Linhas( 6 );
//		linhas2.setBase( "X5" );
//		linhas2.setValor( 1500000 );
//		linhas2.setXValor( 0, 0 );
//		linhas2.setXValor( 1, 12 );
//		linhas2.setXValor( 2, 4.5 );
//		linhas2.setXValor( 3, 15 );
//		linhas2.setXValor( 4, 0 );
//		linhas2.setXValor( 5, 1 );
//		linhas2.setLinha( 2 );
//		linhas2.getLista();
//		cl.addLinhas( linhas2 );
//		System.out.println( "\n$$$$$" );
//		
//		cl.geraNovasLinhas();
//		linhas0.getLista();
//		System.out.println();
//		linhas1.getLista();
//		System.out.println();
//		linhas2.getLista();
//		
//		System.out.println( "\n$$$$$" );
//		cl.geraNovasLinhas();
//		linhas0.getLista();
//		System.out.println();
//		linhas1.getLista();
//		System.out.println();
//		linhas2.getLista();
		
//		
//		CalculaLinhas cl = new CalculaLinhas();
//		
//		Linhas linhas0 = new Linhas( 6 );
//		linhas0.setBase( "X0" );
//		linhas0.setValor( 0 );
//		linhas0.setXValor( 0, 1 );
//		linhas0.setXValor( 1, -1 );
//		linhas0.setXValor( 2, -1 );
//		linhas0.setXValor( 3, 0 );
//		linhas0.setXValor( 4, 0 );
//		linhas0.setXValor( 5, 0 );
//		linhas0.setLinha( 0 );
//		linhas0.getLista();
//		cl.addLinhas( linhas0 );
//		 
//		System.out.println();
//		Linhas linhas1 = new Linhas( 6 );
//		linhas1.setBase( "X3" );
//		linhas1.setValor( 15 );
//		linhas1.setXValor( 0, 0 );
//		linhas1.setXValor( 1, 1 );
//		linhas1.setXValor( 2, 1 );
//		linhas1.setXValor( 3, 1 );
//		linhas1.setXValor( 4, 0 );
//		linhas1.setXValor( 5, 0 );
//		linhas1.setLinha( 1 );
//		linhas1.getLista();
//		cl.addLinhas( linhas1 );
//		
//		System.out.println();
//		Linhas linhas2 = new Linhas( 6 );
//		linhas2.setBase( "X4" );
//		linhas2.setValor( 10 );
//		linhas2.setXValor( 0, 0 );
//		linhas2.setXValor( 1, 1 );
//		linhas2.setXValor( 2, 0 );
//		linhas2.setXValor( 3, 0 );
//		linhas2.setXValor( 4, 1 );
//		linhas2.setXValor( 5, 0 );
//		linhas2.setLinha( 2 );
//		linhas2.getLista();
//		cl.addLinhas( linhas2 );
//		
//		System.out.println();
//		Linhas linhas3 = new Linhas( 6 );
//		linhas3.setBase( "X5" );
//		linhas3.setValor( 10 );
//		linhas3.setXValor( 0, 0 );
//		linhas3.setXValor( 1, 0 );
//		linhas3.setXValor( 2, 1 );
//		linhas3.setXValor( 3, 0 );
//		linhas3.setXValor( 4, 0 );
//		linhas3.setXValor( 5, 1 );
//		linhas3.setLinha( 3 );
//		linhas3.getLista();
//		cl.addLinhas( linhas3 );
//		
//		
//		System.out.println( "\n$$$$$" );
//		
//		cl.geraNovasLinhas();
//		linhas0.getLista();
//		System.out.println();
//		linhas1.getLista();
//		System.out.println();
//		linhas2.getLista();
//		System.out.println();
//		linhas3.getLista();
//		
//		System.out.println( "\n$$$$$" );
//		cl.geraNovasLinhas();
//		linhas0.getLista();
//		System.out.println();
//		linhas1.getLista();
//		System.out.println();
//		linhas2.getLista();
//		System.out.println();
//		linhas3.getLista();
//		
		CalculaLinhas cl = new CalculaLinhas();
		
		Linhas linhas0 = new Linhas( 8 );
		linhas0.setBase( "X0" );
		linhas0.setValor( -1120 );
		linhas0.setXValor( 0, 1 );
		linhas0.setXValor( 1, -237 );
		linhas0.setXValor( 2, -194 );
		linhas0.setXValor( 3, -151 );
		linhas0.setXValor( 4, 20 );
		linhas0.setXValor( 5, 0 );
		linhas0.setXValor( 6, 0 );
		linhas0.setXValor( 7, 0 );
		
		linhas0.setLinha( 0 );
		linhas0.getLista();
		cl.addLinhas( linhas0 );
		 
		System.out.println();
		Linhas linhas1 = new Linhas( 8 );
		linhas1.setBase( "X6" );
		linhas1.setValor( 24 );
		linhas1.setXValor( 0, 0 );
		linhas1.setXValor( 1, 12 );
		linhas1.setXValor( 2, 6 );
		linhas1.setXValor( 3, 0 );
		linhas1.setXValor( 4, -1 );
		linhas1.setXValor( 5, 0 );
		linhas1.setXValor( 6, 1 );
		linhas1.setXValor( 7, 0 );
		
		linhas1.setLinha( 1 );
		linhas1.getLista();
		cl.addLinhas( linhas1 );
		
		System.out.println();
		Linhas linhas2 = new Linhas( 8 );
		linhas2.setBase( "X7" );
		linhas2.setValor( 32 );
		linhas2.setXValor( 0, 0 );
		linhas2.setXValor( 1, 0 );
		linhas2.setXValor( 2, 4 );
		linhas2.setXValor( 3, 8 );
		linhas2.setXValor( 4, 0 );
		linhas2.setXValor( 5, 0 );
		linhas2.setXValor( 6, 0 );
		linhas2.setXValor( 7, 1 );
		
		linhas2.setLinha( 2 );
		linhas2.getLista();
		cl.addLinhas( linhas2 );
		
		System.out.println();
		Linhas linhas3 = new Linhas( 8 );
		linhas3.setBase( "X5" );
		linhas3.setValor( 20 );
		linhas3.setXValor( 0, 0 );
		linhas3.setXValor( 1, 2 );
		linhas3.setXValor( 2, 8 );
		linhas3.setXValor( 3, 4 );
		linhas3.setXValor( 4, 0 );
		linhas3.setXValor( 5, 1 );
		linhas2.setXValor( 6, 0 );
		linhas2.setXValor( 7, 0 );

		linhas3.setLinha( 3 );
		linhas3.getLista();
		cl.addLinhas( linhas3 );
		
		
		System.out.println( "\n$$$$$" );
		
		cl.geraNovasLinhas();
		linhas0.getLista();
		System.out.println();
		linhas1.getLista();
		System.out.println();
		linhas2.getLista();
		System.out.println();
		linhas3.getLista();
		
		System.out.println( "\n$$$$$" );
		cl.geraNovasLinhas();
		linhas0.getLista();
		System.out.println();
		linhas1.getLista();
		System.out.println();
		linhas2.getLista();
		System.out.println();
		linhas3.getLista();
	
	}
	
	
	public static void main(String[] args) {
		new Inicio();
	}
	
}