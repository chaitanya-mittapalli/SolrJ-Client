package com.chaitu.solrj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;

public class SolrJATCLoaderMain 
{
	public static void main(String[] args) throws IOException, SolrServerException 
	{
		String url="http://localhost:8983/solr/atcontology";
		HttpSolrClient solr=new HttpSolrClient(url);
		solr.setParser(new XMLResponseParser());	
		List<ATCDao> list=loadOntologyFromTextFile();
		System.out.println("Finished loading the text file");
		for (ATCDao atcDao : list) 
		{
			solr.addBean(atcDao);
		}
		solr.commit();
		System.out.println("Added documents to Solr please check the Solr Admin console ");
		System.out.println("Application Shutting down...");

	}
	public static List<ATCDao> loadOntologyFromTextFile()
	{
		List<ATCDao> list=null;
		ATCDao atcDao=null;
		Scanner scanner=null;
		try
		{
			String fileLocation="/home/chaitu/Downloads/ATC-KEGGJuly2017.txt";
			File file=new File(fileLocation);
			scanner=new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8")));
			list=new ArrayList<ATCDao>();
			System.out.println("Headers of the file");
			System.out.println(scanner.nextLine());
			while (scanner.hasNextLine()) 
			{
				String line=scanner.nextLine();
				String[] elements=line.split("\\t");
				System.out.println("Retrived line from the file : "+line);
				atcDao=new ATCDao(elements[1],elements[2],Integer.parseInt(elements[3]));
				list.add(atcDao);
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		scanner.close();
		return list;
	}

}
