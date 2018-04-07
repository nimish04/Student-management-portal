import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.Runnable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class ViewAccountant extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAccountant frame = new ViewAccountant();
					frame.getContentPane().setBackground(Color.BLUE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewAccountant() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		
		String data[][]=null;
		String column[]=null;
		try{
			
			column = new String[6];
			column[0]="Name";
			column[1]="Password";
			column[2]="e-mail";
			column[3]="age";
			column[4]="city";
			column[5]="contact number";
			File file = new File("accountant.txt");
		   	InputStream in = new FileInputStream(file);
		    Reader reader = new InputStreamReader(in);
		    Reader buffer = new BufferedReader(reader);
			int k=1, n=0;
			int c=0;
		    int flag=0;
		    while((c = buffer.read()) != -1) {
		        char character = (char) c;
		        if(character=='\n'){
		        	n+=1;
		        } 
		    }
		    if(n!=0)
		      n+=1;
		    in.close();
			reader.close();
			buffer.close();
		    int rows=n;
		    data=new String[rows][6]; 
		   		    
		    File file2 = new File("accountant.txt");
		   	 InputStream inp = new FileInputStream(file);
		     Reader reader2 = new InputStreamReader(inp);
		     Reader buffer2 = new BufferedReader(reader2);
		    int c2 = 0;
		    int k2=1;
		    String name1="";
		    int i=0,j=0;
		    while((c2 = buffer2.read()) != -1) {
		        char character = (char) c2;
		        if (character==' ')
		        {
		        	data[i][j]=name1;
		        	name1="";
		        	if(j+1<6)
		        		j+=1;
		        	else
		        		j=0;
		        }
		        else if (character=='\n'){
		        	data[i][j]=name1;
		        	name1="";
		        	i+=1;
		        	j=0;
		        }
		        else{
		        	name1=name1+character;
		        }
		        }        
			
		data[i][j]=name1;
	    in.close();
		reader.close();
		buffer.close();
		
		
			
		}catch(Exception e){System.out.println(e);}
		
		table = new JTable(data,column);
		JScrollPane sp=new JScrollPane(table);
		
		contentPane.add(sp, BorderLayout.CENTER);
	}

}
