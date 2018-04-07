import java.nio.channels.FileChannel;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
public class AccountantDao {

	
	public static int save(String name,String password,String email,String address,String city,String contact){
		int status=0;
		try{
			String x=name+' '+password+' '+email+' '+address+' '+city+' '+contact;
			File file = new File("accountant.txt");
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write('\n');
			bw.write(x);
			bw.close();
			fw.close();
			status=1;
			return status;
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int delete(String id){
		int status=0;
		try{File file = new File("accountant.txt");
   	 InputStream in = new FileInputStream(file);
     Reader reader = new InputStreamReader(in);
     Reader buffer = new BufferedReader(reader);
    int c = 0;
    int k=1, n=-1;
    String name1="";
    int flag=0;
    while((c = buffer.read()) != -1) {
        char character = (char) c;
        if (character==' ')
        {
        	k++;
        	continue;
        }
        if(k==1){
        	name1=name1+character;
        }
        if(character=='\n'){
        	k=1;
        	n+=1;
        	if(id.equals(name1)){
        		reader.close();
        		buffer.close();
        		in.close();
        		flag=1;
        		break;
        	}
            name1="";
        } 
    }       
	if(name1.equals(id)){
		if(flag==0){
		n+=1;
		}
		in.close();
		reader.close();
		buffer.close();
	}else{
		reader.close();
		buffer.close();
		in.close();
		return(0);
	}
	 int lineNo = 0;
	 File file2 = new File("accountant.txt");
	 FileReader reader2 = new FileReader(file2);
	 Scanner scan = new Scanner(reader2);
	 StringBuilder sb = new StringBuilder("");
	 while(scan.hasNextLine()) {
	     String line = scan.nextLine();
	     System.out.println(scan);
	     if (lineNo != n) 
	    	 sb.append(line).append(System.getProperty("line.separator"));
	 lineNo+=1;
	 }
	 System.out.println(sb);
	 FileWriter writter = new FileWriter(file2);
	 writter.write(sb.toString());
	 writter.close();
	 try {
		    File file21 = new File("fileToTruncate");
		    FileChannel fileChannel = new FileOutputStream(file, true).getChannel();
		    fileChannel.truncate(fileChannel.size() - 1); //Removes last character
		    fileChannel.close();
		}
		catch (FileNotFoundException ex) {

		}
		catch (IOException ex) {

		}
	 return(1);
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static boolean validate(String name,String password){
		try{
			File file = new File("accountant.txt");
	    	 InputStream in = new FileInputStream(file);
	         Reader reader = new InputStreamReader(in);
	         Reader buffer = new BufferedReader(reader);
	        int c = 0;
	        int k=1;
	        String name1="",password1="";
	        while((c = buffer.read()) != -1) {
	            char character = (char) c;
	            if (character==' ')
	            {
	            	k++;
	            	continue;
	            }
	            if(k==1){
	            	name1=name1+character;
	            }
	            if(k==2){
	            	password1=password1+character;
	            }
	            if(character=='\n'){
	            	k=1;
	            	if(name.equals(name1) && password1.equals(password1)){
	            		in.close();
	            		return(true);
	            	}
	                name1="";
	                password1="";
	            } 
	        }       
			if(name1.equals(name) && password1.equals(password)){
				in.close();
				return(true);
			}else{
				in.close();
				return(false);
			}
		}
		catch(Exception e){System.out.println(e);}
		return false;
	}

}
