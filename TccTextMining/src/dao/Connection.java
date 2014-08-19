package dao;

import java.util.Iterator;

import oracle.kv.Direction;
import oracle.kv.KVStore;
import oracle.kv.KVStoreConfig;
import oracle.kv.KVStoreFactory;
import oracle.kv.Key;
import oracle.kv.ValueVersion;

import utils.Constants;

public class Connection {
	public KVStore createConnection(){
		KVStore store;
		
		store = KVStoreFactory.getStore(new KVStoreConfig(Constants.HOSTNAME, Constants.STORENAME + ":" + Constants.HOSTPORT));
		
		return store;
	}
	
	public void close(KVStore store){
		store.close();
	}
	
	public Iterator<Key> getAll(KVStore store){
		Iterator<Key> keys = store.storeKeysIterator(Direction.UNORDERED, 0);
        while(keys.hasNext())
        {
        	Key key = keys.next();
        	ValueVersion vv = store.get(key);
            System.out.println(key.toString() + " " + new String(vv.getValue().getValue()));
        }
        
        return keys;
	}
}
