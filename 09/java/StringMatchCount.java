class StringMatchCount {
    public static void main(String args[]) {
	// String P = "ab";
	// String T = "aaaaaaaaaa";

    String P = "";
	String T = "aab";
	//StringMatch matcher = new NaiveStringMatch();

	// int m = 3354;
	// int n= 59396;

	// int m = 3350;
	// int n= 59486;

	// int m = 3350;
	// int n= 28496;
	// //Naive
	// for(int i=0; i< m; i++)
	// {
	// 	if(i ==m-1)
	// 	{
	// 		P+="b";
	// 	}
	// 	else
	// 		P+="a";
	// }
	// for(int j=0; j<n; j++)
	// {
	// 	T+="a";
	// }

	//Rk
	//int m = 59396;
	// int m = 28496;
	
	// for(int i = 0; i< m; i++)
	// {
	// 	P+="a";
	// 	T+="a";
	// }

	
	// //KMP
	int m = 28496;
	for(int i=0; i< m; i++)
	{
		if(i ==m-1)
		{
			P+="b";
		}
		else
			P+="a";
	}

	StringMatch matcher = new KMPStringMatch();


	matcher.match(T, P);
	System.out.println("char reads: " + matcher.counter.report());
    }
}
