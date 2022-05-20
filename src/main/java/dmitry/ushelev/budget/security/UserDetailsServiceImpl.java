package dmitry.ushelev.budget.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;

    @Value("${budget.admin.username}")
    private String username;

    @Value("${budget.admin.password}")
    private String password;

    public UserDetailsServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String u) throws UsernameNotFoundException {
        if (!username.equals(u)) {
            throw new UsernameNotFoundException("'" + u + "' not found");
        }

        return User.builder()
                .username(u)
                .password(passwordEncoder.encode(password))
                .authorities("modify")
                .build();
    }
}
