package com.transportation;
/*
 * @author angcoder-c Angel Chavez 24248
 */
public class GraphFactory {
    public static Graph createGraph(int pesoIndex) {
        return ReadFiles.readAristasFromFile("./src/main/java/com/transportation/test.txt", pesoIndex);
    }    
}
