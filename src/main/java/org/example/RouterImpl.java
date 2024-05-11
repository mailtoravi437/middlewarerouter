package org.example;

import java.util.Map;
import java.util.Objects;

public class RouterImpl implements Router{


    TrieNode root;
    RouterImpl(){
        root = new TrieNode();
    }
    @Override
    public void withRoute(String path, String result) {
        String[] paths = path.split("/");
        insert(paths, result);
    }

    public void insert(String paths[],String res){
        TrieNode current = root;
        for(String path : paths){
            TrieNode trieNode = current.children.get(path);
            if(trieNode==null){
                 trieNode = new TrieNode();
                current.children.put(path,trieNode);
            }
            current = trieNode;
        }

        current.value = res;
    }

    @Override
    public String route(String path) {
        TrieNode current = root;
        String[] paths = path.split("/");

        TrieNode node = search(paths);
        if(node==null){
            return null;
        }

        return node.value;
    }

    public TrieNode search(String[] paths){
        return searchHelper(paths,0,root);
    }

    public TrieNode searchHelper(String paths[],int index,TrieNode root){
        TrieNode current = root;

        for(int i=0;i< paths.length;i++){
            String path = paths[i];
            if(Objects.equals(path,"*")){
                for(Map.Entry<String,TrieNode> entry : current.children.entrySet()){
                    TrieNode trieNode = searchHelper(paths,i+1,entry.getValue());
                    if(trieNode!=null){
                        return trieNode;
                    }
                }
            }

            TrieNode trieNode = current.children.get(path);
            if(trieNode==null){
                return null;
            }
            current = trieNode;
        }

        return current;
    }

}

