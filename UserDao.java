import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserDao {
public static int save(String rollno,String name,String balance,String state,String rank){
	int status=0;
	try{
		String x=rollno+' '+name+' '+balance+' '+state+' '+rank;
		File file = new File("user.txt");
		FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write('\n');
		bw.write(x);
		bw.close();
		fw.close();
		status=1;
		return status;
	}
	catch(Exception e){System.out.println(e);}
	return status;
}
}
