package davidegiliberti.epicode_12_9_24.services;


import davidegiliberti.epicode_12_9_24.entities.Autore;
import davidegiliberti.epicode_12_9_24.entities.Blog;
import davidegiliberti.epicode_12_9_24.exceptions.NotFoundExceptions;
import davidegiliberti.epicode_12_9_24.payloads.BlogPostPayload;
import davidegiliberti.epicode_12_9_24.repositories.AutoreRepository;
import davidegiliberti.epicode_12_9_24.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServices {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private AutoreRepository autoreRepository;

    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    public Blog saveBlog(BlogPostPayload payload) {
        Autore autore = autoreRepository.findById(payload.getAutoreId()).orElseThrow(() -> new NotFoundExceptions(payload.getAutoreId()));

        Blog newBlog = new Blog();

        newBlog.setTitolo(payload.getTitolo());

        newBlog.setContenuto(payload.getContenuto());

        newBlog.setTempoLetturaMinuti(payload.getTempoDiLettura());

        newBlog.setCategoria(payload.getCategoria());

        newBlog.setAutore(autore);

        return blogRepository.save(newBlog);
    }

    public Page<Blog> trovaTuttiPaginati(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }


    public Blog findById(int blogId) {
        return blogRepository.findById(blogId).orElseThrow(() -> new NotFoundExceptions(blogId));
    }

    public void delete(int blogId) {
        Blog blog = findById(blogId);
        blogRepository.delete(blog);
    }

    public Blog findAndUpdate(int blogId, Blog updatedBlog) {
        Blog blog = findById(blogId);

        blog.setCategoria(updatedBlog.getCategoria());

        blog.setTitolo(updatedBlog.getTitolo());

        blog.setCover(updatedBlog.getCover());

        blog.setContenuto(updatedBlog.getContenuto());

        blog.setTempoLetturaMinuti(updatedBlog.getTempoLetturaMinuti());

        return blogRepository.save(blog);

    }

}
