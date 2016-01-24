import java.math.BigDecimal;


public class Linhas{
		
	private String base;
	private int linha;
	
	private double valor;
	private double[] xNumero;
	
	private int posMaiorNegativo = -1;
	private double valorMaiorNegativo = 999999.99;		
	
	private String[] nomeVariavel;
	
	public Linhas( int nVariaveis ){
		xNumero = new double[ nVariaveis ];
		nomeVariavel = new String[ nVariaveis ];
	}
	
	public double getXValor( int variavel ) {
		return xNumero[ variavel ];
	}
	
	public String getNomeVariavel( int variavel ) {
		return nomeVariavel[ variavel ];
	}
	
	public void setXValor( String nomevariavel, int variavel, double valor ){
		xNumero[ variavel ] = valor;
		nomeVariavel[ variavel ] = nomevariavel;
		if( valorMaiorNegativo > valor ){
			posMaiorNegativo = variavel;
			valorMaiorNegativo = valor;
		}
	}
	
	public void setBase( String base ) {
		this.base = base;
	}
	
	public void setLinha(int linha) {
		this.linha = linha;
	}
	
	public void getLista(){
		System.out.print( base );
		System.out.print( " | " );
		System.out.print( valor );
		for (int i = 0; i < xNumero.length; i++) {
			System.out.print( " | " );
			System.out.print( xNumero[ i ] );
		}			
		System.out.print( " | " );
		System.out.print( linha );
	}
	
	public String getSLista(){
		StringBuilder sb = new StringBuilder();
		sb.append( base );
		sb.append( " | " );
		sb.append( valor );
		for (int i = 0; i < xNumero.length; i++) {
			sb.append( " | " );
			sb.append( xNumero[ i ] );
		}			
		sb.append( " | " );
		sb.append( linha );
		return sb.toString();
	}
	
	public void setValor( double valor ) {
		this.valor = valor;
	}
	
	public double getValor() {
		return valor;
	}
	
	public int getPosMaiorNegativo() {
		return posMaiorNegativo;
	}
	
	public void calcularRegra1( int pos ) {
		double valorPos = xNumero[ pos ];
		if( valorPos != 0 ){
			valorMaiorNegativo = 999999.99;
			
			double valorBkp = valor;
			try{
				valor = ajusta( valor / valorPos );
			} catch (Exception e) {
				valor = valorBkp;
			}
			
			for ( int i = 0; i < xNumero.length; i++ ) {
				double xNumeroBkp = xNumero[ i ];
				try{
					xNumero[ i ] = ajusta( xNumero[ i ] / valorPos );
				} catch (Exception e) {
					xNumero[ i ] = xNumeroBkp;
				}
				if( valorMaiorNegativo > xNumero[ i ] ){
					posMaiorNegativo = i;
					valorMaiorNegativo = xNumero[ i ];
				}
			}
			
		}
	}
	
	public void calcularRegra2( int pos, Linhas linhaBase ) {
		
		double valorPos = xNumero[ pos ];
		
		valorPos = -valorPos;
		valorMaiorNegativo = 999999.99;
		
		valor = ajusta( (  linhaBase.getValor() * valorPos ) + valor );
		
		for ( int i = 0; i < xNumero.length; i++ ) {
			if( i == 2 ){
				System.out.println( "\na: " + i );
				System.out.println( "b: " + xNumero[ i ] );
				System.out.println( "c: " + valor );
				System.out.println( "d: " + linhaBase.getXValor( i ) );
			}
			xNumero[ i ] = ajusta( ( linhaBase.getXValor( i ) * valorPos ) + xNumero[ i ] );
			if( i == 2 ){
				System.out.println( "\ne: " + i );
				System.out.println( "f: " + xNumero[ i ] );
				System.out.println( "g: " + valor );
				System.out.println( "h: " + linhaBase.getXValor( i ) );
			}
			if( valorMaiorNegativo > xNumero[ i ] ){
				posMaiorNegativo = i;
				valorMaiorNegativo = xNumero[ i ];
			}
		}
	}
	public static double ajusta ( double a ) {
		double resultado;
	    BigDecimal ba = new BigDecimal( a );
	    ba = ba.setScale( 5, BigDecimal.ROUND_HALF_UP );
	    resultado = ba.doubleValue();
	    
	    return resultado;
	}
}
