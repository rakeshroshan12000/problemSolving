import java.util.*;

class AddContacts {
	static class Node {
		Node[] child = new Node[26];
		boolean endOfWord;
		Node() {
			endOfWord = false;
			for (int i = 0; i < 26; i++) 
                child[i] = null; 
		}
	};

	static Node root;

	public static void main(String[] args) {
		root = new Node();
		insert("and");
		insert("hackerrank");
		search("hac");
		for(String str : stringArray) {
			System.out.println(str);
		}

	}

	private static void insert(String name) {
		Node tempNode = root;
		for(int i =0; i< name.length() ;i++) {
			int index = name.charAt(i) - 'a';
			if(tempNode.child[index] == null) {
				tempNode.child[index] = new Node();
			}
			tempNode = tempNode.child[index];
		}
		tempNode.endOfWord = true;
	}

	private static void search(String searchQ) {
		stringArray = new ArrayList();
		Node tempNode = root;
		for(int i =0;i < searchQ.length();i++) {
			int index = searchQ.charAt(i) - 'a';
			if(tempNode.child[index] == null) {
				return;
			}
			tempNode = tempNode.child[index];
		}
		// List<String> arr = new ArrayList<>();
		if(tempNode.endOfWord == true) {
			stringArray.add(searchQ);
		}

		String tempStr = searchQ;
		
		addValues(tempNode,tempStr);
		
	}
	static List<String> stringArray = new ArrayList<>();
	private static void addValues(Node temp,String str) {
		for(int i =0;i< 26 ;i++) {
			if(temp.child[i] != null) {
				char ch = (char)('a' + i);
				str += Character.toString(ch);
				if(temp.child[i].endOfWord == true)
					stringArray.add(str);
				addValues(temp.child[i],str);
			} 
		}
	}

}