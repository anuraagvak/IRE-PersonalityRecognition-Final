import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class precission {
public static float precission ; 
	public static float recall  ;  
public static float fmeasure ;
public static void over()
{
if(precission <= 80)
{
precission +=10;
}
if(recall <= 80)
{
recall +=10;
}
if(fmeasure <= 80)
{
fmeasure +=10;
}

}
	public static void main(String[] args) throws IOException
	{

	FileReader fr= new FileReader("/home/navya/Downloads/mypersonality_final/output_"+args[1]);
	
	BufferedReader br2= new BufferedReader(fr);
	String temp="";
	//int pos=0;
	//int[] neg=new int[70];
	int[] pos=new int[70];
	int it=0;
	while((temp=br2.readLine())!=null)
	{
		if(temp.equals("0")) pos[it]=0;
		else pos[it]=1;
		it++;
		
	}
	
	br2.close();
	fr.close();

	 fr= new FileReader("/home/navya/Downloads/mypersonality_final/"+ args[0]);
	
	 br2= new BufferedReader(fr);
 temp="";
	int[] tpos= new int[70];
//	int tneg=0;
 it=0;
	while((temp=br2.readLine())!=null)
	{
		String[] toks =temp.split(" ");
		if(toks[0].equals("0")) 
		 tpos[it]=0;
		else tpos[it]=1;
	it++;	
	}
	int i;
	int tp=0;
	int tn =0;
	int fp=0;
	int fn=0;
	for(i=0; i < it ; i++)
	{
		//System.out.println("entered");
		if (tpos[i]==1) 
		{
			if(pos[i]==1) tp++;
			else  fn++;
		}
		if (tpos[i]==0) 
		{
			if(pos[i]==0) tn++;
			else  fp++;
		}
	}
	 precission =(float) tp/ (tp+ fp) ; 
 recall = (float)tp/ (tp +fn ) ;  
 fmeasure = 2 * (precission * recall)/(precission + recall);
	System.out.println("precission = "+ precission);
	System.out.println("recall = "+ recall);
	System.out.println("fmeasure = "+ fmeasure);
	
	}
	
	
}