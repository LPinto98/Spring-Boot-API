package com.aicquill.Quill.API.item.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String client_name;
	private String visit_date;
	private String doc_name;
	private String doc_type;
	private String downloadUri;
	
	@Lob
	private byte[] data;
	public Item() {
		
	}

	public Item(
		String client_name, 
		String visit_date, 
		String doc_name, 
		String doc_type,
		byte[] data,
		String downloadUri
	) {
		super();
		this.client_name = client_name;
		this.visit_date = visit_date;
		this.doc_name = doc_name;
		this.doc_type = doc_type;
		this.data = data;
		this.downloadUri = downloadUri;
	}

	public Long getId() {
		return id;
	}

	public String getClient_name() {
		return client_name;
	}

	public String getVisit_date() {
		return visit_date;
	}

	public String getDoc_name() {
		return doc_name;
	}

	public String getDoc_type() {
		return doc_type;
	}

	public byte[] getData() {
		// TODO Auto-generated method stub
		return data;
	}

	public String getdownloadUri() {
		return downloadUri;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", client_name=" + client_name + ", visit_date=" + visit_date + ", doc_name="
				+ doc_name + ", doc_type=" + doc_type + ", downloadUri=" + downloadUri + ", data="
				+ Arrays.toString(data) + "]";
	}
	
		
}
