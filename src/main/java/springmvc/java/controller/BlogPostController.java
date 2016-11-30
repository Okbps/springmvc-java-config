package springmvc.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.ModelAndView;
import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;
import springmvc.java.service.BlogPostService;
import springmvc.java.service.UserService;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

/**
 * Created by Aspire on 23.11.2016.
 */
@Controller
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/saveBlogPost",
//            consumes ="text/plain;charset=UTF-8",
            method = RequestMethod.POST)
    public ModelAndView saveBlogPost(
        @RequestParam(value = "title") String title,
        @RequestParam(value = "content") String content,
        @RequestParam(value = "draft", required = false) boolean draft,
        Locale locale,
        Principal principal
    ){
        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(title);
        blogPost.setContent(content);
        blogPost.setUser(userService.findUserWithBlogPostsByUsername(principal.getName()));

        if(draft)
            blogPostService.saveAsDraft(blogPost);
        else
            blogPostService.savePost(blogPost);

        return new ModelAndView("newblogpost", "message", messageSource.getMessage("blogpost.saved", null, locale));
    }

    @RequestMapping(value = "/blogposts", method = RequestMethod.GET)
    public ModelAndView blogPost(Principal principal){
        User user = userService.findUserWithBlogPostsByUsername(principal.getName());
        List<BlogPost>blogPosts = user.getBlogPosts();
        return new ModelAndView("blogposts", "blogposts", blogPosts);
    }

    @RequestMapping(value = "/draftBlogPosts", method = RequestMethod.GET)
    public ModelAndView draftBlogPost(Principal principal){
        User user = userService.findUserWithBlogPostsByUsername(principal.getName());
        List<BlogPost>draftBlogPosts = blogPostService.listAllBlogPostsByUserAndDraftStatus(user, true);
        return new ModelAndView("blogposts", "blogposts", draftBlogPosts);
    }

    @RequestMapping(value = "/getBlogPostById/{id}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public @ResponseBody BlogPost getBlogPostById(
            @PathVariable(value = "id") long id
    ){
        return blogPostService.findBlogPostById(id);
    }

    @RequestMapping(value = "/deleteBlogPostById/{id}", method = RequestMethod.GET)
    public ModelAndView deleteBlogPostById(
            @PathVariable(value = "id") long id, Principal principal
    ){
        BlogPost blogPost = blogPostService.findBlogPostById(id);
        blogPostService.deleteBlogPost(blogPost);
        User user = userService.findUserWithBlogPostsByUsername(principal.getName());
        return new ModelAndView("blogposts", "blogposts", user.getBlogPosts());
    }

    @RequestMapping(value = "/searchByTitle", method = RequestMethod.POST)
    public ModelAndView searchByTitle(
            @RequestParam(value = "title") String title,
            Principal principal
    ){
        User user = userService.findUserWithBlogPostsByUsername(principal.getName());
        List<BlogPost>blogPosts = blogPostService.listAllBlogPostsByUserAndTitleLike(user, title);
        return new ModelAndView("blogposts", "blogposts", blogPosts);
    }
}
