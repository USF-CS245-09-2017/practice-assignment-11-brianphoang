public class Hashtable<K, V>
{
    class HashNode<K, V>
    {
		K key;
		V value;
		HashNode<K, V> next;

        public HashNode(K key, V value)
        {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	HashNode[] arr;
	int size;

    //constructor
    public Hashtable()
    {
		arr = new HashNode[314527]; //between 2027 and 314527.
		size = 0;
	}

    public int Index(K key)
    {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % arr.length;
		return index;
    }
    
    //get value at key
    public String get(String key)
    {
		int pos = Index((K) key);
		String Value = null;
		HashNode start = arr[pos];

        while (start != null)
        {
            if (start.key == key)
            {
				Value = (String) start.value;
				return Value;
			}
			start = start.next;
		}
		return Value;
    }

    //put value given key and value
    public void put(String key, String value)
    {
		int index = Index((K) key);
        if (arr[index] == null)
        {
			arr[index] = new HashNode(key, value);
        }
        else
        {
			HashNode start = arr[index];
            if (start.key.equals(key))
            {
                arr[index].value = value;
			}
            while ((start.next != null) && (start.next.key != key))
            {
				start = start.next;
			}
            if (start.next != null)
            {
				start.next.value = value;
			}
			HashNode hn = new HashNode(key, value);
			start.next = hn;
		}
    }

    	//remove value at key
        public String remove(String key)
        {
            int index = Index((K) key);
    
            HashNode temp = arr[index];
            if (temp.key.equals(key))
            {
                arr[index] = temp.next;
                return (String) temp.value;
            }
            while ((temp.next != null) && (temp.next.key != key))
            {
                temp = temp.next;
            }
            if (temp.next != null)
            {
                temp.next = temp.next.next;
                return (String) temp.next.value;
            }
            return null;
        }

    //returns true if key matches argument
    public boolean containsKey(String key)
    {
        int index = Index((K) key);
        
		boolean Value = false;
		HashNode start = arr[index];
        while (start != null)
        {
            if (start.key.equals(key))
            {
				Value = (boolean) start.value;
				return Value;
			}
			start = start.next;
		}
		return Value;
	}
}

