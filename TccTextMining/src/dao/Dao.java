package dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import oracle.kv.Direction;
import oracle.kv.DurabilityException;
import oracle.kv.FaultException;
import oracle.kv.KVStore;
import oracle.kv.KVStoreConfig;
import oracle.kv.KVStoreFactory;
import oracle.kv.Key;
import oracle.kv.Operation;
import oracle.kv.OperationExecutionException;
import oracle.kv.Value;
import oracle.kv.ValueVersion;

public class Dao 
{
	private final KVStore store;
	
	public Dao()
	{
		//Valores padrões
		String storeName = "kvstore";
		String hostName = "localhost";
		String hostPort = "5000";
		
		store = KVStoreFactory.getStore(new KVStoreConfig(storeName, hostName + ":" + hostPort));
	}
	
	public void put(String strKey, Map<String, String> values)
	{
        // Create a batch of operations
        List<Operation> batch = new LinkedList<Operation>(); 
        List<String> majorPath = Arrays.asList("RawTweet", strKey); 
        for (Map.Entry<String, String> entry : values.entrySet())
        {
        	Key key = Key.createKey(majorPath, entry.getKey());
        	Value value = Value.createValue(entry.getValue().getBytes());
        	Operation op = store.getOperationFactory().createPut(key, value);
        	batch.add(op);
        }
        
        try 
        {
			store.execute(batch);
		} catch (DurabilityException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OperationExecutionException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FaultException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printAll()
	{
		//Criado para testar
		Iterator<Key> keys = store.storeKeysIterator(Direction.UNORDERED, 0);
        while(keys.hasNext())
        {
        	Key key = keys.next();
        	ValueVersion vv = store.get(key);
            System.out.println(key.toString() + " " + new String(vv.getValue().getValue()));
        }
	}
	
	public void close()
	{
		store.close();
	}
}
