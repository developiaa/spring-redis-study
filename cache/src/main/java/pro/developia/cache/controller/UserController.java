package pro.developia.cache.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pro.developia.cache.domain.entity.RedisHashUser;
import pro.developia.cache.domain.entity.User;
import pro.developia.cache.domain.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/redishash-users/{id}")
    public RedisHashUser getUser2(@PathVariable Long id) {
        return userService.getUser2(id);
    }

    @GetMapping("/users3/{id}")
    public User getUser3(@PathVariable Long id) {
        return userService.getUser3(id);
    }
}
