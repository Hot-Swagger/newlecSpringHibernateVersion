package com.notepubs.web.dao;

import java.util.List;

import com.notepubs.web.entity.Note;
import com.notepubs.web.entity.NoteView;


public interface NoteDao {
	
	List<NoteView> getList(Integer page);
	
	NoteView get(Integer id);
	
	int insert(Note note);

	NoteView getPrev(Integer id);

	NoteView getNext(Integer id);
}

/*mybatis용
public interface NoteDao {
	@Select("select * from Note order by regDate desc" + 
			"		limit ${(page-1)*15},15")
	List<Note> getList(@Param("page") Integer page);
	
	Note get(Integer id);
	
	int insert(Note note);
}*/
