import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class correlation {
	public static void cal_correl(float[][]x , float[][]y , int users , int k , int l )
	{
		//System.out.println("ntr");
		float a=0;
		float b=0;
		
		for(int i=0;i< users ; i++)
		{
			a = a+ x[i][k]*x[i][k]; 
			b = b+ x[i][k] ; 
			
		}
	float x1 = a - (b *b)/users;
	a=0;
	b=0;
	for(int i=0;i< users ; i++)
	{
		a = a+ y[i][l]*y[i][l]; 
		b = b+ y[i][l] ; 
		
	}
	float y1 = a - (b *b)/users;
	a=0;
	b=0;
	float as=0;
	float bs=0;
	for(int i=0;i< users ; i++)
	{
		a = a+ x[i][k]*y[i][l]; 
	 as = as+ x[i][k];
	 bs = bs+ y[i][l];
		
	}
	float xy = a - (as*bs)/users;
	double val = (double )xy/(Math.sqrt(x1*y1));
	//System.out.println(x1+"  "+y1);
	System.out.println("feature:" + k +"class:"+l +"   "+val);
	
	}

	public static void main(String[] args) throws IOException
	
	
	{
		FileReader fr= new FileReader("/home/navya/Downloads/mypersonality_final/vectors_n/ext_traindata");
		
		BufferedReader br2= new BufferedReader(fr);
		String temp="";
		//int pos=0;
		//int[] neg=new int[70];
		int length=10;
		float[][] x=new float[181][length];
		float [][] y= new float[181][5] ;
		Integer it=0;
		int siz=0;
		while((temp=br2.readLine())!=null)
		{
			String[] toks= temp.split(" ");
			for(int i=1; i< toks.length; i++)
			{
				String vals=toks[i].split(":")[1] ;
				x[it][i-1]=Integer.parseInt(vals) ;
				
				siz++;
			}
it++;

length=siz;
siz=0;
		}
		Integer users=it ;
		//length=siz;
		br2.close();
		fr.close();
		 fr= new FileReader("/home/navya/Downloads/mypersonality_final/mypersonality_final.csv");
			
 br2= new BufferedReader(fr);
 it=0;
 temp=br2.readLine();
 ArrayList <String> user_id= new  ArrayList <String> ();
 while((temp=br2.readLine())!=null)
	{
	 String[] toks= temp.split(",");
	
	 if(user_id.contains(toks[0]))
		 continue;
	 else
	 {
		 System.out.println(toks[0]);
		 user_id.add(toks[0]);
	 }
	 siz=0;
	 for(int i=toks.length -14-4 ;i<= toks.length - 14  ; i++ )
	 {
		 
		 y[it][siz]= Float.parseFloat(toks[i]);
		 siz++;
		
	 }

	
		siz=0;
		it++;
	if(it.compareTo(users) ==0)
		break;
	}
	


}
}