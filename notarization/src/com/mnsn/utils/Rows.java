package com.mnsn.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Rows {
	 private int lineCount; 

	    private int fileCount; 

	    public int getLineCount() 

	    { 

	        return lineCount; 

	    } 

	    public int getFileCount() 

	    { 

	        return fileCount; 

	    } 

	  

	    public static void main(String[] args) throws IOException 

	    { 

	    	Rows itemCount = new Rows(); 

	        //path的值就是你的项目路径 

	        String path = "F:\\workerspacetrue\\qzdl"; 

	        itemCount.getItemLineNum(new File(path)); 

	        System.out.println("该项目一共有"+itemCount.getFileCount()+"个java源文件,"+itemCount.getLineCount()+"行代码"); 

	    } 

	      

	    //递归 

	    public void getItemLineNum(File path) throws IOException{ 

	        if(path.isFile() && path.getName().endsWith(".java")){ 

	            BufferedReader br = new BufferedReader(new FileReader(path)); 

	            fileCount++; 

	            while(br.readLine()!=null){ 

	                lineCount++; 

	            } 

	            System.out.println(path.getName()); 

	            br.close(); 

	        }else if(path.isDirectory()){ 

	            File[] listFiles = path.listFiles(); 

	            for (File file : listFiles) 

	            { 

	                getItemLineNum(file); 

	            } 

	        } 

	    } 
}
