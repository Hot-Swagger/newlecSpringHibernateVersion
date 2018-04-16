package com.notepubs.web.dao;

import java.util.List;

import com.notepubs.web.entity.Note;


public interface NoteDao {
	
	List<Note> getList(Integer page);
	
	Note get(Integer id);
	
	int insert(Note note);
}

/*mybatis용
public interface NoteDao {
	@Select("select * from Note order by regDate desc" + 
			"		limit ${(page-1)*15},15")
	List<Note> getList(@Param("page") Integer page);
	
	Note get(Integer id);
	
	int insert(Note note);
}*/
