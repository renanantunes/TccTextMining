package twitter;

import java.io.IOException;

import twitter4j.ConnectionLifeCycleListener;
import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;
import utils.ApplicationUtils;
import utils.Constants;
import weka.core.Instances;
import arff.ARFFHandler;

public class TwitterListener {
	private static TwitterStream twitterStream; //Transformei essa variável em statica para poder verificar se está conectado
												//Aqui que acho que fica estranho, existe alguma outra maneira de usar essa variavel sem deixar static?
	
	public static void createLitener(String keyWords[], final Instances data){
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey(Constants.TWITTERCONSUMERKEY);
        cb.setOAuthConsumerSecret(Constants.TWITTERCONSUMERSECRET);
        cb.setOAuthAccessToken(Constants.TWITTERACCESSTOKEN);
        cb.setOAuthAccessTokenSecret(Constants.TWITTERACCESSTOKENSECRET);

        twitterStream = new TwitterStreamFactory(cb.build()).getInstance();

        StatusListener listener = new StatusListener() {

            @Override
            public void onStatus(Status status) {
            	
            	String formatedDate = ApplicationUtils.createFormatDate(Constants.DATEFORMAT1);
            	
            	Tweet tweet = new Tweet();
            	tweet.setId(status.getId());
            	tweet.setUser(status.getUser().getScreenName());
            	tweet.setTweet(status.getText());
            	tweet.setDate(formatedDate);
            	
            	//imprime
            	System.out.println(tweet.getId());
            	System.out.println(tweet.getUser());
            	System.out.println(tweet.getTweet());
            	System.out.println(tweet.getDate()+"\n");
            	
            	ARFFHandler.addDatatoARFF(tweet, data);
            }
        	
            @Override
            public void onException(Exception arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onScrubGeo(long arg0, long arg1) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onTrackLimitationNotice(int arg0) {
                // TODO Auto-generated method stub

            }

			@Override
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub
				
			}

        };
        
        FilterQuery fq = new FilterQuery();
	    String language[] = {"pt"};

	    fq.track(keyWords);
	    fq.language(language);

	    twitterStream.addListener(listener);
	    twitterStream.filter(fq);
	    
	    //Adicionei isso aqui
	    try {
	    	System.out.println("Enter to exit");
			System.in.read(); //Linha para segurar a execução do resto enquanto não pressionar o enter
		} catch (IOException e) {
			System.err.println("===TwitterListener.createListener error closing listener.s");
		}

	    //Necessário para saber status da conexão do twitter
	    twitterStream.addConnectionLifeCycleListener(new ConnectionLifeCycleListener() {
			
			@Override
			public void onDisconnect() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onConnect() {
				// Quando conectado ele executa o Shutdown para fechar a conexão
				//Feito dessa maneira, pois se ele não estiver conectado o shutdown é simplesmente ignorado pelo código
				System.out.println("Shutdown");
			    twitterStream.shutdown();
			}
			
			@Override
			public void onCleanUp() {
				// TODO Auto-generated method stub
				
			}
		});
	    
	}

}
