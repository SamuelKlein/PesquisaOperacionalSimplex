import java.util.Vector;

public class ConverteFormulaEmSimplex {
	
	private String MaxOuMin = "";
	private Vector<String> vVariaveis = new Vector<String>();
	
	private Vector<String[]> vFormulas = new Vector<String[]>();
	private Vector<String> vlinha = new Vector<String>();
		
	private String[] bases = null;
	private int qtBaseY = 0;
	private double valorMGrande = 1000;
	
	public ConverteFormulaEmSimplex( String formula ){
		String[] split = formula.split( "\n" );
		
		for (int i = 0; i < split.length; i++) {
			vFormulas.add( split[ i ].split( "[ ]" ) );
			vlinha.add( split[ i ] );
		}
		
		investeMinParaMax();
		converteParaEquacaoAX0();
		int qtx = converteParaEquacaoLinhas();
		procurarBase( qtx );
		
		vFormulas.clear();
		for (int i = 0; i < vlinha.size(); i++) {
			vFormulas.add( vlinha.get( i ).split( "[ ]" ) );
		}
		
		buscaVariaveis();
		
		aplicarMGrande();
		
		for (int i = 0; i < bases.length; i++) {
			System.out.println( bases[ i ] );
		}
		
		
		for (int i = 0; i < vlinha.size(); i++) {
			System.out.println( vlinha.get( i ) );
		}
		
		
		
		
		
	}
	
	private void buscaVariaveis() {
		String[] funcaoO = vFormulas.get( 0 );
		for (int i = 0; i < funcaoO.length -2; i++) {
			String campo = funcaoO[ i ];
			System.out.println( campo );
			System.out.println("$$$$$$$$" );
			int posC = posInicialDaVariavel( campo );
			System.out.println( campo.substring( posC ) );
			
		}
	}

	private int posInicialDaVariavel( String campo ) {
		
		for (int j = 0; j < campo.length(); j++) {
			switch ( campo.charAt( j ) ){
				case '+':
				case '-':
				case '.':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
				case '0':
					break;
				default : 
					return j;
			}
		}
		return 0;
	}

	private void aplicarMGrande() {
		for (int i = 0; i < bases.length; i++) {
			if( bases[ i ] == null ){
				qtBaseY ++;
				bases[ i ] = "Y" + qtBaseY;
				adicioneYNaLinha( i );
			}
		}
	}

	private void adicioneYNaLinha( int i ) {
		StringBuilder sb = new StringBuilder();
		String funcaoO = vlinha.get( 0 ).toString();
		
		sb.append( funcaoO.substring( 0, funcaoO.indexOf( "=" ) ) );
		sb.append( "+" + valorMGrande + "Y" + qtBaseY );
		sb.append( " " );
		sb.append( funcaoO.substring( funcaoO.indexOf( "=" ) ) );
		
		vlinha.remove( 0 );
		vlinha.add( 0, sb.toString() );
		
		String linha = vlinha.get( i ).toString();
		sb.delete( 0, sb.length() );
		sb.append( linha.substring( 0, linha.indexOf( "=" ) ) );
		sb.append( "+1Y" + qtBaseY );
		sb.append( " " );
		sb.append( linha.substring( linha.indexOf( "=" ) ) );
		
		vlinha.remove( i );
		vlinha.add( i, sb.toString() );
		
	}

	private void procurarBase( int qtx ) {
		bases = new String[ vlinha.size() ];
		for( int i = 0; i < qtx; i++) {
			boolean contem = false;
			int linha = 0;
			for (int j = 0; j < vlinha.size(); j++) {
				if( !contem ){
					linha = j;
					contem = vlinha.get( j ).contains( "+1X" + i );
				} else {
					contem = !vlinha.get( j ).contains( "+1X" + i );
				}
			}
			
			if( contem ){
				bases[ linha ] = "X" + i;
			}
		}
		
		
	}



	private int converteParaEquacaoLinhas() {
		StringBuilder sb = null;	
		int qtX = 1;
		for (int j = 1; j < vFormulas.size(); j++) {
			sb = new StringBuilder();
			
			for (int i = 0; i < vFormulas.get(j).length; i++) {
				String campo = vFormulas.get( j )[ i ];
				if( campo.contains( "[=]" ) ){
				} else if( campo.contains( ">=" ) ){
					sb.append( " -1X" + qtX ++ + " =" );
				} else if(campo.contains( "<=" ) ) {
					sb.append( " +1X" + qtX ++ + " =" );
				} else {
					sb.append( " " + vFormulas.get(j)[ i ] );
				}
			}	
			vlinha.add( sb.toString().trim() );
		}
		return qtX;
	}



	private void converteParaEquacaoAX0() {
		String[] sub = new String[ vFormulas.get(0).length + 2 ];
		
		sub[ 0 ] = "+1X0";
		for (int i = 1; i < vFormulas.get(0).length; i++) {
			if( vFormulas.get( 0 )[ i ].startsWith( "+" ) ){
				sub[ i ] = vFormulas.get( 0 )[ i ].replaceAll( "[+]", "-" );
			} else if( vFormulas.get( 0 )[ i ].startsWith( "-" ) ){
				sub[ i ]  = vFormulas.get( 0 )[ i ].replaceAll( "[-]", "+" );
			} else {
				sub[ i ] = "-" + vFormulas.get( 0 )[ i ];
			}
		}
		
		sub[ vFormulas.get(0).length ] = "=";
		sub[ vFormulas.get(0).length + 1 ] = "0";
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sub.length; i++) {
			sb.append( " " + sub[ i ] );
		}
		
		vlinha.clear();
		vlinha.add( sb.toString().trim() );
		
	}



	private void investeMinParaMax() {
		MaxOuMin = vFormulas.get( 0 )[ 0 ];
		
		if( MaxOuMin.trim().equalsIgnoreCase( "MIN" ) ){
			vFormulas.get(0)[ 0 ] = "MAX";
			for (int i = 1; i < vFormulas.get(0).length; i++) {
				if( vFormulas.get( 0 )[ i ].startsWith( "+" ) ){
					vFormulas.get( 0 )[ i ] = vFormulas.get( 0 )[ i ].replaceAll( "[+]", "-" );
				} else if( vFormulas.get( 0 )[ i ].startsWith( "-" ) ){
					System.out.println( "entrouuuu +++ " );
					vFormulas.get( 0 )[ i ] = vFormulas.get( 0 )[ i ].replaceAll( "[-]", "+" );
				} else {
					vFormulas.get( 0 )[ i ] = "-" + vFormulas.get( 0 )[ i ];
				}
			}
		}
	}



	public static void main( String[] args ) {
		StringBuilder sb = new StringBuilder();
		
//		sb.append( "MAX 3A +1.5B +6C\n" );
//		sb.append( "30A +3B +15C <= 300000\n" );
//		sb.append( "12A +4.5B +15C <= 1500000" );
		
		sb.append( "min 3a +2.5b\n" );
		sb.append( "30a +40b >= 120\n" );
		sb.append( "40a +40b <= 80" );
		
		ConverteFormulaEmSimplex c = new ConverteFormulaEmSimplex( sb.toString() );
	}
}