package com.chaitu.solrj;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrResponse;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

public class SolrJIndexQuery 
{
	public static void main(String[] args) throws SolrServerException, IOException 
	{
		String url="http://localhost:8983/solr/atcontology";
		SolrClient solr=new HttpSolrClient.Builder(url).build();
		SolrQuery solrQuery=new SolrQuery();
		solrQuery.set("q","atcCode:A01AA01");
		QueryResponse response=solr.query(solrQuery);
		SolrDocumentList docList=response.getResults();
		for (SolrDocument solrDocument : docList) 
		{
			System.out.println("Atc Code "+(String)solrDocument.getFieldValue("atcCode"));
			System.out.println("ATC Nmae "+(String)solrDocument.getFieldValue("atcName"));
		}
		
	}

}
