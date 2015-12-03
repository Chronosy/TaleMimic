package IndieCrypter;
import java.awt.event.*;
import javax.swing.JOptionPane;


public class EventHandler extends Function implements ActionListener{
	Gui g;

	/**
	 * @wbp.parser.entryPoint
	 */
	public EventHandler(){
		g = new Gui();
		g.enc.addActionListener(this);
		g.dec.addActionListener(this);
		g.cop.addActionListener(this);
		g.pas.addActionListener(this);
		g.exp.addActionListener(this);
		g.imp.addActionListener(this);
		g.select.addActionListener(this);
		g.enc1.addActionListener(this);
		g.dec1.addActionListener(this);
		g.string.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
					g.string.setText("");					
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		//Text encryption
		if(source == g.enc){
			if(g.Show()== JOptionPane.OK_OPTION){
				g.result.setText(Encryption(g.string.getText(), g.passwd.getText()));
				g.passwd.setText("");
			}else{
				JOptionPane.showMessageDialog(null, "Canceled");
			}
		}
		else if(source==g.dec){
			if(g.Show()== JOptionPane.OK_OPTION){
				g.result.setText(Decryption(g.string.getText(),g.passwd.getText()));
				g.passwd.setText("");
			}else{
				JOptionPane.showMessageDialog(null, "Canceled");
			}
		}
		else if(source==g.cop){
			g.result.selectAll();
			g.result.copy();			
		}
		else if(source==g.pas){
			g.string.setText("");
			g.string.paste();
		}
		else if(source==g.exp){
			Export(g.result.getText());
		}
		else if(source==g.imp){
			g.string.setText(Import());
			g.result.setText("String");
		}
		//Steganography
		else if(source==g.select){
			g.source.setText(Select());
		}
		
		else if(source==g.enc1){
			if(g.source.getText().length()!=0){
				if(g.Show()== JOptionPane.OK_OPTION){
					StegaEnc(g.message.getText(), g.passwd.getText());
				}else{
					JOptionPane.showMessageDialog(null, "Canceled");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Please Select An Image File!");
			}
		}
		
		else if(source ==g.dec1){
			if(g.source.getText().length()!=0){
					g.message.setText(StegaDec());
			}else{
				JOptionPane.showMessageDialog(null, "Please Select An Image File!");
			}
		}
	}
}
