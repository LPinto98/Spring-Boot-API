package com.aicquill.Quill.API.item.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aicquill.Quill.API.item.model.Item;
import com.aicquill.Quill.API.item.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	private ItemRepository repository;

	public Item saveFile(MultipartFile file, String client_name, String visit_date, String downloadUri) {
		String doc_name = file.getOriginalFilename();
		try {
			Item item = new Item(client_name, visit_date,doc_name,file.getContentType(),file.getBytes(),downloadUri);
			return repository.save(item);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//	public Item deleteFile()
	public Optional<Item> getFile(Long Id) {
		return repository.findById(Id);
	}
	public void delete(Long Id) {
		try {
			repository.deleteById(Id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Item> getFiles(){
		return repository.findAll();
	}


}
