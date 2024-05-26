import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

interface TriesNode {
  public char getValue();
  public boolean hasChilderns();
  public boolean hasChild(char ch);
  public void insertChild(char ch);
  public void removeChild(char ch);
  public void removeChilderns();
  public TriesNode getChild(char ch);
  public void markEow();
  public void unMarkEow();
  public boolean isEow();
  public TriesNode[] getChilderns();
}

class HashNode implements TriesNode {

  HashNode(char value) {
    this.value = value;
    this.childerns = new HashMap<>();
  }

  char value;
  boolean isEOW;
  HashMap<Character, HashNode> childerns;

  @Override
  public char getValue() {
    return this.value;
  }

  @Override
  public boolean hasChild(char ch) {
    return this.childerns.containsKey(ch);
  }

  @Override
  public boolean hasChilderns() {
     return this.childerns.size() > 0;
  }

  @Override
  public void insertChild(char ch) {
    this.childerns.put(ch, new HashNode(ch));
  }

  @Override
  public void removeChild(char ch) {
    this.childerns.remove(ch);
  } 

  @Override
  public void removeChilderns() {
    this.childerns.clear();;
  } 


  @Override
  public TriesNode getChild(char ch) {
    return this.childerns.get(ch);
  }
  
  @Override
  public void markEow() {
    this.isEOW = true;
  }

  @Override
  public boolean isEow() {
    return this.isEOW;
  }

  @Override
  public void unMarkEow() {
    this.isEOW = false;
  }
  
  @Override
  public TriesNode[] getChilderns() {
    return this.childerns.values().toArray(new TriesNode[0]);
  }
  
  @Override
  public String toString() {
    return "TriesNode(" + value + ")";
  }

}

class ArrayNode implements TriesNode {

  char value;
  boolean isEOW;
  ArrayNode[] childerns;

  ArrayNode(char value) {
    this.value = value;
    this.childerns = new ArrayNode[26];
  }

  @Override
  public char getValue() {
    return this.value;
  }

  @Override
  public boolean hasChild(char ch) {
     return this.childerns[ch - 'a'] != null;
  }

  @Override
  public boolean hasChilderns() {
     return this.childerns.length > 0;
  }

  @Override
  public void insertChild(char ch) {
    ArrayNode node = new ArrayNode(ch);
    this.childerns[ch - 'a'] = node;
  }

  @Override
  public void removeChild(char ch) {    
    this.childerns[ch - 'a'] = null;
  }

  @Override
  public void removeChilderns() {    
    this.childerns = null;
  }


  @Override
  public TriesNode getChild(char ch) {
    return this.childerns[ch - 'a'];
  }

  @Override
  public void markEow() {
    this.isEOW = true;
  }

  @Override
  public boolean isEow() {
    return this.isEOW;
  }  

  @Override
  public void unMarkEow() {
    this.isEOW = false;
  }

  @Override
  public TriesNode[] getChilderns() {
    return this.childerns;
  }



  @Override
  public String toString() {
    return "TriesNode(" + value + ")";
  }
  
}


public class Tries {

  private TriesNode root;

  Tries() {
    this.root = new HashNode(' ');
  }

  public void insert(String word) {
    TriesNode current = root;
    for (char ch: word.toCharArray()) {
      if (!current.hasChild(ch)) {
        current.insertChild(ch);
      }
      current = current.getChild(ch);
    }
    current.markEow();
  }

  public boolean contains(String word) {
    TriesNode current = root;
    for (char ch: word.toCharArray()) {
      if (!current.hasChild(ch)) return false;
      current = current.getChild(ch);      
    }
    return current.isEow();
  }

  public void traverse() {
    this.traverse(root);
  }

  private void traverse(TriesNode root) {
    System.out.println(root.getValue());

    for (TriesNode node: root.getChilderns()) {
      this.traverse(node);
    }

  }

  public boolean remove(String word) {
    TriesNode current = root;
    for (char ch: word.toCharArray()) {
      if (!current.hasChild(ch)) return false;
      current = current.getChild(ch);
    }
    current.unMarkEow();
    return true;
  }

  public void removeRecursive(String word) {
    this.removeRecursive(word, root, 0);
  }

  private void removeRecursive(String word, TriesNode root, int index) {
    if (index == word.length()) {
      root.unMarkEow();
      return;
    }

    char ch = word.charAt(index);
    TriesNode child = root.getChild(ch);
    if (child == null) return;

    this.removeRecursive(word, root.getChild(ch), index + 1);      

    if (!child.hasChilderns() && !child.isEow() ) root.removeChild(ch);

  }

  public List<String> suggest(String prefix) {
    List<String> words = new ArrayList<String>();

    TriesNode current = root;
    for (char ch: prefix.toCharArray()) {
      if (!current.hasChild(ch)) return words;
      current = current.getChild(ch);
    }

    words.add(prefix);
    this.suggest(current, prefix, words);

    return words;
  }

  private void suggest(TriesNode node, String prefix, List<String> words) {
    if (!node.hasChilderns()) return;

    for (TriesNode childNode: node.getChilderns()) {
      char ch = childNode.getValue();
      String word = prefix + ch;

      if (childNode.isEow()) words.add(word);

      this.suggest(childNode, word, words);
    }

  }

}
