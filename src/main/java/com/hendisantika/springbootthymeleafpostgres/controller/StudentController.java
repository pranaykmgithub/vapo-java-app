package com.hendisantika.springbootthymeleafpostgres.controller;

import com.hendisantika.springbootthymeleafpostgres.entity.Student;
import com.hendisantika.springbootthymeleafpostgres.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student")
@Controller
public class StudentController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().write("Hi StudentServlet!");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
    }
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("student", studentRepository.findAll());
        return "students";
    }

    @GetMapping("/")
    public String createHome() {
        return "index";
    }

    @GetMapping(value = "/create")
    public String create1(Model model) {
        model.addAttribute("student", new Student());
        return "formStudent";
    }

    @PostMapping(value = "/create")
    public String create2(Model model, Student student) {
        model.addAttribute("student", studentRepository.save(student));
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("student", studentRepository.getOne(id));
        return "formStudent";
    }

    @GetMapping(value = "/hapus/{id}")
    public String hapusStudent(@PathVariable Integer id) {
        studentRepository.deleteById(id);
        return "redirect:/";
    }
}
