/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsontestreader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.Iterator;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
//import java.util.Scanner;
import java.util.Set;


/**
 *
 * @author samira
 */
public class arrayOfJson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException, ParseException {
        // TODO code application logic here
        int numL=0;
        int CounterS=0;
        int count=0;
        int key=0;
        char c,v; 
        String m ;
      String doc;
      String valueOfchar="";
      
         JSONParser parser = new JSONParser();
         HashMap<Integer, String> myHashMap = new HashMap<Integer, String>();
          HashMap<Integer, String> myHashMap2 = new HashMap<Integer, String>();
////read jason
    try {

        Object obj = parser.parse(new FileReader("G:\\unii\\6\\NLP\\en.json"));
        JSONArray jsonArray = (JSONArray) obj;
        int length = jsonArray.size();
        LinkedList body = new LinkedList();

        for (int i =0; i< length; i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            Set s = jsonObject.entrySet();
            Iterator iter = s.iterator();

            LinkedList ll = new LinkedList();
            LinkedList lm = new LinkedList();

            while(iter.hasNext()){
                Map.Entry me = (Map.Entry) iter.next();
                ll.add(me.getValue());
                lm.add(me.getKey());
            }
              
              body.add(ll.get(2)); 
              
            }            
      //// convert body to string , split , write in to file 
        String[] array = (String[]) body.toArray(new String[body.size()]);
     
        
        int Average=0;
       
       
         
        
           
  
       System.out.println("Array Elements:");
       try {

              File file = new File("G:\\unii\\6\\NLP\\outTest.txt");

              if (!file.exists()) {

                   file.createNewFile();

                   System.out.println("creating new file");

              }else{

                   System.out.println("updating file");

              }
              BufferedWriter buffer = new BufferedWriter(new FileWriter(file));
             
    for (int i = 0; i < array.length; i++)
    {
       
        for (String retval: array[i].split("\\s")) {
              for (String retval2: retval.split("\\/")) {
                   for (String retval3: retval2.split("\\,")) {
                       for (String retval4: retval3.split("\\-")) {
                           
                       // System.out.println(retval4);
                        buffer.write(retval4);
                        buffer.newLine();
                           
                        
                       }
                        
                   }
             
              }
              
              
        }
    }
              buffer.close();

              System.out.println("finish writing to file");

          } catch (IOException e) {

              e.printStackTrace();

          }
         
         
      }
        catch(FileNotFoundException fe)
        {
            fe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
   
   ///// read tokenize file put in hashmap 
   
      try {
               
              File file = new File("G:\\unii\\6\\NLP\\outTest.txt");

              if (file.exists()) {

                   System.out.println("****** Reading file … ******");

                   BufferedReader buffer = new BufferedReader(new FileReader(file));

                   String line;
                   
                    String StringLine="";
                   while ((line = buffer.readLine()) != null) {
                     
                       int CheckD= line.compareTo(".");
                       
                        int CheckS= line.compareTo("");
                        if(CheckS!=0){
                       
                        myHashMap2.put(CounterS,line);
                        CounterS++;
                        }
                        
                        
                        
                        if(CheckD!=0 && CheckS!=0){
                        myHashMap.put(key,line);
                        
                        //System.out.println(line);
                        key++;}
                   }
                  count=key;
                   System.out.println("****** Finish Reading file ******");

              }else{

                   System.out.println(file.getAbsolutePath()+" not exist");

              }

          } catch (FileNotFoundException e) {

              // TODO Auto-generated catch block

              e.printStackTrace();

          } catch (IOException e) {

              // TODO Auto-generated catch block

              e.printStackTrace();

          }
     String [ ][ ] textData = new String [2][count];
     int y=0; 
     int i,j,result,result2,result3;
     for(i=0;i<count;i++){
         String temp =(String) myHashMap.get(i);
         
        
         textData[0][i]=(String) myHashMap.get(i);
        
         textData[1][i]="1";
   
     }
     
          
          String value,value2;
   for( i=0;i<count;i++){
         if( textData[1][i]!="0"){
         for(j=i+1; j<count;j++){
            result = textData[0][i].compareTo( textData[0][j] );
            
            
            if(result==0){
             y = Integer.parseInt(textData[1][i]);
               y++;
               textData[1][i] = Integer.toString(y);
               textData[1][j]="0"; 
            }
     }}}
   
 ///// sort tokens 
   int [] sortmax=new int [count];
  for ( i=0;i<count;i++){
   sortmax[i] = Integer.parseInt(textData[1][i]);
   //System.out.println(sortmax[i]);
  }
  
  int n=0,max,temp;
  String temp1;
  for(i=0;i<count;i++){
                              for(j=i+1;j<count;j++){
                                  if(sortmax[i]<sortmax[j]){
                                  temp1=textData[0][j];
                                     temp=sortmax[j];   
                                  sortmax[j]=sortmax[i];
                                     textData[0][j]=textData[0][i];
                                  sortmax[i]=temp;
                                     textData[0][i]=temp1;
                                  }
                              
                              
                              }
                          }
  /////// sentence segmentation
     try {

              File file = new File("G:\\unii\\6\\NLP\\92643228_Assignment2_Part2_EN.txt");

              if (!file.exists()) {

                   file.createNewFile();

                   System.out.println("creating new file");

              }else{

                   System.out.println("updating file");

              }
              BufferedWriter buffer2 = new BufferedWriter(new FileWriter(file));
               int CounterSentence=0 ,tooleJomle=0;
  int z=0;
  
  for(i=0;i<CounterS;i++){
                        
                        int soal= myHashMap2.get(i).compareTo("?");
                        int taaajob= myHashMap2.get(i).compareTo("!");
                        int CheckD=myHashMap2.get(i).compareTo(".");
                        int DoNoghteSoal= myHashMap2.get(i).compareTo(":?");
                       // System.out.print(myHashMap2.get(i)+" ");
                         if(CheckD==0 || taaajob==0 || CheckD==0 || DoNoghteSoal==0){
                         CounterSentence++;
                          
                         }
             
                        if(i<=100){
                        if(CheckD==0 || taaajob==0 || CheckD==0 || DoNoghteSoal==0){
                         
                         for(j=z+1;j<i;j++){
                          System.out.print(myHashMap2.get(j)+" ");
                          buffer2.write(myHashMap2.get(j)+" ");}
                         /*if(lengthLine==10){
                         System.out.print(lengthLine); 
                         System.out.print("\n");
                         
                         lengthLine=0;*/
                        z=i;
                        System.out.print("\n");
                        buffer2.newLine();
                         
                        
                        
                        }
                        }}
           System.out.println("SentenceCount :" +CounterSentence);
            buffer2.write("SentenceCount :" +CounterSentence);
            buffer2.newLine();
             buffer2.write(" جمله با طول ده پیدا نشد جملات فوق طولی کمتر از صد دارند");
              buffer2.close();

              System.out.println("finish writing to file");
             
          } catch (IOException e) {

              e.printStackTrace();

          }
  ///////
  
 
  
  
  try {

              File file = new File("G:\\unii\\6\\NLP\\92463228_Assignment2_Part1_EN.txt");

              if (!file.exists()) {

                   file.createNewFile();

                   System.out.println("creating new file");

              }else{

                   System.out.println("updating file");

              }
              BufferedWriter buffer = new BufferedWriter(new FileWriter(file));

                          for ( j=0;j<1000;j++){
                              textData[0][j]=textData[0][j].toLowerCase();
                              buffer.write(j+")  "+ textData[0][j]+"     "+sortmax[j]);
                              buffer.newLine();
                             System.out.println(j+")  "+ textData[0][j]+"    "+sortmax[j]);
                              
                            }
                    
              buffer.close();

              System.out.println("finish writing to file");

          } catch (IOException e) {

              e.printStackTrace();

          }
    
      }}

      


    
    
    
    
    
  
   
