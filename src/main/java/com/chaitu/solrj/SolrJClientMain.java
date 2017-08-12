package com.chaitu.solrj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;

public class SolrJClientMain 
{
	public static void main(String[] args) throws SolrServerException, IOException 
	{
		String url="http://localhost:8983/solr/bigboxstore";
		HttpSolrClient solr=new HttpSolrClient(url);
		solr.setParser(new XMLResponseParser());
		SolrInputDocument document =new SolrInputDocument();
		document.addField("id","1234567");
		document.addField("name", "chaitanya123");
		document.addField("description", "Introduction to apache zookeperr");
		solr.add(document);
		solr.commit();
	}
}
