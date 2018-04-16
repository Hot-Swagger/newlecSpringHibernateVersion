package com.notepubs.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.notepubs.web.entity.Note;
import com.notepubs.web.service.NoteService;



@Controller
@RequestMapping("/note/")
public class NoteController {
	
	@Autowired
	private NoteService service;	//	= new NoteService();
	
	@RequestMapping("list")
	public String list(@RequestParam(value="p",defaultValue="1")Integer page, Model model) {
		
		List<Note> notes = service.getNoteList(page);
		model.addAttribute("notes", notes);
		
		return "note.list";
	}
	
	@GetMapping("{id}")
	public String detail(@PathVariable("id") Integer id, Model model) {
	
		Note note = service.getNote(id);
		model.addAttribute("note", note);
		return "note.detail";
	}
	
	@GetMapping("{id}/like")
	public String like(@PathVariable("id") Integer noteId
			, Model model
			, Principal principal /*인증정보 변수*/) {
	
		//String memberId = principal.getName();
		String memberId = "dskim";
		
		service.setNoteLike(noteId, memberId);
		
		return "redirect:../"+noteId;
	}
	
}
