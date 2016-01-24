import java.util.Vector;

public class CalculaLinhas{
		
	private double valor = 9999999999.99;
	private int posValor = 0;
	
	private Vector<Linhas> vc = new Vector<Linhas>();
	
	public void addLinhas( Linhas linha ){
		if( linha.getValor() > 0 && valor > linha.getValor() ){
			valor = linha.getValor();
			posValor = vc.size();
		}
		vc.add( linha );
	}
	
	public void geraNovasLinhas(){
		int pos = 0;
		if( vc.size() > 0 ){
			pos = vc.get( 0 ).getPosMaiorNegativo();
			
			Linhas linhaBase = vc.get( posValor );
			linhaBase.setBase( linhaBase.getNomeVariavel( pos ) );
			linhaBase.calcularRegra1( pos );
			
			for (int i = 0; i < vc.size(); i++) {
				if( i != posValor ){
					Linhas lc = vc.get( i );
					lc.calcularRegra2( pos, linhaBase );
				}
			}
		}
		valor = 99999;
		for (int i = 1; i < vc.size(); i++) {
			Linhas linha = vc.get( i );
			if( valor > linha.getValor() ){
				valor = linha.getValor();
				posValor = i;
			}
		}
		
	}
		
	public String getlinhas(){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < vc.size(); i++) {
			sb.append( vc.get(i).getSLista() );
			sb.append( "\n" );
		}
		return sb.toString();
	}
		
}