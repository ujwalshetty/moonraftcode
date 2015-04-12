
package com.jdwb.twitterapi;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class GetUserStatus {
	
	public static void main(String[] args) {
		/*creating an application in twitter developer and then using twitter api 
		 * which is using twitter 4j.
		 */
		
		ConfigurationBuilder builder = new ConfigurationBuilder();
	    builder.setUserStreamWithFollowingsEnabled(true);
	    
	    
        
		//	My Applications Consumer and Auth Access Token
        builder.setOAuthConsumerKey("MunKbtkcVNIHTrdyY1nlGD1dz");
        builder.setOAuthConsumerSecret( "rF5L5Su4e1wp47UDkjYeqSoXQampkjsC2sKHohAbCUhgswQuvG");
        builder.setOAuthAccessToken("789278107-ALGMCuzj1Ov4ZBLHWXsKGngmMNgZnk9r8DJE0XA6");
       builder.setOAuthAccessTokenSecret("mYgcpzP5wkzM47spguJ7LrVnKEStoIwMi9YDRXYMdyp1l");
       TwitterFactory factory = new TwitterFactory(builder.build());
		Twitter twitter = factory.getInstance();//creating twitter instance
		Query query = new Query("haircut");//giving the keyword  which has to be there in the tweet
     
	
		int numberOfTweets = 1000;//the number of tweets that is needed
		  long lastID = Long.MAX_VALUE;
		  ArrayList<Status> tweets = new ArrayList<Status>();
		  
		  while (tweets.size () < numberOfTweets) {
		    if (numberOfTweets - tweets.size() > 100)
		    {
		      query.setCount(100);
		    }
		    else 
		    {
		      query.setCount(numberOfTweets - tweets.size());
		    }
		    
		    try {
		      QueryResult result = twitter.search(query);
		      tweets.addAll(result.getTweets());//putting all the tweets into an arraylist
	
		      for (Status t: tweets) 
		      {System.out.println(t.getText());
		      String s=t.getText();
		      /* putting the tweets into the database
		       
		       */
		
		      /*Class.forName("oracle.jdbc.driver.OracleDriver");
		       catch(ClassNotFoundException e)
		       
		       {
		       System.out.println("class not found"+e)
		       }
              Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","UJWALORACLE","UJWALORACLE");
              pst=con.prepareStatement("insert into tweet(tweet_value) values(?)");
               pst.setString(1,s);
               
               catch(SQLException e)
               {
            	   System.out.println("exception occurs"+e);
               }*/
		      int count=0;
		      StringTokenizer st = new StringTokenizer(s," ");
		        while(st.hasMoreTokens()){
		        	{
		        		if (st.nextToken().equals(""))
		        	{
	
		      
		        	}
		        }
		    	 
		        if(t.getId() < lastID) 
		        	{
		        	lastID = t.getId();
		        	}

		    }
		      
		      }
		    }

		    catch (TwitterException te) {
		      System.out.println("Couldn't connect: " + te);
		    }
		    query.setMaxId(lastID-1);
		  }

	}
}
	

