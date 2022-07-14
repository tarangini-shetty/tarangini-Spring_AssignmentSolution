package com.greatlearning.student.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/students")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/list")
	public String showBooks(Model model) {
		List<Book> books = bookService.findAll();
		model.addAttribute("books",books);
		return "book-list";
	}
	
	@RequestMapping("/showFormForAdd") 
	public String showFormForAdd(Model model)
	{
		Book book = new Book();
		model.addAttribute("book",book);
		model.addAttribute("mode","Add");
		return "book-form";
	}
	
	@RequestMapping("/showFormForUpdate") 
	public String showFormForUpdate(@RequestParam("bookId") int id, Model model)
	{
		Book book = bookService.findById(id);
		model.addAttribute("book",book);
		model.addAttribute("mode","Update");
		return "book-form";

				
	}
	
	@PostMapping("/save") 
	public String saveBook(@RequestParam("id") int id, 	@RequestParam("title") String title, @RequestParam("author") String author, @RequestParam("category") String category)
	{
		Book book = null;
		if(id == 0)
		{
			book = new Book(title, author, category);
		}
		else
		{
			book = bookService.findById(id);
			book.setTitle(title);
			book.setAuthor(author);
			book.setCategory(category);
		}
		bookService.save(book);
		return "redirect:/books/list";
		
	}
	
	@RequestMapping("/delete") 
	public String delete(@RequestParam("bookId") int id)
	{
		bookService.deleteById(id);
		return "redirect:/books/list";

	}
	
	@RequestMapping("/search") 
	public String search(@RequestParam("title") String title, 	@RequestParam("author") String author, Model model)
	{
		List<Book> booksList = bookService.searchBy(title, author);
		model.addAttribute("books", booksList);
		return "book-list";
	}
	
	@RequestMapping("/403")
	public String show403(Model model) {
		return "403";
	}
	
	
}
