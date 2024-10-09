package homework.config.security;

import homework.entity.UserCredential;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;


public class UserDetailsConfig implements UserDetails {
    @Getter
    private Long id;
    private String username;
    private String password;
    private SimpleGrantedAuthority authority;

    // Добавляем конструктор, принимающий UserCredential
    public UserDetailsConfig(UserCredential userCredential) {
        this.id = userCredential.getId();
        this.username = userCredential.getUsername();
        this.password = userCredential.getPassword();
        this.authority = new SimpleGrantedAuthority(userCredential.getRoles().toString());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(authority);
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

