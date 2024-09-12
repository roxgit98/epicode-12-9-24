package davidegiliberti.epicode_12_9_24.controllers;


import davidegiliberti.epicode_12_9_24.entities.Blog;
import davidegiliberti.epicode_12_9_24.payloads.BlogPostPayload;
import davidegiliberti.epicode_12_9_24.services.BlogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogServices blogServices;

    @GetMapping
    private List<Blog> getAllBlogs() {
        return blogServices.findAll();
    }

    @GetMapping("/{blogId}")
    private Blog getBlogById(@PathVariable int blogId) {
        return blogServices.findById(blogId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Blog createBlog(@RequestBody BlogPostPayload body) {
        return blogServices.saveBlog(body);
    }

    @PutMapping("/{blogId}")
    private Blog findBlogByIdAndUpdate(@PathVariable int blogId, @RequestBody Blog body) {
        return blogServices.findAndUpdate(blogId, body);
    }

    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.OK)
    private void deleteBlog(@PathVariable int blogId) {
        blogServices.delete(blogId);
    }
}
