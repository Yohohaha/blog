package me.yohohaha.blog.controller;

import me.yohohaha.blog.domain.User;
import me.yohohaha.blog.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * created at 2019/11/17 13:36:37
 *
 * @author Yohohaha
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有用户
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("userList", userRepository.listUsers());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("/users/list", "userModel", model);
    }

    /**
     * 根据id查询用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("/users/view", "userModel", model);
    }


    /**
     * 获取创建表单页面
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView form(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("/users/form", "userModel", model);
    }

    /**
     * 新建用户
     * @param user
     * @return
     */
    @PostMapping
    public ModelAndView create(User user) {
        userRepository.saveOrUpdateUser(user);
        return new ModelAndView("redirect:/users");
    }


    /**
     * 根据id删除用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, Model model) {
        userRepository.deleteUser(id);
        model.addAttribute("userList", userRepository.listUsers());
        model.addAttribute("title", "删除用户");
        return new ModelAndView("/users/list", "userModel", model);
    }


    @GetMapping("/modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("/users/form", "userModel", model);
    }
}
