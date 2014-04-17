import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


public class feature_words {
	
	
	
	
	public static void  getFeatures (String filename , int index) throws IOException
	{
		 String stops[]={"a","able","about","above","abst","accordance","according","accordingly","across","act","actually","added","adj","affected","affecting","affects","after","afterwards","again","against","ah","all","almost","alone","along","already","also","although","always","am","among","amongst","an","and","announce","another","any","anybody","anyhow","anymore","anyone","anything","anyway","anyways","anywhere","apparently","approximately","are","aren","arent","arise","around","as","aside","ask","asking","at","auth","available","away","awfully","b","back","be","became","because","become","becomes","becoming","been","before","beforehand","begin","beginning","beginnings","begins","behind","being","believe","below","beside","besides","between","beyond","biol","both","brief","briefly","but","by","c","ca","came","can","cannot","can't","cause","causes","certain","certainly","co","com","come","comes","contain","containing","contains","could","couldnt","d","date","did","didn't","different","do","does","doesn't","doing","done","don't","down","downwards","due","during","e","each","ed","edu","effect","eg","eight","eighty","either","else","elsewhere","end","ending","enough","especially","et","et-al","etc","even","ever","every","everybody","everyone","everything","everywhere","ex","except","f","far","few","ff","fifth","first","five","fix","followed","following","follows","for","former","formerly","forth","found","four","from","further","furthermore","g","gave","get","gets","getting","give","given","gives","giving","go","goes","gone","got","gotten","h","had","happens","hardly","has","hasn't","have","haven't","having","he","hed","hence","her","here","hereafter","hereby","herein","heres","hereupon","hers","herself","hes","hi","hid","him","himself","his","hither","home","how","howbeit","however","hundred","i","id","ie","if","i'll","im","immediate","immediately","importance","important","in","inc","indeed","index","information","instead","into","invention","inward","is","isn't","it","itd","it'll","its","itself","i've","j","just","k","keep"," keeps","kept","kg","km","know","known","knows","l","largely","last","lately","later","latter","latterly","least","less","lest","let","lets","like","liked","likely","line","little","'ll","look","looking","looks","ltd","m","made","mainly","make","makes","many","may","maybe","me","mean","means","meantime","meanwhile","merely","mg","might","million","miss","ml","more","moreover","most","mostly","mr","mrs","much","mug","must","my","myself","n","na","name","namely","nay","nd","near","nearly","necessarily","necessary","need","needs","neither","never","nevertheless","new","next","nine","ninety","no","nobody","non","none","nonetheless","noone","nor","normally","nos","not","noted","nothing","now","nowhere","o","obtain","obtained","obviously","of","off","often","oh","ok","okay","old","omitted","on","once","one","ones","only","onto","or","ord","other","others","otherwise","ought","our","ours","ourselves","out","outside","over","overall","owing","own","p","page","pages","part","particular","particularly","past","per","perhaps","placed","please","plus","poorly","possible","possibly","potentially","pp","predominantly","present","previously","primarily","probably","promptly","proud","provides","put","q","que","quickly","quite","qv","r","ran","rather","rd","re","readily","really","recent","recently","ref","refs","regarding","regardless","regards","related","relatively","research","respectively","resulted","resulting","results","right","run","s","said","same","saw","say","saying","says","sec","section","see","seeing","seem","seemed","seeming","seems","seen","self","selves","sent","seven","several","shall","she","shed","she'll","shes","should","shouldn't","show","showed","shown","showns","shows","significant","significantly","similar","similarly","since","six","slightly","so","some","somebody","somehow","someone","somethan","something","sometime","sometimes","somewhat","somewhere","soon","sorry","specifically","specified","specify","specifying","still","stop","strongly","sub","substantially","successfully","such","sufficiently","suggest","sup","sure","t","take","taken","taking","tell","tends","th","than","thank","thanks","thanx","that","that'll","thats","that've","the","their","theirs","them","themselves","then","thence","there","thereafter","thereby","thered","therefore","therein","there'll","thereof","therere","theres","thereto","thereupon","there've","these","they","theyd","they'll","theyre","they've","think","this","those","thou","though","thoughh","thousand","throug","through","throughout","thru","thus","til","tip","to","together","too","took","toward","towards","tried","tries","truly","try","trying","ts","twice","two","u","un","under","unfortunately","unless","unlike","unlikely","until","unto","up","upon","ups","us","use","used","useful","usefully","usefulness","uses","using","usually","v","value","various","'ve","very","via","viz","vol","vols","vs","w","want","wants","was","wasn't","way","we","wed","welcome","we'll","went","were","weren't","we've","what","whatever","what'll","whats","when","whence","whenever","where","whereafter","whereas","whereby","wherein","wheres","whereupon","wherever","whether","which","while","whim","whither","who","whod","whoever","whole","who'll","whom","whomever","whos","whose","why","widely","willing","wish","with","within","without","won't","words","world","would","wouldn't","www","x","y","yes","yet","you","youd","you'll","your","youre","yours","yourself","yourselves","you've","z","zero","infobox","aa","aaa","aaaa","aaaaa"};
		 Set<String> stopWords=new HashSet<String>(Arrays.asList(stops));
		FileReader fr= new FileReader("/home/navya/Downloads/mypersonality_final/mypersonality_final.csv");
		
		BufferedReader br2= new BufferedReader(fr);
		String currentline="";

		HashMap<String, ArrayList<String>> extrovert = new  HashMap<String, ArrayList<String>>(); // contains key as use id and value as status of thar user
		HashMap<String, Double> tf_extrovert = new  HashMap<String, Double >(); // term frequency of all the words used by the  extrovert users 
		HashMap <String , Double > total_freq= new HashMap <String , Double >(); // term frequency of all the words in the corpus 
		currentline=br2.readLine();
		int total_count=0;
		
		while((currentline=br2.readLine())!=null)
			
		 {
			total_count++;
			// String[] tokens= new String[20];
			 String[] temp_tokens= currentline.split(",");
				int z=19;
				String[] tokens= new String[20];
				int ite= temp_tokens.length-1;
				while(z>1)
				{
					tokens[z]= temp_tokens[ite] ;
					z--;
					ite--;
					
					
				}
				tokens[0]=temp_tokens[0];
				tokens[1]=temp_tokens[1];
				for(int i=2; i<=ite ;i++)
				{
				//	System.out.println(temp_tokens[i]);
					tokens[1] += temp_tokens[i] ; 
				}
			 tokens[1]=tokens[1].replaceAll("\"", "");
			 String[] words = tokens[1].split(" ");
			 for (int i=0;i<words.length;i++)
			 {
				 if (total_freq.get(words[i])==null )
				 {
					
					 total_freq.put((String)words[i], (double)1);
				 }
				 else
				 {
					
					 total_freq.put((String)words[i],total_freq.get(words[i])+1);
				 }
			 }
			
		 }
		System.out.println(total_count);
		fr.close();
		br2.close();
int count_extrovert =0;
FileReader fr2= new FileReader("/home/navya/Downloads/mypersonality_final/mypersonality_final.csv");
TreeMap<Double, String>Y_X_extrovert= new   TreeMap<Double, String>();


BufferedReader br= new BufferedReader(fr2);
currentline=br.readLine();
		while((currentline=br.readLine())!=null)
				
		 {
			String[] temp_tokens= currentline.split(",");
			int z=19;
			String[] tokens= new String[20];
			int ite= temp_tokens.length-1;
			//extracting the 20 columns of each line  into tokens[20]
			while(z>1)
			{
				tokens[z]= temp_tokens[ite] ;
				z--;
				ite--;
				
				
			}
			tokens[0]=temp_tokens[0];
			tokens[1]=temp_tokens[1];
			for(int i=2; i<=ite ;i++)
			{
		
				tokens[1] += temp_tokens[i] ; 
			}
			
			 if (extrovert.get(tokens[0])==null ) 
			 {
				 System.out.println(tokens[index]);
				
				 if (tokens[index].equals("y"))
				 {
					 tokens[1]=tokens[1].replaceAll("\"","") ; 
				 String[]  words= tokens[1].split(" ");
				 ArrayList<String> words_user= new ArrayList<String> ();
				 for (int i=0; i< words.length ; i++)
				 {
					 words_user.add(words[i]);
					 
				 }
				 extrovert.put(tokens[0], words_user) ; 
				 }
				 count_extrovert ++;
			 }
			 else
			 {
				 if (tokens[index].equals("y"))
				 {
										 tokens[1]=tokens[1].replaceAll("\"","") ; 
							 String[]  words= tokens[1].split(" ");
					 
				 
				 ArrayList<String> words_user = extrovert.get(tokens[0]);
				 for (int i=0; i< words.length ; i++)
				 {
					
				 
words_user.add(words[i])	;				 
				 }
				 extrovert.put(tokens[0], words_user) ; 
				 }
			 }
				 
			 
		 }
		// clalculates term frequency in the extroverts corpus 
		 for (Entry<String, ArrayList<String>> entry : extrovert.entrySet())
		 {
			
ArrayList words= entry.getValue() ; 
for (int i=0; i< words.size() ; i++)
{
	if (tf_extrovert.get(words.get(i))==null)
	{
		tf_extrovert.put((String) words.get(i), (double) 1);
		
	}
	else
	{
		tf_extrovert.put((String) words.get(i), tf_extrovert.get((String) words.get(i))+1);
	}
	
}

			 
		 }
		 //used TreeMap x to sort the terms based on the value of x 
		 TreeMap< Double,String> X = new  TreeMap< Double,String> ();
		 
		 for (Entry<String, Double> entry : tf_extrovert.entrySet())
		 {
			 X.put(-(entry.getValue()), entry.getKey());
		 }
		
		 int cout=0;
		 //take the first 200 values from x and sort them in the increasing order of y-x 
		 for (Entry<Double, String> entry : X.entrySet())
		 {
			 if(cout>200)
			 {
				 break;
			 }
			
				 cout++;
			
			 Double val = total_freq.get(entry.getValue());
			Y_X_extrovert.put( (val-entry.getKey()), entry.getValue());
			
			  
		 }
		 int count=0;
		 FileWriter fw= new FileWriter(filename, false);
		
			
			BufferedWriter bre= new BufferedWriter(fw);
			ArrayList<String>unigrams= new ArrayList<String>();
		 for (Entry<Double, String> entry :Y_X_extrovert.entrySet()) 
		 {
			 String temp = entry.getValue().toLowerCase();
		//	 temp.replaceAll(, replacement)
			 if(temp.length()>0)
			 {
			if(temp.charAt(temp.length()-1)=='.' || temp.charAt(temp.length()-1)=='!') 
			{
				temp=temp.substring(0, temp.length()-1) ;
			}
			 }
			
			 if(!(stopWords.contains(temp)))
			 {
				 
				 unigrams.add(temp);
			 bre.write(temp);
			 bre.newLine();
			 count++;
			 }
			 if(count>=50)
			 {
				 break; 
			 }
		 }
	
		 bre.close();
		 fw.close();

		  fw= new FileWriter(filename+"_bigrams", false);
			
			
		 bre= new BufferedWriter(fw);
		 count=0;
		int  j=0;
		 for(int i=0; i < unigrams.size() ; i++)
		 {
				 bre.write(unigrams.get(i)+" "+unigrams.get(unigrams.size()-j-1));
				 bre.newLine();
				 j++;
				  count++;
				  if(count>50) break ; 
				  
				 
			
			 
		 }
		 
		 bre.close();
		 fw.close();
	}
	
	
	public static void main(String[] args) throws IOException
	{
		
		getFeatures("/home/navya/Downloads/mypersonality_final/ext_features" ,7) ;
		getFeatures("/home/navya/Downloads/mypersonality_final/neu_features" ,8) ;
		getFeatures("/home/navya/Downloads/mypersonality_final/agr_features" ,9) ;
		getFeatures("/home/navya/Downloads/mypersonality_final/con_features" ,10) ;
		getFeatures("/home/navya/Downloads/mypersonality_final/opn_features" ,11) ; 
	
		
	}
	
}
