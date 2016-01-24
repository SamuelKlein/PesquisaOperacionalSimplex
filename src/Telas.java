import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Telas extends JFrame {
	
	private static final long serialVersionUID = 1662660018541852485L;
	
	private JTextField[][] tfv;
	private JTextField[] tfNomeV;
	private JTextArea text;
	public Telas() {
		
		setLayout( null );
		
		setBounds( 0, 0, 850, 550 );
		text = new JTextArea();
		JScrollPane scroll = new JScrollPane( text );
		
		
		
		geraPlanilha( 6, 2 );
		setVisible( true );
		
		addWindowListener( new WindowListener() {
			
			public void windowOpened(WindowEvent e) {
				
			}
			
			public void windowIconified(WindowEvent e) {
				
			}
			
			public void windowDeiconified(WindowEvent e) {
				
			}
			
			public void windowDeactivated(WindowEvent e) {
				
			}
			
			public void windowClosing(WindowEvent e) {
				System.exit( 0 );
			}
			
			public void windowClosed(WindowEvent e) {
				System.exit( 0 );
			}
			
			public void windowActivated(WindowEvent e) {
				
			}
		});
	}
	
	
	private CalculaLinhas c = null;
	
	protected void calcular() {
		if( c == null ){
			c = new CalculaLinhas();
			Linhas linha = null;
			for (int i = 0; i < tfv.length; i++) {
				JTextField[] tf = tfv[ i ]; 
				linha = new Linhas( tf.length - 2 );
				linha.setLinha( i );
				linha.setBase( tf[ 0 ].getText() );
				linha.setValor( Double.parseDouble( tf[ 1 ].getText() ) );
				
				for (int j = 2; j < tf.length; j++) {
					linha.setXValor( tfNomeV[ j-2 ].getText(), j-2, Double.parseDouble( tf[ j ].getText() ) );	
				}
				c.addLinhas( linha );
			}		
		}	
		System.out.println( c.getlinhas() );
		c.geraNovasLinhas();
		
		System.out.println( "@@@@@@@@@@@@@@@@@@@@@@@@@ " );
		System.out.println( c.getlinhas() );
	}


	private JPanel geraPlanilha( int var, int restricoes ){
		
		JPanel panel = new JPanel();
		panel.setLayout( null );
		panel.setBounds( 10, 150, ( 85 * var ) + 30, ( 60 * restricoes )  );
		panel.setBorder( BorderFactory.createLineBorder( Color.BLACK ) );
		JTextField text = null;
		
		JLabel label = new JLabel( "BASE       VALOR" );
		label.setBounds( 30, 5, 550, 20 );
		panel.add( label );
		
		tfNomeV = new JTextField[ var ];
		
		for (int i = 0; i < tfNomeV.length; i++) {
			text = new JTextField();
			text.setBounds( ( ( i + 2 ) * 62 ) + 15, 5, 60, 20 );
			tfNomeV[ i ] = text;
			panel.add( text );
		}
		
		text = null;
		
		tfv = new JTextField[ restricoes + 1 ][ var + 2 ];
		for (int i = 0; i < tfv.length; i++) {
			int y = 25;
			if( text != null ){
				y = text.getY() + 20;
			}
			label = new JLabel( "" + i );
			label.setBounds( 5, y, 140, 20 );
			panel.add( label );
			JTextField[] sub = tfv[ i ];
			for (int j = 0; j < sub.length; j++) {
				text = new JTextField();
				text.setBounds( ( j * 62 )+ 15, y, 60, 20 );
				tfv[ i ][ j ] = text;
				panel.add( text );
			}
			
		}
		
		JButton bnt = new JButton( "calcula" );
		
		bnt.setBounds( 30 * var, 30 * ( restricoes + 1 ), 150, 35 );
		bnt.addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				calcular();
			}
			
		});
		
		panel.add( bnt );
		add( panel );
		return panel;
	}
	
	public static void main(String[] args) {
		new Telas();
	}
}