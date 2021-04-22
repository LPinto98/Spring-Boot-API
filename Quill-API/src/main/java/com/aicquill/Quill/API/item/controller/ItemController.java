package com.aicquill.Quill.API.item.controller;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

// Import HttpHeaders, HttpStatus, MediaType, ResponseEntity
import org.springframework.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

// Import CrossOrigin,GetMapping,PostMapping,PathVariable, RequestMapping, RequestMethod, RequestParam
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.aicquill.Quill.API.item.model.Item;
import com.aicquill.Quill.API.item.service.ItemService;

@Controller
@CrossOrigin(origins="*")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	
//	@RequestMapping(value = "/", method = RequestMethod.GET,produces = { "application/json" })
//	public List<Item> get(Model model) {
////		List <Item> items = itemService.getFiles();
////		model.addAttribute("items",items);
//		return itemService.getFiles();
//	}

//	@GetMapping("/allitems")
//	@ResponseBody
//	public List<Item> getAllFiles(){
//		List<Item> list = new ArrayList<>();
//		Iterable<Item> items =  itemService.getFiles();
//		items.forEach(list::add);
//		return list;
//	}
//	
//	
//	
	@PostMapping("/uploadFile")
	public ResponseEntity <String> UploadFile(@RequestParam("files") MultipartFile[] files, @RequestParam("client") String client_name,@RequestParam("date") String visit_date ) {
		for(MultipartFile file: files) {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/downloadFile/")
					.path(fileName)
					.toUriString();
			itemService.saveFile(file,client_name, visit_date, fileDownloadUri);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
	}

	@GetMapping("/downloadFile/{Id}")
	public ResponseEntity <Resource> downloadFile(@PathVariable Long Id){
		Item item = itemService.getFile(Id).get();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(item.getDoc_type()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\""+item.getDoc_name()+"\"")
				.body(new ByteArrayResource(item.getData()));
	}

	
	@GetMapping("/getFiles")
	@ResponseBody
	public List<Item> getFilesList(){
		return itemService.getFiles();
	}
}
